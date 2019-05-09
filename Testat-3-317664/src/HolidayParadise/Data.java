/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayParadise;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Benedict
 */
public class Data 
{
    private ArrayList<Instructor> instructorList = new ArrayList<Instructor>();
    private ArrayList<Customer> customerList = new ArrayList<Customer>();
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private Scanner scanner = new Scanner(System.in);
    private Pattern pattern;
    private Matcher matcher;
    private String regex="^(0[0-9]|1[0-9]|2[0-3]|[0-9]):[0-5][0-9]$";

    public String getInstructorList (int pIndex)
    {
        String output;
        String courseOutput;
        int id;
        String name;
        String prename;
        LocalDate birtday;
        String sex;
        String spesification;
        String workRelation;
        int courseID;
        
        courseOutput="";
        id=this.instructorList.get(pIndex).getInstructorID();
        name=this.instructorList.get(pIndex).getInstructorName();
        prename=this.instructorList.get(pIndex).getInstructorPrname();
        birtday=this.instructorList.get(pIndex).getBirthDate();
        sex=this.instructorList.get(pIndex).getSex();
        spesification=this.instructorList.get(pIndex).getSpesification();
        workRelation=this.instructorList.get(pIndex).getWorkRelation();
        for(int i=0;i<this.instructorList.get(pIndex).getCoursIdListSize();i++)
        {
            courseID=this.instructorList.get(pIndex).getCourseIDList(i);
            if(courseOutput.equals(""))
            {
                courseOutput=""+courseID;   
            }
            else
            {
                courseOutput=courseOutput+", "+courseID;
            }
        }
        output="| "+id+" | "+name+" | "+prename+" | "+birtday+" | "+sex+" | "+spesification+" | "+workRelation+" | "+courseOutput+" |";
        return output;
    }
        
    public void setInstructorList (LocalDate pBirthDate, String pInstructorName, String pInstructorPrname, String pSex, String pSpesification, String pWorkRelation)
    {
        Instructor instructor = new Instructor();
        instructor.setBirthDate(pBirthDate);
        instructor.setInstructorName(pInstructorName);
        instructor.setInstructorPrname(pInstructorPrname);
        instructor.setSex(pSex);
        instructor.setSpesification(pSpesification);
        instructor.setWorkRelation(pWorkRelation);
        this.instructorList.add(instructor);
    }
    
    public void setInstructorCoursId(int pIndex, int pCoursID)
    {
        Instructor instructor = new Instructor(pIndex);
        instructor.setCourseID(pCoursID);
        
        String name;
        String prename;
        LocalDate birtday;
        String sex;
        String spesification;
        String workRelation;
        
        name=this.instructorList.get(pIndex).getInstructorName();
        prename=this.instructorList.get(pIndex).getInstructorPrname();
        birtday=this.instructorList.get(pIndex).getBirthDate();
        sex=this.instructorList.get(pIndex).getSex();
        spesification=this.instructorList.get(pIndex).getSpesification();
        workRelation=this.instructorList.get(pIndex).getWorkRelation();
        
        instructor.setBirthDate(birtday);
        instructor.setInstructorName(name);
        instructor.setInstructorPrname(prename);
        instructor.setSex(sex);
        instructor.setSpesification(spesification);
        instructor.setWorkRelation(workRelation);
        
        this.instructorList.remove(pIndex);
        this.instructorList.add(pIndex, instructor);
    }
    
    public int lastInstructorId()
    {
        int id;
        
        id=-1;
        
        for(int i=0; i<this.instructorList.size();i++)
        {
            id=this.instructorList.get(i).getInstructorID();
        }
        return id;
    }
    
    public void deleteInstructor(int pIndex)
    {
        this.instructorList.remove(pIndex);
    }
    
