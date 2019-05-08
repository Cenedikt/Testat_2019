/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayParadise;

import java.util.ArrayList;

/**
 *
 * @author Cenedikt
 */
public final class Customer 
{
    private static int lastID;
    private int customerId;
    private String title;
    private String customerName;
    private String customerPrename;
    private String birthData;
    private String sex;
    
    /**
     * 
     * @return customerId
     */
    public int getCustomerId() 
    {
        return customerId;
    }
    
    /**
     * 
     * @param pCustomerId 
     */
    public void setCustomerId(int pCustomerId) 
    {
        this.customerId = pCustomerId;
    }
    
    /**
     * 
     * @return title
     */
    public String getTitle() 
    {
        return this.title;
    }

    /**
     * 
     * @param pTitle 
     */
    public void setTitle(String pTitle) 
    {
        this.title = pTitle;
    }
           
    /**
     * 
     * @return customerName
     */
    public String getCustomerName() 
    {
        return customerName;
    }
    
    /**
     * 
     * @param pCustomerName 
     */
    public void setCustomerName(String pCustomerName) 
    {
        this.customerName = pCustomerName;
    }

    /**
     * 
     * @return customerPrename
     */
    public String getCustomerPrename() 
    {
        return this.customerPrename;
    }
    
    /**
     * 
     * @param pCustomerPrename 
     */
    public void setCustomerPrename(String pCustomerPrename) 
    {
        this.customerPrename = pCustomerPrename;
    }
    
    /**
     * 
     * @return birthData
     */
    public String getBirthData() 
    {
        return this.birthData;
    }

    /**
     * 
     * @param birthData 
     */
    public void setBirthData(String pBirthData) {
        this.birthData = pBirthData;
    }
    
    /**
     * 
     * @return sex
     */
    public String getSex() 
    {
        return this.sex;
    }

    /**
     * 
     * @param pSex 
     */
    public void setSex(String pSex) 
    {
        this.sex = pSex;
    }
    
    /**
     * constructor
     * <br> sets automaticly the value of CustomerId and alsow counts up
     */
    public  Customer()
    {
        this.setCustomerId(Customer.lastID++);
    }   
}
