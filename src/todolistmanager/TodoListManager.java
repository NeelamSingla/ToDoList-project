/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *  @author Neelam
 */
public class TodoListManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
            
            
      
      Scanner sc=new Scanner(System.in);
      inputTaskDetails input= new inputTaskDetails();
      int userChoice = 0;
      while(userChoice != 4)
      {
          System.out.println("Welcome to ToDoList.Please choose some option");
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Display all Sort Task by date and project");
            System.out.println("4. Save and Quit");
            userChoice=sc.nextInt();
      switch(userChoice)
          {
          case 1:
                     input.enterTaskDetails();
                      break;
          case 2:     input.editTaskDetails();
                      break;
          case 3:     input.displayAll();
                      break;
          case 4:     input.saveToFile();
                System.out.println("Thanks for using TodoList");
      }
      }

     // Task A = new Task("Buy grocery" ,new SimpleDateFormat("dd/MM/yyyy").parse("15/12/2018"),false,Project.GROCERY); //(String name, Date dueDate, boolean status, Project proj)
     // Task B = new Task("Send MOM" ,new SimpleDateFormat("dd/MM/yyyy").parse("15/03/2018"),false,Project.OFFICE);

      //todo.add(A);
      //todo.add(B);
     // todo.delete(A);
     // todo.save();
     // todo.displayTaskList();
    
     
        //catch(IOException ex){
//
  //              ex.printStackTrace();
    //        }

  }
    

            
    }
    