    public void updataInstructor(int pIndex, String pInput)
    {
        int id;
        String name;
        String prename;
        LocalDate birtday;
        String sex;
        String spesification;
        String workRelation;
        int courseID;
        Instructor instructor;
        String input;
        id=this.instructorList.get(pIndex).getInstructorID();
        name=this.instructorList.get(pIndex).getInstructorName();
        prename=this.instructorList.get(pIndex).getInstructorPrname();
        birtday=this.instructorList.get(pIndex).getBirthDate();
        sex=this.instructorList.get(pIndex).getSex();
        spesification=this.instructorList.get(pIndex).getSpesification();
        workRelation=this.instructorList.get(pIndex).getWorkRelation();
//        courseID=this.instructorList.get(pIndex).getCourseID(); 
        switch(pInput)
        {
            case "name":
                instructor = new Instructor(id);
                instructor.setBirthDate(birtday);
//                instructor.setCourseID(courseID);
                instructor.setInstructorPrname(prename);
                instructor.setSex(sex);
                instructor.setSpesification(spesification);
                instructor.setWorkRelation(workRelation);
                System.out.print("Please enter the new Name of the instructor: ");
                name=this.scanner.next(); 
                instructor.setInstructorName(name);
                this.instructorList.add(pIndex, instructor);
                break;
            case "Name":
                instructor = new Instructor(id);
                instructor.setBirthDate(birtday);
//                instructor.setCourseID(courseID);
                instructor.setInstructorPrname(prename);
                instructor.setSex(sex);
                instructor.setSpesification(spesification);
                instructor.setWorkRelation(workRelation);
                System.out.print("Please enter the new Name of the instructor: ");
                name=this.scanner.next(); 
                instructor.setInstructorName(name);
                this.instructorList.add(pIndex, instructor);                
                break; 
            case "prename":
                instructor = new Instructor(id);
                instructor.setBirthDate(birtday);
//                instructor.setCourseID(courseID);               
                instructor.setInstructorName(name);
                instructor.setSex(sex);
                instructor.setSpesification(spesification);
                instructor.setWorkRelation(workRelation);
                System.out.print("Please enter the prename of the new instructor: ");
                prename= this.scanner.next();
                instructor.setInstructorPrname(prename);
                this.instructorList.add(pIndex, instructor);
                break;
            case "Prename":
                                instructor = new Instructor(id);
                instructor.setBirthDate(birtday);
//                instructor.setCourseID(courseID);               
                instructor.setInstructorName(name);
                instructor.setSex(sex);
                instructor.setSpesification(spesification);
                instructor.setWorkRelation(workRelation);
                System.out.print("Please enter the prename of the new instructor: ");
                prename= this.scanner.next();
                instructor.setInstructorPrname(prename);
                this.instructorList.add(pIndex, instructor);
                break;
            case "birtday":
                instructor = new Instructor(id);               
//                instructor.setCourseID(courseID);
                instructor.setInstructorName(name);
                instructor.setInstructorPrname(prename);
                instructor.setSex(sex);
                instructor.setSpesification(spesification);
                instructor.setWorkRelation(workRelation);
                System.out.print("Please enter the new birthdate of the  instructor (YYYY-MM-DD): ");
                do
                {
                    input=this.scanner.next();
                    try 
                    {
                      birtday=LocalDate.parse(input);  
                    } 
                    catch (Exception e) 
                    {
                        System.err.println("input incorrect please reenter: ");
                        input="";
                    }
                }
                while(input.equals(""));
                instructor.setBirthDate(birtday);
                this.instructorList.add(pIndex, instructor);
                break;
            case "Birtday":
                instructor = new Instructor(id);               
//                instructor.setCourseID(courseID);
                instructor.setInstructorName(name);
                instructor.setInstructorPrname(prename);
                instructor.setSex(sex);
                instructor.setSpesification(spesification);
                instructor.setWorkRelation(workRelation);
                System.out.print("Please enter the new birthdate of the  instructor (YYYY-MM-DD): ");
                do
                {
                    input=this.scanner.next();
                    try 
                    {
                      birtday=LocalDate.parse(input);  
                    } 
                    catch (Exception e) 
                    {
                        System.err.println("input incorrect please reenter: ");
                        input="";
                    }
                }
                while(input.equals(""));
                instructor.setBirthDate(birtday);
                this.instructorList.add(pIndex, instructor);
                break;
            case "sex":
                instructor = new Instructor(id);
                instructor.setBirthDate(birtday);
//                instructor.setCourseID(courseID);
                instructor.setInstructorName(name);
                instructor.setInstructorPrname(prename);               
                instructor.setSpesification(spesification);
                instructor.setWorkRelation(workRelation);
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
                instructor.setSex(sex);
                this.instructorList.add(pIndex, instructor);
                break;
            case "Sex":
                instructor = new Instructor(id);
                instructor.setBirthDate(birtday);
//                instructor.setCourseID(courseID);
                instructor.setInstructorName(name);
                instructor.setInstructorPrname(prename);               
                instructor.setSpesification(spesification);
                instructor.setWorkRelation(workRelation);
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
                instructor.setSex(sex);
                this.instructorList.add(pIndex, instructor);                
                break;
            case "spesification":
                instructor = new Instructor(id);
                instructor.setBirthDate(birtday);
//                instructor.setCourseID(courseID);
                instructor.setInstructorName(name);
                instructor.setInstructorPrname(prename);
                instructor.setSex(sex);               
                instructor.setWorkRelation(workRelation);
                System.out.print("Please enter the spesification of the new instructor: ");
                spesification=this.scanner.next();
                instructor.setSpesification(spesification);
                this.instructorList.add(pIndex, instructor);
                break;
            case "Spesification":
                instructor = new Instructor(id);
                instructor.setBirthDate(birtday);
//                instructor.setCourseID(courseID);
                instructor.setInstructorName(name);
                instructor.setInstructorPrname(prename);
                instructor.setSex(sex);               
                instructor.setWorkRelation(workRelation);
                System.out.print("Please enter the spesification of the new instructor: ");
                spesification=this.scanner.next();
                instructor.setSpesification(spesification);
                this.instructorList.add(pIndex, instructor);
                break;
            case "workRelation":
                instructor = new Instructor(id);
                instructor.setBirthDate(birtday);
//                instructor.setCourseID(courseID);
                instructor.setInstructorName(name);
                instructor.setInstructorPrname(prename);
                instructor.setSex(sex);
                instructor.setSpesification(spesification);
                System.out.print("Please enter the workrelation of the new instructor like extern or intern: ");
                workRelation=this.scanner.next();
                while(!(workRelation.equals("extern")||workRelation.equals("intern")))
                {
                    System.out.print("Pleas enter extern or intern for the workrelation: ");
                    workRelation=scanner.next();            
                }                
                instructor.setWorkRelation(workRelation);
                this.instructorList.add(pIndex, instructor);
                break;
            case "WorkRelation":
                                instructor = new Instructor(id);
                instructor.setBirthDate(birtday);
//                instructor.setCourseID(courseID);
                instructor.setInstructorName(name);
                instructor.setInstructorPrname(prename);
                instructor.setSex(sex);
                instructor.setSpesification(spesification);
                System.out.print("Please enter the workrelation of the new instructor like extern or intern: ");
                workRelation=this.scanner.next();
                while(!(workRelation.equals("extern")||workRelation.equals("intern")))
                {
                    System.out.print("Pleas enter extern or intern for the workrelation: ");
                    workRelation=scanner.next();            
                }                
                instructor.setWorkRelation(workRelation);
                this.instructorList.add(pIndex, instructor);
                break;
            case "courseID":
                instructor = new Instructor(id);
                instructor.setBirthDate(birtday);
                instructor.setInstructorName(name);
                instructor.setInstructorPrname(prename);
                instructor.setSex(sex);
                instructor.setSpesification(spesification);
                instructor.setWorkRelation(workRelation);
                System.out.print("Please enter the courseID where the new instructor participaed if ther is no course yet do you want to create a new course press y or Y ");
                input=this.scanner.next();
                do
                {
                    if(input.equals("Y")||input.equals("y"))
                    {
                    
                    }
                    else
                    {
                        do
                        {
                            if(input.equals("n"))
                            {
                                
                                break;
                            }
                            try
                            {                   
                                courseID=Integer.parseInt(input);
                                if(courseID>=0)
                                {
                                    if(courseID>this.getCourseListSize())
                                    {
                                        System.out.println("Their is no course with that ID! with n you creat a new course");
                                        System.out.print("Please enter a new courseID: ");
                                        input=this.scanner.next();
                                        courseID=-1;
                                    }
                                }
                                else
                                {
                                    System.out.println("No negetiv nummbers are allowed!");
                                    System.out.print("Please enter a course id: ");
                                    input=this.scanner.next();
                                    courseID=-1;                        
                                }
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Please enter a nurtal number! ");
                                System.out.print("Please enter a new courseID: ");
                                input=this.scanner.next();
                                courseID=-1;
                            }
                        }
                        while(courseID==-1);
                    }
//                    this.setInstructorCoursId(id, courseID);
                    System.out.print("are their more courses for the new instructor enter y or Y: ");
                    input=this.scanner.next();
                }
                 while(input.equals("y")||input.equals("Y"));
                this.instructorList.add(pIndex, instructor);
                break;
            case "CourseID":
                break;
            default:
                break;
           
        }
    }
   
