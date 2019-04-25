/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayParadise;

import java.util.Scanner;

/**
 *
 * @author Benedict
 */
public class Gui 
{
    private Scanner scanner = new Scanner(System.in);
    private String input;
    
    public void mainMenu()
    {
        System.out.println("HOLIDAY PARADISE");
        System.out.println("Basic Data Management 1.0 Copyright 2019 Benedict Goldhorn, MNR 317664");
        System.out.println("MAIN MENU");
        System.out.println("Pleas select:\n");
        System.out.println("Managing instructors 1");
        System.out.println("Managing customers 2");
        System.out.println("Managing courses 3");
        System.out.println("Program exit 0 \n");
        System.out.println("please enter your choice:");
        input=scanner.nextLine();
        this.menuSelection();
    }
    
    public void errorMenu()
    {
        System.out.println("This program section is currently not implemented pres Enter to return to the menu");
        input=scanner.nextLine();       
        if(input.isEmpty())
        {
            this.mainMenu();
        }
    }
    
    public void menuSelection()
    {      
        switch(input)
        {
            case "1":
                this.errorMenu();
                break;
            case "2":
                this.errorMenu();
                break;
            case "3":
                this.errorMenu();
                break;
            case "0":
                System.exit(0);
            default:
                this.mainMenu();
        }
    }
}
