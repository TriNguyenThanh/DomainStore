package com.java.domainstore.ui.controller;

import com.java.domainstore.services.RegisterServices;
import com.java.domainstore.ui.model.RegisterModel;
import java.util.ArrayList;
import java.util.List;

public class RegisterController {

    public List<Integer> verify(RegisterModel data) {
        List<Integer> errorList = new ArrayList<>();

        if (data.getName().isBlank()) {
            errorList.add(1);
        }
        if (data.getPhone().isBlank() || !phoneNumberCheck(data.getPhone())) {
            errorList.add(2);
        }
        if (data.getEmail().isBlank() || !emailCheck(data.getEmail())) {
            errorList.add(3);
        }
        if (data.getPsID().isBlank() || !personalIDCheck(data.getPsID())) {
            errorList.add(4);
        }
        if (data.getPass().isBlank() || !passwordCheck(data.getPass())) {
            errorList.add(5);
        }
        if (data.getCfPass().isBlank() || !data.getPass().equals(data.getCfPass())) {
            errorList.add(6);
        }
        if (!errorList.isEmpty())
            return errorList;
        
        RegisterServices gsv = new RegisterServices();
        if (gsv.addToDB(data.getName(), data.getPhone(), data.getEmail(), data.getPsID(), data.getPass())) {
            return errorList;
        } else {
            errorList.clear();
            errorList.add(7);
            return errorList;
        }
    }

    // sdt phải bắt đầu bằng 0 hoặc +84 và có độ dài là 9
    private boolean phoneNumberCheck(String s) {
        String pattern = "^(0|\\+84)\\d{9}$";
        return s.matches(pattern);
    }

    // kiểm tra số căn cước công dân
    private boolean personalIDCheck(String s) {
        String pattern = "^(0|)\\d{12}$";
        return s.matches(pattern);
    }
// kiểm tra email

    private boolean emailCheck(String s) {
        String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return s.matches(pattern);
    }
//kiểm tra mặt khẩu có độ dài 8-16 ký tự, bao gồm a - z, A - Z, 0 - 9, @, _, .

    private boolean passwordCheck(String s) {
        String pattern = "^[a-zA-Z0-9@_.]{8,16}$";
        return s.matches(pattern);
    }
}
