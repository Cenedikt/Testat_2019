/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Benedict
 */
public class CustumorData 
{
    private DBConnection connection = new DBConnection();
    
    /**
     * adds an Customer to the DB
     * @param title
     * @param name
     * @param prename
     * @param birtdate
     * @param sex
     * @throws SQLException 
     */
    public void addCustomer(String title, String name, String prename, LocalDate birtdate, String sex) throws SQLException
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
            pstmt.close();
        }
        System.out.println("Customer has been added to the DB");
        connection.dbClose();
    } 
    
    /**
     * delets an Customer in the DB an thier bookings
     * <br>booking means the Realationship between Customer and cours
     * @throws SQLException 
     */
    public void deletCustomer(int id) throws SQLException
    {
        String deleteCustomer;
        deleteCustomer="DELETE FROM Cours as c,  WHERE c.ID=?;";
        try(PreparedStatement pstmt = connection.connectToDb().prepareStatement(deleteCustomer))
        {
            pstmt.setInt(1,id);
            pstmt.execute();
            pstmt.close();
        }
        System.out.println("Customer has been deleted");
        connection.dbClose();
    }
    
    /**
     * sets the modle of the jtable in the gui
     */
    public void customerModle()
    {
        String col[]= {};
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
        Gui.MainFrame.coursTable.setModel(tbaleModel);
    }
}
