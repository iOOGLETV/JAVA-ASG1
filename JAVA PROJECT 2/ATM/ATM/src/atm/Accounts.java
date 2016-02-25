/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.*;
import java.util.*;
import java.text.*;

/**
 *
 * @author omsf7f
 */


public class Accounts implements Serializable
{    
    NumberFormat depositFormatted = NumberFormat.getCurrencyInstance();    
    Date date = new Date();
    
    protected int firstdate;
    protected int seconddate;
    protected Calendar cal1 = new GregorianCalendar();
    protected Calendar cal2 = new GregorianCalendar();
    protected boolean dateflag = false;
    protected double rate;
    private Object formater;
    public double balance;
    double transaction_balance = 0.00;     
    double newAcct = 100.00;  
    String name;
    
    

    public Accounts() 
    {
    }
    
    public Accounts(double newAccountBalance)  //constructor
    {
        newAccountBalance = newAcct;
        balance = newAccountBalance;
    }    
    
    private double Accounts (double balanced)
    {
        balance = balanced;
        return balance;
    }

    public String setAcctName(String input)
    {
        name = input;
        return name;
    }
    
    public void menu() throws IOException
    {   
        Scanner sc = new Scanner(System.in);
        ATM a = new ATM();
        int input;
        
        double bal = getBalance();
        
        do
        {
            System.out.print("\n");
            System.out.println("1) Deposit");
            System.out.println("2) Withdraw");
            System.out.println("3) Check Balance");
            System.out.println("4) Create New Account");
            System.out.println("5) Exit");
            System.out.print ("\n");
            input = sc.nextInt();
            
            if(input == 1)
            {
                System.out.println("\n\n\n\n\n" + name + " your current balance before your deposit is: " + depositFormatted.format(bal) + "\n\n\n\n\n");             
                    if(dateflag == true)
                    {
                        date = getDate2();
                        deposit();  
                    }
                    else
                    {
                        date = getDate1();
                        deposit();                  
                        System.out.println(name + " your current balance after your deposit is: " + depositFormatted.format(bal));
                    }
            }
            else
            if(input == 2)
            {
                System.out.println(name + " your current balance before your withdraw is: " + depositFormatted.format(bal));
                if (dateflag == true)
                    {
                        getDate2();
                        withdraw();  
                    }
                else
                    {
                        getDate1();
                        withdraw();
                        System.out.println("Your current balance after your withdraw is: " + depositFormatted.format(bal) + "\n\n");
                    }
            }
            else
            if(input == 3)              
                    System.out.println(name + " your current balance is: " + depositFormatted.format(bal));
            else
            if (input == 4)
            {
                a.number++;
                a.CreateMenu();
            }
            else
            if(input == 5)
            {   
                a.saveAccount();
                System.out.print("\n\nThank You " + name + ", nice seeing you agian!  \n\n          Visit us at: \n     www.BancoDeOmar.com \n\n\n\n");
                System.exit(0);
            }
            else
            if(input > 5 || input < 1)
            {
                System.out.println("Please make a correct menu option: ");
                input = sc.nextInt();
            }
        }while(input < 6);  
    }

    
    
    public void deposit()throws IOException
        {
    //ask for deposit//add intrest rate to deposit//get the date for the deposit//menu
            BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            ATM a = new ATM();
            String deposit;
            double dep;
        
            System.out.print ("\n\n\n Enter desired deposit ammount: $");
            deposit = br.readLine();
            dep = Double.valueOf(deposit).doubleValue();
            
            transaction_balance =+dep;
        
            balance = balance + dep;
        
            System.out.println ("\n\n" + name + ", you have deposited " + depositFormatted.format(dep) + " on " + date + ".   Your current balance is " + depositFormatted.format(balance) + "\n\n");
        
            a.saveAccount();
        
            menu();
        }
    
    public void withdraw()throws IOException
        {
    //ask for deposit//add intrest rate to deposit//get the date for the deposit//menu
            BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            ATM a = new ATM();
            String withdraw;
            double with;
        
            System.out.print ("Enter desired withdraw ammount: $");
            withdraw = br.readLine();
            with = Double.valueOf(withdraw).doubleValue();
                        
            transaction_balance -= with;
        
            balance = balance - with;
            
            System.out.println(name + " your current balance is " + depositFormatted.format(balance));        
        
            a.saveAccount();
            
            menu();
        }

    private Date getDate1() throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String inputText;
        
        System.out.print("Enter todays date mm/dd/yyyy \n\n");
        inputText = br.readLine();
        
        SimpleDateFormat formatter = new SimpleDateFormat ("MM/dd/yyyy");
        ParsePosition pos = new ParsePosition(0);
        
        Date date = new Date();

        date = formatter.parse(inputText, pos);
    
        cal1.setTime(date);
         
        firstdate = cal1.get(cal1.DAY_OF_YEAR);
    
        dateflag = true;
    
        return date;
    }
    
    private Date getDate2() throws IOException
    {   
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String inputText;
        
        System.out.print("Enter todays date mm/dd/yyyy: \n\n");
        inputText = br.readLine();
        
        SimpleDateFormat formatter = new SimpleDateFormat ("MM/dd/yyyy");
        ParsePosition pos = new ParsePosition(0);
        
        Date date = new Date();

        date = formatter.parse(inputText, pos);
    
        cal2.setTime(date);
         
        seconddate = cal2.get(cal2.DAY_OF_YEAR);
    
        if (firstdate > seconddate)
        {
            System.out.println("Enter future date mm/dd/yyyy:  \n\n");
            getDate2();
        }
        
        return date;
    }    

    public double getBalance()
    {
        return balance;
    }
}
     

/*//////////////////////////////////////////////////////////////////////////////
//                          USE COMPUTER GENERATED DATE                       //       
////////////////////////////////////////////////////////////////////////////////
//        Date date = new Date();                                             //
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");   //
//        System.out.println("Current Date: "                                 //
//                + dateFormat.format(date.getTime()));                       //
//        System.out.println("Day of given date : " + date.getDate());        //
//                                                                            //
//        cal1.setTime(date);                                                 //
//                                                                            //
//        firstdate = cal1.get(cal1.DAY_OF_YEAR);                             //
//    }                                                                       //
////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////*/
