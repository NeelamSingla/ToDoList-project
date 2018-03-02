import java.util.*;
import java.lang.Exception;
import java.io.*;
import java.io.FileWriter;
import java.nio.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
 enum Project{
  GROCERY,HOME,OFFICE
}

 class Task  {

private String taskTitle;
private Date dueDate;
private boolean isDone;
private Project proj;

 public Task(String taskTitle, Date dueDate, boolean isDone, Project proj){
     this.taskTitle=taskTitle;
     this.dueDate=dueDate;
     this.isDone=isDone;
     this.proj=proj;


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



public String toString(){
  return "TaskTitle:" + this.taskTitle + " Due Date:" +this.dueDate;
}




}

class TaskManager
{
  List<Task> list;
  File file ;
  public TaskManager()
  {
    list = new ArrayList<Task>();
   file = new File("TaskList.txt");
  }
  public void add(Task A){
      list.add(A);
 }


 public void delete(Task A){
     list.remove(A);
 }

 public void displayTaskList() throws IOException
 {

   FileReader fr=new FileReader("TaskList.txt");
   BufferedReader br=new BufferedReader(fr);
   Charset utf8 = StandardCharsets.UTF_8;
   int i;
   String line=br.readLine();
   while((line)!= null){
   System.out.print(line);
   line=br.readLine();
   }
   br.close();
   fr.close();
 }
  public void save() throws IOException{
      try {

          BufferedWriter bw =new BufferedWriter(new FileWriter(file,true));

          for(Task m : list)
            {

              bw.write(m.toString());
              bw.write("\n");
            }


            bw.close();


          } catch (FileNotFoundException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  public static void main(String[] args) throws IOException{

try{
      TaskManager todo = new TaskManager();
      Task A = new Task("Buy grocery" ,new SimpleDateFormat("dd/MM/yyyy").parse("15/12/2018"),false,Project.GROCERY); //(String name, Date dueDate, boolean status, Project proj)
      Task B = new Task("Send MOM" ,new SimpleDateFormat("dd/MM/yyyy").parse("15/03/2018"),false,Project.OFFICE);

      todo.add(A);
      todo.add(B);
      todo.delete(A);
      todo.save();
      todo.displayTaskList();
    }
      catch (ParseException e) {

                e.printStackTrace();
            }

  }

}
