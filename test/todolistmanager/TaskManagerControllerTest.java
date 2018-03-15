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

/**
 *
 * @author Mukesh
 */
public class TaskManagerControllerTest {
    
     TaskManager taskManager;
     TaskManagerController taskManagerController;
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
     * Test of enterTaskDetails method, of class TaskManagerController.
     */
    @Test
    public void testEnterTaskDetailsForInvalidDate() {
        try{
          
         Date dueDate =new SimpleDateFormat("dd/MM/yyyy").parse("01");
        Object CreatedTask = taskManager.createTask("shopping","Home",false,dueDate);
        fail("Invalid Date");
        }
        catch (InputMismatchException e) {
        }
        catch (ParseException ex) {
           
                  
        } 
        
    }
    
    

    /**
     * Test of addTask method, of class TaskManagerController.
     */
    @Test
    public void testAddTask() {
        try{
       Date dueDate =new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        Object CreatedTask = taskManager.createTask("shopping","Home",false,dueDate);
        String actual,expected= "Task is added in TODO List";
        taskManagerController.addTask(CreatedTask);
        Boolean IfTaskExists = taskManager.checkIfTaskExists((Task)CreatedTask);
        if(!IfTaskExists)
         actual = "Task is added in TODO List";
        else
          actual = "Task is already present in TODO List";
        assertEquals(expected, actual);
        }
        catch (InputMismatchException e) {
        }
        catch (ParseException ex) {
         } 
        // TODO review the generated test code and remove the default call to fail.
        
    }

     @Test
    public void testAddTaskforDuplicateTask() {
        try{
       Date dueDate =new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2018");
        Object CreatedTask = taskManager.createTask("shopping","Home",false,dueDate);
        String actual,expected= "Task is already present in TODO List";
        
        taskManagerController.addTask(CreatedTask);
         Boolean IfTaskExists = taskManager.addTask(CreatedTask);
      if(!IfTaskExists)
         actual = "Task is added in TODO List";
        else
          actual = "Task is already present in TODO List";
        assertEquals(expected, actual);
        }
        catch (InputMismatchException e) {
        }
        catch (ParseException ex) {
         } 
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of displayAll method, of class TaskManagerController.
     */
    @Test
    public void testDisplayAll() {
        taskManagerController.displayAll();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of editTaskDetails method, of class TaskManagerController.
     */
    @Test
    public void testEditTaskDetails() {
       // System.out.println("editTaskDetails");
       // TaskManagerController instance = new TaskManagerController();
       // instance.editTaskDetails();
        
    }

    /**
     * Test of saveToFile method, of class TaskManagerController.
     */
    @Test
    public void testSaveToFile() {
        System.out.println("saveToFile");
        TaskManagerController instance = new TaskManagerController();
        instance.saveToFile();
       
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
        System.out.println("InitilizeSavedTaskList");
        TaskManagerController instance = new TaskManagerController();
        instance.InitilizeSavedTaskList();
    }
    
}
