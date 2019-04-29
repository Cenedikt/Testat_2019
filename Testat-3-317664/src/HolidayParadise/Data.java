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
    private ArrayList<Instructors> instructorList = new ArrayList<Instructors>();
    private ArrayList<Customer> customerList = new ArrayList<Customer>();
    private ArrayList<Course> courseList = new ArrayList<Course>(); 
    
    public void setInstructorList ()
    {
        Instructors instructor = new Instructors();
    }
    
    public void getInstructorList ()
    {
        
    }
    
    public int getInstructorListSize ()
    {
        return instructorList.size();
    }
    
    public void getCustomerList (String pCustomerName)
    {
        Customer customer = new Customer();
        customer.setCustomerName(pCustomerName);
    }
    
    public void getCustomerList ()
    {
    }
    
    public int getCustomerListSize ()
    {
        return customerList.size();
    }
    
    public void test()
    {
        Customer customer0= new Customer();
        Customer customer1= new Customer();
        Customer customer2= new Customer();
        Customer customer3= new Customer();
        Customer customer4= new Customer();
            customerList.add(customer0);
            customerList.add(customer1); 
            customerList.add(customer2); 
            customerList.add(customer3);
            customerList.add(customer4); 
            System.out.println(customerList.get(0));
            System.out.println(customerList.get(1).getCustomerId());
            System.out.println(customerList.get(2).getCustomerId());
            System.out.println(customerList.get(3).getCustomerId());
            System.out.println(customerList.get(4).getCustomerId());       
    }
}
