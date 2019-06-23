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
import java.time.LocalDate;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Benedict
 */
public class InstructorData 
{    
    private final DBConnection connection = new DBConnection();
    private Statement stmt;
    
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
        Gui.MainFrame.instructorTable.setModel(tbaleModel);
        TableModelListener modelListener = new TableModelListener() 
        {
            public void tableChanged(TableModelEvent evt) 
            {
                Boolean error = false;

                try 
                {
                    int rows = Gui.MainFrame.instructorTable.getRowCount();

                    for (int row = 0; row < rows; row++) {
                        String id = (Gui.MainFrame.instructorTable.getModel().getValueAt(row, 0).toString());
                        Integer idToInt = Integer.valueOf(id);
                        String name = (Gui.MainFrame.instructorTable.getModel().getValueAt(row, 1).toString());
                        String prename = (Gui.MainFrame.instructorTable.getModel().getValueAt(row, 2).toString());
                        String birthdate = (Gui.MainFrame.instructorTable.getModel().getValueAt(row, 3).toString());
                        String sex = (Gui.MainFrame.instructorTable.getModel().getValueAt(row, 4).toString());
                        String spesification = (Gui.MainFrame.instructorTable.getModel().getValueAt(row, 5).toString());
                        String workrelation = (Gui.MainFrame.instructorTable.getModel().getValueAt(row, 6).toString());
                        updateInstructor(name, prename, birthdate, sex, spesification, workrelation, idToInt);
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
                        System.out.println("Saving successfull");
                    }
                }
            }
        };
        tbaleModel.addTableModelListener(modelListener);
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
    
    public void updateInstructor(String name, String prename, String birthdate, String sex, String spesification, String workrelation, int id) throws SQLException
    {
        String updateInstructor;
        updateInstructor="UPDATE Instructor"
                        +"SET Name=?, Prename=?, Birthdate=?, Sex=?, Spesification=?, Workrelation=?"
                        +"WHERE ID=?;";
        PreparedStatement pstmt=connection.connectToDb().prepareStatement(updateInstructor);
        pstmt.setString(0, name);
        pstmt.setString(1, prename);
        pstmt.setString(2, birthdate);
        pstmt.setString(3, spesification);
        pstmt.setString(4, workrelation);
        pstmt.setString(5, sex);
        pstmt.setInt(6, id);
        pstmt.executeUpdate();
        pstmt.close();
        System.out.println("Instructor has been updated");
        connection.dbClose();
    }
    
    public void removInstructor() throws SQLException
    {
        int[] selectedRows = Gui.MainFrame.instructorTable.getSelectedRows();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                String idAsString = (Gui.MainFrame.instructorTable.getValueAt(selectedRows[i], 0).toString());
                int id = Integer.valueOf(idAsString);
                deleteInstructor(id);
            }
        }
        readInstructor();  
    }
}
