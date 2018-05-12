package ToDoListModel;

import Controller.Task;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testGetTaskTitle() throws ParseException {
        Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        expectedTask = new Task("shopping", "Home", false, dueDate);
        String actual = "shopping";
        String expected = expectedTask.getTaskTitle();
        assertEquals(expected, actual);

    }

    /**
     * Test of geTaskDueDate method, of class Task.
     */
    @Test
    public void testGetTaskDueDate() throws ParseException {
        Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        expectedTask = new Task("shopping", "Home", false, dueDate);
        Date actual = expectedTask.getTaskDueDate();
        assertEquals(dueDate, actual);

    }

    /**
     * Test of geTaskStatus method, of class Task.
     */
    @Test
    public void testGetTaskStatus() throws ParseException {
        Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        expectedTask = new Task("shopping", "Home", false, dueDate);
        String expected = "To DO";
        String actual = expectedTask.getTaskStatus();
        assertEquals(expected, actual);

    }

    /**
     * Test of getTaskProject method, of class Task.
     */
    @Test
    public void testGetTaskProject() throws ParseException {

        Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        expectedTask = new Task("shopping", "Home", false, dueDate);
        String actual = "Home";
        String expected = expectedTask.getTaskProject();
        assertEquals(expected, actual);

    }

    /**
     * Test of setTaskStatusDone method, of class Task.
     */
    @Test
    public void testSetTaskStatusDone() throws ParseException {
        Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        expectedTask = new Task("shopping", "Home", false, dueDate);
        expectedTask.setTaskStatusDone();
        String actual = "Done";
        String expected = expectedTask.getTaskStatus();
        assertEquals(expected, actual);

    }

    /**
     * Test of equals method, of class Task. Checks if Title and category of two
     * tasks are equal
     */
    @Test
    public void testEquals() throws ParseException {
        Date dueDate = null;
        dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");

        Task task1 = new Task("shopping", "Home", false, dueDate);
        Task task2 = new Task("shopping", "Home", true, dueDate);
        boolean expResult = true;
        boolean result = task1.equals(task2);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Task. it returns all fields of task as
     * String
     */
    @Test
    public void testToString() throws ParseException {
        Date dueDate = null;
        dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("02/04/2018");

        Task task1 = new Task("shopping", "Home", false, dueDate);
        String expResult = "Shopping           Home          Mon,2 Apr 2018         To DO";
        String result = task1.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of compareTo method, of class Task. It compares task by Due date
     */
    @Test
    public void testCompareTo() throws ParseException {
        Date dueDate = null;
        dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");

        Task task1 = new Task("shopping", "Home", false, dueDate);
        Task task2 = new Task("shopping", "Home", true, dueDate);
        int expResult = task1.getTaskDueDate().compareTo(task2.getTaskDueDate());
        int result = task1.compareTo(task2);
        assertEquals(expResult, result);
    }

}
