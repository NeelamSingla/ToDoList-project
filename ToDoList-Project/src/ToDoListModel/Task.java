package ToDoListModel;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Task class with Title, DueDate, Is Done, Project Category
 *
 * @author Neelam Singla
 */
public class Task implements Serializable, Comparable<Task> {

    private final String taskTitle,projectCategory;
    private final Date dueDate;
    private boolean isDone;

    /**
     * Constructor to create task with all options
     *
     * @param taskTitle task description
     * @param category category or project task belongs to
     * @param isDone Status of task
     * @param dueDate Estimated Due Date
     */
    public Task(String taskTitle, String category, boolean isDone, Date dueDate) {
        this.taskTitle = taskTitle;
        this.dueDate = dueDate;
        this.isDone = isDone;
        this.projectCategory = category;

    }

    /**
     * To get Task Title
     *
     * @return Task Title
     */
    public String getTaskTitle() {
        return taskTitle;
    }

    /**
     * To get Task Due Date
     *
     * @return task due Date
     */
    public Date getTaskDueDate() {
        return dueDate;
    }

    /**
     * To get task status
     *
     * @return Task status as Done or To Do
     */
    public String getTaskStatus() {
        return isDone == true ? "Done" : "To DO";
    }

    /**
     * To get Task project or Category
     *
     * @return Task Project or Category
     */
    public String getTaskProject() {
        return projectCategory;
    }

    /**
     * To set Task Status as Done
     */
    public void setTaskStatusDone() {
        isDone = true;
    }

    /**
   * Equal checks for equality between this and another Task
   * It compares task title and task project name
   * @param t object
   * @return true if the task compared shares the same title and project name 
   */
    public boolean equals(Task t) {
        return (this.getTaskTitle().toLowerCase().equals(t.getTaskTitle().toLowerCase())
                && this.getTaskProject().toLowerCase().equals(t.getTaskProject().toLowerCase()
                ));
    }

    /**
     * Override toString to return all task fields Format date as day,Date Month
     * Year
     *
     * @return task with different fields as String
     */
    @Override
    public String toString() {
        String s1 = this.getTaskTitle().substring(0, 1).toUpperCase();
        String taskTitleCapitalized = s1 + this.getTaskTitle().substring(1);
        String prjt1 = this.getTaskProject().substring(0, 1).toUpperCase();
        String taskProjectCapitalized = prjt1 + this.getTaskProject().substring(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE,d MMM yyyy");
        return taskTitleCapitalized + "           " + taskProjectCapitalized
                + "          " + simpleDateFormat.format(this.dueDate) + "         " + this.getTaskStatus();
    }

    /**
     * To compare Task by date for sorting
     *
     * @param t takes task to compare
     * @return 
     */
    @Override
    public int compareTo(Task t) {
        if (getTaskDueDate() == null || t.getTaskDueDate() == null) {
            return 0;
        }
        return getTaskDueDate().compareTo(t.getTaskDueDate());

    }

    /**
     * Comparator to compare task by project
     */
    public static Comparator<Task> taskProjectComparator = (Task t1, Task t2) -> {
        String taskprjt1 = t1.getTaskProject().toUpperCase();
        String taskprjt2 = t2.getTaskProject().toUpperCase();
        
        //ascending order
        return taskprjt1.compareTo(taskprjt2);
    };

    /**
     * Comparator to compare task by Date
     */
    public static Comparator<Task> taskdueDateComparator = (Task t1, Task t2) -> {
        Date taskdueDate1 = t1.getTaskDueDate();
        Date taskdueDate2 = t2.getTaskDueDate();
        
        //ascending order
        return taskdueDate1.compareTo(taskdueDate2);
    };

}
