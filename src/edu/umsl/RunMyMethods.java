/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.util.Scanner;

/**
 *
 * @author Omar
 */
public class RunMyMethods
{
    public static void main(String[] args)
    {
        RunMyMethods rmm = new RunMyMethods();
        rmm.menu();
    }
    
    void menu()
    {
        Methods mm = new Methods();
        Scanner sc = new Scanner(System.in);
        int input;
        
        do
        {
            System.out.println("1. Product No Negatives");
            System.out.println("2. Find Twelve");
            System.out.println("3. Min Max Avg");
            System.out.println("4. Letter Grade");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Which would you like to choose? ");
            
            input = sc.nextInt();
            
            System.out.println();
            
            if(input == 1)
            {
                mm.product();
            }
            else if(input == 2)
            {
                mm.findTwelve();
            }
            else if(input == 3)
            {
                mm.minMaxAvg();
            }
            else if(input == 4)
            {
                mm.letterGrades();
            }
            else if((input < 1) || (input > 5))
            {
                System.out.println("Invalid input");
                System.out.println();
            }
        } while(input != 5);
        
        System.out.println("Goodbye!");
    }
}