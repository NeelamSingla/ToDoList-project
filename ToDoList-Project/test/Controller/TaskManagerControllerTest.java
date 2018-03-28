package Controller;

import ToDoListModel.Task;
import ToDoListModel.TaskManager;
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

/**
 * Test file to Test TestManager controller file
 *
 */
public class TaskManagerControllerTest {

    TaskManager taskManager;
    TaskManagerController taskManagerController;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public TaskManagerControllerTest() {

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
        taskManagerController = new TaskManagerController();
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
     * Test of enterTaskDetails method, of class TaskManagerController.
     */
    @Test
    public void testEnterTaskDetailsForInvalidDate() {
        try {

            Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01");
            Object CreatedTask = taskManager.createTask("shopping", "Home", false, dueDate);
            fail("Invalid Date");
        } catch (InputMismatchException | ParseException e) {
        }

    }

    /**
     * Test of addTask method, of class TaskManagerController.
     */
    @Test
    public void testAddTask() {
        try {
            Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
            Object CreatedTask = taskManager.createTask("shopping", "Home", false, dueDate);
            String actual, expected = "Task is added in TODO List";
            taskManagerController.addTask(CreatedTask);
            Boolean IfTaskExists = taskManager.checkIfTaskExists((Task) CreatedTask);
            if (!IfTaskExists) {
                actual = "Task is added in TODO List";
            } else {
                actual = "Task is already present in TODO List";
            }
            assertEquals(expected, actual);
        } catch (InputMismatchException | ParseException e) {
        }
        // TODO review the generated test code and remove the default call to fail.

        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testAddTaskforDuplicateTask() {
        try {
            Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
            Object CreatedTask = taskManager.createTask("shopping", "Home", false, dueDate);
            String actual, expected = "Task is already present in TODO List";

            taskManagerController.addTask(CreatedTask);
            Boolean IfTaskExists = taskManager.addTask(CreatedTask);
            if (!IfTaskExists) {
                actual = "Task is added in TODO List";
            } else {
                actual = "Task is already present in TODO List";
            }
            assertEquals(expected, actual);
        } catch (InputMismatchException | ParseException e) {
        }
        // TODO review the generated test code and remove the default call to fail.

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of displayAll method, of class TaskManagerController.
     */
    @Test
    public void testDisplayAll() {
        taskManagerController.displayAll();
        String expected = "Here goes the Tasks list";
        String actual = outContent.toString();

        boolean isExist = actual.contains(expected);
        assertTrue(isExist);
    }

    /**
     * Test of editTaskDetails method, of class TaskManagerController.
     */
    @Test
    public void testEditTaskDetails() {
        try {
            Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
            Object CreatedTask = taskManager.createTask("shopping", "Home", false, dueDate);
            String actual, expected = "Personal";
            taskManagerController.addTask(CreatedTask);
            String UpdatedCategory="Personal";
            Object updated=taskManagerController.updateTaskByCategory(CreatedTask, UpdatedCategory);
            actual= ((Task)updated).getTaskProject();
            assertEquals(expected, actual);
        } catch (InputMismatchException | ParseException e) {
        }

    }

    /**
     * Test of saveToFile method, of class TaskManagerController.
     */
    @Test
    public void testSaveToFile() {
        TaskManagerController instance = new TaskManagerController();
       Date dueDate = null;
        try {
            dueDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        } catch (ParseException ex) {
            Logger.getLogger(TaskManagerControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            Object CreatedTask = instance.createTask("shopping", "Home", false, dueDate);
            instance.addTask(CreatedTask);
        instance.saveToFile();
        testInitilizeSavedTaskList();
        String expected = "Shopping           Home          Sat,1 Dec 2018         To DO";
        String actual = outContent.toString();

        boolean isExist = actual.contains(expected);
        assertTrue(isExist);

    }

    /**
     * Test of sortByDate method, of class TaskManagerController.
     */
    @Test
    public void testSortByDate() {
        System.out.println("sortByDate");
        TaskManagerController instance = new TaskManagerController();
        instance.sortByDate();

    }

    /**
     * Test of sortByProject method, of class TaskManagerController.
     */
    @Test
    public void testSortByProject() {
        System.out.println("sortByProject");
        TaskManagerController instance = new TaskManagerController();
        instance.sortByProject();
    }

    /**
     * Test of InitilizeSavedTaskList method, of class TaskManagerController.
     */
    @Test
    public void testInitilizeSavedTaskList() {
        TaskManagerController instance = new TaskManagerController();
        instance.InitilizeSavedTaskList();
    }

}
