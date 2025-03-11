/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.domainstore.model;

import java.sql.Date;

public class Customer {
    private String id;
    private String name;
    private Date birthday;
    private String personal_id;
    private String address;
    private String email;
    private String phone;
    private String hash_code;
    private Role role;
    
    public enum Role{
        user, admin
    }
    public Customer() {
    }

    public Customer(String id, String name, Date birthday, String personal_id, String address, String email, String phone, String hash_code, Role role) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.personal_id = personal_id;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.hash_code = hash_code;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPersonal_id() {
        return personal_id;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return hash_code;
    }

    public Role getRole() {
        return role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPersonal_id(String personal_id) {
        this.personal_id = personal_id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String hash_code) {
        this.hash_code = hash_code;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", birthday=" + birthday + ", personal_id=" + personal_id + ", address=" + address + ", email=" + email + ", phone=" + phone + ", hash_code=" + hash_code + ", role=" + role + '}';
    }
    
    
}
