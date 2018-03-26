package FileUtility;

import ToDoListModel.Task;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author tmp-sda-1160
 */
public final class SaveToFile {
    
       /**
        * Save all task in file
        * @param file file name 
        * @param tasklist collection of task to save
        */
    public static void saveToFile(File file,List<Task> tasklist)
        {
           try{
                 FileOutputStream f = new FileOutputStream(file);
                 ObjectOutputStream o = new ObjectOutputStream(f);

                    for(Task t:tasklist)
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

    
}
