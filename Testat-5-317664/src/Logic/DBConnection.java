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
   private String url= "jdbc:sqlite:Hotel.db";
   private Connection conn = null;
   
   /**
    * connects to the db 
    */
   public void connectToDb() throws SQLException
   {
        try
        {
            conn = DriverManager.getConnection(url);
            System.out.println("Connectet to db");
            
            String createInstructorTable;
            createInstructorTable="CREATE TABLE \\\"CoustomerToCourse\\\" (\\n\"\n" +
"                    + \"	\\\"ID\\\"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\\n\"\n" +
"                    + \"	\\\"FK_Customer\\\"	INTEGER NOT NULL,\\n\"\n" +
"                    + \"	\\\"FK_Course\\\"	INTEGER NOT NULL,\\n\"\n" +
"                    + \"	FOREIGN KEY(\\\"FK_Course\\\") REFERENCES \\\"Course\\\"(\\\"ID\\\"),\\n\"\n" +
"                    + \"	FOREIGN KEY(\\\"FK_Customer\\\") REFERENCES \\\"Customer\\\"(\\\"ID\\\")\\n\"\n" +
"                    + \");";
            Statement stmt  = conn.createStatement();
            stmt.execute(createInstructorTable);
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage()); 
        }
        conn.close();
   }    
}
