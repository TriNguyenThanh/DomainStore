package com.java.domainstore;

import com.java.domainstore.repository.JDBC;

public class DomainStore {

    public static void main(String[] args) {
        System.out.println(JDBC.getConnection());
    }
}
