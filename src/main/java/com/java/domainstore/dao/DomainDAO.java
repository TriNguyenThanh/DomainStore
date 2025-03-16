package com.java.domainstore.dao;

import com.java.domainstore.model.DomainModel;
import com.java.domainstore.model.DomainStatusEnum;
import com.java.domainstore.repository.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class DomainDAO implements DAOInterface<DomainModel>{
    
    // create static method for we can use without declare an object
    public static DomainDAO getInstance() {
        return new DomainDAO();
    }
    // insert a domain to database
    @Override
    public int insert(DomainModel t) {
        int kq = 0;
        try {
            Connection c = JDBC.getConnection();
            
            // use PreparedStatement to protectd database against SQL_injection
            String sql = "INSERT INTO Domain (MD_text, TLD_id, domain_status, domain_date) VALUE (?, ?, ?, ?);";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMD_text());
            pst.setString(2, t.getTLD_id() + "");
            pst.setString(3, t.getStatus().name().toLowerCase());
            
            if (t.getStatus() == DomainStatusEnum.AVAILABLE)
                pst.setString(4, null);
            else
                pst.setString(4, t.getActivateDate().toString());
            
            // use kq to count how many rows were added
            kq = pst.executeUpdate();
            
            JDBC.closeConnection(c);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        
        return kq;
    }

//     Modify a domain through its ID
    @Override
    public int update(DomainModel t) {
        int kq = 0;
        try {
            Connection c = JDBC.getConnection();
            
            String sql = "UPDATE Domain" +
                         "SET MD_text = ?, TLD_id = ?, domain_status = ?, domain_date = ?" +
                         "WHERE id = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMD_text());
            pst.setString(2, t.getTLD_id() + "");
            pst.setString(3, t.getStatus().name().toLowerCase());
            if (t.getStatus() == DomainStatusEnum.AVAILABLE)
                pst.setString(4, null);
            else
                pst.setString(4, t.getActivateDate().toString());
            pst.setString(5, t.getId()+ "");
            
            kq = pst.executeUpdate();
            
            JDBC.closeConnection(c);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        
        return kq;
    }
    
    // delete a domain by the ID. We can get its ID through its name. Use DomainModel's data constructor
    @Override
    public int delete(DomainModel t) {
                int kq = 0;
        try {
            Connection c = JDBC.getConnection();
            
            String sql = "DELETE FROM Domain WHERE id = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getId()+ "");
            
            kq = pst.executeUpdate();
            
            JDBC.closeConnection(c);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        
        return kq;
    }

    // Retrieve all domain
    @Override
    public ArrayList<DomainModel> selectAll() {
        ArrayList<DomainModel> domains = new ArrayList<>();
        try {
            Connection c = JDBC.getConnection();
            
            String sql = "SELECT d.id, d.MD_text, tld.TLD_text TLD_text, tld.id TLD_id, d.domain_status domain_status, tsi.domain_years years, TLD.price price, ts.transaction_date activateDate " +
                        "FROM domain d " +
                        "JOIN topleveldomain tld ON d.TLD_id = tld.id " +
                        "JOIN transactions_info tsi ON d.id = tsi.domain_id " +
                        "JOIN transactions ts ON tsi.transactions_id = ts.id";
            PreparedStatement pst = c.prepareStatement(sql);
            
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()) {
                DomainModel domain = new DomainModel();
                // use resultSet.getString(Column name) to retrieve the value from the desired column
                // Convert the string data type to a compatible Java data type
                // assign it to the domain object, and return it
                
                domain.setId(Integer.parseInt(resultSet.getString("id")));
                domain.setMD_text(resultSet.getString("MD_text"));
                domain.setTLD_text(resultSet.getString("TLD_text"));
                domain.setTLD_id(Integer.parseInt(resultSet.getString("TLD_id")));
                domain.setStatus(DomainStatusEnum.valueOf(resultSet.getString("domain_status").toUpperCase()));
                domain.setYears(Integer.parseInt(resultSet.getString("years")));
                domain.setPrice(Integer.parseInt(resultSet.getString("price")));
                domain.setActivateDate(Date.valueOf(resultSet.getString("activateDate")));
                
                domains.add(domain);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return domains;
    }

    // Retrieve a domain by its ID
    @Override
    public DomainModel selectById(DomainModel t) {
        DomainModel domain = new DomainModel();
        try {
            Connection c = JDBC.getConnection();
            
            String sql = "SELECT d.id, d.MD_text, tld.TLD_text TLD_text, tld.id TLD_id, d.domain_status domain_status, tsi.domain_years years, TLD.price price, ts.transaction_date activateDate " +
                        "FROM domain d " +
                        "JOIN topleveldomain tld ON d.TLD_id = tld.id " +
                        "JOIN transactions_info tsi ON d.id = tsi.domain_id " +
                        "JOIN transactions ts ON tsi.transactions_id = ts.id " +
                        "WHERE d.id = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getId()+"");
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()) {
                domain.setId(Integer.parseInt(resultSet.getString("id")));
                domain.setMD_text(resultSet.getString("MD_text"));
                domain.setTLD_text(resultSet.getString("TLD_text"));
                domain.setTLD_id(Integer.parseInt(resultSet.getString("TLD_id")));
                domain.setStatus(DomainStatusEnum.valueOf(resultSet.getString("domain_status").toUpperCase()));
                domain.setYears(Integer.parseInt(resultSet.getString("years")));
                domain.setPrice(Integer.parseInt(resultSet.getString("price")));
                domain.setActivateDate(Date.valueOf(resultSet.getString("activateDate")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return domain;
    }
    
    // Retrieve a domain by its name
    public DomainModel selectByName(DomainModel t) {
        DomainModel domain = new DomainModel();
        try {
            Connection c = JDBC.getConnection();
            
            String sql = "SELECT d.id, d.MD_text, tld.TLD_text TLD_text, tld.id TLD_id, d.domain_status domain_status, tsi.domain_years years, TLD.price price, ts.transaction_date activateDate " +
                        "FROM domain d " +
                        "JOIN topleveldomain tld ON d.TLD_id = tld.id " +
                        "JOIN transactions_info tsi ON d.id = tsi.domain_id " +
                        "JOIN transactions ts ON tsi.transactions_id = ts.id " +
                        "WHERE d.MD_text = ? and d.TLD_id = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMD_text());
            pst.setString(2, t.getTLD_id()+"");
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()) {
                domain.setId(Integer.parseInt(resultSet.getString("id")));
                domain.setMD_text(resultSet.getString("MD_text"));
                domain.setTLD_text(resultSet.getString("TLD_text"));
                domain.setTLD_id(Integer.parseInt(resultSet.getString("TLD_id")));
                domain.setStatus(DomainStatusEnum.valueOf(resultSet.getString("domain_status").toUpperCase()));
                domain.setYears(Integer.parseInt(resultSet.getString("years")));
                domain.setPrice(Integer.parseInt(resultSet.getString("price")));
                domain.setActivateDate(Date.valueOf(resultSet.getString("activateDate")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return domain;
    }

    // Retrieve a domain that meets a condition.
    @Override
    public ArrayList<DomainModel> selectByCondition(String condition) {
        ArrayList<DomainModel> domains = new ArrayList<>();
        try {
            Connection c = JDBC.getConnection();
            
            String sql = "SELECT d.id, d.MD_text, tld.TLD_text TLD_text, tld.id TLD_id, d.domain_status domain_status, tsi.domain_years years, TLD.price price, ts.transaction_date activateDate " +
                        "FROM domain d " +
                        "JOIN topleveldomain tld ON d.TLD_id = tld.id " +
                        "JOIN transactions_info tsi ON d.id = tsi.domain_id " +
                        "JOIN transactions ts ON tsi.transactions_id = ts.id " +
                        "WHERE " + condition + " ;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()) {
                DomainModel domain = new DomainModel();
                domain.setId(Integer.parseInt(resultSet.getString("id")));
                domain.setMD_text(resultSet.getString("MD_text"));
                domain.setTLD_text(resultSet.getString("TLD_text"));
                domain.setTLD_id(Integer.parseInt(resultSet.getString("TLD_id")));
                domain.setStatus(DomainStatusEnum.valueOf(resultSet.getString("domain_status").toUpperCase()));
                domain.setYears(Integer.parseInt(resultSet.getString("years")));
                domain.setPrice(Integer.parseInt(resultSet.getString("price")));
                domain.setActivateDate(Date.valueOf(resultSet.getString("activateDate")));
                
                domains.add(domain);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return domains;
    }
}
