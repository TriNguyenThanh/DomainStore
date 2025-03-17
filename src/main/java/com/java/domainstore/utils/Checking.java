package com.java.domainstore.utils;

public class Checking {
    public static boolean phoneNumberCheck(String s) {
        String pattern = "^(0|\\+84)\\d{9}$";
        return s.matches(pattern);
    }
    public static boolean personalIDCheck(String s) {
        String pattern = "^(0|)\\d{12}$";
        return s.matches(pattern);
    }
    public static boolean emailCheck(String s) {
        String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return s.matches(pattern);
    }
}
