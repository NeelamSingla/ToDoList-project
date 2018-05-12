package FileUtility;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * It reads and initialize Object collection from given file
 *
 */
public final class ReadFromFile {

    /**
     * To Initialize task from file
     *
     * @param <T> It is generic data type
     * @param file - file name from where it can read tasks
     * @return Collection of T type objects from file if any to display
     */
    public static <T> List<T> initializeListFromFile(File file) {

        List<T> tasklist = new ArrayList<>();
        try {
            if (file.exists()) {
                try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(file))) {
                    T readTask;
                    while ((readTask = (T) oi.readObject()) != null) {
                        // Read objects
                        tasklist.add(readTask);
                    }
                }

                return tasklist;
            } else {
                file.createNewFile();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (EOFException | ClassNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
        return tasklist;

    }
}
