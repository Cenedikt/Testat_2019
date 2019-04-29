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
    private String nasenbaer;
    private ArrayList<Instructors> instructorsList = new ArrayList<Instructors>();
    private ArrayList<Customer> customerList = new ArrayList<Customer>();
    private ArrayList<Course> courseList = new ArrayList<Course>();
    
    public void mainMenu()
    {
        System.out.println("/n HOLIDAY PARADISE");
        System.out.println("Basic Data Management 1.0 Copyright 2019 Benedict Goldhorn, MNR 317664");
        System.out.println("MAIN MENU");
        System.out.println("Pleas select:\n");
        System.out.println("Managing instructors    1");
        System.out.println("Managing customers      2");
        System.out.println("Managing courses        3");
        System.out.println("Program exit            0 \n");
        System.out.print("please enter your choice:");
        input=scanner.nextLine();
        this.nasenbaer = this.input;               
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
        System.out.println("/n HOLIDAY PARADISE");
        System.out.println("Basic Data Management 1.0 Copyright 2019 Benedict Goldhorn, MNR 317664");
        System.out.println("MANAGING INSTRUCTOINS MENU");
        System.out.println("Pleas select:\n");
        System.out.println("Create new instructor       1");
        System.out.println("Update an instructor        2");
        System.out.println("Delete an instructor        3");
        System.out.println("Show instructor list        4 /n");
        System.out.println("Back to main menu           0 /n");
        System.out.print("please enter your choice:");
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
                this.mainMenu();
            default:
                this.mainMenu();
        }      
    }
    
    public void customerMenu()
    {
        System.out.println("/n HOLIDAY PARADISE");
        System.out.println("Basic Data Management 1.0 Copyright 2019 Benedict Goldhorn, MNR 317664");
        System.out.println("MANAGING CUSTOMER MENU");
        System.out.println("Pleas select:\n");  
        System.out.println("Create new customer       1");
        System.out.println("Update an customer        2");
        System.out.println("Delete an customer        3");
        System.out.println("Show customer list        4/n");
        System.out.println("Back to main menu         0/n");
        System.out.print("please enter your choice:");
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
                this.errorMenu();
                break;
            case "0":
                this.mainMenu();
            default:
                this.mainMenu();
        }       
    }
    
    public void coursesMenu()
    {
        System.out.println("/n HOLIDAY PARADISE");
        System.out.println("Basic Data Management 1.0 Copyright 2019 Benedict Goldhorn, MNR 317664");
        System.out.println("MANAGING COURSE MENU");
        System.out.println("Pleas select:\n");
        System.out.println("Create new course       1");
        System.out.println("Update an course        2");
        System.out.println("Delete an course        3");
        System.out.println("Show course list        4 /n");
        System.out.println("Back to main menu       0 /n");
        System.out.print("please enter your choice:");        
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
                this.errorMenu();
                break;
            case "0":
                this.mainMenu();
            default:
                this.mainMenu();
        }        
    }
    
    public void errorMenu()
    {
        System.out.println("/n This program section is currently not implemented pres Enter to return to the menu /n");
        input=scanner.nextLine();       
        if(input.isEmpty())
        {
            this.mainMenu();
        }
    }
    
    
    public void filter()
    {
        System.out.println("Do you want to filter the list? tipp Y for yes if you press somthin else their will be no filter");
        input=scanner.next();
        if(input=="Y"|input=="y")
        {
            switch(this.nasenbaer)
            {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    break;
            }
        }
        else
        {
            switch(this.nasenbaer)
            {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    break;
            }            
        }
        
    }
}
