package Controller;

import ToDoListModel.TaskManager;
import java.io.IOException;
import java.util.Date;

/**
 * Controller class to pass all task related operations call to Task manager
 * Model
 *
 * @author Neelam Singla
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
     * It sends notification email to user if task due date is tomorrow and not
     * done yet
     */
    public void sendNotification() {
        taskManager.sendNotification();
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
    public Task createTask(String taskTitle, String taskCategory, boolean taskStatus, Date dueDate) {
        Task CreatedTask = taskManager.createTask(taskTitle, taskCategory, taskStatus, dueDate);

        return CreatedTask;
    }

    /**
     * Add Task in list passed as Object
     *
     * @param task
     */
    public void addTask(Task task) {
        boolean isTaskCreated = taskManager.addTask(task);
        if (!isTaskCreated) {
            System.out.println(ResourceMessages.TASKEXIST_MSG);
        } else {
            System.out.println(ResourceMessages.TASKADDED_MSG);
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
     * Filter Task by project
     *
     * @param projectCategoryToFilter
     */
    public void filterByProject(String projectCategoryToFilter) {
        taskManager.filterByProject(projectCategoryToFilter);
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
     * @return Task as object if it is present
     */
    public Task selectGivenTask(String taskTitle, String taskCategory) {
        Task selectedTask = taskManager.selectGivenTask(taskTitle, taskCategory);

        return selectedTask;

    }

    /**
     * Select task from task list which has same Task title and Task Category as
     * provided in parameters
     *
     * @param taskIndex
     * @return
     */
    public Task selectGivenTask(int taskIndex) {
        Task selectedTask = taskManager.selectGivenTask(taskIndex);
        return selectedTask;
    }

    /**
     * Update Task
     *
     * @param oldTask- task to be updated
     * @param updatedTask - task with new details
     * @return updated task as Object
     */
    public Task updateTask(Task oldTask, Task updatedTask) {
        Task taskUpdated = taskManager.updateTask(oldTask, updatedTask);
        return taskUpdated;
    }

    /**
     * Update Task title for existing task
     *
     * @param oldTask
     * @param updatedTaskTitle
     * @return updated task as Object
     */
    public Task updateTaskByTitle(Task oldTask, String updatedTaskTitle) {
        Task taskUpdated = taskManager.updateTaskByTitle(oldTask, updatedTaskTitle);
        return taskUpdated;
    }

    /**
     * Update Task Category for existing task
     *
     * @param oldTask
     * @param updatedTaskCategory
     * @return updated task as Object
     */
    public Task updateTaskByCategory(Task oldTask, String updatedTaskCategory) {
        Task taskUpdated = taskManager.updateTaskByCategory(oldTask, updatedTaskCategory);
        return taskUpdated;
    }

    /**
     * Update Task Due date for existing task
     *
     * @param oldTask
     * @param date
     * @return updated task as Object
     */
    public Task updateTaskByDate(Task oldTask, Date date) {
        Task taskUpdated = taskManager.updateTaskByDate(oldTask, date);
        return taskUpdated;
    }

    /**
     * Delete Task passed as object
     *
     * @param o It is Task type object
     */
    public void deleteTask(Task o) {
        taskManager.deleteTask(o);
    }

    /**
     * Mark Task status as Done
     *
     * @param o its Task passed as Object
     */
    public void markAsDone(Task o) {
        taskManager.markAsDone(o);
    }

}
