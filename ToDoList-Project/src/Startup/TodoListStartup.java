package Startup;

import Controller.ResourceMessages;
import Controller.TaskManagerController;
import View.UserInput;
import java.io.IOException;
import java.util.InputMismatchException;

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
     * @param args the command line arguments- it does not take any arguments
     */
    public static void main(String[] args) {
        boolean isValid = true;
        while (isValid) {
            try {

                TaskManagerController taskManagerController = new TaskManagerController();
                taskManagerController.InitilizeSavedTaskList();
                taskManagerController.sendNotification();
                UserInput userInput = new UserInput(taskManagerController);
                userInput.showUserMenu();
                isValid = false;
            } catch (InputMismatchException ex) {
                System.out.println(ResourceMessages.VALIDINPUT_MSG);

            }
        }

    }
}
