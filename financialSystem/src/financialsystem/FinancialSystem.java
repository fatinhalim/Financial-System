/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//daniela ivy ganis wea150030
//nur fatin bt abdul halim wea150043

package financialsystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author noorazlinazainuddin
 */
public class FinancialSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         
        boolean quit = false;
        System.out.println("         ╰☆╮ ╰☆╮ ╰☆╮ ╰☆╮ ╰☆╮ ╰☆╮ ╰☆╮ ╰☆╮   ");
        System.out.println("                   !!Welcome!!             ");
        System.out.println("         ╰☆╮ ╰☆╮ ╰☆╮ ╰☆╮ ╰☆╮ ╰☆╮ ╰☆╮ ╰☆╮   ");
        System.out.println("");
        //Scanner input = new Scanner(System.in);
        
        LogInUI();
        Scanner  input= new Scanner(System.in);
        
        System.out.print("Please enter your username: ");
        String user = input.nextLine();
        
        System.out.print("Please enter your password: ");
        String pass = input.nextLine();
        System.out.println("");
        
        
        try{
            Scanner in = new Scanner(new FileInputStream("login.txt"));
            
            String username = in.nextLine();//read from file
            String password = in.nextLine();//read from file
           
            if(user.equals(username) && pass.equals(password)){
                System.out.println("          ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡  ♡         ");
                System.out.println("          ♡◕ ‿ - !!Access granted!! ◕ ‿ -♡         ");
                System.out.println("          ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡ ♡  ♡         ");
                System.out.println(" ");
            
        
        while (!quit){
            System.out.println("Please select module for the next action:");
            System.out.println("     ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦     ");
            System.out.println("     ☞ ➊ Income ☞ ➋ Expense ☞ ➌ Asset ☞ ➍ Report ☞ ➎ Exit       ");
            System.out.println("     ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦     ");
            int choice = input.nextInt();
            
            switch(choice){
                case 1:
                    incomeUI();
                    break;
                case 2:
                    expenseUI();
                    break;
                case 3:
                    assetUI();
                    break;
                case 4:
                    reportUI();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong input! Please try again.");   
            }
        } 
    }
            else{
                System.out.println("");
                System.out.println("        ✖ Username or password entered wrong, access denied ✖         ");
                System.out.println("");
            }
            
            input.close();
        }
         catch(IOException e){
            System.out.println("problem with file" + e);
        }
    }

    public static void LogInUI(){
        
        try{
            PrintWriter output = new PrintWriter(new FileOutputStream("login.txt"));
            
            String username = "fatin";
            String password = "meowmeow";
            
            output.println(username);
            output.println(password);
            
            output.close();
        }
        
        catch(IOException e){
            System.out.println("problem with file");
        }
    }
    
    public static void assetUI(){
        Scanner input = new Scanner(System.in);
        
        boolean back = false;
        while(!back){
            System.out.println("       ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦       ");
            System.out.println("       ➊ Add ➋ Update ➌ Delete ➍ View All ➎ Back        ");
            System.out.println("       ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦       ");
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter category: ");
                    String cat = input.next();
                    System.out.print("Enter amount: ");
                    double amount = input.nextDouble();
                    Asset a = new Asset(cat, amount);
                    break;
                case 2:
                    Asset.displayAll();
                    System.out.print("Type number of the line you wish to edit: ");
                    int num = input.nextInt();
                    System.out.print("Income type: ");
                    cat = input.next();
                    System.out.print("Amount: ");
                    amount = input.nextDouble();
                    Asset.edit(num, cat, amount);
                    break;
                case 3:
                    Asset.displayAll();
                    System.out.println("");
                    System.out.print("Type number of the line you wish to delete: ");
                    num = input.nextInt();
                    Asset.delete(num);
                    break;
                case 4:
                    Asset.displayAll();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Please select appropriate action.");
            }
        }
    }

    public static void reportUI(){
        Scanner input = new Scanner(System.in);
        
        boolean back = false;
        while(!back){
            System.out.println("      ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦       ");
            System.out.println("      ➊ Balance ➋ Average ➌ Total income ➍ Total expense ➎ Back      ");
            System.out.println("      ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦       ");
            int choice = input.nextInt();
            System.out.println("");
            switch(choice){
                case 1:
                    
                    Report r = new Report();
                    
                    Report.getBalance();
                    break;
                case 2:
                    
                    Report.getBalance();
                    System.out.println("");
                    Report.getBalanceWeek();
                    System.out.println("");
                    Report.getBalanceDay();
                    break;
                    
                case 3:
                    //System.out.println("total income per month: ");
                    Report.getIncomeSum();
                    
                    break;
                case 4:
                    //System.out.println("total expenses per month: ");
                    Report.getExpensesSum();
                    
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Please select appropriate action.");
            }
        }
    }

    public static void incomeUI(){
        Scanner input = new Scanner(System.in);
        
        boolean back = false;
        while(!back){
            System.out.println("      ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦       ");
            System.out.println("      ➊ Add ➋ Update ➌ Delete ➍ View All ➎ Back        ");
            System.out.println("      ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦        ");
            int choice = input.nextInt(); 
            switch(choice){
                case 1:
                    System.out.print("Enter category: ");
                    String cat = input.next();
                    System.out.print("Enter amount: ");
                    double amount = input.nextDouble();
                    Income i = new Income(cat, amount);
                    break;
                case 2:
                    Income.display();
                    System.out.print("Type number of the line you wish to edit: ");
                    int num = input.nextInt();
                    System.out.print("Income type: ");
                    cat = input.next();
                    System.out.print("Amount: ");
                    amount = input.nextDouble();
                    Income.edit(num, cat, amount);
                    break;
                case 3:
                    Income.display();
                    System.out.print("Type number of the line you wish to delete: ");
                    num = input.nextInt();
                    Income.remove(num);
                    break;
                case 4:
                    Income.display();
                    break;
                case 5:
                    
                    back = true;
                    
                    break;
                default:
                    System.out.println("Please select appropriate action.");
            }
        }
    }

    public static void expenseUI(){
        Scanner input = new Scanner(System.in);
        boolean back = false;
        
        while(!back){
            System.out.println("      ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦       ");
            System.out.println("      ➊ Add ➋ Update ➌ Delete ➍ View All ➎ Back        ");
            System.out.println("      ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦ ✦        ");
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter category: ");
                    String cat = input.next();
                    System.out.print("Enter amount: ");
                    double amount = input.nextDouble();
                    Expense e = new Expense(cat, amount);
                    break;
                case 2:
                    Expense.displayAll();
                    System.out.print("Type number of the line you wish to edit: ");
                    int num = input.nextInt();
                    System.out.print("Expense type: ");
                    cat = input.next();
                    System.out.print("Amount: ");
                    amount = input.nextDouble();
                    Expense.edit(num, cat, amount);
                    break;
                case 3:
                    Expense.displayAll();
                    System.out.print("Type number of the line you wish to delete: ");
                    num = input.nextInt();
                    Expense.delete(num);
                    break;
                case 4:
                    Expense.displayAll();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("^︵^ Please select appropriate action ^︵^");
            }
        }
    }
           

}


