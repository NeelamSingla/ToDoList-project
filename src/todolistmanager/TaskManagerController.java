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
public class TaskManagerController {
    TaskManager taskManager;
    Scanner sc;
    
    TaskManagerController()
    {
     taskManager = new TaskManager();
     sc=new Scanner(System.in);
    }
    
    Object enterTaskDetails()
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
            Object CreatedTask = taskManager.createTask(taskTitle,taskCategory,taskStatus,dueDate);
        
            return CreatedTask;
        }
        catch (InputMismatchException e) {
        System.out.println("Invalid input!");
        }
        catch (ParseException ex) {
            System.out.println("Date Format is wrong");
                  
        }
        return null;
    }
    void addTask(Object o)
    {
          boolean  isTaskCreated=taskManager.addTask(o);  
         if(!isTaskCreated)
                System.out.println("Task is already present in TODO List");
            else
                System.out.println("Task is added in TODO List");
    }      
     
    void displayAll()
    {
         taskManager.displayAll();
    }
     
    void editTaskDetails()
    {
        int userChoice = 0;
        String taskTitle,taskCategory;
        Object taskToUpdate;
            System.out.println("Enter Task title to be updated");
            taskTitle= sc.next();
            System.out.println("Enter Task Category to be updated");
            taskCategory= sc.next();
            taskToUpdate=taskManager.selectGivenTask(taskTitle,taskCategory);
            System.out.println(taskToUpdate.toString());
    while(userChoice != 4)
    {
          System.out.println("Welcome to ToDoList.Please choose some option");
            System.out.println("1. Edit Task");
            System.out.println("2. Mark Task as Done");
            System.out.println("3. Remove Task");
            System.out.println("4. Go back to ToDo List main menu");
            
            userChoice=sc.nextInt();
        switch(userChoice)
        {
        
        case 1:
                Object updatedDetails = enterTaskDetails();
                taskManager.updateTask(taskToUpdate,updatedDetails);
                      break;
        case 2: 
                taskManager.markAsDone(taskToUpdate);
                      break;
          case 3:   
                
                taskManager.deleteTask(taskToUpdate);
                      break;
          case 4:     break;
        }
    }
    }
     
    
    
    void saveToFile()
    {
      taskManager.saveToFile();
    }
     
    void sortByDate()
    {
           taskManager.sortByDate();
    }
    
    
    void sortByProject()
    {
            taskManager.sortByProject();
    }
    
    
    void InitilizeSavedTaskList()
    {
            taskManager.initializeListFromFile();
            displayAll();
            
    } 
    
}
