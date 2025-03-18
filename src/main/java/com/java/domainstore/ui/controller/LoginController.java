package com.java.domainstore.ui.controller;

import com.java.domainstore.services.LoginServices;
import com.java.domainstore.ui.model.LoginModel;

public class LoginController {
    public int verify(LoginModel data) {
        if (data.getUsername().isBlank()) return 1;
        if (data.getPassword().isBlank()) return 2;
        
        LoginServices loginsv = new LoginServices();
        if (loginsv.authentication(data.getUsername(), data.getPassword())) return 0;
        
        return 3;
    }
}