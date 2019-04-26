/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayParadise;

/**
 *
 * @author Cenedikt
 */
public class Course 
{
 private int cousrseID;
 private String cousrsName;

    public int getCousrseID() 
    {
        return cousrseID;
    }

    public void setCousrseID(int pCousrseID) 
    {
        this.cousrseID = pCousrseID;
    }

    public String getCousrsName() 
    {
        return cousrsName;
    }

    public void setCousrsName(String pCousrsName) 
    {
        this.cousrsName = pCousrsName;
    }
    
    public void Course(String pCousrsName, int pCousrseID)
    {
        this.setCousrsName(pCousrsName);
        this.setCousrseID(pCousrseID);
    }
}
