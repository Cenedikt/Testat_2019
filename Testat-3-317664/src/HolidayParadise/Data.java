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
    
    public void setInstructorList ()
    {
        Instructor instructor = new Instructor();
    }
    
    public void getInstructorList ()
    {
        
    }
    
    
    public void setCustomerList (String pCustomerName)
    {
        Customer customer = new Customer();
        customer.setCustomerName(pCustomerName);
    }
    
    public void getCustomerList ()
    {
    }
    
}
