/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayParadise;

/**
 *
 * @author Cenedikt
 */
public class Customer 
{
    private int customerId;
    private String customerName;
    
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
}
