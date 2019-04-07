package ROI;

import java.util.Scanner;

/**
 * Calculation of Return On Investment short ROI 
 * <br>is a programm which calculates the intrestrate and final amount of an contact 
 * which inclouds selling an Trailer and rent it back for a period of time and buying the same trailer after the time back.
 */


/**
 * @author Benedict Goldhorn 317664
 * @version 1.0
 */
public class Main 
{
    /*
    * Declaration of the Variables of first part of the Testat
    */
    double bankBalance;
    int quant;
    String tyreID;
    double wages;
    int matricalNumb;
    //or
    int studentsID;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        /**
        * the variable scanner is implemented with the datatyp  Scanner
        * <br>because of the scanner the Scanner methods are useable
        * 
        */
        Scanner scanner = new Scanner(System.in);
        /**
        * the variable valueTrailer is implemeted with the datatyp int
        * <br> it's the value of the new Trailer and it's saved in it in €
        */
        int valueTrailer;
        /**
        * the variable contractPeriod is implemeted with the datatyp int
        * <br> it's the time of the contract and it' saved in it in years
        */
        int contractPeriod;
        /**
        * the variable dalyRentPrice is implemeted with the datatyp double
        * <br> it's the value of the rent and it's saved int it in €
        */
        double dalyRentPrice;
        /**
        * the variable valueUsedTrailer is implemeted with the datatyp double
        * <br> it's the value of the used trailer after the the contaract ends
        * and it's saved in it in €
        */
        double valueUsedTrailer;
        /**
        * the variable stringInput is implemeted with the datatyp String
        * <br> it's the cache of the input of the arguments and the scanner
        */
        String stringInput;
        /**
        * the variable finalAmount is implemeted with the datatyp double
        * <br> it's the final amount of cost wich are followed with the contract
        * and it's saved in it in €
        */
        double finalAmount;
        /**
        * the variable interestRate is implemeted with the datatyp double
        * <br> it´s the intrestrate of the contract and it's saved in it 
        */
        double interestRate;
        
        /**
        * the programm checks if their are 4 argumnets to competed with if not it exits the programm
        * <br> withe the methoed length which shows how long an araay is
        * @exception a consel output what says missing arguments
        */
        if(args.length != 4)
        {
            /**
            * error message 
            */
            System.out.println("It must be 4 arguments to run the program pleas restart and enter 4 arguments! ");
            /**
            * exits the programm
            */
            System.exit(1); 
        }
        /**
         * the first position of the araay is given to the stringInput to work with it
         */
        stringInput=args[0];
        /**
         * the loop checks if the valueTrailer isn't 0
         */
        do
        {

            try
            {
                /**
                 * the stringInput is pared in to an int and saved in valueTrailer
                 */
                valueTrailer=Integer.parseInt(stringInput);
            }
            /**
             * @exception input incorrect
             */
            catch(NumberFormatException e)
            {

                do
                {
                    /**
                     * error message 
                     */
                    System.out.println("The input is incorrect!");
                    /**
                     * Consal output
                     */
                    System.out.println("Enter the value of the trailer:");
                    /**
                     * next() reads the console input and saved it int StringInput
                     */
                    stringInput=scanner.next();
                    /**
                     * set value of valueTrailer to 0 to competed withe the loop
                     */
                    valueTrailer=0;
                }
                /**
                 * loop argumet
                 * <br> a matches check if the string has positiv nummbers
                 * @return a boolean
                 */
                while(stringInput.matches("\\d+")==false);
            }
        }
        /**
         * loop argument
         */
        while(valueTrailer==0);

        /**
         * the second position of the araay is given to the stringInput to work with it
         */        
        stringInput=args[1];
        /**
         * the loop checks if the valueTrailer isn't 0
         */        
        do
        {            
            try
            {
                contractPeriod=Integer.parseInt(stringInput);
                if(!(contractPeriod>0 && contractPeriod<=10))
                {
                    /**
                     * error message 
                     */  
                    System.out.println("The input is incorrect!");
                    /**
                     * Consal output
                     */                    
                    System.out.println("Enter the values of the period time of the contract it should be between 1 and 10:");
                    /**
                     * next() reads the console input and saved it int StringInput
                     */                    
                    stringInput= scanner.next();
                    /**
                     * set value of contractPeriod to 0 to competed withe the loop
                     */
                    contractPeriod=0;
                }
            }
            /**
             * @exception input incorrect
             */            
            catch(NumberFormatException e)
            {
                /**
                 * error message 
                 */
                System.out.println("The input is incorrect!");
                /**
                 * Consal output
                 */                
                System.out.println("Enter the values of Years the contract is going it shouldn’t be between 1 and 10:");
                /**
                * next() reads the console input and saved it int StringInput
                */                
                stringInput= scanner.next();
                /**
                 * set value of contractPeriod to 0 to competed withe the loop
                 */                
                contractPeriod=0;
            }
        }
        /**
         * loop argument
         */
        while(contractPeriod==0);

