package Controller;

import ToDoListModel.Task;
import ToDoListModel.TaskManager;
import java.util.Date;

/**
 * Controller class to pass all task related operations call to Task manager
 * Model
 *
 * @author Neelam
 */
public class TaskManagerController {

    TaskManager taskManager;

    /**
     * Constructor to initialize Task Manager Model
     */
    public TaskManagerController() {
        taskManager = new TaskManager();

    }

    /**
     * Initialize tasks from file if any and display all tasks
     */
    public void InitilizeSavedTaskList() {
        taskManager.initializeListFromFile();

    }

    /**
     * Create new task with given details
     *
     * @param taskTitle
     * @param taskCategory
     * @param taskStatus
     * @param dueDate
     * @return
     */
    public Object createTask(String taskTitle, String taskCategory, boolean taskStatus, Date dueDate) {
        Object CreatedTask = taskManager.createTask(taskTitle, taskCategory, taskStatus, dueDate);

        return CreatedTask;
    }

    /**
     * Add Task in list passed as Object
     *
     * @param o -Its a new task passed as object
     */
    public void addTask(Object o) {
        boolean isTaskCreated = taskManager.addTask(o);
        if (!isTaskCreated) {
            System.out.println("Task is already present in TODO List");
        } else {
            System.out.println("Task is added in TODO List");
        }
    }

    /**
     * Display all Tasks
     */
    public void displayAll() {
        taskManager.displayAll();
    }

    /**
     * Sort Task by Date
     */
    public void sortByDate() {
        taskManager.sortByDate();
    }

    /**
     * Sort Task by project
     */
    public void sortByProject() {
        taskManager.sortByProject();
    }

    /**
     * Save Task to file
     */
    public void saveToFile() {
        taskManager.saveToFile();
    }

    /**
     * Select task from task list which has same Task title and Task Category as
     * provided in parameters
     *
     * @param taskTitle
     * @param taskCategory
     * @return Task if it is present
     */
    public Object selectGivenTask(String taskTitle, String taskCategory) {
        Object selectedTask = taskManager.selectGivenTask(taskTitle, taskCategory);

        return selectedTask;

    }

    /**
     * Select task from task list which has same Task title and Task Category as
     * provided in parameters
     *
     * @param taskIndex
     * @return
     */
    public Object selectGivenTask(int taskIndex) {
        Object selectedTask = taskManager.selectGivenTask(taskIndex);
        return selectedTask;
    }

    /**
     * Update Task
     *
     * @param oldTask- task to be updated
     * @param updatedTask - task with new details
     */
    public void updateTask(Object oldTask, Object updatedTask) {
        taskManager.updateTask(oldTask, updatedTask);

    }

    /**
     * Delete Task passed as object
     *
     * @param o It is Task type object
     */
    public void deleteTask(Object o) {
        taskManager.deleteTask(o);
    }

    /**
     * Mark Task status as Done
     *
     * @param o its Task passed as Object
     */
    public void markAsDone(Object o) {
        taskManager.markAsDone(o);
    }

}
