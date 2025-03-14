package com.java.domainstore.model;

import java.sql.Date;
import java.time.LocalDate;

public class DomainModel {
    private int id;
    private String MD_text;
    private String TLD_text;
    private int TLD_id;
    private DomainStatusEnum status;
    private int years;
    private int price;
    private Date activateDate;

    public DomainModel() {
        
    }

    public DomainModel(int id, String MD_text, String TLD_text, int TLD_id, DomainStatusEnum status, int years, int price, Date activateDate) {
        this.id = id;
        this.MD_text = MD_text;
        this.TLD_text = TLD_text;
        this.TLD_id = TLD_id;
        this.status = status;
        this.years = years;
        this.price = price;
        this.activateDate = activateDate;
    }
    
    // dataconstructor: use to access to the database system
    public DomainModel(int id, String MD_text, int TLD_id, DomainStatusEnum status, int years) {
        this.MD_text = MD_text;
        this.TLD_id = TLD_id;
        this.status = status;
        this.years = years;
        this.activateDate = Date.valueOf(LocalDate.now());
        this.id = id;
        this.TLD_text = "";
        this.price = 0;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMD_text() {
        return MD_text;
    }

    public void setMD_text(String MD_text) {
        this.MD_text = MD_text;
    }

    public int getTLD_id() {
        return TLD_id;
    }

    public void setTLD_id(int TLD_id) {
        this.TLD_id = TLD_id;
    }

    public DomainStatusEnum getStatus() {
        return status;
    }

    public void setStatus(DomainStatusEnum status) {
        this.status = status;
    }

    public String getTLD_text() {
        return TLD_text;
    }

    public void setTLD_text(String TLD_text) {
        this.TLD_text = TLD_text;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Date activateDate) {
        this.activateDate = activateDate;
    }
    
    public String getText() {
        return MD_text + TLD_text;
    }

    @Override
    public String toString() {
        return "DomainModel{" + "id= " + id + ", text= " + MD_text + TLD_text + ", TLD_id= " + TLD_id + ", status= " + status + ", years= " + years + ", price= " + price + ", activateDate= " + activateDate + '}';
    }
    
    
}
