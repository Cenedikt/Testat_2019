/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Cenedikt
 */
public class DBConnection 
{
    
   private String url= "jdbc:sqlite:HolidayParadise.db";
   private Connection conn = null;
   
   /**
    * connects to the db and creats the tabels if the tables dont exist
    */
   public void connectToDb() throws SQLException
   {
        try
        {
            conn = DriverManager.getConnection(url);
            System.out.println("Connectet to db");
            
            String createInstructorTable;
            String createManageTable;
            String createCoursTable;
            String createCustomerTable;
            String createBookingTable;
            
            createBookingTable="CREATE TABLE IF NOT EXIST \"Booking\" (\n" +
                               "    ID         INTEGER PRIMARY KEY,\n" +
                               "    CustomerID INTEGER REFERENCES Customer (ID),\n" +
                               "    CoursID    INTEGER REFERENCES Cours (ID) \n" +
                               ");"
            ;
            
            createCoursTable="CREATE TABLE IF NOT EXISTS \"Cours\" (\n" +
                             "    ID      INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                             "    Name    TEXT    NOT NULL,\n" +
                             "    [Begin] STRING  NOT NULL,\n" +
                             "    [End]   STRING  NOT NULL,\n" +
                             "    Date    DATE    NOT NULL,\n" +
                             "    Day     STRING  NOT NULL\n" +
                             ");"
            ;
            
            createCustomerTable="CREATE TABLE IF NOT EXISTS \"Customer\" (\n" +
                                "    ID        INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                                "    Title     STRING  NOT NULL,\n" +
                                "    Name      TEXT    NOT NULL,\n" +
                                "    Prename   TEXT    NOT NULL,\n" +
                                "    Birthdate DATE    NOT NULL,\n" +
                                "    Sex       STRING  NOT NULL\n" +
                                ");"
            ;
            
            createInstructorTable="CREATE TABLE IF NOT EXISTS \"Instructor\" (\n" +
                                  "    ID            INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                                  "    Name          TEXT    NOT NULL,\n" +
                                  "    Prename       TEXT    NOT NULL,\n" +
                                  "    Birthdate     DATE    NOT NULL,\n" +
                                  "    Sex           STRING  NOT NULL,\n" +
                                  "    Spesification TEXT    NOT NULL,\n" +
                                  "    Workrelation  STRING  NOT NULL\n" +
                                  ");"
            ;
            
            createManageTable="CREATE TABLE IF NOT EXIST \"Booking\" (\n" +
                              "    ID         INTEGER PRIMARY KEY,\n" +
                              "    CustomerID INTEGER REFERENCES Customer (ID),\n" +
                              "    CoursID    INTEGER REFERENCES Cours (ID) \n" +
                              ");"
            ;
            Statement stmt  = conn.createStatement();
            stmt.execute(createInstructorTable);
            stmt.execute(createBookingTable);
            stmt.execute(createCoursTable);
            stmt.execute(createCustomerTable);
            stmt.execute(createManageTable);
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage()); 
        }
        finally
        {
            try
            {
                conn.close();
                System.out.println("DB connection has been closed");
            }
            catch(SQLException exception)
            {
                System.out.println(exception.getMessage());
            }
        }
        
   }    
}
