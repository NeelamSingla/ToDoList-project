/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistmanager;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Neelam
 */
public  class Task  implements Serializable,Comparable<Task> {

private String taskTitle;
private Date dueDate;
private boolean isDone;
private String projectCategory;


    public Task(String taskTitle,String category, boolean isDone,  Date dueDate){
         this.taskTitle=taskTitle;
         this.dueDate=dueDate;
         this.isDone=isDone;
         this.projectCategory=category;


    }
 
 
        String getTaskTitle()
        {
                  return taskTitle;
        }

        Date getTaskDueDate()
        {
          return dueDate;
        }

        String getTaskStatus()
        {
          return isDone == true? "Done" :"To DO";
        }

        String getTaskProject()
        {
          return projectCategory;
        }

        void setTaskStatusDone()
        {
           isDone= true;
        }
        
        /**
         * Equal return true if task has same title and same task project
         * 
         * @param t
         * @return 
         */
        public boolean equals(Task t) {
            return (this.getTaskTitle().toLowerCase().equals(t.getTaskTitle().toLowerCase())
                    && 
                    this.getTaskProject().toLowerCase().equals(t.getTaskProject().toLowerCase()
                    ));
        }


        @Override
        public String toString(){
            String dueDate= new SimpleDateFormat("yyyy-mm-dd").format(this.dueDate);
          return this.getTaskProject() + "  " + this.getTaskTitle() +
                  "  " + dueDate + "  " + this.getTaskStatus() ;
        }

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
 


