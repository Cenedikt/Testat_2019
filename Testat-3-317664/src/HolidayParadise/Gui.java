/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayParadise;

import java.util.Scanner;

/**
 *
 * @author Benedict
 */
public class Gui 
{
    private Scanner scanner = new Scanner(System.in);
    private String input;
    private Data data=new Data();
    
    public void setInput(String pInput)
    {
      this.input=pInput;  
    }
    
    public String getInput()
    {
        return this.input;
    }
      
    public void mainMenu()
    {
        System.out.println("/n HOLIDAY PARADISE");
        System.out.println("Basic Data Management 1.0 Copyright 2019 Benedict Goldhorn, MNR 317664");
        System.out.println("MAIN MENU");
        System.out.println("Please select: \n");
        System.out.println("Managing instructors    1");
        System.out.println("Managing customers      2");
        System.out.println("Managing courses        3");
        System.out.println("Program exit            0 \n");
        System.out.print("please enter your choice: ");
        this.setInput(this.scanner.nextLine());               
        switch(this.getInput())
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
                break;
        }
    }
    
    public void instructionMenu()
    {
        System.out.println("/n HOLIDAY PARADISE");
        System.out.println("Basic Data Management 1.0 Copyright 2019 Benedict Goldhorn, MNR 317664");
        System.out.println("MANAGING INSTRUCTOINS MENU");
        System.out.println("Please select: \n");
        System.out.println("Create new instructor       1");
        System.out.println("Update an instructor        2");
        System.out.println("Delete an instructor        3");
        System.out.println("Show instructor list        4 \n");
        System.out.println("Back to main menu           0 \n");
        System.out.print("please enter your choice: ");
        this.setInput(this.scanner.nextLine());
        switch(this.getInput())
        {
            case "1":
                this.createInstructorMenu();
                break;
            case "2":
                this.errorMenu();
                break;
            case "3":
                this.deleteInstructorMenu();
                break;
            case "4":
                this.errorMenu();
                break;
            case "0":
                this.mainMenu();
                break;
            default:
                this.mainMenu();
                break;
        }      
    }
    
    public void createInstructorMenu()
    {
        String name;
        String preName;
        String birthday;
        String sex;
        String spesification;
        String workRelation;
        int courseID=-1;
        System.out.print("Please enter the Name of the new instructor: ");
        name=this.scanner.next();
        System.out.print("Please enter the prename of the new instructor: ");
        preName= this.scanner.next();
        System.out.print("Please enter the birthday of the new instructor: ");
        birthday=this.scanner.next();
        System.out.print("Please enter the sex of the new instructor: ");
        do
        {
            sex=this.scanner.next();
            switch(sex)
            {
                case("male"):
                    sex="m";
                    break;
                case("m"):
                    break;
                case("female"):
                    sex="f";
                    break;
                case("f"):
                    break;
                case("divers"):
                    sex="d";
                    break;
                case("d"):
                    break;
                default:
                    System.out.println("Pleas enter a vailid sex ");
                    sex="";
                break;
            }
        }
        while(sex.equals(""));
        System.out.print("Please enter the spesification of the new instructor: ");
        spesification=this.scanner.next();
        System.out.print("Please enter the workrelation of the new instructor like extern or intern: ");
        workRelation=this.scanner.next();
        System.out.print("Please enter the courseID where the new instructor participaed if ther is no course yet do you want to create a new course press y or Y");
        this.setInput(this.scanner.next());
        if(this.getInput().equals("Y")||this.getInput().equals("y"))
        {
            this.errorMenu();
        }
        else
        {
            try
            {
                courseID=Integer.parseInt(this.getInput());
            }
            catch(NumberFormatException e)
            {
                System.out.println("nana");
            }
        }
        this.data.setInstructorList(birthday, courseID, name, preName, sex, spesification, workRelation);
        System.out.println("Instructor has been added");
        this.pausing();
        this.instructionMenu();
    }
    
    public void updateInstructorMenu()
    {
        System.out.println("Instructor has been updatet!");
        this.pausing();
        this.instructionMenu();
    }
    
    public void deleteInstructorMenu()
    {
        int index=-1;
        System.out.print("Please enter the ID of the Instructor which you want to delet: ");
        do
        {
            try
            {
                this.setInput(this.scanner.next());
                if(index>=0)
                {
                    index=Integer.parseInt(this.getInput());
                }
                else
                {
                    System.out.print("Please enter an positiv number: ");
                    this.setInput("");
                }
            }
            catch(NumberFormatException e)
            {
            System.out.print("Please enter an natural nummber!");
            this.setInput("");
            }
        }
        while(input.isEmpty());
        System.out.println("are you sure to delete enter y or Y for delet");
        this.setInput(this.scanner.next());
        if(this.getInput().equals("Y")||this.getInput().equals("y"))
        {
            this.data.deleteInstructor(index);
            System.out.println("The instructor has been deleted");
            this.pausing();
            this.instructionMenu();
        }
        else
        {
            System.out.println("Deletion abbort");
            this.pausing();
            this.instructionMenu();
        }
    }
    
    public void showInstrucorListMenu()
    {
        this.pausing();
        this.instructionMenu();
    }
    
    
    public void customerMenu()
    {
        System.out.println("/n HOLIDAY PARADISE");
        System.out.println("Basic Data Management 1.0 Copyright 2019 Benedict Goldhorn, MNR 317664");
        System.out.println("MANAGING CUSTOMER MENU");
        System.out.println("Please select: \n");  
        System.out.println("Create new customer       1");
        System.out.println("Update an customer        2");
        System.out.println("Delete an customer        3");
        System.out.println("Show customer list        4 \n");
        System.out.println("Back to main menu         0 \n");
        System.out.print("please enter your choice: ");
        this.setInput(this.scanner.next());
        switch(this.getInput())
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
                break;
            default:
                this.mainMenu();
                break;
        }       
    }
    
    public void creatCustomerMenu()
    {
    }
    
    public void updateCustomerMenu()
    {
    }
    
    public void deleteCustomerMenu()
    {
        int index=-1;
        System.out.print("Please enter the ID of the customer which you want to delet: ");
        do
        {
            try
            {
                this.setInput(this.scanner.next());
                if(index>=0)
                {
                    index=Integer.parseInt(this.getInput());
                }
                else
                {
                    System.out.print("Please enter an positiv number: ");
                    this.setInput("");
                }
            }
            catch(NumberFormatException e)
            {
            System.out.print("Please enter an natural nummber!");
            this.setInput("");
            }
        }
        while(this.input.isEmpty());
        System.out.println("are you sure to delete enter y or Y for delet");
        this.setInput(this.scanner.next());
        if(this.getInput().equals("Y")||this.getInput().equals("y"))
        {
            this.data.deleteInstructor(index);
            System.out.println("The customer has been deleted");
            this.pausing();
            this.customerMenu();
        }
        else
        {
            System.out.println("Deletion abbort");
            this.pausing();
            this.customerMenu();
        }        
    }
    
    public void showCustomerListMenu()
    {}
    
    public void coursesMenu()
    {
        System.out.println("/n HOLIDAY PARADISE");
        System.out.println("Basic Data Management 1.0 Copyright 2019 Benedict Goldhorn, MNR 317664");
        System.out.println("MANAGING COURSE MENU");
        System.out.println("Please select: \n");
        System.out.println("Create new course       1");
        System.out.println("Update an course        2");
        System.out.println("Delete an course        3");
        System.out.println("Show course list        4 \n");
        System.out.println("Back to main menu       0 \n");
        System.out.print("please enter your choice: ");        
        this.setInput(this.scanner.next());
        switch(this.getInput())
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
                break;
            default:
                this.mainMenu();
                break;
        }        
    }
    
    public void createCourseMenu()
    {
        String name;
        String beginTime;
        String endTime;
        String date;
        String weekday;
        System.out.print("Please enter the Name of the new course: ");
        name=this.scanner.next();
        System.out.print("Please enter the starting time of the new course: ");
        beginTime= this.scanner.next();
        System.out.print("Please enter the ending time of the new course: ");
        endTime=this.scanner.next();
        System.out.print("Please enter the date of the new course: ");
        date=this.scanner.next();
        System.out.print("Please enter the weekday of the new course: ");
        weekday=this.scanner.next();
        switch(weekday)
        {
            case "Monday":
                weekday="M";
                break;
            
            case "monday":
                weekday="M";
                break;
            
            case "m":
                weekday="M";
                break;
                
            case "Tuesday":
                weekday="Tu";
                break;
            
            case "tuesday":
                weekday="Tu";
                break;
            
            case "t":
                weekday="Tu";
                break; 
                
            case "Wensday":
                weekday="W";
                break;
            
            case "=wensday":
                weekday="W";
                break;
            
            case "w":
                weekday="W";
                break; 
                
            case "Thursday":
                weekday="Thu";
                break;
            
            case "thursday":
                weekday="Thu";
                break;
            
            case "thu":
                weekday="Thu";
                break;
                
            case "Friday":
                weekday="F";
                break;
            
            case "friday":
                weekday="F";
                break;
            
            case "f":
                weekday="F";
                break; 
                
            case "Saturday":
                weekday="Sat";
                break;
            
            case "saturday":
                weekday="Sat";
                break;
            
            case "sat":
                weekday="Sat";
                break;
                
            case "Sunday":
                weekday="Sun";
                break;
            
            case "sunday":
                weekday="Sun";
                break;
            
            case "sun":
                weekday="Sun";
                break; 
            default:                
                break;
        }
        this.data.setCourseList(name, beginTime, endTime, date, weekday);
        System.out.println("Couse has been added!");
        this.pausing();
        this.coursesMenu();
    }
    
    public void updateCourseMenu()
    {}
    
    public void deleteCourseMenu()
    {
        int index=-1;
        System.out.print("Please enter the ID of the course which you want to delet: ");
        do
        {
            try
            {
                this.setInput(this.scanner.next());
                if(index>=0)
                {
                    index=Integer.parseInt(this.getInput());
                }
                else
                {
                    System.out.print("Please enter an positiv number: ");
                    this.setInput("");
                }
            }
            catch(NumberFormatException e)
            {
            System.out.print("Please enter an natural nummber!");
            this.setInput("");
            }
        }
        while(this.input.isEmpty());
        System.out.println("are you sure to delete enter y or Y for delet");
        this.setInput(this.scanner.next());
        if(this.getInput().equals("Y")||this.getInput().equals("y"))
        {
            this.data.deleteInstructor(index);
            System.out.println("The course is deleted");
            this.pausing();
            this.coursesMenu();
        }
        else
        {
            System.out.println("Deletion abbort");
            this.pausing();
            this.coursesMenu();
        }
    }
    
    public void showCourseListMenu()
    {}
    
    public void errorMenu()
    {
        
        System.out.println("\n This program section is currently not implemented press Enter to return to the menu \n");
        do
        {
            System.out.println("\n This program section is currently not implemented press Enter to return to the menu \n");
            System.out.println(getInput());
            this.setInput(this.scanner.nextLine());
            if(this.getInput().isEmpty())
            {
                this.mainMenu();
                break;
            }
        }    
        while(!(this.getInput().isEmpty()));
    }
    public void pausing()
    {
        do
        {
            System.out.println("\n This program section is currently not implemented press Enter to continue \n");
            System.out.println(getInput());
            this.setInput(this.scanner.nextLine());
            if(this.getInput().isEmpty())
            {
                break;
            }
        }    
        while(!(this.getInput().isEmpty())); 
    }
}
