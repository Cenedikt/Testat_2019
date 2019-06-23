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
public class BookingData 
{
   public final DBConnection connection = new DBConnection();
   public Statement stmt;
   
   /**
    * adda the relationship between Customer and cours 
    * @param customerID
    * @param coursID
    * @throws SQLException 
    */
   public void addBooking(int customerID, int coursID) throws SQLException
   {
       String addBooking;
       addBooking="INSERT INTO Booking (CustomerID,CoursID) VALUES(?,?);";
       try (PreparedStatement pstmt = connection.connectToDb().prepareStatement(addBooking)) 
       {
           pstmt.setInt(1, customerID);
           pstmt.setInt(2, coursID);
           pstmt.execute(); 
           pstmt.close();
       }
       System.out.println("Bookin has been added");
       connection.dbClose();
   }
  
   /**
    * delets the realtionship between an cours and an Customer 
    * @param id
    * @throws SQLException 
    */
   public void deleteBooing(int id) throws SQLException
   {
       String deleteBooking;
       deleteBooking="DELETE FROM Booking WHERE ID=?;";
       try (PreparedStatement pstmt = connection.connectToDb().prepareStatement(deleteBooking)) 
       {
           pstmt.setInt(1, id);
           pstmt.execute();
       }
       System.out.println("booking has been deleted");
   }
   
   public void bookingModle()
   {
       String col[] = {"ID", "CustomerID", "CustomerName", "CoursID", "CoursName"};
        DefaultTableModel tbaleModel = new DefaultTableModel(col, 0) 
        {
            public boolean isCellEditable(int row, int col) 
            {
                //first column not editable
                if (col <=5) 
                {
                    return false;
                } 
                else 
                {
                    return true;
                }
            }
        };
        Gui.MainFrame.bookingTable.setModel(tbaleModel);
   }
    
   public void removeBooking() throws SQLException
   {
       int[] selectedRows = Gui.MainFrame.bookingTable.getSelectedRows();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                String idAsString = (Gui.MainFrame.bookingTable.getValueAt(selectedRows[i], 0).toString());
                int id = Integer.valueOf(idAsString);
                deleteBooing(id);
            }
        }
        readBooking();
   }
    /**
     * fiels the Jtable withe the data of the DB
     * @throws SQLException 
     */
       public void readBooking() throws SQLException
    {
        String readBooking;
        readBooking="SELECT * FROM Booking;";
        stmt=connection.connectToDb().createStatement();
        ResultSet rs = stmt.executeQuery(readBooking);
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnName = new Vector<>();
        int countColum = metaData.getColumnCount();
        for(int i =1; i<=countColum;i++)
        {
            columnName.add(metaData.getColumnName(i));
        }
        Vector<Vector<Object>> bookingData= new Vector<>();
        while(rs.next())
        {
            Vector<Object> data =new Vector<>();
            for(int i =1;i<= countColum;i++)
            {
                data.add(rs.getObject(i));
            }
            bookingData.add(data);
        } 
        System.out.println("Booking has been loded");
        stmt.close();
        connection.dbClose();
        DefaultTableModel tbaleModel =(DefaultTableModel) Gui.MainFrame.bookingTable.getModel();
        tbaleModel.setDataVector(bookingData, columnName);        
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
                if (col == 6) 
                {
                    return false;
                } 
                else 
                {
                    return true;
                }
            }
        };
        Gui.CreateBookingFrame.coursTable.setModel(tbaleModel);
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
        DefaultTableModel tbaleModel =(DefaultTableModel) Gui.CreateBookingFrame.coursTable.getModel();
        tbaleModel.setDataVector(coursData, columnName);        
    }
}
