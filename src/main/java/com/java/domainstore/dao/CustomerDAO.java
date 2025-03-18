package com.java.domainstore.dao;

import com.java.domainstore.dao.DAOInterface;
import com.java.domainstore.repository.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.java.domainstore.model.CustomerModel;
import com.java.domainstore.model.enums.Role;
import com.java.domainstore.utils.PasswordUtils;
import java.util.ArrayList;

public class CustomerDAO implements DAOInterface<CustomerModel> {

    public static CustomerDAO getInstance() {
        return new CustomerDAO();
    }

    // ✅ Hàm tự động sinh ID mới dạng KH001, KH002, ...
    private String generateCustomerId() {
        String sql = "SELECT id FROM Customer ORDER BY id DESC LIMIT 1";
        try (Connection con = JDBC.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                String lastId = rs.getString("id"); // Lấy ID cuối cùng (VD: KH009)
                int number = Integer.parseInt(lastId.substring(2)); // Lấy số 009
                return "KH" + String.format("%03d", number + 1); // Tạo ID mới KH010
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
             e.printStackTrace();
         }
        return "KH001"; // Nếu database chưa có khách nào, bắt đầu từ KH001
    }

    @Override
public int insert(CustomerModel customer) {
    try {
        Connection con = JDBC.getConnection();

        //  Tạo ID tự động
        String newId = generateCustomerId();
        customer.setId(newId); //  Cập nhật ID vào đối tượng

        //  Debug kiểm tra ID sau khi gán
        System.out.println(" ID sau khi insert: " + customer.getId());

        // Lưu vào bảng Customer
        String sqlCustomer = "INSERT INTO Customer (id, name, birthday, personal_id, address, email, phone, hash_code, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstCustomer = con.prepareStatement(sqlCustomer);
        pstCustomer.setString(1, newId);
        pstCustomer.setString(2, customer.getName());
        pstCustomer.setDate(3, customer.getBirthday());
        pstCustomer.setString(4, customer.getPersonal_id());
        pstCustomer.setString(5, customer.getAddress());
        pstCustomer.setString(6, customer.getEmail());
        pstCustomer.setString(7, customer.getPhone());
        pstCustomer.setString(8, customer.getHash_code());
        pstCustomer.setString(9, customer.getRole().name());
        int result1 = pstCustomer.executeUpdate();

        //  Nếu insert thành công, gán lại ID vào customer
        if (result1 > 0) {
            customer.setId(newId);
        }

        return result1;
    } catch (SQLException e) {
        e.printStackTrace();
    }   catch (NullPointerException e) {
             e.printStackTrace();
         }
    return 0;
}


    @Override
    public int update(CustomerModel customer) {
        try {
            Connection con = JDBC.getConnection();

            // Lấy hash_code hiện tại từ bảng Salt
            String sqlGetHash = "SELECT hash_code FROM Salt WHERE cus_id=?";
            PreparedStatement pstGetHash = con.prepareStatement(sqlGetHash);
            pstGetHash.setString(1, customer.getId());
            ResultSet rs = pstGetHash.executeQuery();

            String oldHashCode = "";
            if (rs.next()) {
                oldHashCode = rs.getString("hash_code");
            }

            // Nếu mật khẩu thay đổi thì băm lại và cập nhật
            String newHashCode = customer.getHash_code();
            if (!newHashCode.equals(oldHashCode)) {
                String salt = PasswordUtils.generateSalt();
                newHashCode = PasswordUtils.hashPassword(newHashCode, salt);
            }

            // Cập nhật bảng Customer
            String sqlCustomer = "UPDATE Customer SET name=?, birthday=?, personal_id=?, address=?, email=?, phone=?, hash_code=?, role=? WHERE id=?";
            PreparedStatement pstCustomer = con.prepareStatement(sqlCustomer);
            pstCustomer.setString(1, customer.getName());
            pstCustomer.setDate(2, customer.getBirthday());
            pstCustomer.setString(3, customer.getPersonal_id());
            pstCustomer.setString(4, customer.getAddress());
            pstCustomer.setString(5, customer.getEmail());
            pstCustomer.setString(6, customer.getPhone());
            pstCustomer.setString(7, newHashCode);  // Cập nhật hash_code trong Customer
            pstCustomer.setString(8, customer.getRole().name());
            pstCustomer.setString(9, customer.getId());
            int result1 = pstCustomer.executeUpdate();

            // Cập nhật bảng Salt
            String sqlUpdateSalt = "UPDATE Salt SET hash_code=? WHERE cus_id=?";
            PreparedStatement pstUpdateSalt = con.prepareStatement(sqlUpdateSalt);
            pstUpdateSalt.setString(1, newHashCode);  // Cập nhật hash_code trong Salt
            pstUpdateSalt.setString(2, customer.getId());
            int result2 = pstUpdateSalt.executeUpdate();

            return (result1 > 0 && result2 > 0) ? 1 : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException e) {
             e.printStackTrace();
         }
        return 0;
    }


