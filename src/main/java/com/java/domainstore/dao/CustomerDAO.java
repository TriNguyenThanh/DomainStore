package com.java.domainstore.dao;

import com.java.domainstore.repository.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.java.domainstore.model.Customer;
import com.java.domainstore.model.Customer.Role;
import com.java.domainstore.utils.PasswordUtils;

public class CustomerDAO implements DAOInterface<Customer> {

    public static CustomerDAO getInstance() {
        return new CustomerDAO();
    }

    @Override
    public int insert(Customer customer) {
        try {
            Connection con = JDBC.getConnection();

            // Tạo salt và hash password
            String salt = PasswordUtils.generateSalt();
            String hashedPassword = PasswordUtils.hashPassword(customer.getHash_code(), salt);

            // Lưu vào bảng Customer
            String sqlCustomer = "INSERT INTO Customer (id, name, birthday, personal_id, address, email, phone, hash_code, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstCustomer = con.prepareStatement(sqlCustomer);
            pstCustomer.setString(1, customer.getId());
            pstCustomer.setString(2, customer.getName());
            pstCustomer.setDate(3, customer.getBirthday());
            pstCustomer.setString(4, customer.getPersonal_id());
            pstCustomer.setString(5, customer.getAddress());
            pstCustomer.setString(6, customer.getEmail());
            pstCustomer.setString(7, customer.getPhone());
            pstCustomer.setString(8, hashedPassword);  // Lưu hash_code vào Customer
            pstCustomer.setString(9, customer.getRole().name());
            int result1 = pstCustomer.executeUpdate();

            // Lưu vào bảng Salt (lưu cả hash_code)
            String sqlSalt = "INSERT INTO Salt (cus_id, hash_code) VALUES (?, ?)";
            PreparedStatement pstSalt = con.prepareStatement(sqlSalt);
            pstSalt.setString(1, customer.getId());
            pstSalt.setString(2, hashedPassword);  // Lưu hash_code vào Salt
            int result2 = pstSalt.executeUpdate();

            return (result1 > 0 && result2 > 0) ? 1 : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException e) {
             e.printStackTrace();
         }
        return 0;
    }


    @Override
    public int update(Customer customer) {
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
    public int delete(Customer customer) {
        try {
            Connection con = JDBC.getConnection();

            // Xóa trước trong Salt để tránh lỗi khóa ngoại
            String sqlSalt = "DELETE FROM Salt WHERE cus_id=?";
            PreparedStatement pstSalt = con.prepareStatement(sqlSalt);
            pstSalt.setString(1, customer.getId());
            int result1 = pstSalt.executeUpdate();

            // Xóa trong Customer
            String sqlCustomer = "DELETE FROM Customer WHERE id=?";
            PreparedStatement pstCustomer = con.prepareStatement(sqlCustomer);
            pstCustomer.setString(1, customer.getId());
            int result2 = pstCustomer.executeUpdate();

            return (result1 > 0 && result2 > 0) ? 1 : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException e) {
             e.printStackTrace();
         }
        return 0;
    }

    @Override
    public Customer selectById(Customer customer) {
        try {
            Connection con = JDBC.getConnection();
            String sql = "SELECT c.*, s.hash_code AS salt_hash FROM Customer c LEFT JOIN Salt s ON c.id = s.cus_id WHERE c.id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, customer.getId());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return new Customer(
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
    public ArrayList<Customer> selectByCondition(String condition) {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            Connection con = JDBC.getConnection();
            String sql = "SELECT * FROM CUSTOMER WHERE " + condition;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                customers.add(new Customer(
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
    public ArrayList<Customer> selectAll() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            Connection con = JDBC.getConnection();
            // JOIN bảng Salt để lấy hash_code từ cả hai bảng
            String sql = "SELECT c.*, s.hash_code AS salt_hash FROM Customer c LEFT JOIN Salt s ON c.id = s.cus_id";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                customers.add(new Customer(
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

}