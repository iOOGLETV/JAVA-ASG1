/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;


import java.io.*;
import java.util.*;

/**
 *
 * @author omsf7f
 */
public class ATM 
{
    Scanner sc = new Scanner(System.in);
    Accounts[] acctArry = new Accounts[3];           
    Accounts mo = new Accounts();
    int number;
    Accounts[] name;
    
    public static void main(String[] args) throws IOException 
    {
        ATM a = new ATM();
              
        a.firstMenu();
    }
    
    public void firstMenu()throws IOException
    {
        String answer = "Y", input;
                
        System.out.println("*********************************");
        System.out.println("*   WELCOME TO BANCO De OMAR    *");
        System.out.println("*                               *");
        System.out.println("*     Come in and ask about     *");
        System.out.println("*         our 5% earned         *");
        System.out.println("*        on your all your       *");
        System.out.println("*   Checking/Saving balances!   *");
        System.out.println("*********************************");  
        System.out.println("\n\n");
        System.out.print("Are you a new customer (Y or N)?   ");
        answer = sc.next();
            
        switch (answer) 
        {
            case "y":
            case "Y":
            case "yes":
            case "Yes":
            case "YES":
 
                if(number < acctArry.length)
                {
                    acctArry[number] = new Accounts(mo.balance);
                    System.out.print("What name will be on your new account?   " );
                    input = sc.next();
                    acctArry[number].name = mo.setAcctName(input);
                    System.out.println("\n\n\n       Welcome " + acctArry[number].name + "!\n  Your Account Number is:  " + number + "\n\n How can we help you today: ");
                }
                saveAccount();
                acctArry[number].menu();;
                break;               
            case "n":
            case "N":
            case "No":
            case "NO":
            case "no":
                pickAccount();
                break;
        }      
    }
    
    public void CreateMenu()throws IOException
    {
        String answer = "N", input;
        
        System.out.println();
        System.out.print("Are you wanting to create a new customer account (Y or N)?   ");
        answer = sc.next();
            
        switch (answer) 
        {
            case "y":
            case "Y":
            case "yes":
            case "Yes":
            case "YES":
                
                if(number < acctArry.length)
                {
                    acctArry[number] = new Accounts(mo.balance);
                    System.out.print("What name will be on your new account?   " );
                    input = sc.next();
                    acctArry[number].name = mo.setAcctName(input);
                    System.out.println("\n\n\n       Welcome " + acctArry[number].name + "!\n  Your Account Number is:  " + number + "\n\n How can we help you today: ");
                }
                saveAccount();
                acctArry[number].menu();
                break;               
            case "n":
            case "N":
            case "No":
            case "NO":
            case "no":
                pickAccount();
                break;
        }      
    }
    
    public void pickAccount() throws IOException
    {
        int input;
       
        System.out.print("Enter your account number: \n\n");
        input = sc.nextInt();
        number = input;

        loadAccts();
        
        if (input >= 0 && input < 3) 
        {
            System.out.println("Hello" + acctArry[number].name + "! \n\n How can we help you: ");
            mo.menu();
        }
        else
        {
            System.out.print("Enter a valid account number: ");
            input = sc.nextInt();

            if (input >= 0 && input < 3)
                mo.menu();
        }
        System.out.println("Please try another time. \n\n");
    }
   
    
    public void saveAccount()
    {
        try
        {
            FileOutputStream outStream =  new FileOutputStream ("file1.out");
            ObjectOutputStream  oos = new ObjectOutputStream(outStream); 
            oos.writeObject(acctArry[number]);
            oos.flush();
            outStream.close();
        }        
        catch (Throwable e)
        {
            System.err.println(e);
        }                                    
    }
    
    public void loadAccts()
    {
        try
        {
            FileInputStream inStream = new FileInputStream("file1.out");
            ObjectInputStream is = new ObjectInputStream(inStream);
            acctArry = (Accounts[]) is.readObject();
            inStream.close();
        }        
        catch (Throwable e)
        {
            System.err.println(e);
        }
    }
}