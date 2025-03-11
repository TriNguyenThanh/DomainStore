package com.java.domainstore;

import com.java.domainstore.repository.JDBC;

public class TestApp {
    public static void main(String[] args) {
        System.out.println("This is test class");
        System.out.println(JDBC.getConnection());
    }
}
