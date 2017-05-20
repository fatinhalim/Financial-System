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
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author noorazlinazainuddin
 */
public class Income {
    
    //Scanner input = new Scanner(System.in);
    private String category;
    private double amount;
    
    Income() {
         //To change body of generated methods, choose Tools | Templates.
    }
 
   public Income(String category, double amount){
        
        this.category = category;
        this.amount = amount;
        
        try{
            PrintWriter output = new PrintWriter(new FileOutputStream("income.txt", true));
            
            output.printf("%s,%.2f\n", this.category, this.amount);
            output.close();
            
        }
        
        catch(IOException e){
            
        }
    }
   
   public static void edit(int lineNo, String category, double amount){
       ArrayList<String[]> array = fileToArray("income.txt");
       
       array.get(lineNo-1)[0] = category;
       array.get(lineNo-1)[1] = String.valueOf(amount) + "0";
       
       try{
       PrintWriter output = new PrintWriter(new FileOutputStream("income.txt"));
       for(int i = 0; i< array.size(); i++){
           for(int j = 0; j<array.get(i).length; j++){
               if( j != 1)
               output.print(array.get(i)[j] + ",");
               else
               output.print(array.get(i)[j]);
           }
           output.println();
       }
       output.close();
     
       }
       catch(FileNotFoundException e){
           System.out.println(e);
       }
       
       System.out.println("edit is successful");
       
   }

    public static void display(){
        ArrayList<String[]> array = fileToArray ("income.txt");
       
            for(int i = 0; i<array.size(); i++){
                System.out.printf("#%d ", i+1);
                for(int j = 0; j<array.get(i).length; j++){
                    System.out.printf("%-20s",array.get(i)[j]);
                }
                System.out.println();
            }
    }
       
    //remove
    public static void remove(int lineNo){
        ArrayList<String[]> array = fileToArray ("income.txt");
        array.remove(lineNo-1);
        
        try{
       PrintWriter output = new PrintWriter(new FileOutputStream("income.txt"));
       
        for(int i = 0; i<array.size(); i++){
            for(int j = 0; j<array.get(i).length; j++){
            if(j != 1)
                output.print(array.get(i)[j] + ",");
            else
                output.print(array.get(i)[j]);

            }
        }
            output.close();
        }
        
        catch(IOException e){
             
          System.out.println("problem with file");
       }
 }
    
    public static ArrayList<String[]> fileToArray(String filename){
        
        ArrayList<String[]> array = new ArrayList<>();
        try{
            Scanner input = new Scanner(new FileInputStream(filename));
            while(input.hasNextLine()){
                String line = input.nextLine();
                array.add(line.split(","));
            }
            input.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
        return array;
    }
}


    
    
     
   
    

