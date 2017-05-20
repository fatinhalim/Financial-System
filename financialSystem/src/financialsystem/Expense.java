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
public class Expense {
    private String category;
    private double amount;
    
    public Expense(String category, double amount){
        this.category = category;
        this.amount = amount;
        
        try {
            PrintWriter write = new PrintWriter(new FileOutputStream("expense.txt", true));
            
            write.printf("%s,%.2f\n", this.category, this.amount);
            write.close();
        }
        
        catch (IOException e){
            System.out.println("problem with output.");
        }
    }


public static void delete(int lineNumber){
        ArrayList<String[]> array = fileToArray("expense.txt");
        array.remove(lineNumber - 1 );
        
        try{
            PrintWriter write = new PrintWriter(new FileOutputStream("expense.txt"));
            for (int  i = 0; i < array.size(); i++){
                 for (int j = 0; j < array.get(i).length; j++){
                     if (j != 1)
                     write.print(array.get(i)[j] + ",");
                     else
                         write.print(array.get(i)[j]);
                 }
                 write.println();
             }
            System.out.println("Delete successful!");
             write.close();
        }
        catch (IOException e){
            System.out.println("Problem with output.");
        }
    }

public static void edit(int lineNumber, String category, double amount){             
         ArrayList<String[]> array = fileToArray("expense.txt");
         array.get(lineNumber - 1)[0] = category;
         array.get(lineNumber - 1)[1] = String.valueOf(amount) + "0";
         try {
             PrintWriter write = new PrintWriter(new FileOutputStream("expense.txt"));
             for (int  i = 0; i < array.size(); i++){
                 for (int j = 0; j < array.get(i).length; j++){
                     if (j != 1)
                     write.print(array.get(i)[j] + ",");
                     else
                         write.print(array.get(i)[j]);
                 }
                 write.println();
             }
             write.close();
         }
         catch (IOException e){
             System.out.println("Problem with output!");
         }
         
         System.out.println("Edit successful.");
     }

public static void displayAll(){
         ArrayList<String[]> array = fileToArray("expense.txt");
         
             for (int  i = 0; i < array.size(); i++){
                 System.out.printf("#%d ", i+1);
                 for (int j = 0; j < array.get(i).length; j++){
                     System.out.printf("%-20s", array.get(i)[j]);
                 }
                 System.out.println();
             }
     }
     public static ArrayList<String[]> fileToArray(String fileName){
         ArrayList<String[]> array = new ArrayList<>();
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
         return array;
     }
    
}
