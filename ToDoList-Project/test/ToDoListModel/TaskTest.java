package ToDoListModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
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
    @Ignore
    public void testSetTaskStatusDone() {
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
     * Test of equals method, of class Task.
     */
    @Ignore
    public void testEquals() {
        System.out.println("equals");
        Task t = null;
        Task instance = null;
        boolean expResult = false;
        boolean result = instance.equals(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Task.
     */
    @Ignore
    public void testToString() {
        System.out.println("toString");
        Task instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Task.
     */
    @Ignore
    public void testCompareTo() {
        System.out.println("compareTo");
        Task t = null;
        Task instance = null;
        int expResult = 0;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
