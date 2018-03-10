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
      TaskManagerController input= new TaskManagerController();
      input.InitilizeSavedTaskList();
      int userChoice = 0;
    while(userChoice != 6)
    {
          System.out.println("Welcome to ToDoList.Please choose some option");
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Display all Sort Task by date and project");
            System.out.println("4. Sort Task by date");
            System.out.println("5. Sort Task by project");
            System.out.println("6. Save and Quit");
            userChoice=sc.nextInt();
        switch(userChoice)
         {
          case 1:
                     Object o =input.enterTaskDetails();
                     input.addTask(o);
                      break;
          case 2:     input.editTaskDetails();
                      break;
          case 3:     input.displayAll();
                      break;
          case 4:     input.sortByDate();
                      break;
          case 5:     input.sortByProject();
                      break;
          case 6:     input.saveToFile();
                System.out.println("Thanks for using TodoList");
        }
    }
  }
    

            
}
    

