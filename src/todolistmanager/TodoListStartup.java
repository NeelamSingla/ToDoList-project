/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package todolistmanager;

import java.util.Scanner;

/**
 *
 *  @author Neelam
 */
public class TodoListStartup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
      Scanner sc=new Scanner(System.in);
      TaskManagerController taskManagerController= new TaskManagerController();
      taskManagerController.InitilizeSavedTaskList();
      int userChoice = 0;
    while(userChoice != 6)
    {
            System.out.println("-----------------------------------------------");  
            System.out.println("Welcome to ToDoList.Please choose some option");
            System.out.println("-----------------------------------------------");  
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Display all task");
            System.out.println("4. Disply Task sorted by date ");
            System.out.println("5. Disply Task sorted by project");
            System.out.println("6. Save and Quit");
            System.out.println("-----------------------------------------------");  
            userChoice=sc.nextInt();
        switch(userChoice)
         {
          case 1:
                     Object o =taskManagerController.enterTaskDetails();
                     taskManagerController.addTask(o);
                      break;
          case 2:     taskManagerController.editTaskDetails();
                      break;
          case 3:     taskManagerController.displayAll();
                      break;
          case 4:     taskManagerController.sortByDate();
                      break;
          case 5:     taskManagerController.sortByProject();
                      break;
          case 6:     taskManagerController.saveToFile();
                System.out.println("Thanks for using TodoList");
        }
    }
  }
    

            
}
    

