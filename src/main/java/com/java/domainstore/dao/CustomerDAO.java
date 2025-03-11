/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.domainstore.dao;

import com.java.domainstore.repository.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.java.domainstore.model.Customer;
import com.java.domainstore.model.Customer.Role;

public class CustomerDAO implements ICustomerDAO{
    
    public static CustomerDAO getInstance(){
        return new CustomerDAO();
    }
    @Override
    public void insertCustomer(Customer customer) {
        try {
            //buoc 1:tao ket noi den jdbc
            Connection con = JDBC.getConnection();

            //buoc 2: tao ra doi tuong statement
            String sql = "INSERT INTO Customer (id, name, birthday, personal_id, address, email, phone, hash_code, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, customer.getId());
            pst.setString(2, customer.getName());
            pst.setDate(3, customer.getBirthday());
            pst.setString(4, customer.getPersonal_id());
            pst.setString(5, customer.getAddress());
            pst.setString(6, customer.getEmail());
            pst.setString(7, customer.getPhone());
            pst.setString(8, customer.getPassword());
            pst.setString(9, customer.getRole().name());
            //buoc 3: thuc thi cau lenh sql

            pst.executeUpdate();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            //buoc 1:tao ket noi den jdbc
            Connection con = JDBC.getConnection();

            //buoc 2: tao ra doi tuong statement
            String sql = "UPDATE CUSTOMER SET name=?, birthday=?, personal_id=?, address=?, email=?, phone=?, hash_code=?, role=? WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, customer.getName());
            pst.setDate(2, customer.getBirthday());
            pst.setString(3, customer.getPersonal_id());
            pst.setString(4, customer.getAddress());
            pst.setString(5, customer.getEmail());
            pst.setString(6, customer.getPhone());
            pst.setString(7, customer.getPassword());
            pst.setString(8, customer.getRole().name());
            pst.setString(9, customer.getId());
            //buoc 3: thuc thi cau lenh sql
            pst.executeUpdate();
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thành công! " + rowsAffected + " dòng đã bị ảnh hưởng.");
            } else {
                System.out.println("Không có dữ liệu nào bị thay đổi.");
            }
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(String id) {
        try {
            //buoc 1:tao ket noi den jdbc
            Connection con = JDBC.getConnection();

            //buoc 2: tao ra doi tuong statement
            String sql = " DELETE FROM CUSTOMER WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            //buoc 3: thuc thi cau lenh sql

            pst.executeUpdate();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomerById(String id) {
        try {
            //buoc 1:tao ket noi den jdbc
            Connection con = JDBC.getConnection();

            //buoc 2: tao ra doi tuong statement
            String sql = " SELECT * FROM CUSTOMER WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            //buoc 3: thuc thi cau lenh sql
            ResultSet rs = pst.executeQuery();
            
            //buoc 4:
            while(rs.next()){
                return new Customer(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("personal_id"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("hash_code"),
                        Role.valueOf(rs.getString("role"))
                );
            }
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {   
            //buoc 1:tao ket noi den jdbc
            Connection con = JDBC.getConnection();

            //buoc 2: tao ra doi tuong statement
            String sql = "SELECT * FROM CUSTOMER";
            PreparedStatement pst = con.prepareStatement(sql);
            //buoc 3: thuc thi cau lenh sql
            ResultSet rs = pst.executeQuery();
            //BUOC 4:
            while(rs.next()){
                customers.add(new Customer(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("personal_id"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("hash_code"),
                        Role.valueOf(rs.getString("role"))
                ));
            }
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return customers;
    }
    
}
