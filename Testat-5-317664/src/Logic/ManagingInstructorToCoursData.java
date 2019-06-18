/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Cenedikt
 */
public class ManagingInstructorToCoursData 
{
    private DBConnection connection = new DBConnection();
    
    /**
     * Adds the relationship between an cours and an instructor
     * @param instructorID
     * @param coursID
     * @throws SQLException 
     */
    public void addManagingInstructorToCours(int instructorID, int coursID) throws SQLException
    {
       String addManagingInstructorToCours;
       addManagingInstructorToCours="INSERT INTO Manage (InstructorID,CoursID) VALUES(?,?)";
       try (PreparedStatement pstmt = connection.connectToDb().prepareStatement(addManagingInstructorToCours)) 
       {
           pstmt.setInt(1, instructorID);
           pstmt.setInt(2, coursID);
           pstmt.execute(); 
           pstmt.close();
       }
       System.out.println("Managing Instructor To Cours has been added");
       connection.dbClose();
    }
    
    /**
     * delets the relationship between Cours and instructor
     * @param id
     * @throws SQLException 
     */
    public void deleteManagingInstructorToCours(int id) throws SQLException
    {
        String deleteManagingInstructorToCours;
        deleteManagingInstructorToCours="DELETE FROM Manage WHERE ID=?";
        try(PreparedStatement pstmt = connection.connectToDb().prepareStatement(deleteManagingInstructorToCours))
        {
            pstmt.setInt(1, id);
            pstmt.execute();
            pstmt.close();
        }
        System.out.println("Managing Instructor To Cours has been deleted");
    }
}
