/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.domainstore.dao;

import java.util.List;
import com.java.domainstore.model.Customer;
import java.util.ArrayList;

public interface ICustomerDAO {
    public void insertCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(String id);
    public Customer getCustomerById(String id);
    public ArrayList<Customer> getAllCustomers();
}
