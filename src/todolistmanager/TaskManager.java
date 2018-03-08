/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistmanager;


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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class TaskManager
{
  List<Task> list;
  
  File file;
  public TaskManager()
  {
      list= new ArrayList<Task>();
      file =new File("TaskList.txt");
      initializeListFromFile();
  }
  
  public void createTask(String taskTitle,String taskCategory,boolean taskStatus,Date dueDate)
          {
      Task A = new Task(taskTitle ,dueDate,taskStatus,taskCategory); //(String name, Date dueDate, boolean status, Project proj)
      addTask(A);
 }

  public void addTask(Task A){
      list.add(A);
 }


 public void deleteTask(Task A){
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
 
 
 
  void displayAll()
 {
     for(Task t:list)
     {
         System.out.println(t.toString());
     }
 }
   void save() throws IOException{
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
  
   void saveToFile()
  {
      try{
      FileOutputStream f = new FileOutputStream(file);
			ObjectOutputStream o = new ObjectOutputStream(f);

		 for(Task t:list)
                {
                   o.writeObject(t);
                }
			
			

                o.close();
                f.close();
                } 
      catch (FileNotFoundException e) {
                System.out.println("File not found");
		} 
      catch (IOException e) {
		System.out.println("Error initializing stream");
		} 
  }
  
  
  final void initializeListFromFile()
  {
      try{
          
          FileInputStream fi = new FileInputStream(file);
			ObjectInputStream oi = new ObjectInputStream(fi);
                        if(( oi.readObject()) != null)
                        {
                            while(( oi.readObject()) != null)
                            {
                                // Read objects
                                Task t = (Task) oi.readObject();
                                list.add(t);
                            }
                        }
                        
      } 
      catch (FileNotFoundException e) {
                System.out.println("File not found");
		} 
      catch (IOException e) {
		System.out.println("Error initializing stream");
		} 
       catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  }
}
 

