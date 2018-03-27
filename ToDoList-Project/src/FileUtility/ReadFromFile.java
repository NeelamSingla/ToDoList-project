package FileUtility;

import ToDoListModel.Task;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * It reads and initialize task collection from
 * given file
 * 
 */
public final class ReadFromFile {
    
    
    /**
     * To Initialize task from file
     * @param file - file name from where it can read tasks
     * @return Collection of tasks from file if any to display
     * sorted by date and project
     */
    public static List<Task> initializeListFromFile(File file) 
        {
         List<Task> tasklist= new ArrayList<>();
            try
            {
              ObjectInputStream oi = new ObjectInputStream(new FileInputStream(file));
              Task readTask;
              while((readTask = (Task) oi.readObject()) != null)
              {
                    // Read objects
                    tasklist.add(readTask);
                }
               oi.close();
               Collections.sort(tasklist,Task.taskdueDateComparator);
               return tasklist;

            } 
            catch (FileNotFoundException e) {
              System.out.println("File not found");
                     } 
            catch (EOFException e) {
            } 
            catch (IOException e) 
            {
                    System.out.println("Error initializing stream");
            } 
            catch (ClassNotFoundException e) 
            {
            }
         return tasklist;

        }
}
