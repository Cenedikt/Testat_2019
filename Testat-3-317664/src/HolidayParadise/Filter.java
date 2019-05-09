/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayParadise;

import java.util.Scanner;

/**
 *
 * @author Cenedikt
 */
public class Filter 
{
    private String input;
    private Scanner scanner = new Scanner(System.in);
    
    public void filterCustemor()
    {
        System.out.println("Do you want to filter the list? tipp Y for yes if you press somthin else their will be no filter");
        input=scanner.next();
        if(input=="Y"|input=="y")
        {
            
        }
        else
        {
        }
    }
    
    public void filterCourse()
    {
        System.out.println("Do you want to filter the list? tipp Y for yes if you press somthin else their will be no filter");
        input=scanner.next();
        if(input=="Y"|input=="y")
        {
            
        }
        else
        {
        }
    }
    
    public void filterInstructor()
    {
        System.out.println("Do you want to filter the list? tipp Y for yes if you press somthin else their will be no filter");
        input=scanner.next();
        if("Y".equals(input)||"y".equals(input))
        {
            System.out.println("1");
        }
        else
        {
            System.out.println("2");
        }
    }
 
    public boolean compareInstructor(String pInput)
    {
        boolean compare;
        
        compare=false;
        
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
                                if(!(pInput.equals("CourseID")||pInput.equals("coursID")))
                                {
                                    compare=false;
                                }
                            }
                        }                       
                    }
                }
            }
        }
        else
        {
            compare=true;
        }
        return compare;
    }
    
    public boolean compareCustomer(String pInput)
    {
        boolean compare;
        
        compare=false;

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
        else
        {
            compare=true;
        }
      
        return compare;
    }
    
    public boolean compareCourse(String pInput)
    {
        boolean compare;
        
        compare=false;
        
        if(!(pInput.equals("name")||pInput.equals("Name")))
        {
            if(!(pInput.equals("start")||pInput.equals("Start")))
            {
                if(!(pInput.equals("End")||pInput.equals("end")))
                {
                    if(!(pInput.equals("date")||pInput.equals("date")))
                    {
                        if(!(pInput.equals("weekday")||pInput.equals("Weekday")))
                        {
                            compare=false;
                        }
                    }
                }
            }
        }
        else
        {
            compare=true;
        }
        return compare;
    }
}
