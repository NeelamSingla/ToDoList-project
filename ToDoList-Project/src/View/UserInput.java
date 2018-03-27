package View;

import Controller.TaskManagerController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class to interact with user input like View
 *
 */
public class UserInput {

    TaskManagerController taskManagerController;

    /**
     * Constructor to initialize Task Manager Controller
     *
     * @param taskManagerController
     */
    public UserInput(TaskManagerController taskManagerController) {
        this.taskManagerController = taskManagerController;

    }

    /**
     * Method to take user input for all task details
     *
     * @return Task as Object
     */
    public Object enterTaskDetails() {
        try {
            Scanner sc = new Scanner(System.in);
            String taskTitle, taskCategory;
            boolean taskStatus;
            Date dueDate;
            System.out.println("Enter Task details");
            taskTitle = sc.nextLine();
            System.out.println("Enter Task Category");
            taskCategory = sc.nextLine();
            System.out.println("Enter Task status, Done-True/False");
            taskStatus = sc.nextBoolean();
            System.out.println("Enter Task due Date in format yyyy-MM-dd ");
            String date = sc.next();
            dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            Object CreatedTask = taskManagerController.createTask(taskTitle, taskCategory, taskStatus, dueDate);

            return CreatedTask;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        } catch (ParseException ex) {
            System.out.println("Date Format is wrong");

        }
        return null;
    }

    /**
     * Asks user details of task to edit either by Task no or By Task Title and
     * Task Category
     */
    public void editTaskDetails() {
        int userChoice = 0, taskIndex;
        String taskIndexChoice;
        Scanner sc = new Scanner(System.in);
        String taskTitle, taskCategory;
        Object taskToUpdate;
        System.out.println("Do you want to update by Index? Enter Yes / No");
        taskIndexChoice = sc.nextLine();
        if (taskIndexChoice.toLowerCase().equals("yes")) {
            System.out.println("Enter Task No to be updated");
            taskIndex = sc.nextInt();
            taskToUpdate = taskManagerController.selectGivenTask(taskIndex);
        } else {
            System.out.println("Enter Task title to be updated");
            taskTitle = sc.nextLine();
            System.out.println("Enter Task Category to be updated");
            taskCategory = sc.nextLine();
            taskToUpdate = taskManagerController.selectGivenTask(taskTitle, taskCategory);
        }
        if (taskToUpdate != null) {
            System.out.println(taskToUpdate.toString());
        } else {
            userChoice = 4;
        }

        while (userChoice != 4) {
            System.out.println("-----------------------------------------------");
            System.out.println("Welcome to To Do List.Please choose some option");
            System.out.println("1. Edit Task");
            System.out.println("2. Mark Task as Done");
            System.out.println("3. Remove Task");
            System.out.println("4. Go back to ToDo List main menu");
            System.out.println("-----------------------------------------------");

            userChoice = sc.nextInt();
            switch (userChoice) {

                case 1:
                    Object updatedDetails = enterTaskDetails();
                    taskManagerController.updateTask(taskToUpdate, updatedDetails);
                    break;
                case 2:
                    taskManagerController.markAsDone(taskToUpdate);
                    break;
                case 3:
                    taskManagerController.deleteTask(taskToUpdate);
                    break;
                case 4:
                    break;
            }
        }
    }

}
