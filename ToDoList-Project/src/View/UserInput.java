package View;

import Controller.ResourceMessages;
import Controller.Task;
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
     * It shows user Main menu to display option which allows user to add,
     * update, show tasks
     */
    public void showUserMenu() {
        Scanner sc = new Scanner(System.in);
        int userChoice = 0;
        while (userChoice != 6) {
            System.out.println("--------------------------------------------------------");
            System.out.println("Welcome to To Do List.Please choose some option");
            System.out.println("-----------------------------------------------");
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Display Task sorted by date ");
            System.out.println("4. Display Task sorted by project");
            System.out.println("5. Display Task filtered by project");
            System.out.println("6. Save and Quit");
            System.out.println("--------------------------------------------------------");
            userChoice = sc.nextInt();
            switch (userChoice) {
                case 1:
                    Task task = enterTaskDetails();
                    if (task != null) {
                        taskManagerController.addTask(task);
                    }

                    break;
                case 2:
                    editTaskDetails();
                    break;
                case 3:
                    taskManagerController.sortByDate();
                    break;
                case 4:
                    taskManagerController.sortByProject();
                    break;
                case 5:
                    System.out.println("Enter project category to filter tasks");
                    String projectCategoryToFilter = enterTaskCategory();
                    taskManagerController.filterByProject(projectCategoryToFilter);
                    break;
                case 6:
                    taskManagerController.saveToFile();
                    System.out.println(ResourceMessages.THANKYOU_MSG);
                    break;
                default:
                    System.out.println(ResourceMessages.VALIDMENUOPTION_MSG);
            }
        }
    }

    /**
     * Method to take user input for all task details
     *
     * @return Task as Object
     */
    public Task enterTaskDetails() {
        try {
            Scanner sc = new Scanner(System.in);
            String taskTitle, taskCategory;
            boolean taskStatus;
            Date dueDate;
            Task createdTask;
            taskTitle = enterTaskTitle();
            taskCategory = enterTaskCategory();
            System.out.println("Enter Task status, Done-True/False");
            taskStatus = sc.nextBoolean();
            dueDate = enterTaskDate();
            if (dueDate != null) {
                createdTask = taskManagerController.createTask(taskTitle, taskCategory, taskStatus, dueDate);
                return createdTask;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        }
        return null;
    }

    /**
     * Enter only Task Title
     *
     * @return TaskTitle
     */
    String enterTaskTitle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task Title");
        String taskTitle = sc.nextLine();
        return taskTitle;
    }

    /**
     * Enter only Task Category
     *
     * @return TaskCategory
     */
    public String enterTaskCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task category");
        String taskCategory = sc.nextLine();
        return taskCategory;
    }

    /**
     * It allows to enter task date
     *
     * @return due Date of task only if it is future date
     */
    Date enterTaskDate() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter Task due Date in format yyyy-MM-dd ");
            String date = sc.next();
            Date dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            boolean isFutureDate = validateIfFutureDate(dueDate);
            if (isFutureDate) {
                return dueDate;
            } else {
                System.out.println(ResourceMessages.VALIDFUTUREDATE_MSG);
            }
        } catch (ParseException ex) {
            System.out.println("Invalid Date format");
        }
        return null;
    }

    /**
     * Asks user details of task to edit either by Task no or By Task Title and
     * Task Category
     */
    public void editTaskDetails() {
        boolean isValid = true;
        while (isValid) {
            int userChoice = 0, taskIndex;
            String taskIndexChoice;
            Scanner sc = new Scanner(System.in);
            String taskTitle, taskCategory;
            Task taskToUpdate, updatedTask = null;
            System.out.println("Do you want to update by Index? Enter Yes / No");
            taskIndexChoice = sc.nextLine();

            try {
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
                    userChoice = 7;
                }

                while (userChoice != 7) {
                    System.out.println("-----------------------------------------------");
                    System.out.println("Welcome to To Do List.Please choose some option");
                    System.out.println("1. Edit Task");
                    System.out.println("2. Edit Task's Title");
                    System.out.println("3. Edit Task's Category");
                    System.out.println("4. Edit Task's Due Date");
                    System.out.println("5. Mark Task as Done");
                    System.out.println("6. Remove Task");
                    System.out.println("7. Go back to ToDo List main menu");
                    System.out.println("-----------------------------------------------");

                    userChoice = sc.nextInt();
                    switch (userChoice) {

                        case 1:
                            Task updatedDetails = enterTaskDetails();
                            updatedTask = taskManagerController.updateTask(taskToUpdate, updatedDetails);
                            System.out.println("Updated Task:" + updatedTask.toString());
                            break;
                        case 2:
                            String updatedTitle = enterTaskTitle();
                            updatedTask = taskManagerController.updateTaskByTitle(taskToUpdate, updatedTitle);
                            System.out.println("Updated Task:" + updatedTask.toString());
                            break;
                        case 3:
                            String updatedCategory = enterTaskCategory();
                            updatedTask = taskManagerController.updateTaskByCategory(taskToUpdate, updatedCategory);
                            System.out.println("Updated Task:" + updatedTask.toString());
                            break;
                        case 4:
                            Date updatedDate = enterTaskDate();
                            updatedTask = taskManagerController.updateTaskByDate(taskToUpdate, updatedDate);
                            System.out.println("Updated Task:" + updatedTask.toString());
                            break;
                        case 5:
                            taskManagerController.markAsDone(taskToUpdate);
                            break;
                        case 6:
                            taskManagerController.deleteTask(taskToUpdate);
                            break;
                        case 7:
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

    /**
     * To Validate if given date is greater than Todays date
     *
     * @param date Due Date of task
     * @return true only if It is greater than todays date
     */
    private boolean validateIfFutureDate(Date date) {
        Date today = new Date();
        return date.after(today);
    }

}
