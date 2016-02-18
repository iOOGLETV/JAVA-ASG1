/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Omar
 */
public class Methods
{
    Scanner sc = new Scanner(System.in);
    
    public void product()
    {
        System.out.println("Product no Negatives INITIATED!");
        System.out.println();
        double num; 
        double product = 1;
        
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter a positive number, or 0 to calculate the product: ");
        num = sc1.nextDouble();
        if (num == 0)
        {
            product -= product;
        }
        while (num != 0)
        {
            if (num < 0)
            {  
                System.out.println("Invalid input! Please retry.");
                System.out.print("Enter a positive number, or 0 to quit: ");
                num = sc1.nextDouble();
            }
            else
            {
                product *= num;  
                System.out.print("Enter a positive number, or 0 to quit: ");
                num = sc1.nextDouble();
                
            }
        }
        System.out.println();
        System.out.println("The product is: " + product);
        System.out.println();
        System.out.println("Product no Negatives DONE!!");
        System.out.println();
        
    }
    
    public void findTwelve()
    {
        System.out.println("Find 12 INITIATED!");
        System.out.println();
        
        int first = 0, last = 0;
        int count = 1;
        boolean containsTwelve = false;
        
        System.out.print("Enter a line of numbers, separated by spaces: ");
        String line = sc.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        
        while(st.hasMoreTokens())
        {
            int input = Integer.parseInt(st.nextToken());
            if(first == 0)
            {
                if(input == 12)
                {
                    first = count;
                    last = count;
                    containsTwelve = true;
                }
            }
            else
            {
                if(input == 12)
                {
                    last = count;
                }
            }
            count++;
        }
        
        System.out.println();
        
        if(containsTwelve)
        {
            System.out.println("First occurrence of 12: " + first);
            System.out.println("Last occurrence of 12: " + last);
        }
        else
        {
            System.out.println("Index: " + 0);
        }
        
        System.out.println();
        System.out.println("Find 12 DONE!!");
        System.out.println();
    }
    
    public void minMaxAvg()
    {
        String line;      
        int input, sum, count, min, max;
        float avg;
        sum = count = min = max = 0;
        
        System.out.println("Min Max Average INITIATED!");
        System.out.println();
        
        System.out.print("Enter a line of numbers, separated by spaces: ");
        line = sc.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        
        while(st.hasMoreTokens())
        {
            input = Integer.parseInt(st.nextToken());
            sum += input;
            
            if(count == 0)
            {
                min = max = input;
            }
            else
            {
                if(input > max)
                {
                    max = input;
                }
                
                if(input < min)
                {
                    min = input;
                }
            }
            
            count++;
        }
        
        if(count > 0)
        {        
            avg = (float)sum / count;

            System.out.println();
            System.out.println("Minimum: " + min);
            System.out.println("Maximum: " + max);
            System.out.println("Average: " + avg);
            System.out.println();
            System.out.println("Min Max Average DONE!");
            System.out.println();
        }
        else
        {
            System.out.println();
            System.out.println("Min Max Average DONE!");
            System.out.println();
        }
    }    
    
    public void letterGrades()
    {
        System.out.println("Letter Grades INITIATED!");
        System.out.println();
        
        int input, count, countA, countB, countC, countD, countF;
        
        count = 0;
        countA = 0;
        countB = 0;
        countC = 0;
        countD = 0;
        countF = 0;
        
//        StringTokenizer st = new StringTokenizer("63 75 72 72 78 67 80 63 0 90 89 43 59 99 82 12 100 75");
        System.out.println("Please enter the scores you are trying to find grades for seperated by a space");
        System.out.println ("(PRESS ENTER WHEN READY TO CALCULATE): ");          //
        Scanner sc = new Scanner(System.in);                      // For entering your own grades
        String line = sc.nextLine();                              //  
        StringTokenizer st = new StringTokenizer(line);           //
        System.out.println();
        System.out.println("Grades: ");
        while(st.hasMoreTokens())
        {
            
            input = Integer.parseInt(st.nextToken());
            count++;
            if(input >= 90 && input <= 100)
            {
                countA++;
                System.out.println(input + " -> " + "A");
            }
            if(input >= 70 && input <= 89)
            {
                countB++;
                System.out.println(input + " -> " + "B");
            }
            if(input >= 50 && input <= 69)
            {
                countC++;
                System.out.println(input + " -> " + "C");
            }
            if(input >= 35 && input <= 49)
            {
                countD++;
                System.out.println(input + " -> " + "D");
            }
            if(input >= 0 && input <= 34)
            {
                countF++;
                System.out.println(input + " -> " + "F");
            }
        }
        System.out.println();
        System.out.println("Total " + count + " grades");
        System.out.println("There are " + countA + " A's");
        System.out.println("There are " + countB + " B's");
        System.out.println("There are " + countC + " C's");
        System.out.println("There are " + countD + " D's");
        System.out.println("There are " + countF + " F's");
        System.out.println();
        System.out.println("Letter Grades DONE!!");
        System.out.println();
    }
    
    
}
