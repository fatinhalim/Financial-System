/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financialsystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author noorazlinazainuddin
 */
public class Report {
     private double daily, weekly, monthly;
    private static double balance;
    
    
    
    public Report(){
        
    }
    
    
    public Report(String fileName){  
        
        this.daily = this.balance/30;
        this.weekly = this.balance/4;
        this.monthly = this.balance;
        
        System.out.printf("Daily average: %.2f\n",this.daily);
        System.out.printf("Weekly average: %.2f\n", this.weekly);
        System.out.printf("Monthly average: %.2f\n", this.monthly);
        
        try{
            PrintWriter output = new PrintWriter(new FileOutputStream("report.txt"));
            output.printf("%-10.2f,%-10.2f,%-10.2f",/*%-10.2f,*/this.daily, this.weekly, this.monthly /*this.balance*/);
            
            
            output.close();
        }
        catch(IOException e){
            System.out.println("");
        }
    }


 public static ArrayList<String[]> fileToArray(String fileName){
         ArrayList<String[]> array = new ArrayList<>();
         try {
             
             Scanner read = new Scanner(new FileInputStream(fileName));
             while(read.hasNextLine()){
                 String line = read.nextLine();
                 array.add(line.split(","));
             }
             read.close();
         }
         catch (FileNotFoundException e){
             System.out.println("File not found!");
         }
         return array;
     }

public static double getIncomeSum(){
         ArrayList<String[]> array = fileToArray("income.txt");
         try {
             Scanner read = new Scanner(new FileInputStream("income.txt"));
             while(read.hasNextLine()){
                 String line = read.nextLine();
                 array.add(line.split(","));
             }
             read.close();
         }
         catch (FileNotFoundException e){
             System.out.println("File not found!");
         }
         double sum = 0;
         for (int i = 0; i < array.size(); i++){
                 sum += Double.parseDouble(array.get(i)[1]);//summing up the amount of incomes and expenses
         }
         System.out.println("sum of the income: " +sum);
         return sum;
     }

public static double getExpensesSum(){
         ArrayList<String[]> array = fileToArray("expense.txt");
         try {
             Scanner read = new Scanner(new FileInputStream("expense.txt"));
             while(read.hasNextLine()){
                 String line = read.nextLine();
                 array.add(line.split(","));
             }
             read.close();
         }
         catch (FileNotFoundException e){
             System.out.println("File not found!");
         }
         double sum = 0;
         for (int i = 0; i < array.size(); i++){
                 sum += Double.parseDouble(array.get(i)[1]);//summing up the amount of incomes and expenses
         }
         System.out.println("some of the expenses: " +sum);
         return sum;
     }

public static void getBalance(){
    balance = getIncomeSum()-getExpensesSum();
    System.out.println("the balance per month is: " +balance);
}

public static void getBalanceWeek(){
    balance = (getIncomeSum()-getExpensesSum())/4;
    System.out.println("the balance per week is: " +balance);
}
public static void getBalanceDay(){
    balance = (getIncomeSum()-getExpensesSum())/30;
    System.out.println("the balance per day is: " +balance);
}

}