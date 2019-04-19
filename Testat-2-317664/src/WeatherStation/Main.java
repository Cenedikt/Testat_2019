/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WeatherStation;

import java.util.Scanner;

/**
 *
 * @author BenedictGoldhorn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        /**
         * station
         * <br> the object WeatherStation is created and saved station
         */
        WeatherStation station = new WeatherStation();

        /**
         * scanner
         * <br> the object Scanner is created and saved in scanner
         */        
        Scanner scanner = new Scanner(System.in);
        
        /**
         * counter
         * <br> saves the amount of repetiton of the loop for the output
         */
        int counter;
        /**
         * input
         * <br> is a ram for the scanner input 
         */
        String input;

        /**
         * checks if there is an given argument else make an input
         */
        if(args.length == 1)
        {
            input = args[0];
            do
            {
                try
                {
                    counter=Integer.parseInt(input);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Please enter an natruale nummber:");
                    input = scanner.next();
                    counter = 0;
                }
            }
            while(counter == 0);      
        }
        else
        {
            input = "";
            try
            {
                System.out.println("No arguments given!");
                System.out.println("Please enter an natruale nummber:");
                input = scanner.next();
                counter = Integer.parseInt(input);
            }
            catch(NumberFormatException e)
            {
                System.out.println("Please enter an natruale nummber:");
                input = scanner.next();
                counter = 0;
            }
            while(counter == 0);  
        }
        station.output(counter);
    }
 }
    
