
package com.java.domainstore.model;

import com.java.domainstore.enums.PaymentType;

public class PaymentMethod {
    private Integer paymentId;
    private PaymentType method;

    public PaymentMethod() {
    }

    public PaymentMethod(Integer paymentId, PaymentType method) {
        this.paymentId = paymentId;
        this.method = method;
    }
    
    public PaymentMethod(PaymentType method) {
        this.method = method;
    }
    
    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentType getMethod() {
        return method;
    }

    public void setMethod(PaymentType method) {
        this.method = method;
    }
}
