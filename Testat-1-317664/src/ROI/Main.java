package ROI;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Benedict Goldhorn 317664
 */
public class Main 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        //Variables
        Scanner scanner = new Scanner(System.in);
        int valueTrailer;
        int years;
        double dalyRentPrice;
        double valueUsedTrailer;
        String argument;
        String inputScann;
        
        
        // Methode
        do
        {
            try
            {
                argument=args[0];
                valueTrailer=Integer.parseInt(argument);
            }
            catch(NumberFormatException e)
            {
                System.out.println("The input is incorrect!");
                System.out.println("Enter the value of the trailer:");
                inputScann= scanner.next();  
                valueTrailer=Integer.parseInt(inputScann);
            }
        }
        while(valueTrailer<=0);
        
        do
        {   
            try
            {
                argument=args[1];
                years=Integer.parseInt(argument);
            }
            catch(NumberFormatException e)
            {
                System.out.println("The input is incorrect!");
                System.out.println("Enter the values of Years the contract is going it shouldn’t be between 1 and 10:");
                inputScann= scanner.next();
                years=Integer.parseInt(inputScann);
            }
        }
        while(years<0 && years>=10);
        
        do
        {
            try
            {
                argument=args[2];
                dalyRentPrice=Double.parseDouble(argument);
            }
            catch(NumberFormatException e)
            {
                System.out.println("The input is incorrect!");
                System.out.println("Enter the value of the daily rent of the trailer:");
                inputScann= scanner.next();
                dalyRentPrice=Double.parseDouble(inputScann);
            }
        }
        while(dalyRentPrice<0);
        
        do
        {
            try
            {
                argument=args[3];
                valueUsedTrailer=Double.parseDouble(argument);
            }
            catch(NumberFormatException e)
            {
                System.out.println("The input is incorrect!");
                System.out.println("Enter the value of the used trailer:");
                inputScann= scanner.next();
                valueUsedTrailer=Double.parseDouble(inputScann);
            }
        }
        while(valueUsedTrailer>0);
    }
   
}
