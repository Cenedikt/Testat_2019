/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayParadise;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Benedict
 */
public class Gui 
{
    private Scanner scanner = new Scanner(System.in);
    private String input;
    private Pattern pattern;
    private Matcher matcher;
    private Data data = new Data();
    private Filter filter = new Filter();
    
    private String regex="^(0[0-9]|1[0-9]|2[0-3]|[0-9]):[0-5][0-9]$";

    /**
     * 
     * @param pInput 
     */
    public void setInput(String pInput)
    {
      this.input=pInput;  
    }
    
    /**
     * 
     * @return input
     */
    public String getInput()
    {
        return this.input;
    }
 
    /**
     * is the Main menu
     */
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

    /**
     * ist the instructor menu
     */    
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

    /**
     * creats a new Instructor and creats a new course if needed if all inputs a correct
     */
    public void createInstructorMenu()
    {
        String name;
        String preName;
        LocalDate birthday;
        String sex;
        String spesification;
        String workRelation;
        int courseID;
        
        birthday=null;
        courseID=-1;
        this.data.clearCoursIdlist();
        System.out.print("Please enter the Name of the new instructor: ");
        name=this.scanner.next();        
        System.out.print("Please enter the prename of the new instructor: ");
        preName= this.scanner.next();
        System.out.print("Please enter the birthdate of the new instructor (YYYY-MM-DD): ");
        do
        {
            this.setInput(this.scanner.next());
            try 
            {
              birthday=LocalDate.parse(this.getInput());  
            } 
            catch (Exception e) 
            {
                System.err.println("input incorrect please reenter: ");
                this.setInput("");
            }
        }
        while(this.getInput().equals(""));
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
        do{
            System.out.print("Please enter the courseID where the new instructor participaed if ther is no course yet do you want to create a new course press y or Y ");
            this.setInput(this.scanner.next());
            if(this.getInput().equals("Y")||this.getInput().equals("y"))
            {
                this.createCourseMenuInstructor();
                courseID=data.getlastCourseId();          
            }
            else
            {
                do
                {
                    if(this.getInput().equals("n"))
                    {                       
                        this.createCourseMenuInstructor();
                        break;
                    }
                    try
                    {                   
                        courseID=Integer.parseInt(this.getInput());
                        if(courseID>=0)
                        {
                            if(courseID>this.data.getCourseListSize())
                            {
                                System.out.println("Their is no course with that ID! with n you creat a new course");
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
            this.data.setCoursIDList(courseID);
            System.out.print("are their more courses for the new instructor enter the CoursID or enter y or Y to creat a new cours: ");
            this.setInput(this.scanner.next());
        }
        while(this.getInput().equals("y")||this.getInput().equals("Y"));
        if(this.filter.compareInstructor(name, preName, birthday, sex)==false)
        {
            this.data.setInstructorList(birthday, name, preName, sex, spesification, workRelation);        
            System.out.println("Instructor has been added!");
            this.pausing();
            this.instructionMenu();
        }
        else
        {
            System.out.println("Instructor allready exist");
            this.pausing();
            this.instructionMenu();
        }
    }

    /**
    * update the instructor if chanches are needed alsow check if the Instructor which showeb be change exists
    */    
    public void updateInstructorMenu()
    {
        int index;
        index=-1;
        System.out.print("Pleas enter the Id of the instructor which you want to update with n cancel update: ");
        this.setInput(this.scanner.next());
        do
        {
            if(this.getInput().equals("n"))
            {
                System.out.println("update canceled");
                this.pausing();
                this.instructionMenu();
                break;
            }
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
        do
        {
            System.out.print("please enter the touble which you want to chanche(Name, Prename, Birthday, Sex, Spesification, WorkRelation, CourseID) with n cancel: ");
            this.setInput(this.scanner.next());
            if(this.getInput().equals("n"))
            {
                System.out.println("uppdate canceled");
                this.pausing();
                this.instructionMenu();
                break;
            }
        }
        while(this.filter.compareInstructor(this.getInput())==false);
        this.data.updataInstructor(index, this.getInput());
        System.out.println("Instructor has been updatet!");
        this.pausing();
        this.instructionMenu();
    }

    /**
     * delets a Instructor and checks if the instructor exists
     */
    public void deleteInstructorMenu()
    {
        int index=-1;
        System.out.print("Please enter the ID of the Instructor which you want to delet with n cancel deletion: ");
        this.setInput(this.scanner.next());
        do
        {
            if(this.getInput().equals("n"))
            {
                System.out.println("Deletion canceled");
                this.pausing();
                this.instructionMenu();
                break;
            }
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

/**
 * retursn the instructor List with its values
 */    
    public void showInstrucorListMenu()
    {
        System.out.println("| ID | Name | Prename | Birthday | Sex | Spesification | Workrelation | CoursID |");
        for(int i=0; i<(this.data.getInstructorListSize()+1);i++)
        {
            System.out.println(this.data.getInstructorList(i));
        }
        this.pausing();
        this.instructionMenu();
    }

    /**
     * the customer menu
     */
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
    
    /**
     * creats a new customer and cheks if all inputs a correct
     */
    public void creatCustomerMenu()
    {
        String title;
        String name;
        String prename;
        LocalDate birthday;
        String sex;
        
        birthday=null;
        
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
        System.out.print("Please enter the prename of the new customer: ");
        prename= this.scanner.next();
        System.out.print("Error please enter a prename without numbers: ");
        System.out.print("Please enter the birthdate of the new customer (YYYY-MM-DD): ");
        do
        {
            this.setInput(this.scanner.next());
            try 
            {
                birthday=LocalDate.parse(this.getInput());  
            } 
            catch (Exception e) 
            {
                System.err.println("input incorrect please reenter: ");
                this.setInput("");
            }
        }
        while(this.getInput().equals(""));

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
        if(this.filter.compareCustomer(title, name, prename, birthday, sex)==false)
        {
            data.setCustomerList(title, name, birthday, prename, sex);
            System.out.println("Customer has been added");
            this.pausing();
            this.customerMenu();            
        }
        else
        {
            System.out.println("The Customer already exist");
            this.pausing();
            this.customerMenu();
        }
    }
/**
 * updates the customer and cheks if the customer exists
 */    
    public void updateCustomerMenu()
    {
        int index=-1;
        System.out.print("Pleas enter the Id of the customer which you want to update with n cancel: ");
        this.setInput(this.scanner.next());
        do
        {
            if(this.getInput().equals("n"))
            {
                System.out.println("uppdate canceled");
                this.pausing();
                this.customerMenu();
                break;
            }
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
        do
        {
            System.out.print("Which touble showed be cahnged Name, Prename, Title, Sex, Birthday to quit update tipe n :");
            this.setInput(scanner.next());
            if(this.getInput().equals("n"))
            {
                System.out.println("Update canceled");
                this.pausing();
                this.customerMenu();
            }
        }
        while(this.filter.compareCustomer(this.getInput())==false);
        this.data.updataCustomer(index,this.getInput());
        System.out.println("Customer has been updated");
        this.pausing();
        this.customerMenu();
    }

/**
 * udelets the customer and cheks if the customer exists
 */    
    public void deleteCustomerMenu()
    {
        int index=-1;
        System.out.print("Please enter the ID of the Customer which you want to delet or n to cancel: ");
        this.setInput(this.scanner.next());
        do
        {
            if(this.getInput().equals("n"))
            {
                System.out.println("deletion canceled");
                this.pausing();
                this.customerMenu();
                break;
            }
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
/**
 * returs all customers with theri walues
 */   
    public void showCustomerListMenu()
    {
        System.out.println("| ID | Title | Name | Prename | Birtdate | Sex |");
        for(int i=0;i<=this.data.getCustomerListSize();i++)
        {
            System.out.println(this.data.getCustomer(i));
        }
        this.pausing();
        this.customerMenu();
    }
/**
 * cours menu
 */    
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

/**
 * crats a new Cours
 */    
    public void createCourseMenu()
    {
        String name;
        String beginTime;
        String endTime;
        LocalDate date;
        String weekday;
        
        date=null;
        
        pattern = Pattern.compile(regex);
        System.out.print("Please enter the Name of the new course: ");
        name=this.scanner.next();
        System.out.print("Please enter the starting time of the new course (hh:mm): ");
        do
        {
            beginTime= this.scanner.next();
            matcher = pattern.matcher(beginTime);
            if(!(matcher.find()&& matcher.group().equals(beginTime)))
            {
                System.out.println("time is not valid please enter in this pattern (hh:mm)");
                beginTime="";
            }
        }
        while(beginTime.equals(""));
        System.out.print("Please enter the ending time of the new course (hh:mm): ");
        do
        {
            endTime= this.scanner.next();
            matcher = pattern.matcher(endTime);
            if(!(matcher.find()&& matcher.group().equals(beginTime)))
            {
                System.out.println("time is not valid please enter in this pattern (hh:mm)");
                endTime="";
            }
        }
        while(endTime.equals(""));
        System.out.print("Please enter the date of the new cours (YYYY-MM-DD): ");
        do
        {
            this.setInput(this.scanner.next());
            try 
            {
                date=LocalDate.parse(this.getInput());  
            } 
            catch (Exception e) 
            {
                System.err.println("input incorrect please reenter: ");
                this.setInput("");
            }
        }
        while(this.getInput().equals(""));
        do
        {
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
                    weekday="";
                    break;
            }
        }
        while(weekday.equals(""));
        if(this.filter.compareCours(name, beginTime, endTime, date, weekday)==false)
        {
            this.data.setCourseList(beginTime, name, date, endTime, weekday);
            System.out.println("Couse has been added!");
            this.pausing();
            this.coursesMenu();
        }
        else
        {
            System.out.println("the Cours allready exist");
            this.pausing();
            this.coursesMenu();
        }
    }
/**
 * creats new cours but its for the creat instructor menu to not jump into the cours menu and skips the the prosses of creating the instructor
 */    
    public void createCourseMenuInstructor()
    {
        String name;
        String beginTime;
        String endTime;
        LocalDate date;
        String weekday; 
        
        date=null;
        
        pattern = Pattern.compile(regex);
        System.out.print("Please enter the Name of the new course: ");
        name=this.scanner.next();
        System.out.print("Please enter the starting time of the new course (hh:mm): ");
        do
        {
            beginTime= this.scanner.next();
            matcher = pattern.matcher(beginTime);
            if(!(matcher.find()&& matcher.group().equals(beginTime)))
            {
                System.out.println("time is not valid please enter in this pattern (hh:mm)");
                beginTime="";
            }
        }
        while(beginTime.equals(""));
        System.out.print("Please enter the ending time of the new course (hh:mm): ");
        do
        {
            endTime= this.scanner.next();
            matcher = pattern.matcher(beginTime);
            if(!(matcher.find()&& matcher.group().equals(endTime)))
            {
                System.out.println("time is not valid please enter in this pattern (hh:mm)");
                endTime="";
            }
        }
        while(endTime.equals(""));
        System.out.print("Please enter the date of the new cours (YYYY-MM-DD): ");
        do
        {
            this.setInput(this.scanner.next());
            try 
            {
                date=LocalDate.parse(this.getInput());  
            } 
            catch (Exception e) 
            {
                System.err.println("input incorrect please reenter: ");
                this.setInput("");
            }
        }
        while(this.getInput().equals(""));
        do
        {
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
                    weekday="";
                    break;
            }
        }
        while(weekday.equals(""));
        this.data.setCourseList(beginTime, name, date, endTime, weekday);
        System.out.println("Couse has been added!");
        this.pausing();
    }

/**
 * updates a new course an check if the cours exists
 */    
    public void updateCourseMenu()
    {
        int index;
        
        index=-1;
        
        System.out.print("Pleas enter the Id of the cours which you want to update with n cancel: ");
        this.setInput(this.scanner.next());
        do
        {
            if(this.getInput().equals("n"))
            {
                System.out.println("update canceled");
                this.pausing();
                this.coursesMenu();
                break;
            }
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
        System.out.print("");
        
        do
        {
            System.out.print("please enter the touble which you want to chanche(Name, start, end, date or weekday) with n cancel: ");
            this.setInput(this.scanner.next());
            if(this.getInput().equals("n"))
            {
                System.out.println("uppdate canceled");
                this.pausing();
                this.coursesMenu();
                break;
            }
        }
        while(this.filter.compareCourse(this.getInput())==false);
        this.data.updataCourse(index, this.getInput());
        System.out.println("Course has been updated");
        this.pausing();
        this.coursesMenu();
    }
/**
 * delets a new course an check if the cours exists
 */    
    public void deleteCourseMenu()
    {
        int index=-1;
        System.out.print("Please enter the ID of the course which you want to delet with n cancel: ");
        this.setInput(this.scanner.next());
        do
        {
            if(this.getInput().equals("n"))
            {
                System.out.println("deletion canceled   ");
                this.pausing();
                this.coursesMenu();
                break;
            }
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
/**
 * returns all Courses with their data
 */    
    public void showCourseListMenu()
    {
        System.out.println("| ID | Name | Start | Ending | Date | Day |");
        for(int i=0;i<=this.data.getCourseListSize();i++)
        {
            System.out.println(this.data.getCourseList(i));
        }
        this.pausing();
        this.coursesMenu();
    }
/**
 * an error Message which waits after an enter input
 */    
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
/**
 * waits that so long if an enter input is made 
 */    
    public void pausing()
    {
        do
        {
            setInput("abc");
            System.out.println("\n To continue press enter");
            this.setInput(this.scanner.nextLine());
            if(this.getInput().isEmpty())
            {
                break;
            }
        }    
        while(!(this.getInput().isEmpty())); 
    }
}
