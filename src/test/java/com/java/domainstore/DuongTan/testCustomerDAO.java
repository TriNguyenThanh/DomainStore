/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.domainstore.DuongTan;

import com.java.domainstore.repository.JDBC;
import com.java.domainstore.dao.CustomerDAO;
import java.sql.Date;
import com.java.domainstore.model.Customer;
import java.util.ArrayList;

public class testCustomerDAO {
    public static void main(String[] args) {
        //them
//        Customer kh1 = new Customer("KH006", "Trịnh Trần Phương Tuấn", Date.valueOf("1997-03-03"), "082265718564", "Bến Tre", "ttpt1997@gmail.com", "0327876533", "iJtVkPfPZGpsIDHlre5bL/FzRiePU5JZmdzyWETsZx4=", Customer.Role.user);
//        CustomerDAO.getInstance().insertCustomer(kh1);
        
        //xoa
//        Customer kh1 = new Customer("KH006", "Trịnh Trần Phương Tuấn", Date.valueOf("1997-03-03"), "082265718564", "Bến Tre", "ttpt1997@gmail.com", "0327876533", "pass03031998", Customer.Role.user);
//        CustomerDAO.getInstance().deleteCustomer(kh1.getId());

        //update
//        Customer kh1 = new Customer("KH006", "Trịnh Trần Phương Tuấn", Date.valueOf("1997-03-03"), "082265718564", "Bến Tre", "ttpt1997@gmail.com", "0327876533", "pass012312", Customer.Role.user);
//        CustomerDAO.getInstance().updateCustomer(kh1);

        //getById
//        Customer find = new Customer("KH005", "Trịnh Trần Phương Tuấn", Date.valueOf("1997-03-03"), "082265718564", "Bến Tre", "ttpt1997@gmail.com", "0327876533", "pass012312", Customer.Role.user);
//        Customer result = CustomerDAO.getInstance().getCustomerById(find.getId());
//        System.out.println(result);

        //get all
          ArrayList<Customer> list = CustomerDAO.getInstance().getAllCustomers();
          for(Customer kh : list){
              System.out.println(kh.toString());
          }
    }
    
}
