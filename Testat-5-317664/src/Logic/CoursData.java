/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.LocalDate;

/**
 *
 * @author Benedict
 */
public class CoursData 
{
    private DBConnection connection = new DBConnection();
    
    public void addCours(String name, String begin, String end, LocalDate date, String day) throws SQLException
    {
        String addCours;
        addCours = "INSERT INTO COURS (Name,Begin,End,Date,Day) VALUES (?,?,?,?,?);";
        try (PreparedStatement pstmt = connection.connectToDb().prepareStatement(addCours)) 
        {
            pstmt.setString(1, name);
            pstmt.setString(2, begin);
            pstmt.setString(3, end);
            String dateasString=date.toString();
            pstmt.setString(4, dateasString);
            pstmt.setString(5, day);
            pstmt.execute();
        }
        System.out.println("Cours has been added to the DB");
        connection.dbClose();
    }
}
