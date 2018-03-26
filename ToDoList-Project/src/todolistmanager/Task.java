package todolistmanager;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Task class with Title, DueDate, Is Done, Project Category
 * @author Neelam
 */
public  class Task  implements Serializable,Comparable<Task> {

private String taskTitle;
private Date dueDate;
private boolean isDone;
private String projectCategory;


/**
 * Constructor to create task with all options
 * @param taskTitle task description
 * @param category category or project task belongs to
 * @param isDone Status of task
 * @param dueDate Estimated Due Date
 */    
public Task(String taskTitle,String category, boolean isDone,  Date dueDate){
         this.taskTitle=taskTitle;
         this.dueDate=dueDate;
         this.isDone=isDone;
         this.projectCategory=category;


    }
 
        /**
         * To get Task Title
         * @return 
         */
        String getTaskTitle()
        {
                  return taskTitle;
        }

        /**
         * To get Task Due Date
         * @return 
         */
        Date getTaskDueDate()
        {
          return dueDate;
        }

        /**
         * To get task status
         * @return 
         */
        String getTaskStatus()
        {
          return isDone == true? "Done" :"To DO";
        }

        /**
         * To get Task project or Category
         * @return 
         */
        String getTaskProject()
        {
          return projectCategory;
        }

        /**
         * To set Task Status as Done
         */
        void setTaskStatusDone()
        {
           isDone= true;
        }
        
        /**
         * Equal return true if task has same title and same task project
         * 
         * @param takes a task 
         * @return true if given task is same as this task
         */
        public boolean equals(Task t) {
            return (this.getTaskTitle().toLowerCase().equals(t.getTaskTitle().toLowerCase())
                    && 
                    this.getTaskProject().toLowerCase().equals(t.getTaskProject().toLowerCase()
                    ));
        }


        
        /**
         * Override toString to return all task fields
         * Format date as day,Date Month Year
         * @return 
         */
        @Override
        public String toString(){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE,d MMM yyyy");
            return this.getTaskProject() + "  " + this.getTaskTitle() +
                  "  " + simpleDateFormat.format(this.dueDate) + "  " + this.getTaskStatus() ;
        }

        
        /**
         * To compare Task by date for sorting
         * @param t
         * @return 
         */
        @Override
        public int compareTo(Task t) {
            if (getTaskDueDate() == null || t.getTaskDueDate() == null)
          return 0;
        return getTaskDueDate().compareTo(t.getTaskDueDate());

            }

        /**
         * Comparator to compare by project
         */
        public static Comparator<Task> taskProjectComparator = new Comparator<Task>() {

            public int compare(Task t1, Task t2) {
               String taskprjt1 = t1.getTaskProject().toUpperCase();
               String taskprjt2 = t2.getTaskProject().toUpperCase();

               //ascending order
               return taskprjt1.compareTo(taskprjt2);


        }};
        
        /**
         * Comparator to compare by Date
         */
        public static Comparator<Task> taskdueDateComparator = new Comparator<Task>() {

           public int compare(Task t1, Task t2) {
              Date taskdueDate1 = t1.getTaskDueDate();
              Date taskdueDate2 = t2.getTaskDueDate();

              //ascending order
              return taskdueDate1.compareTo(taskdueDate2);


       }};

}
 


