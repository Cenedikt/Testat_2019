/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayParadise;
import java.time.LocalDate;

/**
 *
 * @author Cenedikt
 */
public class Course 
{
    private static int lastID;
    private int cousrseID;
    private String cousrsName;
    private String beginingOfCourse;
    private String endOfCourse;
    private LocalDate dateOfCourse;
    private String weekday;
    
    /**
     * 
     * @return cousrseID
     */
    public int getCousrseID() 
    {
        return this.cousrseID;
    }
    
    /**
     * 
     * @param pCousrseID 
     */
    public void setCousrseID(int pCousrseID) 
    {
        this.cousrseID = pCousrseID;
    }
    
    /**
     * 
     * @return cousrsName
     */
    public String getCousrsName() 
    {
        return this.cousrsName;
    }
    
    /**
     * 
     * @param pCousrsName 
     */
    public void setCousrsName(String pCousrsName) 
    {
        this.cousrsName = pCousrsName;
    }
    
    /**
     * 
     * @return beginingOfCourse
     */
    public String getBeginingOfCourse() 
    {
        return this.beginingOfCourse;
    }
    
    /**
     * 
     * @param pBeginingOfCourse 
     */
    public void setBeginingOfCourse(String pBeginingOfCourse) 
    {
        this.beginingOfCourse = pBeginingOfCourse;
    }
    
    /**
     * 
     * @return endOfCourse
     */
    public String getEndOfCourse() 
    {
        return this.endOfCourse;
    }
    
    /**
     * 
     * @param pEndOfCourse 
     */
    public void setEndOfCourse(String pEndOfCourse) 
    {
        this.endOfCourse = pEndOfCourse;
    }
    
    /**
     * 
     * @return dateOfCourse
     */
    public LocalDate getDateOfCourse() 
    {
        return this.dateOfCourse;
    }
    
    /**
     * 
     * @param dateOfCourse 
     */
    public void setDateOfCourse(LocalDate dateOfCourse) 
    {
        this.dateOfCourse = dateOfCourse;
    }
    
    /**
     * 
     * @return weekday
     */
    public String getWeekday()
    {
        return this.weekday;
    }
    
    /**
     * 
     * @param pWeekday 
     */
    public void setWeekday(String pWeekday)
    {
        this.weekday = pWeekday;
    }
    
    /**
     * 
     */
    public Course()
    {
        this.setCousrseID(Course.lastID++);
    }
    
    public Course(int pId)
    {
        this.setCousrseID(pId);
    }
}
