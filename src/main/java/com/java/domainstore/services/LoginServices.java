package com.java.domainstore.services;

import com.java.domainstore.dao.CustomerDAO;
import com.java.domainstore.model.CustomerModel;
import com.java.domainstore.utils.PasswordUtils;

public class LoginServices {
    public String authentication(String username, String password) {
        
        // b1: tìm trong database xem có user nào có username này hay không. Username là số điện thoại
        // nếu có thì qua b2, không thì return ""
        
        // b2: lấy mã salt trong database rồi băm password ra hash code rồi so sánh với hash code của user
        // nếu đúng thì return ID
        
        // Tìm khách hàng theo username (số điện thoại)
        CustomerDAO customerDAO = new CustomerDAO();
        CustomerModel customer = customerDAO.selectByPhone(username);

        if (customer == null) {
            return "";
        }

        // Lấy salt từ database
        String salt = customer.getSalt();
        if (salt == null) { // nên thay bằng salt.isBlank()
            return "";
        }

        // Hash mật khẩu nhập vào với salt lấy từ database
        String hashedPassword = PasswordUtils.hashPassword(password, salt);

        // Kiểm tra với hash_code trong database
        if (hashedPassword.equals(customer.getHash_code())) {
            return customer.getId();
        }
        return "";

    }
}