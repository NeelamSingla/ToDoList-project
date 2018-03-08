/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistmanager;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author tmp-sda-1160
 */
public class inputTaskDetails {
    TaskManager todo;
    Scanner sc;
    
    inputTaskDetails()
    {
     todo = new TaskManager();
     sc=new Scanner(System.in);
    }
    
     void enterTaskDetails()
     {
        try {
            
            String taskTitle,taskCategory;
            boolean taskStatus;
            Date dueDate;
            System.out.println("Enter Task details");
            taskTitle= sc.next();
            System.out.println("Enter Task Category");
            taskCategory= sc.next();
            System.out.println("Enter Task status, Done-True/False");
            taskStatus= sc.nextBoolean();
            System.out.println("Enter Task due Date in format dd/MM/yyyy ");
            String date= sc.next();
            dueDate =new SimpleDateFormat("dd/MM/yyyy").parse(date);
            todo.createTask(taskTitle,taskCategory,taskStatus,dueDate);
            
        }
        catch (InputMismatchException e) {
        System.out.println("Invalid input!");
        }
        catch (ParseException ex) {
            System.out.println("Date Format is wrong");
            
        }
       
       
                
     }
     
     
     void displayAll()
     {
         todo.displayAll();
     }
     
     void editTaskDetails()
     {
         
     }
     
     void saveToFile()
     {
      todo.saveToFile();
     }
     
     void displayTaskDetails() 
     {
        try{
         todo.displayTaskList();
        }
        catch(IOException ex)
        {
            System.out.println("File exception");
        }
     }
    
}
