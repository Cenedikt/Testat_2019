/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

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
    
    public void instructorModle()
    {
        String col[]={"ID", "Name", "Prename", "Birthdate", "Sex", "Spesification", "Workrealtion"};
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
        Gui.CreateManagingFrame.instructorIDTable.setModel(tbaleModel);
    }
    
    public void readInstructor() throws SQLException
    {
        String readInstructor;
        readInstructor="SELECT * FROM Instructor;";
        stmt=connection.connectToDb().createStatement();
        ResultSet rs = stmt.executeQuery(readInstructor);
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnName = new Vector<>();
        int countColum = metaData.getColumnCount();
        for(int i =1; i<=countColum;i++)
        {
            columnName.add(metaData.getColumnName(i));
        }
        Vector<Vector<Object>> instructorData= new Vector<>();
        while(rs.next())
        {
            Vector<Object> data =new Vector<>();
            for(int i =1;i<= countColum;i++)
            {
                data.add(rs.getObject(i));
            }
            instructorData.add(data);
        } 
        System.out.println("Instructor has been loded");
        stmt.close();
        connection.dbClose();
        DefaultTableModel tbaleModel =(DefaultTableModel) Gui.MainFrame.instructorTable.getModel();
        tbaleModel.setDataVector(instructorData, columnName);        
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
        Gui.CreateManagingFrame.coursIDTable.setModel(tbaleModel);
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
}
