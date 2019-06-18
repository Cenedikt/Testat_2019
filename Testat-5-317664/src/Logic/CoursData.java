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
import javax.swing.table.DefaultTableModel;

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
        addCours = "INSERT INTO Cours (Name,Begin,End,Date,Day) VALUES (?,?,?,?,?);";
        try (PreparedStatement pstmt = connection.connectToDb().prepareStatement(addCours)) 
        {
            pstmt.setString(1, name);
            pstmt.setString(2, begin);
            pstmt.setString(3, end);
            String dateasString=date.toString();
            pstmt.setString(4, dateasString);
            pstmt.setString(5, day);
            pstmt.execute();
            pstmt.close();
        }
        System.out.println("Cours has been added to the DB");
        connection.dbClose();
    }
    
    public void deleteCours(int id) throws SQLException
    {
        String deleteCours;
        deleteCours="DELETE FROM Cours as c,  WHERE c.ID=?;";
        try(PreparedStatement pstmt = connection.connectToDb().prepareStatement(deleteCours))
        {
            pstmt.setInt(1,id);
            pstmt.execute();
            pstmt.close();
        }
        System.out.println("Cours has been deleted");
        connection.dbClose();
    }
    
    public void readCours()
    {
        String col[] = {"ID", "Name", "Begin", "End", "Date", "Day"};
        DefaultTableModel tbaleModel = new DefaultTableModel(col, 0) {
            public boolean isCellEditable(int row, int col) {
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
        Gui.MainFrame.coursTable.setModel(tbaleModel);
        String readCours;
        readCours="SELECT * FROM Cours;";
    }
    
    public void updateCours()
    {
        
    }
}
