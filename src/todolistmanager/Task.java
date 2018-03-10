/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistmanager;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;



public  class Task  implements Serializable,Comparable<Task> {

private String taskTitle;
private Date dueDate;
private boolean isDone;
private String projectCategory;

    public Task(String taskTitle, Date dueDate, boolean isDone, String category){
         this.taskTitle=taskTitle;
         this.dueDate=dueDate;
         this.isDone=isDone;
         this.projectCategory=category;


    }
 
 
    String geTaskTitle()
    {
              return taskTitle;
    }

    Date geTaskDueDate()
    {
      return dueDate;
    }

    String geTaskStatus()
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

    public boolean equals(Task t) {
        return (this.geTaskTitle().toLowerCase().equals(t.geTaskTitle().toLowerCase())
                && 
                this.getTaskProject().toLowerCase().equals(t.getTaskProject().toLowerCase()
                ));
    }


    @Override
    public String toString(){
      return this.getTaskProject() + " " + this.geTaskTitle() +
              " " +this.dueDate + " " + this.geTaskStatus() ;
    }

        @Override
        public int compareTo(Task t) {
            if (geTaskDueDate() == null || t.geTaskDueDate() == null)
          return 0;
        return geTaskDueDate().compareTo(t.geTaskDueDate());

            }

        public static Comparator<Task> taskProjectComparator = new Comparator<Task>() {

            public int compare(Task t1, Task t2) {
               String taskprjt1 = t1.getTaskProject().toUpperCase();
               String taskprjt2 = t2.getTaskProject().toUpperCase();

               //ascending order
               return taskprjt1.compareTo(taskprjt2);


        }};
    
        public static Comparator<Task> taskdueDateComparator = new Comparator<Task>() {

           public int compare(Task t1, Task t2) {
              Date taskdueDate1 = t1.geTaskDueDate();
              Date taskdueDate2 = t2.geTaskDueDate();

              //ascending order
              return taskdueDate1.compareTo(taskdueDate2);


       }};

}
 


