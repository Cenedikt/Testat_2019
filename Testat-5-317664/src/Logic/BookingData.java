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
import java.sql.DriverManager;
import java.sql.Connection;


/**
 *
 * @author Cenedikt
 */
public class BookingData 
{
   public final DBConnection connection = new DBConnection();

   
   /**
    * adds the relationship between Customer and cours 
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
   
   /**
    * creats the moddle of the table
    */
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

   /**
    * removs boking from the table
    * @throws SQLException 
    */
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
        Statement stmt;
        String readBooking;
        readBooking="SELECT b.ID,b.CustomerID,cu.Name,b.CoursID,c.Name\n" +
                    "FROM Booking AS b, Customer AS cu, Cours AS c\n" +
                    "WHERE b.CustomerID=cu.ID\n" +
                    "AND b.CoursID=c.ID;";
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
     * imports the data to jtable "courses"
     */
    public static void readCours() 
    {
        String col[] = {"CourseID", "Name"};
        DefaultTableModel tablemodel = new DefaultTableModel(col, 0) {
            public boolean isCellEditable(int row, int col) {
                //s
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
        Gui.CreateBookingFrame.coursTable.setModel(tablemodel);        
        DefaultTableModel tableModel = (DefaultTableModel) Gui.CreateBookingFrame.coursTable.getModel();
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
    
        public static void readCustomer() 
    {
        String col[] = {"CustomerID", "Name"};
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
        Gui.CreateBookingFrame.customerTable.setModel(tablemodel);        
        DefaultTableModel tableModel = (DefaultTableModel) Gui.CreateBookingFrame.customerTable.getModel();
        String url= "jdbc:sqlite:HolidayParadise.db";
        Connection conn=null;
        try  
        {
            conn=DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID,Name FROM Customer;");
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
        System.out.println("customer has been loded");
    }

    public void getCoursesForInstructor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
