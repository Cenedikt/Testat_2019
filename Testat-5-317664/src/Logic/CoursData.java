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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

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
        deleteCours="DELETE FROM Cours WHERE ID=?;";
        try(PreparedStatement pstmt = connection.connectToDb().prepareStatement(deleteCours))
        {
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            pstmt.close();
        }
        System.out.println("Cours has been deleted");
        connection.dbClose();
    }

    /**
     * removes the data set from the jTable
     * @throws SQLException 
     */
    public void removeCourse() throws SQLException 
    {
        int[] selectedRows = Gui.MainFrame.coursTable.getSelectedRows();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                String idAsString = (Gui.MainFrame.coursTable.getValueAt(selectedRows[i], 0).toString());
                int id = Integer.valueOf(idAsString);
                deleteCours(id);
            }
        }
        readCours();
    }
    
    /**
     * sets the table modelin and adds an modle lisiener
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
        
        TableModelListener modelListener = new TableModelListener() 
        {
            public void tableChanged(TableModelEvent evt) 
            {
                Boolean error = false;

                try 
                {
                    int rows = Gui.MainFrame.coursTable.getRowCount();

                    for (int row = 0; row < rows; row++) 
                    {
                        String id = (Gui.MainFrame.coursTable.getModel().getValueAt(row, 0).toString());
                        Integer idToInt = Integer.valueOf(id);
                        String name = (Gui.MainFrame.coursTable.getModel().getValueAt(row, 1).toString());
                        String begin = (Gui.MainFrame.coursTable.getModel().getValueAt(row, 2).toString());
                        String end = (Gui.MainFrame.coursTable.getModel().getValueAt(row, 3).toString());
                        String date = (Gui.MainFrame.coursTable.getModel().getValueAt(row, 4).toString());
                        String day = (Gui.MainFrame.coursTable.getModel().getValueAt(row, 5).toString());
                        updateCours(name, begin, end, date, day, idToInt);
                    }
                } 
                catch (IndexOutOfBoundsException ex) 
                {
                } 
                catch (Exception e) 
                {
                    JOptionPane.showMessageDialog(null, "Incorect input pls cehck day, time or date ");
                    System.out.println(e);
                    error = true;
                    if (error == false) 
                    {
                        System.out.println("cours has been updated");
                    }
                }
            }
        };
        tbaleModel.addTableModelListener(modelListener);
    }
    
    /**
     * reads the data from the database and puts the in the database
     * @throws SQLException 
     */
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
    
    /**
     * updates the cours in the db
     * @param name
     * @param begin
     * @param end
     * @param date
     * @param day
     * @param id
     * @throws SQLException 
     */
    public void updateCours(String name, String begin, String end, String date, String day, int id) throws SQLException
    {
        String updateCours;
        updateCours="UPDATE Cours "
                   +"SET Name = ?, Begin = ?, End = ?, Date = ?, Day = ?"
                   +"WHERE ID = ?;";
        PreparedStatement pstmt =connection.connectToDb().prepareStatement(updateCours);   
        pstmt.setString(1, name);
        pstmt.setString(2, begin);
        pstmt.setString(3, end);
        pstmt.setString(4, date);
        pstmt.setString(5, day);
        pstmt.setInt(6, id);
        pstmt.executeUpdate();
        pstmt.close();
        System.out.println("Cours has benn updatet");
        connection.dbClose();
    }
}
