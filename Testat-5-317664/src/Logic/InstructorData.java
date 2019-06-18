/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Benedict
 */
public class InstructorData 
{    
    private final DBConnection connection = new DBConnection();
    
    /**
     * adds the instructor to DB
     * @param name
     * @param prename
     * @param birtdate
     * @param sex
     * @param spesification
     * @param workrelation
     * @throws SQLException 
     */
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
    
    /**
     * delets the Instructor in the DB and their Relationship
     * <br>Relationship means the realtion between cours and Instructor
     * @param id
     * @throws SQLException 
     */
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
    
    /**
     * setes the modle of the Jtable in the gui
     */
    public void instructorModle()
    {
        String col[]={""};
        DefaultTableModel tbaleModel = new DefaultTableModel(col, 0) 
        {
            public boolean isCellEditable(int row, int col) 
            {
                //first column not editable
                if (col == 0) 
                {
                    return false;
                } 
                else 
                {
                    return true;
                }
            }
        }; 
        Gui.MainFrame.instructorTable.setModel(tbaleModel);
    }
}
