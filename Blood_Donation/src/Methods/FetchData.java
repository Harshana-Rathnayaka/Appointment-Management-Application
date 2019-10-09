/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import DBConnection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hash
 */
public class FetchData {
    
   
    
    public void Insert(char operation, String name, String age, String location,
                                            String bloodGrp, String contact, String date, String eligibility)
    {
        
         Connection con = DbConnection.getConnection();
        PreparedStatement ps;
        
        // i for inserting into confirmed
        if(operation == 'i')
        {
            try {
                ps = con.prepareStatement("Insert into confirmed (name, age, location, bloodGroup, contact, date, eligibility) values (?,?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, age);
            ps.setString(3, location);
            ps.setString(4, bloodGrp);
            ps.setString(5, contact);
            ps.setString(6, date);
            ps.setString(7, eligibility);
            
            if (ps.executeUpdate()>0)
            {

            }
            
            } catch (SQLException ex) {
                Logger.getLogger(FetchData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
        
        public void Update(char operation, String name, String location,
                                            String bloodGrp, String contact, String status)
        {
             Connection con = DbConnection.getConnection();
        PreparedStatement ps;
            
        // u for inserting into completed 
        if(operation == 'u')
        {
            try {
                ps = con.prepareStatement("Insert into completed (name, location, bloodGroup, contact, status) values (?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, location);
            ps.setString(3, bloodGrp);
            ps.setString(4, contact);
            ps.setString(5, status);
            
            
            if (ps.executeUpdate()>0)
            {
                JOptionPane.showMessageDialog(null, "Appointment marked as Completed");
            }
            
            
            } catch (SQLException ex) {
                Logger.getLogger(FetchData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
        
        public void Delete(char operation, String name, String age, String location,
                                            String bloodGrp, String contact)
        {
             Connection con = DbConnection.getConnection();
        PreparedStatement ps;
            
        // d for deleting from requests 
        if(operation == 'd')
        {
            try {
                ps = con.prepareStatement("delete from requests where name = ?");
            ps.setString(1, name);
            
            if (ps.executeUpdate()>0)
            {
                
            }
            
            
            } catch (SQLException ex) {
                Logger.getLogger(FetchData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
        
        public void Delete2(char operation, String name, String location,
                                            String bloodGrp, String contact, String date)
        {
             Connection con = DbConnection.getConnection();
        PreparedStatement ps;
            
        // c for deleting confirmed 
        if(operation == 'c')
        {
            try {
                ps = con.prepareStatement("delete from confirmed where name = ?");
            ps.setString(1, name);
            
            if (ps.executeUpdate()>0)
            {
                
            }
            
            
            } catch (SQLException ex) {
                Logger.getLogger(FetchData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
        
    
    public void fillJTable(JTable table, String valueToSearch)
    {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("select * from requests where concat (name, age, location, bloodGroup, contact) like ?");
            ps.setString(1,"%" +valueToSearch+ "%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object [] row;
            
            while(rs.next())
            {
                row = new Object[5];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                
                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FetchData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
