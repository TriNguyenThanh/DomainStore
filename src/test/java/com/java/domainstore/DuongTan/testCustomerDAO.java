package com.java.domainstore.DuongTan;

import com.java.domainstore.dao.CustomerDAO;
import com.java.domainstore.model.CustomerModel;
import com.java.domainstore.model.enums.Role;
import java.sql.Date;
import java.util.List;

public class testCustomerDAO {
    public static void main(String[] args) {
        CustomerDAO customerDAO = CustomerDAO.getInstance();

        //  1. Thêm khách hàng mới (ID tự động sinh)
//        CustomerModel newCustomer = new CustomerModel(null, "Test xem 2", 
//                Date.valueOf("1997-03-03"), "082265718564", "Bến Tre", 
//                "ttpt1997@gmail.com", "0327876533", "passasd", "", Role.user);
//        
//        int insertResult = customerDAO.insert(newCustomer);
//        if (insertResult > 0) {
//            System.out.println(" Thêm khách hàng thành công! ID mới: " + newCustomer.getId());
//        } else {
//            System.out.println(" Thêm khách hàng thất bại!");
//            return; // Nếu không thêm được thì dừng test
//        }
        //  2. Lấy danh sách tất cả khách hàng
//        List<CustomerModel> customers = customerDAO.selectAll();
//        System.out.println("? Danh sách khách hàng:");
//        for (CustomerModel kh : customers) {
//            System.out.println(kh);
//        }

        //  3. Tìm khách hàng theo ID (Lấy ID mới chèn vào)
//        String customerId = "KH009";
//        CustomerModel findCustomer = new CustomerModel(customerId, "", null, "", "", "", "", "", "", Role.user);
//        CustomerModel result = customerDAO.selectById(findCustomer);
//        System.out.println(result != null ? " Tìm thấy khách hàng: " + result : " Không tìm thấy khách hàng");

        // 4. Cập nhật thông tin khách hàng
//        if (result != null) {
//            result.setName("Trịnh Tuấn");
//            result.setHash_code("newpassword"); 
//            int updateResult = customerDAO.update(result);
//            System.out.println(updateResult > 0 ? " Cập nhật thành công!" : " Cập nhật thất bại!");
//        }

        //  5. Xóa khách hàng
//        String customerId = "KH006";
//        CustomerModel findCustomer = new CustomerModel(customerId, "", null, "", "", "", "", "", "", Role.user);
//        int result = customerDAO.delete(findCustomer);
//        if (result > 0)
//               System.out.println("thanh cong");
//        else
//            System.out.println("that bai");
    }
}
