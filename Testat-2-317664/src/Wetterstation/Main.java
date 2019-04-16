/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wetterstation;

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
        int counter;
        String stringInput;
        Scanner scanner= new Scanner(System.in);
        // TODO code application logic here
        if (args.length ==1)
        {
            stringInput=args[0];
            do
            {
                try
                {
                    counter=Integer.parseInt(stringInput);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Enter a naturale value how often the weather report has to replay");
                    stringInput= scanner.nextLine();
                    counter=0;
                }
            }
            while(counter==0);
        }
        else
        {
            do
            {
                try
                {
                    System.out.println("Enter a naturale value how often the weather report has to replay");
                    stringInput= scanner.nextLine();
                    counter=Integer.parseInt(stringInput);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Enter a naturale value how often the weather report has to replay");
                    stringInput= scanner.nextLine();
                    counter=0;
                }
            }
            while(counter==0);
        }
        Wetterstation station = new Wetterstation();
        station.output(counter);
    }
    
}
