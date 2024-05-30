/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package ProjectRoom;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
//----------------------------------------------------------------------------------------------------------------------------------------------

/**
 *
 * @author Amelia ST10439947@vcconnect.edu.za ST10439947
 */
//----------------------------------------------------------------------------------------------------------------------------------------------
public class TaskClassNGTest {
//this tests specific methods within the task class
//----------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Test of checkTaskDescription method, of class TaskClass.
     */
    @Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");
        TaskClass instance = new TaskClass();
        String taskDescription = "Create Login to authenticate users";
        boolean expResult = true;
        boolean result = instance.checkTaskDescription();
        assertEquals(result, expResult);
        //success("Task successfully captured");
        fail("Please enter a task description of less than 50 characters”");
    }
//----------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Test of createTaskID method, of class TaskClass.
     */
    @Test
    public void testCreateTaskID() {
        System.out.println("createTaskID");
        String taskName = "Login Feature";
        String taskDeveloper = "Robyn Harrison";
        int numTasks = 2;
        TaskClass instance = new TaskClass();
        String expResult = "LO:2:SON";
        String result = instance.createTaskID(taskName, taskDeveloper, numTasks);
        assertEquals(result, expResult);
        //Other test results: CR:0:IKE, CR:1:ARD, CR:2:THA, CR:3:ND
    }

    /*
      @Test
    public void testCreateTaskID() {
        System.out.println("createTaskID");
        String taskName = "Add Task Feature”";
        String taskDeveloper = "Mike Smith";
        int numTasks = 0;
        TaskClass instance = new TaskClass();
        String expResult = "LO:2:SON";
        String result = instance.createTaskID(taskName, taskDeveloper, numTasks);
        assertEquals(result, expResult);
   
        fail("The test case is a prototype.");
    }
     */
//----------------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Test of returnTotalHours method, of class TaskClass.
     */
    @Test
    public void testReturnTotalHours() {
        System.out.println("returnTotalHours");
        TaskClass instance = new TaskClass();
        int expResult = 0;
        //int taskDuration[5] = 10, 12, 55, 11, 1; 
        int result = instance.returnTotalHours();
        assertEquals(result, expResult);
    }
}
  //-----------------------------------------------------END OF FILE-----------------------------------------------------------------------   
