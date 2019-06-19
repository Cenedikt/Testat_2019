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
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *
 * @author Benedict
 */
public class CoursData 
{
    private DBConnection connection = new DBConnection();
    private Statement stmt;
    /**
     * adds the cours in the DB
     * @param name
     * @param begin
     * @param end
     * @param date
     * @param day
     * @throws SQLException 
     */
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
    
    /**
     * delets the cours int the database and their Realation
     * <br> Realtion means between cours and customer and between cours and instructor
     * @param id
     * @throws SQLException 
     */
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

    /**
     * sets the table modelin the gui
     */
    public void coursModel()
    {
        String col[] = {"ID", "Name", "Begin", "End", "Date", "Day"};
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
    
    public void readCours() throws SQLException
    {
        String readCours;
        readCours="SELECT * FROM Cours;";
        stmt=connection.connectToDb().createStatement();
        ResultSet rs = stmt.executeQuery(readCours);
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnName = new Vector<>();
        int countColum = metaData.getColumnCount();
        for(int i =1; i<=countColum;i++)
        {
            columnName.add(metaData.getColumnName(i));
        }
        Vector<Vector<Object>> coursData= new Vector<>();
        while(rs.next())
        {
            Vector<Object> data =new Vector<>();
            for(int i =1;i<= countColum;i++)
            {
                data.add(rs.getObject(i));
            }
            coursData.add(data);
        } 
        System.out.println("Cours has been loded");
        stmt.close();
        connection.dbClose();
        DefaultTableModel tbaleModel =(DefaultTableModel) Gui.MainFrame.coursTable.getModel();
        tbaleModel.setDataVector(coursData, columnName);        
    }
    
    public void updateCours()
    {
        
    }
}
