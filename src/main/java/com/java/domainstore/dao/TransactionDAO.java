
package com.java.domainstore.dao;

import com.java.domainstore.model.Transaction;
import com.java.domainstore.repository.JDBC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionDAO implements BaseDAO<Transaction>{

    public static TransactionDAO getInstance(){
        return new TransactionDAO();
    }
    
    @Override
    public int insert(Transaction transaction) {
        int rowsAffected = 0;
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection(); 
            
            // Bước 2: Chuẩn bị câu lệnh để chèn dữ liệu
            String sql = "INSERT INTO domainstore.transactions(id, cus_id, transaction_date)"
                    + " VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            // Bước 3: Gán giá trị cho các tham số 
            preparedStatement.setString(1, transaction.getTransactionId());
            preparedStatement.setString(2, transaction.getCustomerId());
            preparedStatement.setDate(3, Date.valueOf(transaction.getTransactionDate()));
            
            // Bước 4: Thực thi câu lệnh INSERT và lấy số dòng bị ảnh hưởng
            rowsAffected = preparedStatement.executeUpdate();
            
            // Bước 5: Đóng kết nối
            System.out.println("Thêm dữ liệu thành công !! Có " + rowsAffected + " thay đổi");
            JDBC.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }

    @Override
    public int update(Transaction transaction) {
        int rowsAffected = 0;
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection();
            
            // Bước 2: Chuẩn bị câu lệnh để cập nhật dữ liệu
            String sql = "UPDATE domainstore.transactions "
                    + "SET cus_id = ?, transaction_date = ? "
                    + "WHERE id = ?"; 
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            // Bước 3: Gán giá trị cho các tham số 
            preparedStatement.setString(1, transaction.getCustomerId());
            preparedStatement.setDate(2, java.sql.Date.valueOf(transaction.getTransactionDate()));
            preparedStatement.setString(3, transaction.getTransactionId());
            
            // Bước 4: Thực thi câu lệnh UPDATE và lấy số dòng bị ảnh hưởng
            rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Cập nhật dữ liệu thành công !! Có " + rowsAffected + " thay đổi");
            // Bước 5: Đóng kết nối 
            JDBC.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }

    @Override
    public int delete(Transaction transaction) {
        int rowsAffected = 0;
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection(); 
            
            // Bước 2: Chuẩn bị câu lệnh để xoá dữ liệu
            String sql = "DELETE FROM domainstore.transactions"
                    + " WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
             // Bước 3: Gán giá trị id
            preparedStatement.setString(1, transaction.getTransactionId());
            
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
    public Transaction selectById(Transaction transaction) {
        Transaction t = null;
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection(); 
            // Bước 2: Chuẩn bị câu lệnh SQL để truy vấn dữ liệu
            String sql = "SELECT * FROM domainstore.transactions WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getTransactionId());
            
            // Bước 3: Thực thi truy vấn và nhận kết quả
            ResultSet rs = preparedStatement.executeQuery();
            
            // Bước 4: Duyệt qua kết quả và xử lý dữ liệu
            while(rs.next()){
                // Lấy dữ liệu từ ResultSet
                String transactionId = rs.getString("id");
                String customerId = rs.getString("cus_id");
                LocalDate transactionDate = rs.getDate("transaction_date").toLocalDate();
                
                t = new Transaction(transactionId, customerId, transactionDate);
            }
            // Bước 5: Đóng kết nối 
            JDBC.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return t;
    }

    @Override
    public ArrayList<Transaction> selectAll() {
        ArrayList<Transaction> listTransaction = new ArrayList<>();
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection(); 
            
            // Bước 2: Chuẩn bị câu lệnh SQL để truy vấn dữ liệu
            String sql = "SELECT * FROM transactions";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            // Bước 3: Thực thi truy vấn và nhận kết quả
            ResultSet rs = preparedStatement.executeQuery();
            
            // Bước 4: Duyệt qua kết quả và xử lý dữ liệu
            while(rs.next()){
                // Lấy dữ liệu từ ResultSet
                String transactionId = rs.getString("id");
                String customerId = rs.getString("cus_id");
                LocalDate transactionDate = rs.getDate("transaction_date").toLocalDate();
                
                Transaction t = new Transaction(transactionId, customerId, transactionDate);
                listTransaction.add(t);
            }
            // Bước 5: Đóng kết nối 
            JDBC.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listTransaction;
    }
}
