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
                this.updateInstructorMenu();
                break;
            case "3":
                this.deleteInstructorMenu();
                break;
            case "4":
                this.showInstrucorListMenu();
                break;
            case "0":
                this.mainMenu();
                break;
            default:
                this.instructionMenu();
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
        if(name.equals(""))
        {
            do
            {
                System.out.print("Error please enter a name without numbers: ");
                name= this.scanner.next();
            }
            while(name=="1");
        }
        System.out.print("Please enter the prename of the new instructor: ");
        preName= this.scanner.next();
        if(preName.equals(""))
        {
            do
            {
                System.out.print("Error please enter a prename without numbers: ");
                preName= this.scanner.next();
            }
            while(preName=="1");
        }
        System.out.print("Please enter the birthday of the new instructor: ");
        birthday=this.scanner.next();
        System.out.print("Please enter the sex of the new instructor: ");
        do
        {
            sex=this.scanner.next();
            switch(sex)
            {
                case("male"):
                    sex="Male";
                    break;
                
                case("Male"):
                    sex="Male";
                    break;
                
                case("female"):
                    sex="Female"; 
                    break;
                
                case("Female"):
                    sex="Female";
                    break;
                
                case("divers"):
                    sex="Divers";
                    break;
                
                case("diverse"):
                    sex="Divers";
                    break;
                
                default:
                    System.out.print("Please enter a vailid sex (Male / Female /  Divers): ");
                    sex="";
                    break;
            }
        }
        while(sex.equals(""));
        System.out.print("Please enter the spesification of the new instructor: ");
        spesification=this.scanner.next();
        System.out.print("Please enter the workrelation of the new instructor like extern or intern: ");
        workRelation=this.scanner.next();
        while(!(workRelation.equals("extern")||workRelation.equals("intern")))
        {
            System.out.print("Pleas enter extern or intern for the workrelation: ");
            workRelation=scanner.next();            
        }
        System.out.print("Please enter the courseID where the new instructor participaed if ther is no course yet do you want to create a new course press y or Y ");
        this.setInput(this.scanner.next());
        if(this.getInput().equals("Y")||this.getInput().equals("y"))
        {
            this.createCourseMenuInstructor();
        }
        else
        {
            do
            {
                try
                {                   
                    courseID=Integer.parseInt(this.getInput());
                    if(courseID>=0)
                    {
                        if(courseID>this.data.getCourseListSize())
                        {
                            System.out.println("Their is no course with that ID!");
                            System.out.print("Please enter a new courseID: ");
                            setInput(this.scanner.next());
                            courseID=-1;
                        }
                    }
                    else
                    {
                        System.out.println("No negetiv nummbers are allowed!");
                        System.out.print("Please enter a course id: ");
                        setInput(this.scanner.next());
                        courseID=-1;                        
                    }
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Please enter a nurtal number! ");
                    System.out.print("Please enter a new courseID: ");
                    setInput(this.scanner.next());
                    courseID=-1;
                }
            }
            while(courseID==-1);
        }
        this.data.setInstructorList(birthday, courseID, name, preName, sex, spesification, workRelation);
        System.out.println("Instructor has been added!");
        this.pausing();
        this.instructionMenu();
    }
    
    public void updateInstructorMenu()
    {
        int index;
        System.out.print("Pleas enter the Id of the instructor which you want to update: ");
        this.setInput(this.scanner.next());
        do
        {
            try
            {                   
                index=Integer.parseInt(this.getInput());
                if(index>=0)
                {
                    if(index>this.data.getInstructorListSize())
                    {
                        System.out.println("Their is no instructor with that ID! ");
                        System.out.print("Please enter a instructor: ");
                        setInput(this.scanner.next());
                        index=-1;
                    }        
                }
                else
                {
                    System.out.println("No negetiv nummbers are allowed!");
                    System.out.print("Please enter a instructor id: ");
                    setInput(this.scanner.next());
                    index=-1;    
                }
            }               
            catch(NumberFormatException e)
            {
                System.out.println("Please enter a nurtal number! ");
                System.out.print("Please enter a instructor: ");
                setInput(this.scanner.next());
                index=-1;
            }
        }
        while(index==-1);
        this.data.updataInstructor(index);            
        System.out.println("Instructor has been updatet!");
        this.pausing();
        this.instructionMenu();
    }
    
    public void deleteInstructorMenu()
    {
        int index=-1;
        System.out.print("Please enter the ID of the Instructor which you want to delet: ");
        this.setInput(this.scanner.next());
        do
        {
            try
            {            
                index=Integer.parseInt(this.getInput());
                if(index>=0)
                {
                    if(index>this.data.getInstructorListSize())
                    {
                        System.out.println("Their is no instructor with that ID! ");
                        System.out.print("Please enter a instructor id: ");
                        setInput(this.scanner.next());
                        index=-1;
                    }
                }
                else
                {
                    System.out.println("No negetiv nummbers are allowed!");
                    System.out.print("Please enter a instructor id: ");
                    setInput(this.scanner.next());
                    index=-1;
                }
            }
            catch(NumberFormatException e)
            {
                System.out.print("Please enter an natural nummber! ");
                this.setInput(this.scanner.next());
                index=-1;
            }
        }
        while(index==-1);
        System.out.println("are you sure to delete enter y or Y for delet ");
        this.setInput(this.scanner.next());
        if(this.getInput().equals("Y")||this.getInput().equals("y"))
        {
            this.data.deleteInstructor(index);
            System.out.println("The instructor has been deleted!");
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
        System.out.println("| ID | Name | Prename | Birthday | Sex | Spesification | Workrelation |");
        this.data.getInstructorList();
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
                this.creatCustomerMenu();
                break;
            case "2":
                this.updateCustomerMenu();
                break;
            case "3":
                this.deleteCustomerMenu();
                break;
            case "4":
                this.showCustomerListMenu();
                break;
            case "0":
                this.mainMenu();
                break;
            default:
                this.customerMenu();
                break;
        }       
    }
    
    public void creatCustomerMenu()
    {
        String title;
        String name;
        String prename;
        String birtday;
        String sex;
        System.out.print("Please enter the title of the new customer: ");
        do
        {
            title=this.scanner.next();
            switch(title)
            {
                case "Dr":
                    title="Dr";
                    break;
                case "dr":
                    title="Dr";
                    break;
                case "Ms":
                    title="Ms";
                    break;
                case "ms":
                    title="Ms";
                    break;
                case "Mrs":
                    title="Mrs";
                    break;
                case "mrs":
                    title="Mrs";
                    break;
                case "Mr":
                    title="Mr";
                    break;
                case "mr":
                    title="Mr";
                    break;                   
                default:
                    System.out.print("PLeas enter an correct title (Dr / Ms / Mrs / Mr): ");
                    title="";
                    break;
            }
        }
        while(title.equals(""));
        System.out.print("Please enter the Name of the new customer: ");
        name=this.scanner.next();
        if(name.equals(""))
        {
            do
            {
                System.out.print("Error please enter a name without numbers: ");
                name= this.scanner.next();
            }
            while(name=="1");
        }
        System.out.print("Please enter the prename of the new customer: ");
        prename= this.scanner.next();
        if(prename.equals(""))
        {
            do
            {
                System.out.print("Error please enter a prename without numbers: ");
                prename= this.scanner.next();
            }
            while(prename=="1");
        }
        System.out.print("Please enter the birthday of the new customer: ");
        birtday=this.scanner.next();
        System.out.print("Please enter the sex of the new customer: ");
        do
        {
            sex=this.scanner.next();
            switch(sex)
            {
                case("male"):
                    sex="Male";
                    break;
                
                case("Male"):
                    sex="Male";
                    break;
                
                case("female"):
                    sex="Female"; 
                    break;
                
                case("Female"):
                    sex="Female";
                    break;
                
                case("divers"):
                    sex="Divers";
                    break;
                
                case("diverse"):
                    sex="Divers";
                    break;
                
                default:
                    System.out.print("Please enter a vailid sex (Male / Female /  Divers): ");
                    sex="";
                    break;
            }
        }
        while(sex.equals(""));
        data.setCustomerList(title, name, prename, birtday, sex);
        System.out.println("Customer has been added");
        this.pausing();
        this.customerMenu();
    }
    
    public void updateCustomerMenu()
    {
        int index;
        System.out.print("Pleas enter the Id of the customer which you want to update: ");
        this.setInput(this.scanner.next());
        do
        {
            try
            {                   
                index=Integer.parseInt(this.getInput());
                if(index>=0)
                {
                    if(index>this.data.getCustomerListSize())
                    {
                        System.out.println("Their is no customer with that ID! ");
                        System.out.print("Please enter a customer: ");
                        setInput(this.scanner.next());
                        index=-1;
                    }        
                }
                else
                {
                    System.out.println("No negetiv nummbers are allowed!");
                    System.out.print("Please enter a customer id: ");
                    setInput(this.scanner.next());
                    index=-1;    
                }
            }               
            catch(NumberFormatException e)
            {
                System.out.println("Please enter a nurtal number! ");
                System.out.print("Please enter a customer: ");
                setInput(this.scanner.next());
                index=-1;
            }
        }
        while(index==-1);
        this.data.updataCustomer();
        System.out.println("Customer has been updated");
        this.pausing();
        this.customerMenu();
    }
    
    public void deleteCustomerMenu()
    {
        int index=-1;
        System.out.print("Please enter the ID of the Customer which you want to delet: ");
        this.setInput(this.scanner.next());
        do
        {
            try
            {            
                index=Integer.parseInt(this.getInput());
                if(index>=0)
                {
                    if(index>this.data.getCustomerListSize())
                    {
                        System.out.println("Their is no customer with that ID! ");
                        System.out.print("Please enter a customer id: ");
                        setInput(this.scanner.next());
                        index=-1;
                    }
                }
                else
                {
                    System.out.println("No negetiv nummbers are allowed!");
                    System.out.print("Please enter a customer id: ");
                    setInput(this.scanner.next());
                    index=-1;
                }
            }
            catch(NumberFormatException e)
            {
                System.out.print("Please enter an natural nummber! ");
                this.setInput(this.scanner.next());
                index=-1;
            }
        }
        while(index==-1);
        System.out.println("are you sure to delete enter y or Y for delet ");
        this.setInput(this.scanner.next());
        if(this.getInput().equals("Y")||this.getInput().equals("y"))
        {
            this.data.deleteCustomer(index);
            System.out.println("The coustomer has been deleted!");
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
    {
        System.out.println("| ID | Title | Name | Prename | Birtdate | Sex |");
        this.data.getCustomerList();
        this.pausing();
        this.customerMenu();
    }
    
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
                this.createCourseMenu();
                break;
            case "2":
                this.updateCourseMenu();
                break;
            case "3":
                this.deleteCourseMenu();
                break;
            case "4":
                this.showCourseListMenu();
                break;
            case "0":
                this.mainMenu();
                break;
            default:
                this.coursesMenu();
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
    
    public void createCourseMenuInstructor()
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
    }
    
    public void updateCourseMenu()
    {
        int index;
        System.out.print("Pleas enter the Id of the cours which you want to update: ");
        this.setInput(this.scanner.next());
        do
        {
            try
            {                   
                index=Integer.parseInt(this.getInput());
                if(index>=0)
                {
                    if(index>this.data.getCourseListSize())
                    {
                        System.out.println("Their is no cours with that ID! ");
                        System.out.print("Please enter a cours: ");
                        setInput(this.scanner.next());
                        index=-1;
                    }        
                }
                else
                {
                    System.out.println("No negetiv nummbers are allowed!");
                    System.out.print("Please enter a cours id: ");
                    setInput(this.scanner.next());
                    index=-1;    
                }
            }               
            catch(NumberFormatException e)
            {
                System.out.println("Please enter a nurtal number! ");
                System.out.print("Please enter a cours: ");
                setInput(this.scanner.next());
                index=-1;
            }
        }
        while(index==-1);
        this.data.updataCourse();
        System.out.println("Course has been updated");
        this.pausing();
        this.coursesMenu();
    }
    
    public void deleteCourseMenu()
    {
        int index=-1;
        System.out.print("Please enter the ID of the course which you want to delet: ");
        this.setInput(this.scanner.next());
        do
        {
            try
            {            
                index=Integer.parseInt(this.getInput());
                if(index>=0)
                {
                    if(index>this.data.getCourseListSize())
                    {
                        System.out.println("Their is no course with that ID! ");
                        System.out.print("Please enter a course id: ");
                        setInput(this.scanner.next());
                        index=-1;
                    }
                }
                else
                {
                    System.out.println("No negetiv nummbers are allowed!");
                    System.out.print("Please enter a course id: ");
                    setInput(this.scanner.next());
                    index=-1;
                }
            }
            catch(NumberFormatException e)
            {
                System.out.print("Please enter an natural nummber! ");
                this.setInput(this.scanner.next());
                index=-1;
            }
        }
        while(index==-1);
        System.out.println("are you sure to delete enter y or Y for delet ");
        this.setInput(this.scanner.next());
        if(this.getInput().equals("Y")||this.getInput().equals("y"))
        {
            this.data.deleteCourse(index);
            System.out.println("The course has been deleted!");
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
    {
        System.out.println("| ID | Name | Start | Ending | Date | Day |");
        this.data.getCourseList();
        this.pausing();
        this.coursesMenu();
    }
    
    public void errorMenu()
    {
        
        System.out.println("\n This program section is currently not implemented press Enter to return to the menu \n");
        do
        {
            System.out.println("\n This program section is currently not implemented press Enter to return to the menu \n");
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
            System.out.println("To continue press enter");
            this.setInput(this.scanner.nextLine());
            if(this.getInput().isEmpty())
            {
                break;
            }
        }    
        while(!(this.getInput().isEmpty())); 
    }
}
