/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Cenedikt
 */
public class BookingData 
{
   public final DBConnection connection = new DBConnection();
   
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
}
