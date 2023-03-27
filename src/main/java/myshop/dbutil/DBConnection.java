/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshop.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author notde
 */
public class DBConnection {
    private static Connection conn;   // Static block can only access static variables
    
    static
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//ANSHU:1521/XE","grocery","grocery");
            JOptionPane.showMessageDialog(null,"Connection Opened Successfully");
            
        }
        
        catch(ClassNotFoundException ex)
        {
                JOptionPane.showMessageDialog(null,"Error in loading the Driver","Driver Error",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
                System.exit(1);
        }
            
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"Error in opening connection","DB Error",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
                System.exit(1);
            }
    }
    
    public static Connection getConnection()
    {
        return conn;
    }
    
    public static void closeConnection()
    {
        try
        {
            conn.close();   //Throws SQLException
            JOptionPane.showMessageDialog(null,"Connection Closes Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"Error in closing connection","DB Error",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
                
            }
    }
    
}
