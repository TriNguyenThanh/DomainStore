package com.java.domainstore.dao;

import com.java.domainstore.model.DomainModel;
import com.java.domainstore.model.DomainStatusEnum;
import com.java.domainstore.model.Transaction;
import com.java.domainstore.model.enums.PaymentStatus;
import com.java.domainstore.repository.JDBC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionDAO implements DAOInterface<Transaction> {

    public static TransactionDAO getInstance() {
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
        } catch (SQLException | NullPointerException e) {
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
        } catch (SQLException | NullPointerException e) {
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
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }

    @Override
    public Transaction selectById(Transaction transaction) {
        Transaction t = new Transaction();
        DomainModel domain = null;
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection();
            // Bước 2: Chuẩn bị câu lệnh SQL để truy vấn dữ liệu
            String sql = "SELECT t.id as transaction_id, c.id as customer_id, d.id as domain_id, tld.id as tld_id, "
                    + "t.transaction_date, d.domain_date, c.name, d.MD_text, tld.TLD_text, ti.domain_years, "
                    + "ti.price, d.domain_status, p.payment_status FROM transactions t "
                    + "JOIN customer c ON t.cus_id = c.id "
                    + "JOIN transactions_info ti ON t.id = ti.transactions_id "
                    + "JOIN paymenthistory p ON t.id = p.transaction_id "
                    + "JOIN domain d ON ti.domain_id = d.id "
                    + "JOIN topleveldomain tld ON d.TLD_id = tld.id "
                    + "WHERE t.id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getTransactionId());

            // Bước 3: Thực thi truy vấn và nhận kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Bước 4: Duyệt qua kết quả và xử lý dữ liệu
            while (rs.next()) {
                // Lấy dữ liệu từ ResultSet
                String transactionId = rs.getString("transaction_id");
                String customerId = rs.getString("customer_id");
                LocalDate transactionDate = rs.getDate("transaction_date").toLocalDate();
                int domainId = rs.getInt("domain_id");
                int domainYears = rs.getInt("domain_years");
                int price = rs.getInt("price");
                String statusDomain = rs.getString("domain_status").toUpperCase();
                DomainStatusEnum domainStatus = DomainStatusEnum.valueOf(statusDomain);
                String MD_text = rs.getString("MD_text");
                int TLD_id = rs.getInt("tld_id");
                String status = rs.getString("payment_status");
                PaymentStatus paymentStatus = PaymentStatus.valueOf(status);
                String TLD_text = rs.getString("TLD_text");
                DomainModel d = new DomainModel(domainId, MD_text, TLD_text, TLD_id, domainStatus, domainYears,price, Date.valueOf(transactionDate));
                if(t.getListDomain().isEmpty())
                    t = new Transaction(transactionId, customerId, transactionDate, paymentStatus);
                t.getListDomain().add(d);
            }
            // Bước 5: Đóng kết nối 
            JDBC.closeConnection(connection);
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return t;
    }

    @Override
    public ArrayList<Transaction> selectAll() {
        ArrayList<Transaction> listTransaction = new ArrayList<>();
        DomainModel domain = null;
        try {
            // Bước 1: Mở kết nối đến database
            Connection connection = JDBC.getConnection();

            // Bước 2: Chuẩn bị câu lệnh SQL để truy vấn dữ liệu
            String sql = "SELECT t.id as transaction_id, c.id as customer_id, d.id as domain_id, tld.id as tld_id, "
                    + "t.transaction_date, d.domain_date, c.name, d.MD_text, tld.TLD_text, ti.domain_years, "
                    + "ti.price, d.domain_status, p.payment_status FROM transactions t "
                    + "JOIN customer c ON t.cus_id = c.id "
                    + "JOIN transactions_info ti ON t.id = ti.transactions_id "
                    + "JOIN paymenthistory p ON t.id = p.transaction_id "
                    + "JOIN domain d ON ti.domain_id = d.id "
                    + "JOIN topleveldomain tld ON d.TLD_id = tld.id;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Bước 3: Thực thi truy vấn và nhận kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Bước 4: Duyệt qua kết quả và xử lý dữ liệu
            while (rs.next()) {
                int check = 0;
                // Lấy dữ liệu từ ResultSet
                String transactionId = rs.getString("transaction_id");
                String customerId = rs.getString("customer_id");
                LocalDate transactionDate = rs.getDate("transaction_date").toLocalDate();
                int domainId = rs.getInt("domain_id");
                int domainYears = rs.getInt("domain_years");
                int price = rs.getInt("price");
                String statusDomain = rs.getString("domain_status").toUpperCase();
                DomainStatusEnum domainStatus = DomainStatusEnum.valueOf(statusDomain);
                String MD_text = rs.getString("MD_text");
                int TLD_id = rs.getInt("tld_id");
                String status = rs.getString("payment_status");
                PaymentStatus paymentStatus = PaymentStatus.valueOf(status);
                String TLD_text = rs.getString("TLD_text");
                DomainModel d = new DomainModel(domainId, MD_text, TLD_text, TLD_id, domainStatus, domainYears,price, Date.valueOf(transactionDate));
                for(Transaction tran : listTransaction){
                    if(tran.getTransactionId().equals(transactionId)){
                        tran.getListDomain().add(d);
                        check = 1;
                        break;
                    }
                }
                if(check == 0){
                    Transaction t = new Transaction(transactionId, customerId, transactionDate, paymentStatus);
                    t.getListDomain().add(d);
                    listTransaction.add(t);
                }
            }
            // Bước 5: Đóng kết nối 
            JDBC.closeConnection(connection);
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return listTransaction;
    }

    @Override
    public ArrayList<Transaction> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
