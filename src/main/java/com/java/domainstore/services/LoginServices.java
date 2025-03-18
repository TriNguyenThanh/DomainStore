package com.java.domainstore.services;

public class LoginServices {
    public boolean authentication(String username, String password) {
        
        // b1: tìm trong database xem có user nào có username này hay không. Username là số điện thoại
        // nếu có thì qua b2, không thì return
        
        // b2: lấy mã salt trong database rồi băm password ra hash code rồi so sánh với hash code của user
        // nếu đúng thì return true
        
        if (username.equals("thanhtri") && password.equals("123456")) return true;
        
        return false;
    }
}
