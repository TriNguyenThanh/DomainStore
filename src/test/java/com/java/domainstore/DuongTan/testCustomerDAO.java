package com.java.domainstore.DuongTan;

import com.java.domainstore.dao.CustomerDAO;
import com.java.domainstore.model.Customer;
import com.java.domainstore.model.enums.Role;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class testCustomerDAO {
    public static void main(String[] args) {
        CustomerDAO customerDAO = CustomerDAO.getInstance();

        // Thêm khách hàng mới
//        Customer newCustomer = new Customer("KH006", "Trịnh Trần Phương Tuấn", Date.valueOf("1997-03-03"), "082265718564", "Bến Tre", "ttpt1997@gmail.com", "0327876533", "password123", "", Role.user);
//        int insertResult = customerDAO.insert(newCustomer);
//        System.out.println(insertResult > 0 ? "Thêm khách hàng thành công!" : "Thêm khách hàng thất bại!");

        // Lấy danh sách tất cả khách hàng
//        List<Customer> customers = customerDAO.selectAll();
//        System.out.println("Danh sách khách hàng:");
//        for (Customer kh : customers) {
//            System.out.println(kh);
//        }

        // Tìm khách hàng theo ID
//        Customer findCustomer = new Customer("KH006", "", null, "", "", "", "", "", "", Role.user);
//        Customer result = customerDAO.selectById(findCustomer);
//        System.out.println(result != null ? "Tìm thấy khách hàng: " + result : "Không tìm thấy khách hàng");

        // Cập nhật thông tin khách hàng
//        if (result != null) {
//            result.setName("Trịnh Tuấn");
//            result.setHash_code("newpassword"); 
//            int updateResult = customerDAO.update(result);
//        }

        // Xóa khách hàng
//        Customer newCustomer = new Customer("KH006", "Trịnh Trần Phương Tuấn", Date.valueOf("1997-03-03"), "082265718564", "Bến Tre", "ttpt1997@gmail.com", "0327876533", "password123", "", Role.user);
//        int deleteResult = customerDAO.delete(newCustomer);
//        System.out.println(deleteResult > 0 ? "Xóa khách hàng thành công!" : "Xóa khách hàng thất bại!");
    }
}
