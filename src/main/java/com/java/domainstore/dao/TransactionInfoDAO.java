
package com.java.domainstore.dao;

import com.java.domainstore.model.TransactionInfo;
import com.java.domainstore.repository.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionInfoDAO implements DAOInterface<TransactionInfo>{

    public static TransactionInfoDAO getInstance(){
        return new TransactionInfoDAO();
    }
    
    @Override
    public int insert(TransactionInfo transactionInfo) {
        int rowsAffected = 0;
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection(); 
            
            // Bước 2: Chuẩn bị câu lệnh để chèn dữ liệu
            String sql = "INSERT INTO domainstore.transactions_info(transactions_id, domain_id, domain_years, price)"
                    + " VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            // Bước 3: Gán giá trị cho các tham số 
            preparedStatement.setString(1, transactionInfo.getTransactionId());
            preparedStatement.setInt(2, transactionInfo.getDomainId());
            preparedStatement.setInt(3, transactionInfo.getDomainYears());
            preparedStatement.setInt(4, transactionInfo.getTotalCost());
            
            // Bước 4: Thực thi câu lệnh INSERT và lấy số dòng bị ảnh hưởng
            rowsAffected = preparedStatement.executeUpdate();
            
            // Bước 5: Đóng kết nối
//            System.out.println("Thêm dữ liệu thành công !! Có " + rowsAffected + " thay đổi");
            JDBC.closeConnection(connection);
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
    
    @Override
    public int update(TransactionInfo transactionInfo) {
        int rowsAffected = 0;
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection(); 
            
            // Bước 2: Chuẩn bị câu lệnh để xoá dữ liệu
            String sql = "UPDATE transactions_info "
                    + "SET domain_years = ?, price = ?"
                    + " WHERE transactions_id = ? and domain_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
             // Bước 3: Gán giá trị id
            preparedStatement.setInt(1, transactionInfo.getDomainYears());
            preparedStatement.setInt(2, transactionInfo.getTotalCost()); 
            preparedStatement.setString(3, transactionInfo.getTransactionId());
            preparedStatement.setInt(4, transactionInfo.getDomainId());
            // Bước 4: Thực thi câu lệnh UPDATE và lấy số dòng bị ảnh hưởng
            rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Xoá dữ liệu thành công !! Có " + rowsAffected + " thay đổi");
            // Bước 5: Đóng kết nối 
            JDBC.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
    
    @Override
    public int delete(TransactionInfo transactionInfo) {
        int rowsAffected = 0;
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection(); 
            
            // Bước 2: Chuẩn bị câu lệnh để xoá dữ liệu
            String sql = "DELETE FROM domainstore.transactions_info"
                    + " WHERE transactions_id = ? and domain_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
             // Bước 3: Gán giá trị id
            preparedStatement.setString(1, transactionInfo.getTransactionId());
            preparedStatement.setInt(2, transactionInfo.getDomainId());
            // Bước 4: Thực thi câu lệnh UPDATE và lấy số dòng bị ảnh hưởng
            rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Xoá dữ liệu thành công !! Có " + rowsAffected + " thay đổi");
            // Bước 5: Đóng kết nối 
            JDBC.closeConnection(connection);
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }

    @Override
    public TransactionInfo selectById(TransactionInfo transactionInfo) {
        TransactionInfo t = null;
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection(); 
            // Bước 2: Chuẩn bị câu lệnh SQL để truy vấn dữ liệu
            String sql = "SELECT * FROM domainstore.transactions_info WHERE transactions_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transactionInfo.getTransactionId());
            
            // Bước 3: Thực thi truy vấn và nhận kết quả
            ResultSet rs = preparedStatement.executeQuery();
            
            // Bước 4: Duyệt qua kết quả và xử lý dữ liệu
            while(rs.next()){
                // Lấy dữ liệu từ ResultSet
                String transactionId = rs.getString("transactions_id");
                int domainYears = rs.getInt("domain_years");
                int totalCost = rs.getInt("price");
                t = new TransactionInfo(transactionId, domainYears, domainYears, totalCost);
            }
            // Bước 5: Đóng kết nối 
            JDBC.closeConnection(connection);
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return t;
    }

    @Override
    public ArrayList<TransactionInfo> selectAll() {
        ArrayList<TransactionInfo> listTransactionInfo = new ArrayList<>();
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection(); 
            
            // Bước 2: Chuẩn bị câu lệnh SQL để truy vấn dữ liệu
            String sql = "SELECT * FROM domainstore.transactions_info";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            // Bước 3: Thực thi truy vấn và nhận kết quả
            ResultSet rs = preparedStatement.executeQuery();
            
            // Bước 4: Duyệt qua kết quả và xử lý dữ liệu
            while(rs.next()){
                // Lấy dữ liệu từ ResultSet
                String transactionId = rs.getString("transactions_id");
                String domainId = rs.getString("domain_id");
                int domainYears = rs.getInt("domain_years");
                int totalCost = rs.getInt("price");
                
                TransactionInfo t = new TransactionInfo(transactionId, domainYears, domainYears, totalCost);
                listTransactionInfo.add(t);
            }
            // Bước 5: Đóng kết nối 
            JDBC.closeConnection(connection);
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return listTransactionInfo;
    }

    @Override
    public ArrayList<TransactionInfo> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
