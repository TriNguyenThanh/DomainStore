
package com.java.domainstore.model;

public class TransactionInfo { //TransactionDetail 
    private String transactionId;
    private Integer domainId;
    private Integer domainYears;
    private Integer totalCost;
    
    public TransactionInfo() {
    }

    public TransactionInfo(String transactionId, Integer domainId, Integer domainYears, Integer totalCost) {
        this.transactionId = transactionId;
        this.domainId = domainId;
        this.domainYears = domainYears;
        this.totalCost = totalCost;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    public Integer getDomainYears() {
        return domainYears;
    }

    public void setDomainYears(Integer domainYears) {
        this.domainYears = domainYears;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "TransactionInfo{" + "transactionId=" + transactionId + ", domainId=" + domainId + ", domainYears=" + domainYears + ", totalCost=" + totalCost + '}';
    }
    
}
