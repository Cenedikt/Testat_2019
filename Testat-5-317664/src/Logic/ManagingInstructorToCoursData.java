/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cenedikt
 */
public class ManagingInstructorToCoursData 
{
    private DBConnection connection = new DBConnection();
    private Statement stmt;
    
    /**
     * Adds the relationship between an cours and an instructor
     * @param instructorID
     * @param coursID
     * @throws SQLException 
     */
    public void addManagingInstructorToCours(int instructorID, int coursID) throws SQLException
    {
       String addManagingInstructorToCours;
       addManagingInstructorToCours="INSERT INTO Manage (InstructorID,CoursID) VALUES(?,?);";
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
    
    /**
     * set the modle of the table in the gui
     */
    public void manageModle()
    {
        String col[] = {"ID", "InstructorID", "InstructorName", "CoursID", "CoursName"};
        DefaultTableModel tbaleModel = new DefaultTableModel(col, 0) 
        {
            public boolean isCellEditable(int row, int col) 
            {
                
                if (col <= 5) 
                {
                    return false;
                } 
                else 
                {
                    return true;
                }
            }
        };
        Gui.MainFrame.managingTable.setModel(tbaleModel);
    }
    
    /**
     * reds the data from the db and iports it into the jtable
     * @throws SQLException 
     */
    public void readManage() throws SQLException
    {
        String readManage;
        readManage="SELECT m.ID,m.InstructorID,i.Name,m.CoursID,c.Name\n" +
                    "FROM Manage AS m, Instructor AS i, Cours AS c\n" +
                    "WHERE m.InstructorID=i.ID\n" +
                    "AND m.CoursID=c.ID;";
        stmt=connection.connectToDb().createStatement();
        ResultSet rs = stmt.executeQuery(readManage);
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnName = new Vector<>();
        int countColum = metaData.getColumnCount();
        for(int i =1; i<=countColum;i++)
        {
            columnName.add(metaData.getColumnName(i));
        }
        Vector<Vector<Object>> manageData= new Vector<>();
        while(rs.next())
        {
            Vector<Object> data =new Vector<>();
            for(int i =1;i<= countColum;i++)
            {
                data.add(rs.getObject(i));
            }
            manageData.add(data);
        } 
        System.out.println("Manage has been loded");
        stmt.close();
        connection.dbClose();
        DefaultTableModel tbaleModel =(DefaultTableModel) Gui.MainFrame.managingTable.getModel();
        tbaleModel.setDataVector(manageData, columnName);        
    }
    
    /**
     * removes the data from the jtable
     * @throws SQLException 
     */
    public void removManage() throws SQLException
    {
        int[] selectedRows = Gui.MainFrame.managingTable.getSelectedRows();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                String idAsString = (Gui.MainFrame.managingTable.getValueAt(selectedRows[i], 0).toString());
                int id = Integer.valueOf(idAsString);
                deleteManagingInstructorToCours(id);
            }
        }
        readManage();
    }
    
    /**
     * imports the data to jtable "courses"
     */
    public static void readCours() 
    {
        String col[] = {"CourseID", "Name"};
        DefaultTableModel tablemodel = new DefaultTableModel(col, 0) 
        {
            public boolean isCellEditable(int row, int col) 
            {
                if (col <= 2) 
                {
                    return false;
                } 
                else 
                {
                    return true;
                }
            }
        };
        Gui.CreateManagingFrame.coursIDTable.setModel(tablemodel);        
        DefaultTableModel tableModel = (DefaultTableModel) Gui.CreateManagingFrame.coursIDTable.getModel();
        String url= "jdbc:sqlite:HolidayParadise.db";
        Connection conn=null;
        try  
        {
            conn=DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID,Name FROM Cours;");
            ResultSetMetaData metaData = rs.getMetaData();            
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) 
            {
                columnNames.add(metaData.getColumnName(i));
            }

            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) 
                {
                    vector.add(rs.getObject(i));
                }
                data.add(vector);
            }
            tableModel.setDataVector(data, columnNames);
            conn.close();
        } 
        catch (Exception e) 
        {
        }
        System.out.println("cours has been loded");       
    }
    
    /**
     * imports the data to jtable "courses"
     */
    public static void readInstructor() 
    {
        String col[] = {"ID", "Name"};
        DefaultTableModel tablemodel = new DefaultTableModel(col, 0) 
        {
            public boolean isCellEditable(int row, int col) 
            {
                if (col <= 2) 
                {
                    return false;
                } 
                else 
                {
                    return true;
                }
            }
        };
        Gui.CreateManagingFrame.instructorIDTable.setModel(tablemodel);        
        DefaultTableModel tableModel = (DefaultTableModel) Gui.CreateManagingFrame.instructorIDTable.getModel();
        String url= "jdbc:sqlite:HolidayParadise.db";
        Connection conn=null;
        try  
        {
            conn=DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID,Name FROM Instructor;");
            ResultSetMetaData metaData = rs.getMetaData();          
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) 
            {
                columnNames.add(metaData.getColumnName(i));
            }

            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) 
            {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) 
                {
                    vector.add(rs.getObject(i));
                }
                data.add(vector);
            }
            tableModel.setDataVector(data, columnNames);
            conn.close();
        } 
        catch (Exception e) 
        {
        }
        System.out.println("Instructor has been loded");       
    } 
}