        /**
         * the thiered position of the araay is given to the stringInput to work with it
         */        
        stringInput=args[2];
        /**
         * the loop checks if the valueTrailer isn't 0
         */
        do
        {
            try
            {
                dalyRentPrice=Double.parseDouble(stringInput);
                dalyRentPrice=Math.round(dalyRentPrice*100)/100.0;
            }
            /**
             * @exception input incorrect
             */            
            catch(NumberFormatException e)
            {
                /**
                 * the loop check if the nummber is positive
                 */                
                do
                {
                    /**
                    * error message 
                    */                    
                    System.out.println("The input is incorrect!");
                    /**
                     * Consal output
                     */                    
                    System.out.println("Enter the value of the daily rent of the trailer:");
                    /**
                     * next() reads the console input and saved it int StringInput
                     */                    
                    stringInput= scanner.next();
                    /**
                     * set value of dalyRentPrice to 0 to competed withe the loop
                     */                    
                    dalyRentPrice=0;
                }
                /**
                 * loop argumet
                 * <br> a matches check if the string has positiv nummbers
                 * @return a boolean
                 */                
                while(stringInput.matches("\\d+")==false);
            }
        }
        /**
         * loop argument
         */
        while(dalyRentPrice==0);

        /**
         * the fourth position of the araay is given to the stringInput to work with it
         */        
        stringInput=args[3];
        /**
         * the loop checks if the valueTrailer isn't 0
         */        
        do            
        {
            try
            {
                valueUsedTrailer=Double.parseDouble(stringInput);
                valueUsedTrailer=Math.round(valueUsedTrailer*100)/100.0;
            }
            /**
             * @exception input incorrect
             */            
            catch(NumberFormatException e)
            {
               /**
                 * the loop check if the nummber is positive
                 */                    
                do                
                {
                    /**
                    * error message 
                    */
                    System.out.println("The input is incorrect!");
                    /**
                     * Consal output
                     */                      
                    System.out.println("Enter the value of the used trailer:");
                    /**
                     * next() reads the console input and saved it int StringInput
                     */                    
                    stringInput= scanner.next();
                    /**
                     * set value of valueUsedTrailer to 0 to competed withe the loop
                     */                    
                    valueUsedTrailer=0;
                }
                /**
                 * loop argumet
                 * <br> a matches check if the string has positiv nummbers
                 * @return a boolean
                 */                
                while(stringInput.matches("\\d+")==false);
            }
        }
        /**
         * loop argument
         */
        while(valueUsedTrailer==0);
        
        /**
         * calculates with the methods computeFinalAmount the finalAmount
         */
        finalAmount=computeFinalAmount(valueTrailer, contractPeriod, dalyRentPrice);
        /**
         * calculates with the methods computeInterestRate the interestRate
         */
        interestRate=computeInterestRate(finalAmount, valueTrailer, contractPeriod);        
       
        /**
         * Output of the programm int the console
         */
        System.out.println("_______________________________");
        System.out.println("The entered values are:");
        System.out.println("Price of the trailer: "+valueTrailer+"€");
        System.out.println("Contracted time: "+contractPeriod);
        System.out.println("Price of daly rent: "+dalyRentPrice+"€");
        System.out.println("Value of udes trailer: "+ valueUsedTrailer+"€");
        System.out.println("_______________________________");
        System.out.println("The final amount is: "+finalAmount+"€");
        System.out.println("The intrestrate is: "+interestRate);
    }
    
    /**
    * the methoed computeFinalAmount
    * <br> it calculateds the cost of the contract
    * @param pvalueUsedTrailer value of the used trailer 
    * @param pcontractPeriod the contract period
    * @param pdalyRentPrice the daly rent price of the trailer
    * @return finalAmount the coast
    */
    public static double computeFinalAmount (int pvalueUsedTrailer, int pcontractPeriod, double pdalyRentPrice)               
    {
        /**
        * the local variable finalAmount is implemeted with the datatyp double
        * <br> it's the coast of the contract and it's saved it in €
        */
        double finalAmount;
        /**
        * the final amount is calculated with the a simple funktion
        */
        finalAmount = pvalueUsedTrailer + (pcontractPeriod * 12 * 30 * pdalyRentPrice);
        /*
        * it's rounded to the second position after the comma
        */
        finalAmount=Math.round(finalAmount*100)/100.0;
        /**
        * it returns the finalAmount
        */
        return finalAmount;
    }
    
    /**
    * the methoed computeInterestRate
    * <br> it calculates the intrestrate
    * @param pfinalAmount the coast of the contract
    * @param pvalueTrailer the vale of the trailer
    * @param pcontractPeriod the contract period
    * @return interestRate the intrest rate of the contract
    */
    public static double computeInterestRate(double pfinalAmount, int pvalueTrailer, int pcontractPeriod)
    {
        /**
        * the local variable interestRate is implemeted with the datatyp double
        * <br> it's the intrest rate of the contract and it's saved it
        */
        double interestRate;
        /**
        * the intrestRate is calculated whit the funktion
        */
        interestRate = Math.pow((pfinalAmount / pvalueTrailer), (1.0 / pcontractPeriod) - 1);
        /**
        * it return the intrestRate
        */
        return interestRate;       
    }
}