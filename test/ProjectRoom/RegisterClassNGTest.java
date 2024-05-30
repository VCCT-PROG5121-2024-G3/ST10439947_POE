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
//this class tests specific methods within the register class
public class RegisterClassNGTest {
//----------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Test of checkUserName method, of class RegisterClass.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String username = "kyle!!!!!!!";
        RegisterClass instance = new RegisterClass();
        boolean expResult = false;
        boolean result = instance.checkUserName(username);
        assertEquals(result, expResult);
        //   assertFalse(result, expResult);
        fail("“Username is not correctly formatted, please ensure that your username contains an underscore "
                + "and is no more than 5 characters in length.”");
    }
//----------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Test of checkPasswordComplexity method, of class RegisterClass.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch&&sec@ke99!";
        RegisterClass instance = new RegisterClass();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(result, expResult);
        //    assertTrue(result, expResult);
        fail("Password is not correctly formatted, please ensure that the password contains at least 8 characters, "
                + "a capital letter, a number and a special character.”.");
    }
}
    //-----------------------------------------------------END OF FILE--------------------------------------------------------------------- 