    public int getInstructorListSize()
    {
        int size;
        size=instructorList.size();
        size--;
        return size;
    }
    
    public String getCustomer (int pIndex)
    {
        String output;
        int id;
        String title;
        String name;
        String prename;
        LocalDate birtday;
        String sex;
        id=this.customerList.get(pIndex).getCustomerId();
        title=this.customerList.get(pIndex).getTitle();
        name=this.customerList.get(pIndex).getCustomerName();
        prename=this.customerList.get(pIndex).getCustomerPrename();
        birtday=this.customerList.get(pIndex).getBirthData();
        sex=this.customerList.get(pIndex).getSex();
        output=("| "+id+" | "+title+" | "+name+" | "+prename+" | "+birtday+" | "+sex+" |");
        return output;
    }
    
    public void getCustomerList()
    {
        for(int i=0; i<this.customerList.size();i++)
        {
            System.out.println(this.getCustomer(i));
        }
    }
    
    public void setCustomerList (String pTitle, String pCustomerName, LocalDate pBirthData, String pCustomerPrename, String pSex)
    {
        Customer customer = new Customer();
        customer.setTitle(pTitle);
        customer.setCustomerName(pCustomerName);
        customer.setBirthData(pBirthData);
        customer.setCustomerPrename(pCustomerPrename);
        customer.setSex(pSex);
        this.customerList.add(customer);
    }
    
