/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayParadise;

import java.util.ArrayList;

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
    private String dateOfCourse;
    private String weekday;
    private ArrayList<Integer> customerIDList = new ArrayList<Integer>();
    private ArrayList<Integer> instructorIDList = new ArrayList<Integer>();
    
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
    public String getDateOfCourse() 
    {
        return this.dateOfCourse;
    }
    
    /**
     * 
     * @param dateOfCourse 
     */
    public void setDateOfCourse(String dateOfCourse) 
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
     * @param pIndex
     * @return customerID
     */
    public int getCustomerID(int pIndex)
    {
        return this.customerIDList.get(pIndex);
    }
    
    /**
     * 
     */
    public void getCustomerID()
    {
        for(int i=0;i<this.customerIDList.size();i++)
        {
            System.out.println(this.getCustomerID(i));
        }
    }
    
    /**
     * 
     * @param pcustomerID 
     */
    public void setCustomerID(int pcustomerID)
    {
        this.customerIDList.add(pcustomerID);
    }
    
    /**
     * 
     * @param pIndex
     * @return instructorID
     */
    public int getInstructorID(int pIndex)
    {
        return this.instructorIDList.get(pIndex);
    }
    
    /**
     * 
     */
    public void getInstructorID()
    {
        for(int i=0; i<this.instructorIDList.size();i++)
        {
            System.out.println(this.getInstructorID(i));
        }    
    }
    
    /**
     * 
     * @param pInstructorID 
     */
    public void setInstructorID(int pInstructorID) 
    {
        this.instructorIDList.add(pInstructorID);
    }
    
    /**
     * 
     */
    public Course()
    {
        this.setCousrseID(Course.lastID++);
    }
}
