/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayParadise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Benedict
 */
public class Gui 
{
    private Scanner scanner = new Scanner(System.in);
    private String input;
    private ArrayList<Instructors> instructorsList = new ArrayList<Instructors>();
    private ArrayList<Customer> customerList = new ArrayList<Customer>();
    private ArrayList<Course> courseList = new ArrayList<Course>();
    
    public void mainMenu()
    {
        System.out.println("HOLIDAY PARADISE");
        System.out.println("Basic Data Management 1.0 Copyright 2019 Benedict Goldhorn, MNR 317664");
        System.out.println("MAIN MENU");
        System.out.println("Pleas select:\n");
        System.out.println("Managing instructors 1");
        System.out.println("Managing customers 2");
        System.out.println("Managing courses 3");
        System.out.println("Program exit 0 \n");
        System.out.print("please enter your choice:");
        input=scanner.nextLine();
        System.out.println("");
        switch(input)
        {
            case "1":
                this.instructionMenu();
                break;
            case "2":
                this.customerMenu();
                break;
            case "3":
                this.coursesMenu();
                break;
            case "0":
                System.exit(0);
            default:
                this.mainMenu();
        }
    }
    
    public void instructionMenu()
    {
        System.out.println("HOLIDAY PARADISE");
        System.out.println("Basic Data Management 1.0 Copyright 2019 Benedict Goldhorn, MNR 317664");
        System.out.println("INSTRUCTOINS MENU");
        System.out.println("Pleas select:\n");
        input=scanner.nextLine();
        switch(input)
        {
            case "1":
                this.errorMenu();
                break;
            case "2":
                this.errorMenu();
                break;
            case "3":
                this.errorMenu();
                break;
            case "4":
                this.filter();
                this.errorMenu();
                break;
            case "0":
                System.exit(0);
            default:
                this.mainMenu();
        }      
    }
    
    public void customerMenu()
    {
        System.out.println("HOLIDAY PARADISE");
        System.out.println("Basic Data Management 1.0 Copyright 2019 Benedict Goldhorn, MNR 317664");
        System.out.println("CUSTOMER MENU");
        System.out.println("Pleas select:\n");        
        input=scanner.nextLine();
        switch(input)
        {
            case "1":
                this.errorMenu();
                break;
            case "2":
                this.errorMenu();
                break;
            case "3":
                this.errorMenu();
                break;
            case "4":
                this.filter();
                this.errorMenu();
                break;
            case "0":
                System.exit(0);
            default:
                this.mainMenu();
        }       
    }
    
    public void coursesMenu()
    {
        System.out.println("HOLIDAY PARADISE");
        System.out.println("Basic Data Management 1.0 Copyright 2019 Benedict Goldhorn, MNR 317664");
        System.out.println("COURSE MENU");
        System.out.println("Pleas select:\n");        
        input=scanner.nextLine();
        switch(input)
        {
            case "1":
                this.errorMenu();
                break;
            case "2":
                this.errorMenu();
                break;
            case "3":
                this.errorMenu();
                break;
            case "4":
                this.filter();
                this.errorMenu();
                break;
            case "0":
                System.exit(0);
            default:
                this.mainMenu();
        }        
    }
    
    public void errorMenu()
    {
        System.out.println("This program section is currently not implemented pres Enter to return to the menu");
        input=scanner.nextLine();       
        if(input.isEmpty())
        {
            this.mainMenu();
        }
    }
    
    
    public void filter()
    {
        System.out.println("Do you want to filter the list? tipp Y for yes");
        input=scanner.next();
        if(input=="Y"|input=="y")
        {
          
        }
        else
        {
            
        }
        
    }
}
