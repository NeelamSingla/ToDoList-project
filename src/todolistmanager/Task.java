/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistmanager;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Neelam
 */
//enum Project{
 // GROCERY,HOME,OFFICE
//}

public  class Task  implements Serializable {

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

boolean geTaskStatus()
{
  return isDone;
}

String getTaskProject()
{
  return projectCategory;
}

@Override
public String toString(){
  return "Project:" + this.projectCategory + ",Task Title:" + this.taskTitle +
          " ,Due Date:" +this.dueDate + ",TaskStatus is done:" + this.isDone ;
}
 }
 


