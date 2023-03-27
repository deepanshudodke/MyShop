/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import myshop.dbutil.DBConnection;
import myshop.pojo.UserPojo;
import myshop.pojo.UserProfile;

/**
 *
 * @author notde
 */
public class UserDAO {
    
    public static boolean validateUser(UserPojo user) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from users where userid=? and password=? and usertype=?");
        ps.setString(1,user.getUserid());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUsertype());
        
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            UserProfile.setUsername(rs.getString(5));
            return true;
            
        }
        
        return false;   
    }
    
    public static boolean isUserPresent(String empid) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select 1 from users where empid=?");
        ps.setString(1, empid);
        
        ResultSet rs=ps.executeQuery();
        
        return rs.next();
    }
    
}
