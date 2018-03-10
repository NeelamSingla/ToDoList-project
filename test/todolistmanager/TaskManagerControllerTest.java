/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistmanager;

import java.util.Date;
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of enterTaskDetails method, of class TaskManagerController.
     */
    @Test
    public void testEnterTaskDetails() {
       // System.out.println("enterTaskDetails");
       // TaskManagerController instance = new TaskManagerController();
       // Object expResult = null;
       // Object result = instance.enterTaskDetails();
        //assertEquals(expResult, result);
        
    }

    /**
     * Test of addTask method, of class TaskManagerController.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        Task t= new Task("dummyTask",new Date("02/02/2018"),true,"dummyProject");
        TaskManagerController instance = new TaskManagerController();
        instance.addTask(t);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of displayAll method, of class TaskManagerController.
     */
    @Test
    public void testDisplayAll() {
        System.out.println("displayAll");
        TaskManagerController instance = new TaskManagerController();
        instance.displayAll();
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
