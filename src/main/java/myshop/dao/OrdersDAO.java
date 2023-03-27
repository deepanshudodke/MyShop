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
import myshop.dbutil.DBConnection;
import myshop.pojo.ProductsPojo;
import myshop.pojo.UserProfile;

/**
 *
 * @author notde
 */
public class OrdersDAO {
    
    public static String getNextOrderId() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        
        ResultSet rs=st.executeQuery("Select max(order_id) from orders");
        
        rs.next();
        
        String order_id=rs.getString(1);
        if(order_id==null)
            return "O-101";
        int orderNo=Integer.parseInt(order_id.substring(2));
        orderNo=orderNo+1;
        return "O-"+orderNo;
        
    }
     
    public static boolean addOrder(ArrayList <ProductsPojo> al,String orderId) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into orders values(?,?,?,?)");
        
        int count=0;
        for(ProductsPojo p:al)
        {
            ps.setString(1, orderId);
            ps.setString(2,p.getProductId());
            ps.setInt(3,p.getQuantity());
            ps.setString(4,UserProfile.getUserid());
            count=count+ps.executeUpdate();
        }
        
        return count==al.size();
    }
    
}
