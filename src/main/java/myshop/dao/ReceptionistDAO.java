/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import myshop.dbutil.DBConnection;
import myshop.pojo.ReceptionistPojo;
import myshop.pojo.UserPojo;

/**
 *
 * @author notde
 */
public class ReceptionistDAO {
    
    public static Map<String,String> getNonRegisteredReceptionist()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select empid,empname from employees where job='Receptionist' and empid not in(select empid from users where usertype='Receptionist')");
        
        HashMap<String,String> receptionist=new HashMap<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            String name=rs.getString(2);
            receptionist.put(id, name);
        }
        
        return receptionist;
    }
    
    public static boolean addReceptionist(UserPojo user) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into users values(?,?,?,?,?)");
        
        ps.setString(1, user.getUserid());
        ps.setString(2, user.getEmpid());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getUsertype());
        ps.setString(5, user.getUsername());
        
        int result = ps.executeUpdate();
        
        return result==1;
    }
    
    
    public static List<ReceptionistPojo> getAllReceptionistDetails() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select users.empid,empname,userid,job,salary from users,employees where usertype='Receptionist' and users.empid=employees.empid");
        ArrayList<ReceptionistPojo> al=new ArrayList<>();
        
        while(rs.next())
        {
            ReceptionistPojo recep=new ReceptionistPojo();
            recep.setEmpid(rs.getString(1));
            recep.setEmpname(rs.getString(2));
            recep.setUserid(rs.getString(3));
            recep.setJob(rs.getString(4));
            recep.setSal(rs.getDouble(5));
            
            al.add(recep);
        }
        
        return al;
    }
    
    
    public static Map<String,String> getAllReceptionistId () throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select userid,username from users where usertype='Receptionist' order by userid");
        
        HashMap<String,String> receptionist=new HashMap<>(); 
        while(rs.next())
        {
            String id=rs.getString(1);
            String name=rs.getString(2);
            receptionist.put(id, name);
        }
        
        return receptionist;
    }
    
    public static boolean updatePassword(String userid , String pwd) throws SQLException
    {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("update users set password=? where userid =?");
            
            ps.setString(1,pwd);
            ps.setString(2,userid);
            
            return ps.executeUpdate()==1;
    }
    
    public static boolean deleteReceptionist(String id) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("delete from users where userid=?");
            
            ps.setString(1,id);
           
            
            return ps.executeUpdate()==1;
    }
    
}
