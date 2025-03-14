
package com.java.domainstore.model;

import com.java.domainstore.model.enums.PaymentStatus;
import java.time.LocalDate;
import java.util.ArrayList;

public class Transaction {
    private String transactionId; 
    private String customerId; // 
    private LocalDate transactionDate; // chuyển LocalDate thành Date trước khi lưu vào database
    private PaymentStatus paymentStatus;
    
    private Integer totalCost;
    private ArrayList<DomainModel> listDomain = new ArrayList<>();
    
    public Transaction() {
    }

    public Transaction(String transactionId, String customerId, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.transactionDate = transactionDate;
    }

    public Transaction(String transactionId, String customerId, LocalDate transactionDate, PaymentStatus paymentStatus) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.paymentStatus = paymentStatus;
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
    
    public Integer getTotalCost() {
        int total = 0;
        for(DomainModel domain : listDomain){
            total += domain.getPrice();
        }
        this.totalCost = total;
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public ArrayList<DomainModel> getListDomain() {
        return listDomain;
    }

    public void setListDomain(ArrayList<DomainModel> listDomain) {
        this.listDomain = listDomain;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionId=" + transactionId + ", customerId=" + customerId + ", transactionDate=" + transactionDate + ", paymentStatus=" + paymentStatus + ", totalCost=" + getTotalCost() + ", listDomain=" + listDomain + '}';
    }
}
