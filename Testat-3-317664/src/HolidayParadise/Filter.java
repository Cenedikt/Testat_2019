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
public class Filter 
{
    private Data data= new Data();
    
    /**
     * checks which input is an coorect input of the colums to updaten an touble of the Instructor
     * @param pInput
     * @return compare
     */
    public boolean compareInstructor(String pInput)
    {
        boolean compare;
        
        compare=true;
        
        if(!(pInput.equals("name")||pInput.equals("Name")))
        {
            if(!(pInput.equals("prename")||pInput.equals("Prename")))
            {
                if(!(pInput.equals("birthday")||pInput.equals("Birthday")))
                {
                    if(!(pInput.equals("sex")||pInput.equals("Sex")))
                    {
                        if(!(pInput.equals("spesification")||pInput.equals("Spesification")))
                        {
                            if(!(pInput.equals("workRelation")||pInput.equals("WorkRelation")))
                            {
                                if(!(pInput.equals("CoursID")||pInput.equals("coursID")))
                                {
                                    compare=false;
                                }
                            }
                        }
                    }
                }
            }
        }    
        return compare;
    }
    
    /**
     * checks which input is an coorect input of the colums to updaten an touble of the customer
     * @param pInput
     * @return compare
     */
    public boolean compareCustomer(String pInput)
    {
        boolean compare;
        
        compare=true;

        if(!(pInput.equals("name")||pInput.equals("Name")))
        {
           if(!(pInput.equals("prename")||pInput.equals("Prename")))
           {
                if(!(pInput.equals("title")||pInput.equals("Title")))
                {
                    if(!(pInput.equals("sex")||pInput.equals("Sex")))
                    {
                        if(!(pInput.equals("birthday")||pInput.equals("Birthday")))
                        {
                         compare=false;   
                        }
                    }
                }            
           }
        }     
        return compare;
    }

    /**
     * checks which input is an coorect input of the colums to updaten an touble of the cours
     * @param pInput
     * @return compare
     */
    public boolean compareCourse(String pInput)
    {
        boolean compare;
        
        compare=true;
        
        if(!(pInput.equals("name")||pInput.equals("Name")))
        {
            if(!(pInput.equals("start")||pInput.equals("Start")))
            {
                if(!(pInput.equals("End")||pInput.equals("end")))
                {
                    if(!(pInput.equals("date")||pInput.equals("date")))
                    {
                        if(!(pInput.equals("day")||pInput.equals("Day")))
                        {
                            compare=false;
                        }
                    }
                }
            }
        }
        return compare;
    }
 
    /**
     * checks if the Insturctor allready exists
     * @param pInstructorName
     * @param pInstructorPrname
     * @param pBirthDate
     * @param pSex
     * @return compare
     */
    public boolean compareInstructor(String pInstructorName, String pInstructorPrname, LocalDate pBirthDate, String pSex)
    {
        boolean compare;
        String oldData;
        String newData;
        
        compare=false;
        newData=pInstructorName+","+pInstructorPrname+","+pBirthDate+","+pSex;
        for(int i=0; i<= data.getInstructorListSize();i++)
        {            
            oldData=data.getInstructorListCompare(i);
            if(oldData.equals(newData))
            {
                compare=true;
            }
        }
        return compare;
    }
    
    /**
     * checks if the Customer allready exists
     * @param pTitle
     * @param pCustomerName
     * @param pCustomerPrname
     * @param pBirthDate
     * @param pSex
     * @return compare
     */
    public boolean compareCustomer(String pTitle, String pCustomerName, String pCustomerPrname, LocalDate pBirthDate, String pSex)
    {
        boolean compare;
        String oldData;
        String newData;
        
        compare=false;
        newData=pTitle+""+pCustomerName+","+pCustomerPrname+","+pBirthDate+","+pSex;
        for(int i=0; i<=data.getCustomerListSize();i++)
        {            
            oldData=data.getCustomerCompare(i);
            if(oldData.equals(newData))
            {
                compare=true;
            }
            else
            {
            }
        }
        return compare;
    }
    
    /**
     * checks if the cours allready exists
     * @param pCoursName
     * @param pBeginingOfCourse
     * @param pEndOfCourse
     * @param pDateOfCourse
     * @param pWeekday
     * @return compare
     */
    public boolean compareCours(String pCoursName, String pBeginingOfCourse, String pEndOfCourse, LocalDate pDateOfCourse, String pWeekday)
    {
        boolean compare;
        String oldData;
        String newData;
        
        compare=false;
        newData=pCoursName+","+pBeginingOfCourse+","+pEndOfCourse+","+pDateOfCourse+","+pWeekday;
        for(int i=0; i<=data.getCourseListSize();i++)
        {            
            oldData=data.getCourseListCompare(i);
            if(oldData.equals(newData))
            {
                compare=true;
                break;
            }
        }
        return compare;
    }
}
