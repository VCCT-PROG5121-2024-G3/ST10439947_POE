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
public class LoginClassNGTest {
//This tests a specific method within login class
//----------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Test of LoginUser method, of class LoginClass.
     */
    @Test
    public void testLoginUser() {
        System.out.println("LoginUser");
        String username = "kyl_1";
        String password = "";
        LoginClass instance = null;
        boolean expResult = true;
        boolean result = instance.LoginUser(username, password);
        assertEquals(result, expResult);
        //    assertTrue(result, expResult);
    }
}
    //-------------------------------------------------------------------------END OF FILE------------------------------------------------- 
