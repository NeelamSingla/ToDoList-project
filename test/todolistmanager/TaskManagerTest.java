/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistmanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author tmp-sda-1160
 */
public class TaskManagerTest {
    
    TaskManager taskManager;
    Task expectedTask;
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
     * Test of createTask method, of class TaskManager.
     */
    @Test
    public void testCreateTask() {
        try{
        Date dueDate =new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        Object CreatedTask = taskManager.createTask("shopping","Home",false,dueDate);
        expectedTask = new Task("shopping","Home",false,dueDate);
        assertEquals(CreatedTask, CreatedTask);
        }
        catch (InputMismatchException e) {
        }
        catch (ParseException ex) {
         } 
    }

    /**
     * Test of addTask method, of class TaskManager.
     */
    @Test
    public void testAddTask() {
        try{
        Date dueDate =new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        Object CreatedTask = taskManager.createTask("shopping","Home",false,dueDate);
        boolean isTaskAdded = taskManager.addTask(CreatedTask);
        assertEquals(true, isTaskAdded);
        }
        catch (InputMismatchException e) {
        }
        catch (ParseException ex) {
         } 
    }
    
    /**
     * Test of addTask method, of class TaskManager.
     */
    @Test
    public void testAddDuplicateTask() {
        try{
        Date dueDate =new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        Object CreatedTask = taskManager.createTask("shopping","Home",false,dueDate);
        boolean isTaskAdded = taskManager.addTask(CreatedTask);
        Boolean IfTaskExists = taskManager.checkIfTaskExists((Task)CreatedTask);
        boolean isSameTaskAdded = taskManager.addTask(CreatedTask);
        assertEquals(false, isSameTaskAdded);
        }
        catch (InputMismatchException e) {
        }
        catch (ParseException ex) {
         } 
    }


    /**
     * Test of updateTask method, of class TaskManager.
     */
    @Ignore
    public void testUpdateTask() {
        System.out.println("updateTask");
        Object oldTask = null;
        Object updatedTask = null;
        TaskManager instance = new TaskManager();
        instance.updateTask(oldTask, updatedTask);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTask method, of class TaskManager.
     */
    @Test
    public void testDeleteTask() {
          try{
        Date dueDate =new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        Object CreatedTask = taskManager.createTask("shopping","Home",false,dueDate);
        boolean isTaskAdded = taskManager.addTask(CreatedTask);
        taskManager.deleteTask(CreatedTask);
        Boolean IfTaskExists = taskManager.checkIfTaskExists((Task)CreatedTask);
        
        assertEquals(false, IfTaskExists);
        }
        catch (InputMismatchException e) {
        }
        catch (ParseException ex) {
         } 
    }

    /**
     * Test of displayAll method, of class TaskManager.
     */
    @Ignore
    public void testDisplayAll() {
        System.out.println("displayAll");
        TaskManager instance = new TaskManager();
        instance.displayAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveToFile method, of class TaskManager.
     */
    @Ignore
    public void testSaveToFile() {
        System.out.println("saveToFile");
        TaskManager instance = new TaskManager();
        instance.saveToFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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

    /**
     * Test of initializeListFromFile method, of class TaskManager.
     */
    @Ignore
    public void testInitializeListFromFile() {
        System.out.println("initializeListFromFile");
        TaskManager instance = new TaskManager();
        instance.initializeListFromFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIfTaskExists method, of class TaskManager.
     */
     @Test
    public void testCheckIfTaskExists() {
        try{
        Date dueDate =new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        Object CreatedTask = taskManager.createTask("shopping","Home",false,dueDate);
        boolean isTaskAdded = taskManager.addTask(CreatedTask);
        Boolean IfTaskExists = taskManager.checkIfTaskExists((Task)CreatedTask);
        assertEquals(true, IfTaskExists);
        }
        catch (InputMismatchException e) {
        }
        catch (ParseException ex) {
         } 
    }

    /**
     * Test of selectGivenTask method, of class TaskManager.
     */
     @Test
    public void testSelectGivenTask() {
         try{
        Date dueDate =new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        Object CreatedTask = taskManager.createTask("shopping","Home",false,dueDate);
        boolean isTaskAdded = taskManager.addTask(CreatedTask);
        Task expected=(Task)CreatedTask;
        Task result = taskManager.selectGivenTask("shopping","Home");
        assertEquals(expected, result);
        }
        catch (InputMismatchException e) {
        }
        catch (ParseException ex) {
         } 
    }

    /**
     * Test of markAsDone method, of class TaskManager.
     */
     @Test
    public void testMarkAsDone() {
        {
          try{
        Date dueDate =new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        Object CreatedTask = taskManager.createTask("shopping","Home",false,dueDate);
        boolean isTaskAdded = taskManager.addTask(CreatedTask);
        taskManager.markAsDone((Task)CreatedTask);
        String result=((Task)CreatedTask).getTaskStatus();
        assertEquals("Done", result);
        }
        catch (InputMismatchException e) {
        }
        catch (ParseException ex) {
         } 
    }
    }
    
}
