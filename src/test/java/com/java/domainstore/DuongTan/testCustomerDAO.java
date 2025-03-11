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

        // Lấy danh sách tất cả khách hàng
//        ArrayList<Customer> customers = customerDAO.selectAll();
//        System.out.println("Danh sách khách hàng:");
//        for (Customer kh : customers) {
//            System.out.println(kh);
//        }
//
//        // Tìm khách hàng theo ID
//        Customer findCustomer = new Customer("KH006", "", null, "", "", "", "", "", "", Role.user);
//        Customer result = customerDAO.selectById(findCustomer);
//        System.out.println(result != null ? "Tìm thấy khách hàng: " + result : "Không tìm thấy khách hàng");
//
        // Cập nhật thông tin khách hàng
//        if (result != null) {
//            result.setName("Trịnh Tuấn");
//            result.setHash_code("newpassword"); // Mật khẩu mới
//            int updateResult = customerDAO.update(result);
//        }
//
//        // Xóa khách hàng
//        Customer newCustomer = new Customer("KH006", "Trịnh Trần Phương Tuấn", Date.valueOf("1997-03-03"), "082265718564", "Bến Tre", "ttpt1997@gmail.com", "0327876533", "password123", "", Role.user);
//        int deleteResult = customerDAO.delete(newCustomer);
    }
    
}
