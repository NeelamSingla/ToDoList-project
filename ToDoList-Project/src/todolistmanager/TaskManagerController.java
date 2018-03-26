package todolistmanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Controller class to pass all task related operations
 * call to Task manager Model
 * @author Neelam
 */
public class TaskManagerController {
    TaskManager taskManager;
    
    
        /**
         * Constructor to initialize Task Manager Model
         */
        TaskManagerController()
        {
         taskManager = new TaskManager();
         
        }
        
        /**
         * Initialize tasks from file if any
         * and display all tasks
         */
        void InitilizeSavedTaskList()
        {
                taskManager.initializeListFromFile();
                displayAll();

        } 

        /**
         * Method to take user input for all task details
         * @return 
         */
        Object enterTaskDetails()
        {
            try {
                Scanner sc=new Scanner(System.in);
                String taskTitle,taskCategory;
                boolean taskStatus;
                Date dueDate;
                System.out.println("Enter Task details");
                taskTitle= sc.nextLine();
                System.out.println("Enter Task Category");
                taskCategory= sc.nextLine();
                System.out.println("Enter Task status, Done-True/False");
                taskStatus= sc.nextBoolean();
                System.out.println("Enter Task due Date in format yyyy-MM-dd ");
                String date= sc.next();
                dueDate =new SimpleDateFormat("yyyy-MM-dd").parse(date);
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
        
        /**
         * Add Task in list passed as Object 
         * @param o -Its a new task passed as object
         */
        void addTask(Object o)
        {
              boolean  isTaskCreated=taskManager.addTask(o);  
             if(!isTaskCreated)
                    System.out.println("Task is already present in TODO List");
                else
                    System.out.println("Task is added in TODO List");
        }      

        /**
         * Display all Tasks
         */
        void displayAll()
        {
             taskManager.displayAll();
        }
        
       
       /**
        * Asks user details of task to edit
        * either by Task no
        * or By Task Title and Task Category
        */ 
        void editTaskDetails()
        {
            int userChoice = 0,taskIndex;
            String taskIndexChoice;
            Scanner sc=new Scanner(System.in);
            String taskTitle,taskCategory;
            Object taskToUpdate;
            System.out.println("Do you want to update by Index? Enter Yes / No");
             taskIndexChoice= sc.nextLine();
            if(taskIndexChoice.toLowerCase().equals("yes"))
            {
            System.out.println("Enter Task No to be updated");
             taskIndex= sc.nextInt();
            taskToUpdate=taskManager.selectGivenTask(taskIndex);
            }
            else
            {
                System.out.println("Enter Task title to be updated");
                taskTitle= sc.nextLine();
                System.out.println("Enter Task Category to be updated");
                taskCategory= sc.nextLine();
                taskToUpdate=taskManager.selectGivenTask(taskTitle,taskCategory);
            }
                if(taskToUpdate!= null)
                System.out.println(taskToUpdate.toString());
                else
                 userChoice=4;
           
        while(userChoice != 4)
        {
                System.out.println("-----------------------------------------------");
                System.out.println("Welcome to ToDoList.Please choose some option");
                System.out.println("1. Edit Task");
                System.out.println("2. Mark Task as Done");
                System.out.println("3. Remove Task");
                System.out.println("4. Go back to ToDo List main menu");
                System.out.println("-----------------------------------------------");

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

        /**
         * Sort Task by Date
         */
        void sortByDate()
        {
               taskManager.sortByDate();
        }

        /**
         * Sort Task by project
         */
        void sortByProject()
        {
                taskManager.sortByProject();
        }

        /**
         * Save Task to file
         */
        void saveToFile()
        {
          taskManager.saveToFile();
        }
    
}
