/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayParadise;

import java.util.ArrayList;

/**
 *
 * @author Benedict
 */
public class Data 
{
    private ArrayList<Instructor> instructorList = new ArrayList<Instructor>();
    private ArrayList<Customer> customerList = new ArrayList<Customer>();
    private ArrayList<Course> courseList = new ArrayList<Course>(); 

    public String getInstructorList (int pIndex)
    {
        String output;
        int id;
        String name;
        String prename;
        String birtday;
        String sex;
        String spesification;
        String workRelation;
        int courseID;
        id=this.instructorList.get(pIndex).getInstructorID();
        name=this.instructorList.get(pIndex).getInstructorName();
        prename=this.instructorList.get(pIndex).getInstructorPrname();
        birtday=this.instructorList.get(pIndex).getBirthDate();
        sex=this.instructorList.get(pIndex).getSex();
        spesification=this.instructorList.get(pIndex).getSpesification();
        workRelation=this.instructorList.get(pIndex).getWorkRelation();
        this.instructorList.get(pIndex).getCourseID();
        output="| "+id+" | "+name+" | "+prename+" | "+birtday+" | "+sex+" | "+spesification+" | "+workRelation+" |";
        return output;
    }
    
    public void getInstructorList()
    {
        for(int i=0; i<this.instructorList.size();i++)
        {
            System.out.println(this.getInstructorList(i));
        }
    }
    
    public void setInstructorList (String pBirthDate, int pCourseID, String pInstructorName, String pInstructorPrname, String pSex, String pSpesification, String pWorkRelation)
    {
        Instructor instructor = new Instructor();
        instructor.setBirthDate(pBirthDate);
        instructor.setCourseID(pCourseID);
        instructor.setInstructorName(pInstructorName);
        instructor.setInstructorPrname(pInstructorPrname);
        instructor.setSex(pSex);
        instructor.setSpesification(pSpesification);
        instructor.setWorkRelation(pWorkRelation);
        this.instructorList.add(instructor);
    }
    
    public void deleteInstructor(int pIndex)
    {
        this.instructorList.remove(pIndex);
    }
    
    public void updataInstructor(int pIndex)
    {
       
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
        String birtday;
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
    
    public void setCustomerList (String pTitle, String pCustomerName, String pBirthData, String pCustomerPrename, String pSex)
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
    
    public void updataCustomer()
    {}
    
    public String getCourseList(int pIndex)
    {
        String output;
        int id;
        String name;
        String begin;
        String end;
        String date;
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
    
    public void setCourseList(String pBeginingOfCourse, String pCousrsName, String pdateOfCourse, String pEndOfCourse, String pWeekday)
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
    
    public void updataCourse()
    {}
    
    public  void test()
    {
        this.getCourseList();
        this.setInstructorList("19.99.99", 0, "BErns", "gsdsad", "m", "dsad", "dsadasd");
        this.getInstructorList(0);
    }
}
