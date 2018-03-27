package ToDoListModel;

import java.util.*;
import java.util.Date;
import java.io.File;
import FileUtility.ReadFromFile;
import FileUtility.SaveToFile;

/**
 * Task Manager class like Model to perform all task related stuff
 * Controller directs all call to Task Manager
 */
public class TaskManager {

    List<Task> tasklist = new ArrayList<>();
    File file;

    /**
     * Constructor to initialize task list and and also file name from where to
     * restore saved tasks
     */
    public TaskManager() {

        file = new File("TaskList.ser");
    }

    
    /**
     * Uses FileUtility ReadFromFile
     * Initialize tasks from file if any and display all tasks
     */
    public void initializeListFromFile() {
        tasklist = ReadFromFile.initializeListFromFile(file);
        if (tasklist != null) {
            displayAll();
        }

    }

    /**
     * Create new task with given details
     *
     * @param taskTitle
     * @param taskCategory
     * @param taskStatus
     * @param dueDate
     * @return new Task 
     */
    public Task createTask(String taskTitle, String taskCategory, boolean taskStatus, Date dueDate) {
        Task task = new Task(taskTitle, taskCategory, taskStatus, dueDate); //(String name, Date dueDate, boolean status, Project proj)
        return task;
    }

    /**
     * Add Task if it does not exist earlier
     *
     * @param o Task passed as object
     * @return true if task is added otherwise returns false
     */
    public boolean addTask(Object o) {
        Task newTask = (Task) o;
        if (!checkIfTaskExists(newTask)) {
            tasklist.add(newTask);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Update Task
     *
     * @param oldTask- old task details to be updated
     * @param updatedTask - task with new details
     */
    public void updateTask(Object oldTask, Object updatedTask) {
        Task task = (Task) oldTask;
        Task updated = (Task) updatedTask;
        int index = tasklist.indexOf(task);
        tasklist.set(index, updated);

    }

    /**
     * Delete Task passed as object
     *
     * @param o It is Task type object
     */
    public void deleteTask(Object o) {
        Task taskToRemove = (Task) o;
        tasklist.remove(taskToRemove);
    }

    /**
     * Display all tasks present in ToDo List
     */
    public void displayAll() {
        System.out.println("   " + "Title"+"           "+"Category"+"           "+"Due Date"+"           "+"Status");
        for (int i = 1; i <= tasklist.size(); i++) {
            System.out.println(i + ". " + tasklist.get(i - 1).toString());
        }
    }

    /**
     * Sort all tasks by Project
     */
    public void sortByProject() {
        Collections.sort(tasklist, Task.taskProjectComparator);
        displayAll();
    }

    /**
     * Sort all tasks by Date
     */
    public void sortByDate() {
        Collections.sort(tasklist, Task.taskdueDateComparator);
        displayAll();
    }

    /**
     * Check If Task with same Title and same category is already present in the
     * list
     *
     * @param newTask task which we want to check 
     * @return true if task exists in given list
     */
    public boolean checkIfTaskExists(Task newTask) {
        boolean isTaskExists = false;
        for (Task t : tasklist) {
            isTaskExists = t.equals(newTask);
        }
        return isTaskExists;

    }

    /**
     * Select task from task list which has same Task title and Task Category as
     * provided in parameters
     *
     * @param taskTitle
     * @param taskCategory
     * @return Task if it is present else null
     */
    public Task selectGivenTask(String taskTitle, String taskCategory) {
        try {
            Task selectedTask = (tasklist.stream()
                    .filter(t -> t.getTaskTitle().toLowerCase().equals(taskTitle.toLowerCase())
                    && t.getTaskProject().toLowerCase().equals(taskCategory.toLowerCase())
                    )
                    .findFirst()
                    .get());

            return selectedTask;
        } catch (NoSuchElementException ex) {
            System.out.println("No Such Task Exist in To Do List");
        }
        return null;
    }

    /**
     * Select task from task list which has same Task title and Task Category as
     * provided in parameters
     *
     * @param taskIndex
     * @return Task at given index if it exists
     */
    public Task selectGivenTask(int taskIndex) {
        try {
            if (taskIndex <= tasklist.size()) {
                Task selectedTask = tasklist.get(taskIndex - 1);
                return selectedTask;
            } else {
                System.out.println("No Such Task Exist in To Do List");
            }

        } catch (NoSuchElementException ex) {
            System.out.println("No Such Task Exist in To Do List");
        }
        return null;
    }

    /**
     * Mark Task status as Done
     *
     * @param o its Task passed as Object
     */
    public void markAsDone(Object o) {
        Task markTaskDone = (Task) o;
        if ((markTaskDone) != null) {
            markTaskDone.setTaskStatusDone();
        }
    }

    /**
     * Save tasks to file in serialized way
     */
    public void saveToFile() {
        SaveToFile.saveToFile(file, tasklist);
    }

}
