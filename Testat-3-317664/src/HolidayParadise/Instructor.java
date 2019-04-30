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
public class Instructor 
{
    private static int lastID;
    private int instructorID;
    private String instructorName;
    private String instructorPrname;
    private String birthDate;
    private String sex;
    private String spesification;
    private String workRelation;
    private ArrayList<Integer> courseIDList = new ArrayList<Integer>();
    
    /**
     * 
     * @return instructorID
     */
    public int getInstructorID()
    {
        return this.instructorID;
    }        
          
    /**
     * 
     * @param pInstructorsID 
     */
    public void setInstructorID(int pInstructorsID) 
    {
        this.instructorID = pInstructorsID;
    }
    
    /**
     * 
     * @return instructorName
     */
    public String getInstructorName() 
    {
        return this.instructorName;
    }
    
    /**
     * 
     * @param pInstructorName 
     */
    public void setInstructorName(String pInstructorName) 
    {
        this.instructorName = pInstructorName;
    }
    
    /**
     * 
     * @return instructorPrname
     */
    public String getInstructorPrname() 
    {
        return this.instructorPrname;
    }

    /**
     * 
     * @param pInstructorPrname 
     */
    public void setInstructorPrname(String pInstructorPrname) 
    {
        this.instructorPrname = pInstructorPrname;
    }
    
    /**
     * 
     * @return birthDate
     */
    public String getBirthDate() 
    {
        return this.birthDate;
    }

    /**
     * 
     * @param pBirthDate 
     */
    public void setBirthDate(String pBirthDate) 
    {
        this.birthDate = birthDate;
    }

    /**
     * 
     * @return sex
     */
    public String getSex() 
    {
        return this.sex;
    }

    /**
     * 
     * @param pSex 
     */
    public void setSex(String pSex) 
    {
        this.sex = pSex;
    }

    /**
     * 
     * @return spesification
     */
    public String getSpesification() 
    {
        return this.spesification;
    }

    /**
     * 
     * @param pSpesification 
     */
    public void setSpesification(String pSpesification) 
    {
        this.spesification = pSpesification;
    }

    /**
     * 
     * @return workRelation
     */
    public String getWorkRelation() 
    {
        return this.workRelation;
    }

    /**
     * 
     * @param pWorkRelation 
     */
    public void setWorkRelation(String pWorkRelation) 
    {
        this.workRelation = pWorkRelation;
    }

    /**
     * 
     * @param pIndex
     * @return courseID
     */
    public int getCourseIDList(int pIndex) 
    {
        return courseIDList.get(pIndex);
    }
    
    /**
     * 
     */
    public void getCourseID()
    {
        for(int i=0; i<this.courseIDList.size();i++)
        {
            System.out.println(this.courseIDList.get(i));
        }
    }
    
    /**
     * 
     * @param pCourseID 
     */
    public void setCourseID(int pCourseID) 
    {
        this.courseIDList.add(pCourseID);
    }
  
    /**
     * 
     */
    public Instructor()
    {
        this.setInstructorID(Instructor.lastID++);
    }
    
    public Instructor(boolean overload)
    {
       
    }
}
