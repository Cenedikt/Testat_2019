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
        int contractPeriod;
        double dalyRentPrice;
        double valueUsedTrailer;
        String stringInput;
        double finalAmount;
        double interestRate;
        
        // Methode
        if(args.length != 4)
        {
            System.out.println("It must to be 4 arguments to run the program pleas restart and enter 4 arguments! ");
          System.exit(0); 
        }
        
        stringInput=args[0];
        do
        {
            try
            {
                valueTrailer=Integer.parseInt(stringInput);
            }
            catch(NumberFormatException e)
            {
                do
                {
                    System.out.println("The input is incorrect!");
                    System.out.println("Enter the value of the trailer:");
                    stringInput=scanner.next();
                    valueTrailer=0;
                }
                while(stringInput.matches("-?\\d+")==true);
            }
        }
        while(valueTrailer==0);
        
        stringInput=args[1];
        do
        {   
            try
            {
                contractPeriod=Integer.parseInt(stringInput);
                if(!(contractPeriod>0 && contractPeriod<=10))
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
                contractPeriod=0;
            }
        }
        while(contractPeriod==0);
        
        stringInput=args[2];
        do
        {
            try
            {
                dalyRentPrice=Double.parseDouble(stringInput);
                dalyRentPrice=Math.round(dalyRentPrice*100)/100.0;
            }
            catch(NumberFormatException e)
            {
                do
                {
                    System.out.println("The input is incorrect!");
                    System.out.println("Enter the value of the daily rent of the trailer:");
                    stringInput= scanner.next();
                    dalyRentPrice=0;
                }
                while(stringInput.matches("-?\\d+")==true);
            }
        }
        while(dalyRentPrice==0);
        
        stringInput=args[3];
        do
        {
            try
            {
                valueUsedTrailer=Double.parseDouble(stringInput);
                valueUsedTrailer=Math.round(valueUsedTrailer*100)/100.0;
            }
            catch(NumberFormatException e)
            {
                do
                {
                    System.out.println("The input is incorrect!");
                    System.out.println("Enter the value of the used trailer:");
                    stringInput= scanner.next();
                    valueUsedTrailer=0;
                }
                while(stringInput.matches("-?\\d+")==true);
            }
        }
        while(valueUsedTrailer==0);
        System.out.println("The entered values are:");
        System.out.println("Price of the trailer: "+valueTrailer+"€");
        System.out.println("Contracted time: "+contractPeriod);
        System.out.println("Price of daly rent: "+dalyRentPrice+"€");
        System.out.println("Value of udes trailer: "+ valueUsedTrailer+"€");
        finalAmount=computeFinalAmount(valueTrailer, contractPeriod, dalyRentPrice);
        System.out.println("_______________________________");
        System.out.println("The final amount is: "+finalAmount+"€");
        interestRate=computeInterestRate(finalAmount, valueTrailer, contractPeriod);
        System.out.println("The intrestrate is: "+interestRate+"€");
    }
    
    public static double computeFinalAmount (int pvalueUsedTrailer, int pcontractPeriod, double pdalyRentPrice)               
    {
        double finalAmount;
        finalAmount = pvalueUsedTrailer + (pcontractPeriod * 12 * 30 * pdalyRentPrice); 
        finalAmount=Math.round(finalAmount*100)/100.0;
        return finalAmount;
    }
    
    public static double computeInterestRate(double pfinalAmount, int pvalueTrailer, int pcontractPeriod)
    {
        double interestRate;
        interestRate = Math.pow((pfinalAmount / pvalueTrailer), (1.0 / pcontractPeriod) - 1);
        interestRate=Math.round(interestRate*100)/100.0;
        return interestRate;       
    }
}
