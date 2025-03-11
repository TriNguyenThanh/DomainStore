
package com.java.domainstore.model;

import com.java.domainstore.enums.PaymentStatus;
import java.time.LocalDate;

public class PaymentHistory {
    private Integer id; // ID duy nhất của mỗi lịch sử thanh toán
    private String transactionId;
    private String paymentCode; // mã giao dịch bên thứ 3
    private Integer paymentMethodId; // ID của PaymentMeThod
    private PaymentStatus paymentStatus;
    private LocalDate paymentDate;

    public PaymentHistory() {
    }
    
    public PaymentHistory(Integer id, String transactionId,String paymentCode, Integer paymentMethodId, PaymentStatus paymentStatus, LocalDate paymentDate) {
        this.id = id;
        this.transactionId = transactionId;
        this.paymentCode = paymentCode;
        this.paymentMethodId = paymentMethodId;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }
    
    public PaymentHistory(String transactionId, String paymentCode, Integer paymentMethodId, PaymentStatus paymentStatus, LocalDate paymentDate) {
        this.transactionId = transactionId;
        this.paymentCode = paymentCode;
        this.paymentMethodId = paymentMethodId;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
    
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "PaymentHistory{" + "id=" + id + ", transactionId=" + transactionId + ", paymentCode=" + paymentCode + ", paymentMethodId=" + paymentMethodId + ", paymentStatus=" + paymentStatus + ", paymentDate=" + paymentDate + '}';
    }
    
}
