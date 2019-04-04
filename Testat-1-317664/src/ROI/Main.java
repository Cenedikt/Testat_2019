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
        String stringInput;

        
        
        // Methode
        stringInput=args[0];
        do
        {
            try
            {
                valueTrailer=Integer.parseInt(stringInput);
            }
            catch(NumberFormatException e)
            {
                System.out.println("The input is incorrect!");
                System.out.println("Enter the value of the trailer:");
                stringInput=scanner.next();
                valueTrailer=0;
            }
        }
        while(valueTrailer==0);
        
        stringInput=args[1];
        do
        {   
            try
            {
                years=Integer.parseInt(stringInput);
                if(years>0 && years<=10)
                {
                }
                else
                {
                    System.out.println("The input is incorrect!");
                    System.out.println("Enter the values of the period time of the contract it should be between 1 and 10:");
                    stringInput= scanner.next();   
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println("The input is incorrect!");
                System.out.println("Enter the values of Years the contract is going it shouldn’t be between 1 and 10:");
                stringInput= scanner.next();
                years=0;
            }
        }
        while(years==0);
        
        stringInput=args[2];
        do
        {
            try
            {
                dalyRentPrice=Double.parseDouble(stringInput);
            }
            catch(NumberFormatException e)
            {
                System.out.println("The input is incorrect!");
                System.out.println("Enter the value of the daily rent of the trailer:");
                stringInput= scanner.next();
                dalyRentPrice=0;
            }
        }
        while(dalyRentPrice==0);
        
        stringInput=args[3];
        do
        {
            try
            {
                valueUsedTrailer=Double.parseDouble(stringInput);
            }
            catch(NumberFormatException e)
            {
                System.out.println("The input is incorrect!");
                System.out.println("Enter the value of the used trailer:");
                stringInput= scanner.next();
                valueUsedTrailer=0;
            }
        }
        while(valueUsedTrailer==0);
    }
      
}
