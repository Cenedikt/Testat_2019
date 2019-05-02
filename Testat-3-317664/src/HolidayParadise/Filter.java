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
}
