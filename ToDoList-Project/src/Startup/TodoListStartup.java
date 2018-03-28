package Startup;

import Controller.ResourceMessages;
import Controller.TaskManagerController;
import View.UserInput;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It is simple To Do application which allows user to add, update and Remove
 * task
 *
 * @author Neelam Singla
 */
public class TodoListStartup {

    /**
     * Main method to show menu to user for performing task related operations
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean isValid = true;
        while (isValid) {
            try {
                Scanner sc = new Scanner(System.in);
                TaskManagerController taskManagerController = new TaskManagerController();
                taskManagerController.InitilizeSavedTaskList();
                UserInput userInput = new UserInput(taskManagerController);
                int userChoice = 0;
                while (userChoice != 5) {
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Welcome to To Do List.Please choose some option");
                    System.out.println("-----------------------------------------------");
                    System.out.println("1. Add Task");
                    System.out.println("2. Edit Task");
                    System.out.println("3. Disply Task sorted by date ");
                    System.out.println("4. Disply Task sorted by project");
                    System.out.println("5. Save and Quit");
                    System.out.println("--------------------------------------------------------");
                    userChoice = sc.nextInt();
                    switch (userChoice) {
                        case 1:
                            Object o = userInput.enterTaskDetails();
                            if (o != null) {
                                taskManagerController.addTask(o);
                            }
                            break;
                        case 2:
                            userInput.editTaskDetails();
                            break;
                        case 3:
                            taskManagerController.sortByDate();
                            break;
                        case 4:
                            taskManagerController.sortByProject();
                            break;
                        case 5:
                            taskManagerController.saveToFile();
                            System.out.println(ResourceMessages.THANKYOU_MSG);
                            break;
                        default:
                            System.out.println(ResourceMessages.VALIDMENUOPTION_MSG);
                    }
                }
                isValid = false;
            } catch (InputMismatchException ex) {
                System.out.println(ResourceMessages.VALIDINPUT_MSG);

            }
        }

    }
}