    @Override
    public int delete(CustomerModel customer) {
        try {
            Connection con = JDBC.getConnection();

            // ✅ Debug: Kiểm tra ID trước khi xóa
            System.out.println("🔍 Đang xóa khách hàng có ID: " + customer.getId());

            // ✅ Xóa giao dịch trong bảng Transactions trước
            String sqlTransactions = "DELETE FROM Transactions WHERE cus_id=?";
            PreparedStatement pstTransactions = con.prepareStatement(sqlTransactions);
            pstTransactions.setString(1, customer.getId());
            int transactionsDeleted = pstTransactions.executeUpdate();
            System.out.println("🗑 Xóa " + transactionsDeleted + " giao dịch trong Transactions.");

            // ✅ Xóa trong bảng Salt trước để tránh lỗi khóa ngoại
            String sqlSalt = "DELETE FROM Salt WHERE cus_id=?";
            PreparedStatement pstSalt = con.prepareStatement(sqlSalt);
            pstSalt.setString(1, customer.getId());
            int saltDeleted = pstSalt.executeUpdate();
            System.out.println("🗑 Xóa " + saltDeleted + " bản ghi trong Salt.");

            // ✅ Xóa trong bảng Customer
            String sqlCustomer = "DELETE FROM Customer WHERE id=?";
            PreparedStatement pstCustomer = con.prepareStatement(sqlCustomer);
            pstCustomer.setString(1, customer.getId());
            int customerDeleted = pstCustomer.executeUpdate();
            System.out.println("🗑 Xóa " + customerDeleted + " bản ghi trong Customer.");

            // ✅ Kiểm tra kết quả xóa
            if (customerDeleted > 0) {
                System.out.println("✔ Khách hàng có ID " + customer.getId() + " đã bị xóa!");
            } else {
                System.out.println("❌ Không tìm thấy khách hàng để xóa!");
            }

            return customerDeleted;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
             e.printStackTrace();
         }
        return 0;
    }


    @Override
    public CustomerModel selectById(CustomerModel customer) {
        try {
            Connection con = JDBC.getConnection();
            String sql = "SELECT c.*, s.hash_code AS salt_hash FROM Customer c LEFT JOIN Salt s ON c.id = s.cus_id WHERE c.id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, customer.getId());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return new CustomerModel(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("personal_id"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("hash_code"), 
                        rs.getString("salt_hash"), 
                        Role.valueOf(rs.getString("role"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException e) {
             e.printStackTrace();
         }
        return null;
    }

    @Override
    public ArrayList<CustomerModel> selectByCondition(String condition) {
        ArrayList<CustomerModel> customers = new ArrayList<>();
        try {
            Connection con = JDBC.getConnection();
            String sql = "SELECT * FROM CUSTOMER WHERE " + condition;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                customers.add(new CustomerModel(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("personal_id"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("hash_code"),
                        rs.getString("salt"),
                        Role.valueOf(rs.getString("role"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException e) {
             e.printStackTrace();
         }
        return customers;
    }

    @Override
    public ArrayList<CustomerModel> selectAll() {
        ArrayList<CustomerModel> customers = new ArrayList<>();
        try {
            Connection con = JDBC.getConnection();
            // JOIN bảng Salt để lấy hash_code từ cả hai bảng
            String sql = "SELECT c.*, s.hash_code AS salt_hash FROM Customer c LEFT JOIN Salt s ON c.id = s.cus_id";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                customers.add(new CustomerModel(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("personal_id"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("hash_code"),  // Hash từ Customer
                        rs.getString("salt_hash"),  // Hash từ Salt
                        Role.valueOf(rs.getString("role"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException e) {
             e.printStackTrace();
         }
        return customers;
    }
    //lay so dien thoai
    public CustomerModel selectByPhone(String phone) {
        try {
            Connection con = JDBC.getConnection();
            String sql = "SELECT c.*, s.hash_code AS salt FROM Customer c LEFT JOIN Salt s ON c.id = s.cus_id WHERE c.phone=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, phone);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return new CustomerModel(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("personal_id"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("hash_code"), 
                        rs.getString("salt"),       
                        Role.valueOf(rs.getString("role"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException e) {
             e.printStackTrace();
         }
        return null;
    }


}