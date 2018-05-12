package ToDoListModel;

import Controller.Task;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
 * Test file to test Test manager class
 *
 */
public class TaskManagerTest {

    TaskManager taskManager;
    Task expectedTask;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public TaskManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        taskManager = new TaskManager();
    }

    @After
    public void tearDown() {
    }

    /**
     * set up stream to test print statement
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    /**
     * Test of createTask method, of class TaskManager.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testCreateTask() throws ParseException {
        Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        Task createdTask = taskManager.createTask("shopping", "Home", false, dueDate);
        Task expectedTask = new Task("shopping", "Home", false, dueDate);
        assertEquals(expectedTask, createdTask);

    }

    /**
     * Test of addTask method, of class TaskManager.
     */
    @Test
    public void testAddTask() throws ParseException {
        Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        Task createdTask = taskManager.createTask("shopping", "Home", false, dueDate);
        boolean isTaskAdded = taskManager.addTask(createdTask);
        assertEquals(true, isTaskAdded);

    }

    /**
     * Test of addTask method, of class TaskManager.
     */
    @Test
    public void testAddDuplicateTask() throws ParseException {
        Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        Task createdTask = taskManager.createTask("shopping", "Home", false, dueDate);
        boolean isTaskAdded = taskManager.addTask(createdTask);
        Boolean IfTaskExists = taskManager.checkIfTaskExists((Task) createdTask);
        boolean isSameTaskAdded = taskManager.addTask(createdTask);
        assertEquals(false, isSameTaskAdded);

    }

    /**
     * Test of updateTask method, of class TaskManager.
     */
    @Ignore
    public void testUpdateTask() {
        System.out.println("updateTask");
        Task oldTask = null;
        Task updatedTask = null;
        TaskManager instance = new TaskManager();
        instance.updateTask(oldTask, updatedTask);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTask method, of class TaskManager.
     */
    @Test
    public void testDeleteTask() throws ParseException {
        Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        Task createdTask = taskManager.createTask("shopping", "Home", false, dueDate);
        boolean isTaskAdded = taskManager.addTask(createdTask);
        taskManager.deleteTask(createdTask);
        boolean IfTaskExists = taskManager.checkIfTaskExists((Task) createdTask);

        assertEquals(false, IfTaskExists);

    }

    /**
     * Test of displayAll method, of class TaskManager.
     */
    @Test
    public void testDisplayAll() {
        taskManager.displayAll();
        String expected = "Here goes the Tasks list";
        String actual = outContent.toString();

        boolean isExist = actual.contains(expected);
        assertTrue(isExist);
    }

    /**
     * Test of saveToFile method, of class TaskManager.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testSaveToFile() throws ParseException {
        Date dueDate = null;
        dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");

        Task createdTask = taskManager.createTask("shopping", "Home", false, dueDate);
        taskManager.addTask(createdTask);
        taskManager.saveToFile();
        testInitilizeSavedTaskList();
        String expected = "Shopping           Home          Sat,1 Dec 2018         To DO";
        String actual = outContent.toString();

        boolean isExist = actual.contains(expected);
        assertTrue(isExist);
    }

    /**
     * Test of sortByProject method, of class TaskManager.
     */
    @Ignore
    public void testSortByProject() {
        System.out.println("sortByProject");
        TaskManager instance = new TaskManager();
        instance.sortByProject();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortByDate method, of class TaskManager.
     */
    @Ignore
    public void testSortByDate() {
        System.out.println("sortByDate");
        TaskManager instance = new TaskManager();
        instance.sortByDate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testInitilizeSavedTaskList() {
        taskManager.initializeListFromFile();
    }

    /**
     * Test of checkIfTaskExists method, of class TaskManager.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testCheckIfTaskExists() throws ParseException {
        Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        Task createdTask = taskManager.createTask("shopping", "Home", false, dueDate);
        taskManager.addTask(createdTask);
        boolean ifTaskExists = taskManager.checkIfTaskExists((Task) createdTask);
        assertEquals(true, ifTaskExists);

    }

    /**
     * Test of selectGivenTask method, of class TaskManager.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testSelectGivenTask() throws ParseException {
        Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        Task createdTask = taskManager.createTask("shopping", "Home", false, dueDate);
        Task expected = createdTask;
        taskManager.addTask(createdTask);
        Task result = taskManager.selectGivenTask("shopping", "Home");
        assertEquals(expected, result);

    }

    /**
     * Test of markAsDone method, of class TaskManager.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testMarkAsDone() throws ParseException {
        {
            Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
            Task createdTask = taskManager.createTask("shopping", "Home", false, dueDate);
            taskManager.addTask(createdTask);
            taskManager.markAsDone((Task) createdTask);
            String result = ((Task) createdTask).getTaskStatus();
            assertEquals("Done", result);

        }
    }

}
