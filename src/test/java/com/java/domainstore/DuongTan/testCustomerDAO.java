package com.java.domainstore.DuongTan;

import com.java.domainstore.dao.CustomerDAO;
import com.java.domainstore.model.CustomerModel;
import com.java.domainstore.model.enums.Role;
import com.java.domainstore.ui.view.swing.fLogin;
import java.sql.Date;
import java.util.List;

public class testCustomerDAO {

    public static void CustomerDAOTest(int i) {
        CustomerDAO customerDAO = CustomerDAO.getInstance();

        switch (i) {
            case 1:
                //  Thêm khách hàng mới
                CustomerModel newCustomer = new CustomerModel(null, "Test User", 
                        Date.valueOf("1997-03-03"), "082265718564", "Bến Tre", 
                        "testuser@gmail.com", "0327876533", "passasd", "", Role.user);

                int insertResult = customerDAO.insert(newCustomer);
                break;

            case 2:
                //  Lấy danh sách tất cả khách hàng
                List<CustomerModel> customers = customerDAO.selectAll();
                System.out.println("Danh sách khách hàng:");
                for (CustomerModel kh : customers) {
                    System.out.println(kh);
                }
                break;

            case 3:
                // Tìm khách hàng theo ID
                String customerId = "KH001";
                CustomerModel findCustomer = new CustomerModel(customerId, "", null, "", "", "", "", "", "", Role.user);
                CustomerModel result = customerDAO.selectById(findCustomer);
                break;

            case 4:
                //  Cập nhật thông tin khách hàng
                CustomerModel updateCustomer = new CustomerModel("KH006", "Nguyễn Văn A",
                        Date.valueOf("2000-01-01"), "123456789012", "Hà Nội",
                        "nguyenvana@gmail.com", "0912345678", "newpassword", "", Role.user);

                int updateResult = customerDAO.update(updateCustomer);
                break;

            case 5:
                //  Xóa khách hàng
                String deleteId = "KH006";
                CustomerModel deleteCustomer = new CustomerModel(deleteId, "", null, "", "", "", "", "", "", Role.user);
                int deleteResult = customerDAO.delete(deleteCustomer);
                break;
        }
    }

    public static void UITest() {
        fLogin.start();
        // fRegister.start();
        // fMain.start();
    }

    public static void main(String[] args) {
        //  Chọn test case mong muốn (thay số 3 bằng test case bạn cần chạy)
//        CustomerDAOTest(5);
        
        //  Kiểm tra giao diện UI
        UITest();
    }
}
