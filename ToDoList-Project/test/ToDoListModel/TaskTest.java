package ToDoListModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * Test file to Test Task file
 *
 */
public class TaskTest {

    Task expectedTask;

    public TaskTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of geTaskTitle method, of class Task.
     */
    @Test
    public void testGetTaskTitle() {
        try {
            Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
            expectedTask = new Task("shopping", "Home", false, dueDate);
            String actual = "shopping";
            String expected = expectedTask.getTaskTitle();
            assertEquals(expected, actual);
        } catch (InputMismatchException | ParseException e) {
        }

    }

    /**
     * Test of geTaskDueDate method, of class Task.
     */
    @Test
    public void testGetTaskDueDate() {
        try {
            Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
            expectedTask = new Task("shopping", "Home", false, dueDate);
            Date actual = expectedTask.getTaskDueDate();
            assertEquals(dueDate, actual);
        } catch (InputMismatchException | ParseException e) {
        }
    }

    /**
     * Test of geTaskStatus method, of class Task.
     */
    @Test
    public void testGetTaskStatus() {
        try {
            Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
            expectedTask = new Task("shopping", "Home", false, dueDate);
            String expected = "To DO";
            String actual = expectedTask.getTaskStatus();
            assertEquals(expected, actual);
        } catch (InputMismatchException | ParseException e) {
        }
    }

    /**
     * Test of getTaskProject method, of class Task.
     */
    @Test
    public void testGetTaskProject() {
        try {
            Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
            expectedTask = new Task("shopping", "Home", false, dueDate);
            String actual = "Home";
            String expected = expectedTask.getTaskProject();
            assertEquals(expected, actual);
        } catch (InputMismatchException | ParseException e) {
        }
    }

    /**
     * Test of setTaskStatusDone method, of class Task.
     */
    @Test
    public void testSetTaskStatusDone() {
        try {
            Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
            expectedTask = new Task("shopping", "Home", false, dueDate);
            expectedTask.setTaskStatusDone();
            String actual = "Done";
            String expected = expectedTask.getTaskStatus();
            assertEquals(expected, actual);
        } catch (InputMismatchException | ParseException e) {
        }
    }

    /**
     * Test of equals method, of class Task.
     * Checks if Title and category of two tasks are equal
     */
    @Test
    public void testEquals() {
        Date dueDate = null;
        try {
            dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        } catch (ParseException ex) {
            Logger.getLogger(TaskTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            Task task1 = new Task("shopping", "Home", false, dueDate);
            Task task2 = new Task("shopping", "Home", true, dueDate);
        boolean expResult = true;
        boolean result = task1.equals(task2);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Task.
     * it returns all fields of task as String
     */
    @Test
    public void testToString() {
        Date dueDate = null;
        try {
            dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("02/04/2018");
        } catch (ParseException ex) {
            Logger.getLogger(TaskTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            Task task1 = new Task("shopping", "Home", false, dueDate);
        String expResult = "Shopping           Home          Mon,2 Apr 2018         To DO";
        String result = task1.toString();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of compareTo method, of class Task.
     * It compares task by Due date
     */
    @Test
    public void testCompareTo() {
         Date dueDate = null;
        try {
            dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        } catch (ParseException ex) {
            Logger.getLogger(TaskTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            Task task1 = new Task("shopping", "Home", false, dueDate);
            Task task2 = new Task("shopping", "Home", true, dueDate);
        int expResult = task1.getTaskDueDate().compareTo(task2.getTaskDueDate());
        int result = task1.compareTo(task2);
        assertEquals(expResult, result);
    }

}
