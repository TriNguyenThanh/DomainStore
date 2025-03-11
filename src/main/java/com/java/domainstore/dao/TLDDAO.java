package com.java.domainstore.dao;

import com.java.domainstore.model.TLDModel;
import com.java.domainstore.repository.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TLDDAO implements DAOInterface<TLDModel>{

    public static TLDDAO getInstance() {
        return new TLDDAO();
    }
    
    @Override
    public int insert(TLDModel t) {
        int kq = 0;
        try {
            Connection c = JDBC.getConnection();
            
            String sql = "INSERT INTO TopLevelDomain(TLD_text, price) VALUES (?, ?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getName());
            pst.setString(2, t.getPrice() + "");
            
            kq = pst.executeUpdate();
            
            JDBC.closeConnection(c);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return kq;
    }

    @Override
    public int update(TLDModel t) {
        int kq = 0;
        try {
            Connection c = JDBC.getConnection();
            
            String sql = "UPDATE TopLevelDomain " +
                        "Set TLD_text = ?, price = ? " +
                        "WHERE id = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getName());
            pst.setString(2, t.getPrice() + "");
            pst.setString(3, t.getId() + "");
            
            kq = pst.executeUpdate();
            
            JDBC.closeConnection(c);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return kq;
    }

    @Override
    public int delete(TLDModel t) {
        int kq = 0;
        try {
            Connection c = JDBC.getConnection();
            
            String sql = "DELETE FROM TopLevelDomain WHERE id = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getId() + "");
            
            kq = pst.executeUpdate();
            
            JDBC.closeConnection(c);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return kq;
    }

    @Override
    public ArrayList<TLDModel> selectAll() {
        ArrayList<TLDModel> kq = new ArrayList<TLDModel>();
        try {
            Connection c = JDBC.getConnection();

            String sql = "SELECT * FROM ToplevelDomain";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery(sql); // resultSet is a list of data

            System.out.println("done");
            
            // use result.next() to get 1 row
            while (resultSet.next()) {
                TLDModel tlds = new TLDModel();
                
                //  use result.getString("column name") to get data at the column
                tlds.setId(Integer.parseInt(resultSet.getString("id")));
                tlds.setName(resultSet.getString("TLD_text"));
                tlds.setPrice(Integer.parseInt(resultSet.getString("price")));
                kq.add(tlds);
            }

            // Step 5: close connection
            JDBC.closeConnection(c);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return kq;
    }

    @Override
    public TLDModel selectById(TLDModel t) {
        TLDModel kq = new TLDModel();
        try {
            Connection connection = JDBC.getConnection();

            String sql = "SELECT * FROM topleveldomain WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getId() + "");
            
            ResultSet resultSet = pst.executeQuery(); // resultSet is a list of data

            while (resultSet.next()) {
                
                //  use result.getString("column name") to get data at the column
                kq.setId(Integer.parseInt(resultSet.getString("id")));
                kq.setName(resultSet.getString("TLD_text"));
                kq.setPrice(Integer.parseInt(resultSet.getString("price")));
            }
            JDBC.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return kq;
    }

    @Override
    public ArrayList<TLDModel> selectByCondition(String condition) {
        ArrayList<TLDModel> kq = new ArrayList<TLDModel>();
        try {
            Connection c = JDBC.getConnection();

            String sql = "SELECT * FROM topleveldomain WHERE " + condition;
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery(sql); // resultSet is a list of data

            System.out.println("done");
            
            // use result.next() to get 1 row
            while (resultSet.next()) {
                TLDModel tlds = new TLDModel();
                
                //  use result.getString("column name") to get data at the column
                tlds.setId(Integer.parseInt(resultSet.getString("id")));
                tlds.setName(resultSet.getString("TLD_text"));
                tlds.setPrice(Integer.parseInt(resultSet.getString("price")));
                kq.add(tlds);
            }

            // Step 5: close connection
            JDBC.closeConnection(c);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return kq;
    }
    
}
