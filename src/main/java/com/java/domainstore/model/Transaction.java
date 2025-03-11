
package com.java.domainstore.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String transactionId; 
    private String customerId; // 
    private LocalDate transactionDate; // chuyển LocalDate thành Date trước khi lưu vào database
    
    private List<TransactionInfo> listTransactionInfo = new ArrayList<>();
    
    public Transaction() {
    }

    public Transaction(String transactionId, String customerId, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.transactionDate = transactionDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public List<TransactionInfo> getListTransactionInfo() {
        return listTransactionInfo;
    }

    public void setListTransactionInfo(List<TransactionInfo> listTransactionInfo) {
        this.listTransactionInfo = listTransactionInfo;
    }
    
    @Override
    public String toString() {
        return "Transaction{" + "transactionId=" + transactionId + ", customerId=" + customerId + ", transactionDate=" + transactionDate + '}';
    }

}
