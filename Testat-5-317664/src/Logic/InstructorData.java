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
public class InstructorData 
{    
    private final DBConnection connection = new DBConnection();
    
    public void addInstructor(String name, String prename, LocalDate birtdate, String sex, String spesification, String workrelation) throws SQLException
    {
        String addInstructor;
        addInstructor = "INSERT INTO Instructor (Name,Prename,Birthdate,Sex,Spesification,Workrelation) VALUES (?,?,?,?,?,?);";
        try (PreparedStatement pstmt = connection.connectToDb().prepareStatement(addInstructor)) 
        {
            pstmt.setString(1, name);
            pstmt.setString(2, prename);
            String birthdateasString=birtdate.toString();            
            pstmt.setString(3, birthdateasString);
            pstmt.setString(4, sex);
            pstmt.setString(5, spesification);
            pstmt.setString(6, workrelation);
            pstmt.execute();
            pstmt.close();
        }
        System.out.println("Instructor has been added to the DB");
        connection.dbClose();
    }
    
    
    public void deleteInstructor(int id) throws SQLException
    {
        String deleteInstructor;
        deleteInstructor="DELETE FROM Cours as c,  WHERE c.ID=?;";
        try(PreparedStatement pstmt = connection.connectToDb().prepareStatement(deleteInstructor))
        {
            pstmt.setInt(1,id);
            pstmt.execute();
            pstmt.close();
        }
        System.out.println("Instructor has been deleted");
        connection.dbClose();
    }
}
