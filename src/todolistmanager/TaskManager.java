/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


public class TaskManager
{
  List<Task> tasklist;
  File file;
  
  
    public TaskManager()
    {
        tasklist= new ArrayList<Task>();
        file =new File("TaskList.ser");
    }
  
    public Task createTask(String taskTitle,String taskCategory,boolean taskStatus,Date dueDate)
    {
        Task task = new Task(taskTitle ,taskCategory,taskStatus,dueDate); //(String name, Date dueDate, boolean status, Project proj)
         return task;
    }

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
    
    public void updateTask(Object oldTask, Object updatedTask)
    {
        Task task= (Task)oldTask;
        Task updated= (Task)updatedTask;
        int index=tasklist.indexOf(task);
        tasklist.set(index, updated);
        
    }


    public void deleteTask(Object o)
    {
        Task taskToRemove=(Task)o;
        tasklist.remove(taskToRemove);
    }

 
    void displayAll()
    {
       for(int i=1;i<=tasklist.size();i++)
       {
           System.out.println(i + ". " + tasklist.get(i-1).toString());
       }
    }
    
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
  
  
   
    void sortByProject()
    {
              Collections.sort(tasklist, Task.taskProjectComparator);
              displayAll();
    }
   
   
    void sortByDate()
    {
               Collections.sort(tasklist, Task.taskdueDateComparator);
               displayAll();
    }
           
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
			e.printStackTrace();
	}

    }
  
  
    boolean checkIfTaskExists(Task newTask)
    {
       boolean isTaskExists= false;
        for(Task t:tasklist)
       {
           isTaskExists =  t.equals(newTask);
       }
        return isTaskExists;

    }
    
     Task selectGivenTask(String taskTitle, String taskCategory)
    {
        Task selectedTask =(tasklist.stream().filter(t-> t.getTaskTitle().toLowerCase().equals(taskTitle.toLowerCase())
                                    && t.getTaskProject().toLowerCase().equals(taskCategory.toLowerCase())
                                    )
                                   .findFirst()
                                   .get());
        return selectedTask;
    }
    
    void markAsDone(Object o)
    {
        Task markTaskDone= (Task)o;
       if((markTaskDone) != null)
             markTaskDone.setTaskStatusDone();
    }
   
    
}
 

