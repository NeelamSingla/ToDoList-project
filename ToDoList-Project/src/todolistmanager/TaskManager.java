package todolistmanager;


import java.util.*;
import java.io.*;
import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Task Manager class like Model to perform all
 * task related stuff
 * @author Neelam
 */
public class TaskManager
{
  List<Task> tasklist;
  File file;
  
  
        /**
         * Constructor to initialize task list and 
         * and also file name from where to restore saved tasks
         */      
        public TaskManager()
        {
            tasklist= new ArrayList<>();
            file =new File("TaskList.ser");
        }

        /**
         * Initialize task list from file
         * saved last time
         */
        final void initializeListFromFile()
        {

            try
            {
              ObjectInputStream oi = new ObjectInputStream(new FileInputStream(file));
              Task readTask;
              while((readTask = (Task) oi.readObject()) != null)
              {
                    // Read objects
                    tasklist.add(readTask);
                }
               oi.close();
               Collections.sort(tasklist,Task.taskdueDateComparator);

            } 
            catch (FileNotFoundException e) 
            {
                    System.out.println("File not found");
            } 
            catch (EOFException e) {
            } 
            catch (IOException e) 
            {
                    System.out.println("Error initializing stream");
            } 
            catch (ClassNotFoundException e) 
            {
            }

        }
        /**
         * Create new task with given details
         * @param taskTitle
         * @param taskCategory
         * @param taskStatus
         * @param dueDate
         * @return 
         */
        public Task createTask(String taskTitle,String taskCategory,boolean taskStatus,Date dueDate)
        {
            Task task = new Task(taskTitle ,taskCategory,taskStatus,dueDate); //(String name, Date dueDate, boolean status, Project proj)
             return task;
        }

        /**
         * Add Task if it does not exist earlier
         * @param o
         * @return 
         */
        public boolean addTask(Object o)
        {
           Task newTask= (Task)o; 
            if(!checkIfTaskExists(newTask))
                      {
                  tasklist.add(newTask);
                  return true;
                  }
              else
                  return false;
        }

        /**
         * Update Task
         * @param oldTask- task to be updated
         * @param updatedTask - task with new details
         */
        public void updateTask(Object oldTask, Object updatedTask)
        {
            Task task= (Task)oldTask;
            Task updated= (Task)updatedTask;
            int index=tasklist.indexOf(task);
            tasklist.set(index, updated);

        }

        /**
         * Delete Task passed as object
         * @param  o It is Task type object
         */
        public void deleteTask(Object o)
        {
            Task taskToRemove=(Task)o;
            tasklist.remove(taskToRemove);
        }

        /**
         * Display all tasks present in ToDo List
         */
        void displayAll()
        {
           for(int i=1;i<=tasklist.size();i++)
           {
               System.out.println(i + ". " + tasklist.get(i-1).toString());
           }
        }

        /**
         * Sort all tasks by Project
         */
        void sortByProject()
        {
                  Collections.sort(tasklist, Task.taskProjectComparator);
                  displayAll();
        }

        /**
         * Sort all tasks by Date
         */
        void sortByDate()
        {
                   Collections.sort(tasklist, Task.taskdueDateComparator);
                   displayAll();
        }

        /**
         * Check If Task with same Title and same category is 
         * already present in the list
         * @param newTask
         * @return 
         */
        boolean checkIfTaskExists(Task newTask)
        {
           boolean isTaskExists= false;
            for(Task t:tasklist)
           {
               isTaskExists =  t.equals(newTask);
           }
            return isTaskExists;

        }
        
        /**
         * Select task from task list which has same  Task title and Task Category
         * as provided in parameters
         * @param taskTitle
         * @param taskCategory
         * @return Task if it is present
         */
         Task selectGivenTask(String taskTitle, String taskCategory)
        {
            try{
            Task selectedTask =(tasklist.stream()
                                .filter(t-> t.getTaskTitle().toLowerCase().equals(taskTitle.toLowerCase())
                                        && 
                                        t.getTaskProject().toLowerCase().equals(taskCategory.toLowerCase())
                                        )
                                .findFirst()
                                .get());
           
            return selectedTask;
            }
            catch(NoSuchElementException ex)
            {
                System.out.println("No Such Task Exist in To Do List");
            }
            return null;
        }
        
         /**
          * Select task from task list which has same  Task title and Task Category
          * as provided in parameters
          * @param taskIndex
          * @return 
          */
        Task selectGivenTask(int taskIndex)
        {
            try{
                if(taskIndex < tasklist.size()-1)
                    {
                     Task selectedTask =tasklist.get(taskIndex-1);
                     return selectedTask;
                      }  
               else{
                     System.out.println("No Such Task Exist in To Do List");
                    }
                    
                    
            }
            catch(NoSuchElementException ex)
            {
                System.out.println("No Such Task Exist in To Do List");
            }
            return null;
        }

        /**
         * Mark Task status as Done
         * @param o its Task passed as Object
         */
        void markAsDone(Object o)
        {
            Task markTaskDone= (Task)o;
           if((markTaskDone) != null)
                 markTaskDone.setTaskStatusDone();
        }
   
        /**
         * Save all tasks in file in serialized format
         */
        void saveToFile()
        {
           try{
                 FileOutputStream f = new FileOutputStream(file);
                 ObjectOutputStream o = new ObjectOutputStream(f);

                    for(Task t:tasklist)
                   {
                      o.writeObject(t);
                   }



                   o.close();
                   f.close();
            } 
           catch (FileNotFoundException e) {
                     System.out.println("File not found");
                     } 
           catch (IOException e) {
                     System.out.println("Error initializing stream");
                     } 
        }

}
 

