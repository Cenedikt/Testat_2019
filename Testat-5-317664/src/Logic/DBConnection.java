/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Cenedikt
 */
public class DBConnection 
{
   public Connection dbConnection()
   {
        String url = "jdbc:sqlite:Hotel.db";
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(url);
            System.out.println("Connectet to DB");
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage()); 
        }
        return conn;
   }
    
}
