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
    }
    
    public void getInstructorList ()
    {
        
        
    }
    
    
    public void setCustomerList (String pCustomerName, String pBirthData, int pCourseID, String pCustomerPrename)
    {
        Customer customer = new Customer();
        customer.setCustomerName(pCustomerName);
        customer.setBirthData(pBirthData);
        customer.setCourseID(pCourseID);
        customer.setCustomerPrename(pCustomerPrename);
    }
    
    public void getCustomerList ()
    {
    }
    
    public void setCourseList(String pBeginingOfCourse, String pCousrsName, int pCustomerID, String pdateOfCourse, String pEndOfCourse, int pInstructorID, String pWeekday)
    {
        Course course = new Course();
        course.setBeginingOfCourse(pBeginingOfCourse);
        course.setCousrsName(pCousrsName);
        course.setCustomerID(pCustomerID);
        course.setDateOfCourse(pdateOfCourse);
        course.setEndOfCourse(pEndOfCourse);
        course.setInstructorID(pInstructorID);
        course.setWeekday(pWeekday);
    }
}