    public int getCustomerListSize()
    {
        int size;
        size=customerList.size();
        size--;
        return size;
    }
    
    public void deleteCustomer(int pIndex)
    {
        this.customerList.remove(pIndex);
    }
    
    public void updataCustomer(int pIndex, String pInput)
    {
        int id;
        String title;
        String name;
        String prename;
        LocalDate birtday;
        String sex;
        Customer customer;
        String input;
        
        id=this.customerList.get(pIndex).getCustomerId();
        title=this.customerList.get(pIndex).getTitle();
        name=this.customerList.get(pIndex).getCustomerName();
        prename=this.customerList.get(pIndex).getCustomerPrename();
        birtday=this.customerList.get(pIndex).getBirthData();
        sex=this.customerList.get(pIndex).getSex();
        
        this.deleteCustomer(pIndex);
        switch(pInput)
        {
            case "name":
                customer = new Customer(id);
                customer.setTitle(title);
                customer.setBirthData(birtday);
                customer.setCustomerPrename(prename);
                customer.setSex(sex);
                System.out.print("Please enter the new name of the customer: ");
                name=this.scanner.next();
                customer.setCustomerName(name);
                this.customerList.add(pIndex, customer);
                break;
            case "Name":
                customer = new Customer(id);
                customer.setTitle(title);
                customer.setBirthData(birtday);
                customer.setCustomerPrename(prename);
                customer.setSex(sex);
                System.out.print("Please enter the new name of the customer: ");
                name=this.scanner.next();
                customer.setCustomerName(name);
                this.customerList.add(pIndex, customer);
                break;
            case "prename":
                customer = new Customer(id);
                customer.setTitle(title);
                customer.setBirthData(birtday);
                customer.setCustomerName(name);
                customer.setSex(sex);
                System.out.print("Please enter the new prename of the customer: ");
                prename=this.scanner.next();
                customer.setCustomerPrename(prename);
                this.customerList.add(pIndex, customer);
                break;
            case "Prename":
                customer = new Customer(id);
                customer.setTitle(title);
                customer.setBirthData(birtday);
                customer.setCustomerName(name);
                customer.setSex(sex);
                System.out.print("Please enter the new prename of the customer: ");
                prename=this.scanner.next();
                customer.setCustomerPrename(prename);
                this.customerList.add(pIndex, customer);
                break;
            case "title":
                customer = new Customer(id);
                customer.setCustomerPrename(prename);
                customer.setBirthData(birtday);
                customer.setCustomerName(name);
                customer.setSex(sex);
                System.out.print("Please enter the new title of the customer: ");
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
                customer.setTitle(title);
                this.customerList.add(pIndex, customer);
                break;
            case "Title":
                customer = new Customer(id);
                customer.setCustomerPrename(prename);
                customer.setBirthData(birtday);
                customer.setCustomerName(name);
                customer.setSex(sex);
                System.out.print("Please enter the new title of the customer: ");
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
                customer.setTitle(title);
                this.customerList.add(pIndex, customer);
                break;
            case "birthday":
                customer = new Customer(id);
                customer.setCustomerPrename(prename);
                customer.setCustomerName(name);
                customer.setSex(sex);
                 System.out.print("Please enter the new birthdate of the  customer (YYYY-MM-DD): ");
                do
                {
                    input=this.scanner.next();
                    try 
                    {
                      birtday=LocalDate.parse(input);  
                    } 
                    catch (Exception e) 
                    {
                        System.err.println("input incorrect please reenter: ");
                        input="";
                    }
                }
                while(input.equals(""));               
                customer.setBirthData(birtday);
                this.customerList.add(pIndex, customer);
                break;
            case "Birthday":
                customer = new Customer(id);
                customer.setCustomerPrename(prename);
                customer.setCustomerName(name);
                customer.setSex(sex);
                 System.out.print("Please enter the new birthdate of the  customer (YYYY-MM-DD): ");
                do
                {
                    input=this.scanner.next();
                    try 
                    {
                      birtday=LocalDate.parse(input);  
                    } 
                    catch (Exception e) 
                    {
                        System.err.println("input incorrect please reenter: ");
                        input="";
                    }
                }
                while(input.equals(""));                   
                customer.setBirthData(birtday);
                this.customerList.add(pIndex, customer);
                break;
            case "sex":
                customer = new Customer(id);
                customer.setCustomerPrename(prename);
                customer.setBirthData(birtday);
                customer.setCustomerName(name);
                customer.setTitle(title);
                do
                {
                    System.out.print("Please enter the sex of the new customer: ");
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
                customer.setSex(sex);
                this.customerList.add(pIndex, customer);
                break;
            case "Sex":
                do
                {
                    customer = new Customer(id);
                    customer.setCustomerPrename(prename);
                    customer.setBirthData(birtday);
                    customer.setCustomerName(name);
                    customer.setTitle(title);
                    System.out.print("Please enter the sex of the new customer: ");
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
                customer.setSex(sex);
                this.customerList.add(pIndex, customer);
                break;
            default:
                System.out.println("Uppdate canceled");
                break;
        }
    }
    
    public String getCourseList(int pIndex)
    {
        String output;
        int id;
        String name;
        String begin;
        String end;
        LocalDate date;
        String day;               
        id=this.courseList.get(pIndex).getCousrseID();
        name=this.courseList.get(pIndex).getCousrsName();
        begin=this.courseList.get(pIndex).getBeginingOfCourse();
        end=this.courseList.get(pIndex).getEndOfCourse();
        date=this.courseList.get(pIndex).getDateOfCourse();
        day=this.courseList.get(pIndex).getWeekday();
        output=("| "+id+" | "+name+" | "+begin+" | "+end+" | "+date+" | "+day+"| ");
        return output;
    }
    
    public void getCourseList()
    {
        for(int i=0; i<this.customerList.size();i++)
        {
            System.out.println(this.getCourseList(i));
        }
    }
    
    public void setCourseList(String pBeginingOfCourse, String pCousrsName, LocalDate pdateOfCourse, String pEndOfCourse, String pWeekday)
    {
        Course course = new Course();
        course.setBeginingOfCourse(pBeginingOfCourse);
        course.setCousrsName(pCousrsName);
        course.setDateOfCourse(pdateOfCourse);
        course.setEndOfCourse(pEndOfCourse);
        course.setWeekday(pWeekday);
        this.courseList.add(course);
    }
    
    public int getCourseListSize()
    {
        int size;
        size=courseList.size();
        size--;
        return size;
    }
    
    public void deleteCourse(int pindex)
    {
        this.courseList.remove(pindex);
    }
    
    public void updataCourse(int pIndex, String pInput)
    {
        int id;
        String name;
        String start;
        String end;
        LocalDate date;
        String day;
        Course course;
        String input;
        pattern = Pattern.compile(regex);
        id=this.courseList.get(pIndex).getCousrseID();
        name=this.courseList.get(pIndex).getCousrsName();
        start=this.courseList.get(pIndex).getBeginingOfCourse();
        end=this.courseList.get(pIndex).getEndOfCourse();
        date=this.courseList.get(pIndex).getDateOfCourse();
        day=this.courseList.get(pIndex).getWeekday();
        switch(pInput)
        {
            case "name":
                course = new Course(id);
                course.setBeginingOfCourse(start);
                course.setDateOfCourse(date);
                course.setEndOfCourse(end);
                course.setWeekday(day);
                System.out.print("Please enter the new Name of the  course: ");
                name=this.scanner.next();
                course.setCousrsName(name);
                this.courseList.add(pIndex, course);
                break;
            case "Name":
                course = new Course(id);
                course.setBeginingOfCourse(start);
                course.setDateOfCourse(date);
                course.setEndOfCourse(end);
                course.setWeekday(day);
                System.out.print("Please enter the new Name of the  course: ");
                name=this.scanner.next();
                course.setCousrsName(name);
                this.courseList.add(pIndex, course);
                break;
            case "start":
                course = new Course(id);
                course.setCousrsName(name);
                course.setDateOfCourse(date);
                course.setEndOfCourse(end);
                course.setWeekday(day);
                System.out.print("Please enter the starting new time of the course (hh:mm): ");
                do
                {
                    start= this.scanner.next();
                    matcher = pattern.matcher(start);
                    if(!(matcher.find()&& matcher.group().equals(start)))
                    {
                    System.out.println("time is not valid please enter in this pattern (hh:mm)");
                    start="";
                    }
                }
                while(start.equals(""));
                course.setBeginingOfCourse(start);
                this.courseList.add(pIndex, course);
                break;
            case "Start":
                course = new Course(id);
                course.setCousrsName(name);
                course.setDateOfCourse(date);
                course.setEndOfCourse(end);
                course.setWeekday(day);
                System.out.print("Please enter the new starting time of the course (hh:mm): ");
                do
                {
                    start= this.scanner.next();
                    matcher = pattern.matcher(start);
                    if(!(matcher.find()&& matcher.group().equals(start)))
                    {
                    System.out.println("time is not valid please enter in this pattern (hh:mm)");
                    start="";
                    }
                }
                while(start.equals(""));
                course.setBeginingOfCourse(start);
                this.courseList.add(pIndex, course);                
                break;
            case "end":
                course = new Course(id);
                course = new Course(id);
                course.setBeginingOfCourse(start);
                course.setCousrsName(name);
                course.setDateOfCourse(date);
                course.setWeekday(day);
                System.out.print("Please enter the new ending time of the course (hh:mm): ");
                do
                {
                    end= this.scanner.next();
                    matcher = pattern.matcher(end);
                    if(!(matcher.find()&& matcher.group().equals(end)))
                    {
                        System.out.println("time is not valid please enter in this pattern (hh:mm)");
                        end="";
                    }
                }
                while(end.equals(""));
                course.setEndOfCourse(end);
                this.courseList.add(pIndex, course);
                break;
            case "End":
                course = new Course(id);
                course = new Course(id);
                course.setBeginingOfCourse(start);
                course.setCousrsName(name);
                course.setDateOfCourse(date);
                course.setWeekday(day);
                System.out.print("Please enter the new ending time of the course (hh:mm): ");
                do
                {
                    end= this.scanner.next();
                    matcher = pattern.matcher(end);
                    if(!(matcher.find()&& matcher.group().equals(end)))
                    {
                        System.out.println("time is not valid please enter in this pattern (hh:mm)");
                        end="";
                    }
                }
                while(end.equals(""));
                course.setEndOfCourse(end);
                this.courseList.add(pIndex, course);                
                break;
            case "date":
                course = new Course(id);
                course.setBeginingOfCourse(start);
                course.setCousrsName(name);
                course.setEndOfCourse(end);
                course.setWeekday(day);
                System.out.print("Please enter the new date of the cours (YYYY-MM-DD): ");
                do
                {
                    input=this.scanner.next();
                    try 
                    {
                      date=LocalDate.parse(input);  
                    } 
                    catch (Exception e) 
                    {
                        System.err.println("input incorrect please reenter: ");
                        input="";
                    }
                }
                while(input.equals(""));          
                course.setDateOfCourse(date);
                this.courseList.add(pIndex, course);
                break;
            case "Date":
                course = new Course(id);
                course.setBeginingOfCourse(start);
                course.setCousrsName(name);
                course.setEndOfCourse(end);
                course.setWeekday(day);
                System.out.print("Please enter the new date of the cours (YYYY-MM-DD): ");
                do
                {
                    input=this.scanner.next();
                    try 
                    {
                      date=LocalDate.parse(input);  
                    } 
                    catch (Exception e) 
                    {
                        System.err.println("input incorrect please reenter: ");
                        input="";
                    }
                }
                while(input.equals(""));          
                course.setDateOfCourse(date);
                this.courseList.add(pIndex, course);                
                break;
            case "day":
                course = new Course(id);
                course.setBeginingOfCourse(start);
                course.setCousrsName(name);
                course.setDateOfCourse(date);
                course.setEndOfCourse(end);
                System.out.print("Please enter the new weekday of the course: ");
                day=this.scanner.next();
                switch(day)
                {
                    case "Monday":
                        day="M";
                        break;
                    case "monday":
                        day="M";
                        break;
                    case "m":
                        day="M";
                        break;
                    case "Tuesday":
                        day="Tu";
                        break;
                    case "tuesday":
                        day="Tu";
                        break;
                    case "t":
                        day="Tu";
                        break; 
                    case "Wensday":
                        day="W";
                        break;
                    case "=wensday":
                        day="W";
                        break;
                    case "w":
                        day="W";
                        break; 
                    case "Thursday":
                        day="Thu";
                        break;
                    case "thursday":
                        day="Thu";
                        break;
                    case "thu":
                        day="Thu";
                        break;
                    case "Friday":
                        day="F";
                        break;
                    case "friday":
                        day="F";
                        break;
                    case "f":
                        day="F";
                        break; 
                   case "Saturday":
                        day="Sat";
                        break;
                    case "saturday":
                        day="Sat";
                        break;
                    case "sat":
                        day="Sat";
                        break;
                    case "Sunday":
                        day="Sun";
                        break;
                    case "sunday":
                        day="Sun";
                        break;
                    case "sun":
                        day="Sun";
                        break;
                    default:                
                        break;
                }
                course.setWeekday(day);
                this.courseList.add(pIndex, course);
                break;
            case "Day":
                course = new Course(id);
                course.setBeginingOfCourse(start);
                course.setCousrsName(name);
                course.setDateOfCourse(date);
                course.setEndOfCourse(end);
                System.out.print("Please enter the new weekday of the course: ");
                day=this.scanner.next();
                switch(day)
                {
                    case "Monday":
                        day="M";
                        break;
                    case "monday":
                        day="M";
                        break;
                    case "m":
                        day="M";
                        break;
                    case "Tuesday":
                        day="Tu";
                        break;
                    case "tuesday":
                        day="Tu";
                        break;
                    case "t":
                        day="Tu";
                        break; 
                    case "Wensday":
                        day="W";
                        break;
                    case "=wensday":
                        day="W";
                        break;
                    case "w":
                        day="W";
                        break; 
                    case "Thursday":
                        day="Thu";
                        break;
                    case "thursday":
                        day="Thu";
                        break;
                    case "thu":
                        day="Thu";
                        break;
                    case "Friday":
                        day="F";
                        break;
                    case "friday":
                        day="F";
                        break;
                    case "f":
                        day="F";
                        break; 
                   case "Saturday":
                        day="Sat";
                        break;
                    case "saturday":
                        day="Sat";
                        break;
                    case "sat":
                        day="Sat";
                        break;
                    case "Sunday":
                        day="Sun";
                        break;
                    case "sunday":
                        day="Sun";
                        break;
                    case "sun":
                        day="Sun";
                        break;
                    default:                
                        break;
                }
                course.setWeekday(day);
                this.courseList.add(pIndex, course);
                break;                
            default:
                System.out.println("update canceled");
                break;
        }
    }
    
//    public  void test()
//    {
//        this.getCourseList();
//        this.setInstructorList("19.99.99", 0, "BErns", "gsdsad", "m", "dsad", "dsadasd");
//        this.getInstructorList(0);
//    }
}
