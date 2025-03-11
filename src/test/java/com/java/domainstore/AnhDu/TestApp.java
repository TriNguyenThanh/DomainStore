package com.java.domainstore.AnhDu;

import com.java.domainstore.*;
import com.java.domainstore.repository.JDBC;

public class TestApp {
    public static void main(String[] args) {
        
        // ------------ PaymentHistory -----------
        // Select All
//        ArrayList<PaymentHistory> payments = PaymentHistoryDAO.getInstance().selectAll();
//        for(PaymentHistory p : payments) 
//            System.out.println(p);
        
        // SelectById
//        PaymentHistory p =new PaymentHistory();
//        p.setId(1);
//        System.out.println(PaymentHistoryDAO.getInstance().selectById(p));
        
        // Insert
//        PaymentHistory p =new PaymentHistory("HD003", "74389326", 1, PaymentStatus.failed, LocalDate.parse("2024-03-11"));
//        PaymentHistoryDAO.getInstance().insert(p);
        
        //Update
//        PaymentHistory p = new PaymentHistory(4, "HD003", "74389326", 1, PaymentStatus.completed, LocalDate.parse("2024-03-11"));
//        PaymentHistoryDAO.getInstance().update(p);
        
        // Delete
//        PaymentHistory p =new PaymentHistory();
//        p.setId(4);
//        PaymentHistoryDAO.getInstance().delete(p);

        // ------------ Transaction -----------
        // Select All
//        ArrayList<Transaction> transactions = TransactionDAO.getInstance().selectAll();
//        for(Transaction t : transactions) 
//            System.out.println(t);
         // SelectById
//        Transaction t =new Transaction();
//        t.setTransactionId("HD001");
//        System.out.println(TransactionDAO.getInstance().selectById(t));
        
        // Insert
//        Transaction t = new Transaction("HD004", "KH003", LocalDate.parse("2024-05-02"));
//        TransactionDAO.getInstance().insert(t);
        
        //Update
//        Transaction t = new Transaction("HD004", "KH003", LocalDate.parse("2024-05-03"));
//        TransactionDAO.getInstance().update(t);
        
        // Delete
//        Transaction t = new Transaction(); t.setTransactionId("HD004");
//        TransactionDAO.getInstance().delete(t);

        // Transaction Info
        // Select All
//        ArrayList<TransactionInfo> listTransactionInfo = TransactionInfoDAO.getInstance().selectAll();
//        for(TransactionInfo t : listTransactionInfo) 
//            System.out.println(t);
        // SelectById
//        TransactionInfo t =new TransactionInfo(); t.setTransactionId("HD001");
//        System.out.println(TransactionInfoDAO.getInstance().selectById(t));
        
        // Insert
//        TransactionInfo t = new TransactionInfo("HD003", 3, 2, 66666);
//        TransactionInfoDAO.getInstance().insert(t);
        
        //Update
//        TransactionInfo t = new TransactionInfo("HD003", 3, 2, 78000);
//        TransactionInfoDAO.getInstance().update(t);
        
        // Delete
//        TransactionInfo t = new TransactionInfo("HD003", 3, 2, 78000);
//        TransactionInfoDAO.getInstance().delete(t);
    }
}
