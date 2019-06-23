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
public class CustumorData 
{
    private DBConnection connection = new DBConnection();
    private Statement stmt;
    
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
     * sets the modle of the jtable in the gui and adds an modle lisener
     */
    public void customerModle()
    {
        String col[]= {"ID","Title","Name","Prename","Birthdate","Sex"};
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
        Gui.MainFrame.customerTable.setModel(tbaleModel);
        TableModelListener modelListener = new TableModelListener() 
        {
            public void tableChanged(TableModelEvent evt) 
            {
                Boolean error = false;

                try 
                {
                    int rows = Gui.MainFrame.customerTable.getRowCount();

                    for (int row = 0; row < rows; row++) 
                    {
                        String id = (Gui.MainFrame.customerTable.getModel().getValueAt(row, 0).toString());
                        Integer idToInt = Integer.valueOf(id);
                        String title = (Gui.MainFrame.customerTable.getModel().getValueAt(row, 1).toString());
                        String name = (Gui.MainFrame.customerTable.getModel().getValueAt(row, 2).toString());
                        String prename = (Gui.MainFrame.customerTable.getModel().getValueAt(row, 3).toString());
                        String birthdate = (Gui.MainFrame.customerTable.getModel().getValueAt(row, 4).toString());
                        String sex = (Gui.MainFrame.customerTable.getModel().getValueAt(row, 5).toString());
                        updateCustomer(title, name, prename, birthdate, sex, idToInt);
                    }
                } 
                catch (IndexOutOfBoundsException ex) 
                {
                } 
                catch (Exception e) 
                {
                    JOptionPane.showMessageDialog(null, "Incorect input pls cehck birthdate, title and sex ");
                    System.out.println(e);
                    error = true;
                    if (error == false) 
                    {
                        System.out.println("customer updated");
                    }
                }
            }
        };
        tbaleModel.addTableModelListener(modelListener);
    }
    
    /**
     * thakes the data from the db and import them in the db
     * @throws SQLException 
     */
    public void readCustomer() throws SQLException
    {
        String readCustomer;
        readCustomer="SELECT * FROM Customer;";
        stmt=connection.connectToDb().createStatement();
        ResultSet rs = stmt.executeQuery(readCustomer);
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnName = new Vector<>();
        int countColum = metaData.getColumnCount();
        for(int i =1; i<=countColum;i++)
        {
            columnName.add(metaData.getColumnName(i));
        }
        Vector<Vector<Object>> customerData= new Vector<>();
        while(rs.next())
        {
            Vector<Object> data =new Vector<>();
            for(int i =1;i<= countColum;i++)
            {
                data.add(rs.getObject(i));
            }
            customerData.add(data);
        } 
        System.out.println("Customer has been loded");
        stmt.close();
        connection.dbClose();
        DefaultTableModel tbaleModel =(DefaultTableModel) Gui.MainFrame.customerTable.getModel();
        tbaleModel.setDataVector(customerData, columnName);        
    }
    
    /**
     * Updates the db
     * @param title
     * @param name
     * @param prename
     * @param birthdate
     * @param sex
     * @param id
     * @throws SQLException 
     */
    public void updateCustomer(String title, String name, String prename, String birthdate, String sex, int id) throws SQLException
    {
        String updateCustomer;
        updateCustomer="UPDATE Customer SET Title=?, Name=?, Prename=?, Birthdate=?,Sex=? WHERE ID=?;";
        PreparedStatement pstmt=connection.connectToDb().prepareStatement(updateCustomer);
        pstmt.setString(1, title);
        pstmt.setString(2, name);
        pstmt.setString(3, prename);
        pstmt.setString(4, birthdate);
        pstmt.setString(5, sex);
        pstmt.setInt(6, id);
        pstmt.executeUpdate();
        System.out.println("customer has been updated");
        pstmt.close();
        connection.dbClose();
    }
    
    /**
     * removes the data from the jtable
     * @throws SQLException 
     */
    public void removeCustomer() throws SQLException
    {
        int[] selectedRows = Gui.MainFrame.customerTable.getSelectedRows();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                String idAsString = (Gui.MainFrame.customerTable.getValueAt(selectedRows[i], 0).toString());
                int id = Integer.valueOf(idAsString);
                deletCustomer(id);
            }
        }
        readCustomer();
    }
}
