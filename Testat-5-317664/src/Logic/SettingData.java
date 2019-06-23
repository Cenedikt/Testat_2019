/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;


import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Benedict
 */
public final class SettingData 
{
    private DBConnection connection = new DBConnection();
    
    /**
     * get the information fron the db
     * @return programName
     * @throws SQLException 
     */
    public  String getProgramName() throws SQLException
    {
        String getProgramName;
        getProgramName="SELECT Name FROM Setting WHERE ID=1;";
        Statement stmt=connection.connectToDb().createStatement();
        ResultSet rs = stmt.executeQuery(getProgramName);
        String programName = rs.getString("Name");
        connection.dbClose();
        return programName;
    }
    
    /**
     * get the information fron the db
     * @return version
     * @throws SQLException 
     */
    public String getVersion() throws SQLException
    {
        String getVersion;
        getVersion="SELECT Version FROM Setting WHERE ID=1;";
        Statement stmt=connection.connectToDb().createStatement();
        ResultSet rs = stmt.executeQuery(getVersion);
        String version = rs.getString("Version");
        connection.dbClose();
        return version;
    }
    
    /**
     * get the information fron the db
     * @return company
     * @throws SQLException 
     */
    public String getCompany() throws SQLException
    {
        String getCompany;
        getCompany="SELECT Company FROM Setting WHERE ID=1;";
        Statement stmt=connection.connectToDb().createStatement();
        ResultSet rs = stmt.executeQuery(getCompany);
        String company = rs.getString("Company");
        connection.dbClose();
        return company;
    }
    
    /**
     * set the programName in the db
     * @param ProgramName
     * @throws SQLException 
     */
    public void updateSetting(String programName,String version,String company) throws SQLException
    {
        String setProgramName;
        setProgramName="UPDATE Setting SET Version=?,Name=? ,Company=? WHERE ID=1;";
        PreparedStatement pstmt =connection.connectToDb().prepareStatement(setProgramName);
        pstmt.setString(1, version);
        pstmt.setString(2, programName);
        pstmt.setString(3, company);
        connection.dbClose();
    }
   
    /**
     * creats a default setting;
     * @throws SQLException 
     */
    public void setSetting() throws SQLException
    {
       String setSetting;
       setSetting="INSERT INTO Setting (Version,Name,Company) VALUES ('1.0','ProgramName','Companyname');";
       Statement stmt=connection.connectToDb().createStatement();
       stmt.execute(setSetting);
       connection.dbClose();
    }
    
}
