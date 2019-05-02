/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayParadise;

import java.util.ArrayList;
import java.sql.Time;

/**
 *
 * @author Benedict
 */
public class Data 
{
    private ArrayList<Instructor> instructorList = new ArrayList<Instructor>();
    private ArrayList<Customer> customerList = new ArrayList<Customer>();
    private ArrayList<Course> courseList = new ArrayList<Course>(); 

    public void getInstructorList (int pIndex)
    {
        this.instructorList.get(pIndex).getInstructorID();
        this.instructorList.get(pIndex).getInstructorName();
        this.instructorList.get(pIndex).getInstructorPrname();
        this.instructorList.get(pIndex).getBirthDate();
        this.instructorList.get(pIndex).getSex();
        this.instructorList.get(pIndex).getSpesification();
        this.instructorList.get(pIndex).getWorkRelation();
        this.instructorList.get(pIndex).getCourseID();               
    }
    
    public void getInstructorList()
    {
        for(int i=0; i<this.instructorList.size();i++)
        {
            this.getInstructorList(i);
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
    
    public void getCustomerList (int pIndex)
    {
        this.customerList.get(pIndex).getCustomerId();
        this.customerList.get(pIndex).getCustomerName();
        this.customerList.get(pIndex).getCustomerPrename();
        this.customerList.get(pIndex).getBirthData();
        this.customerList.get(pIndex).getSex();
    }
    
    public void getCustomerList()
    {
        for(int i=0; i<this.customerList.size();i++)
        {
            this.getCustomerList(i);
        }
    }
    
    public void setCustomerList (String pCustomerName, String pBirthData, String pCustomerPrename, String pSex)
    {
        Customer customer = new Customer();
        customer.setCustomerName(pCustomerName);
        customer.setBirthData(pBirthData);
        customer.setCustomerPrename(pCustomerPrename);
        customer.setSex(pSex);
        this.customerList.add(customer);
    }
    
    public void getCourseList(int pIndex)
    {
        this.courseList.get(pIndex).getCousrseID();
        this.courseList.get(pIndex).getCousrsName();
        this.courseList.get(pIndex).getBeginingOfCourse();
        this.courseList.get(pIndex).getEndOfCourse();
        this.courseList.get(pIndex).getEndOfCourse();
        this.courseList.get(pIndex).getWeekday();
    }
    
    public void getCourseList()
    {
        for(int i=0; i<this.customerList.size();i++)
        {
            this.getCourseList(i);
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
    
    public  void test()
    {
        this.getCourseList();
        this.setInstructorList("19.99.99", 0, "BErns", "gsdsad", "m", "dsad", "dsadasd");
        this.getInstructorList(0);
    }
}
