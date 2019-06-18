/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Benedict
 */
public class CustumorData 
{
    private DBConnection connection = new DBConnection();
    
    public void addCoustomer(String title, String name, String prename, LocalDate birtdate, String sex) throws SQLException
    {
        String addCoustomer;
        addCoustomer = "INSERT INTO Customer (Title,Name,Prename,Birthdate,Sex) VALUES (?,?,?,?,?);";
        try (PreparedStatement pstmt = connection.connectToDb().prepareStatement(addCoustomer)) 
        {
            pstmt.setString(1, title);
            pstmt.setString(2, name);           
            pstmt.setString(3, prename);
            String birthdateasString=birtdate.toString();  
            pstmt.setString(4, birthdateasString);
            pstmt.setString(5, sex);
            pstmt.execute();
        }
        System.out.println("Customer has been added to the DB");
        connection.dbClose();
    }    
}
