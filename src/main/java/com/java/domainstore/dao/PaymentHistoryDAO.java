
package com.java.domainstore.dao;

import com.java.domainstore.model.enums.PaymentStatus;
import com.java.domainstore.model.PaymentHistory;
import com.java.domainstore.repository.JDBC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class PaymentHistoryDAO implements DAOInterface<PaymentHistory>{
    
    public static PaymentHistoryDAO getInstance(){
        return new PaymentHistoryDAO();
    }
    
    @Override
    public int insert(PaymentHistory paymentHistory) {
        int rowsAffected = 0;
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection(); 
            
            // Bước 2: Chuẩn bị câu lệnh để chèn dữ liệu
            String sql = "INSERT INTO domainstore.paymenthistory(transaction_id, payment_id, payment_method, payment_status, payment_date) "
                    + "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            // Bước 3: Gán giá trị cho các tham số 
            preparedStatement.setString(1, paymentHistory.getTransactionId());
            preparedStatement.setString(2, paymentHistory.getPaymentCode());
            preparedStatement.setInt(3, paymentHistory.getPaymentMethodId());
            preparedStatement.setString(4, paymentHistory.getPaymentStatus().name());
            preparedStatement.setDate(5, Date.valueOf(paymentHistory.getPaymentDate()));
            
            // Bước 4: Thực thi câu lệnh INSERT và lấy số dòng bị ảnh hưởng
            rowsAffected = preparedStatement.executeUpdate();
            
            // Bước 5: Đóng kết nối
            System.out.println("Thêm dữ liệu thành công !! Có " + rowsAffected + " thay đổi");
            JDBC.closeConnection(connection);
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }

    @Override
    public int update(PaymentHistory paymentHistory) {
        int rowsAffected = 0;
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection();
            
            // Bước 2: Chuẩn bị câu lệnh để cập nhật dữ liệu
            String sql = "UPDATE domainstore.paymenthistory"
                    + " SET transaction_id = ?, payment_id = ?, payment_method = ?, "
                    + "payment_status = ?, payment_date = ?"
                    + " WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            // Bước 3: Gán giá trị cho các tham số 
            preparedStatement.setString(1, paymentHistory.getTransactionId());
            preparedStatement.setString(2, paymentHistory.getPaymentCode());
            preparedStatement.setInt(3, paymentHistory.getPaymentMethodId());
            preparedStatement.setString(4, paymentHistory.getPaymentStatus().name());
            preparedStatement.setDate(5, Date.valueOf(paymentHistory.getPaymentDate()));
            preparedStatement.setInt(6, paymentHistory.getId());
            
            // Bước 4: Thực thi câu lệnh UPDATE và lấy số dòng bị ảnh hưởng
            rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Cập nhật dữ liệu thành công !! Có " + rowsAffected + " thay đổi");
            // Bước 5: Đóng kết nối 
            JDBC.closeConnection(connection);
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }

    @Override
    public int delete(PaymentHistory paymentHistory) {
        int rowsAffected = 0;
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection(); 
            
            // Bước 2: Chuẩn bị câu lệnh để xoá dữ liệu
            String sql = "DELETE FROM domainstore.paymenthistory"
                    + " WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
             // Bước 3: Gán giá trị id
            preparedStatement.setInt(1, paymentHistory.getId());
            
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
    public PaymentHistory selectById(PaymentHistory paymentHistory) {
        PaymentHistory p = null;
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection(); 
            // Bước 2: Chuẩn bị câu lệnh SQL để truy vấn dữ liệu
            String sql = "SELECT * FROM domainstore.paymenthistory WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, paymentHistory.getId());
            
            // Bước 3: Thực thi truy vấn và nhận kết quả
            ResultSet rs = preparedStatement.executeQuery();
            
            // Bước 4: Duyệt qua kết quả và xử lý dữ liệu
            while(rs.next()){
                // Lấy dữ liệu từ ResultSet
                String transactionId = rs.getString("transaction_id");
                String paymentCode = rs.getString("payment_id");
                int paymentMethodId = rs.getInt("payment_method");
                String status = rs.getString("payment_status");
                PaymentStatus paymentStatus = PaymentStatus.valueOf(status);
                LocalDate paymentDate = rs.getDate("payment_date").toLocalDate();
                
                p = new PaymentHistory(paymentHistory.getId(), transactionId, paymentCode, paymentMethodId, paymentStatus, paymentDate);
            }
            // Bước 5: Đóng kết nối 
            JDBC.closeConnection(connection);
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

    @Override
    public ArrayList<PaymentHistory> selectAll() {
        ArrayList<PaymentHistory> listPaymentHistory = new ArrayList<>();
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection(); 
            
            // Bước 2: Chuẩn bị câu lệnh SQL để truy vấn dữ liệu
            String sql = "SELECT * FROM domainstore.paymenthistory";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            // Bước 3: Thực thi truy vấn và nhận kết quả
            ResultSet rs = preparedStatement.executeQuery();
            
            // Bước 4: Duyệt qua kết quả và xử lý dữ liệu
            while(rs.next()){
                // Lấy dữ liệu từ ResultSet
                int id = rs.getInt("id");
                String transactionId = rs.getString("transaction_id");
                String paymentCode = rs.getString("payment_id");
                int paymentMethodId = rs.getInt("payment_method");
                String status = rs.getString("payment_status");
                PaymentStatus paymentStatus = PaymentStatus.valueOf(status);
                LocalDate paymentDate = rs.getDate("payment_date").toLocalDate();
                
                PaymentHistory p = new PaymentHistory(transactionId, paymentCode, paymentMethodId, paymentStatus, paymentDate);
                listPaymentHistory.add(p);
            }
            // Bước 5: Đóng kết nối 
            JDBC.closeConnection(connection);
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return listPaymentHistory;
    }

    @Override
    public ArrayList<PaymentHistory> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
