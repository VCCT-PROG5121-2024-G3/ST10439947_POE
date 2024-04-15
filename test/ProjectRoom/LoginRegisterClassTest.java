/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ProjectRoom;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amelia ST10439947@vcconnect.edu.za ST10439947
 */

public class LoginRegisterClassTest {

    public LoginRegisterClassTest() {
    }

    /**
     * Test of loginCheck method, of class LoginRegisterClass.
     */
    @Test
    public void testLoginCheck() {
        System.out.println("loginCheck");
        String userName = "";
        String passWord = "";
        LoginRegisterClass instance = new LoginRegisterClass();
        instance.loginCheck(userName, passWord);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class LoginRegisterClass.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String userName1 = "kyle_1";
        String passWord1 = "";
        int i = 0;
        LoginRegisterClass instance = new LoginRegisterClass();
        boolean expResult = true;
        boolean result = instance.loginUser(userName1, passWord1, i);
        assertEquals(expResult, result);

    }

    /**
     * Test of checkUserName method, of class LoginRegisterClass.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String userName1 = "“kyle!!!!!!!";
        LoginRegisterClass instance = new LoginRegisterClass();
        boolean expResult = false;
        boolean result = instance.checkUserName(userName1);
        assertEquals(expResult, result);
        
        fail("Username is not correctly formatted, please ensure that your username contains an underscore "
                + "and is no more than 5 characters in length.”.");
    }
    
    /**
     * Test of checkPasswordComplexity method, of class LoginRegisterClass.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String passWord1 = "Ch&&sec@ke99!";
        LoginRegisterClass instance = new LoginRegisterClass();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(passWord1);
        assertEquals(expResult, result);
        
    }
    
    //@Test
    //public void testCheckPasswordComplexity() {
      //  System.out.println("checkPasswordComplexity");
        //String passWord1 = "password";
        //LoginRegisterClass instance = new LoginRegisterClass();
        //boolean expResult = True;
        //boolean result = instance.checkPasswordComplexity(passWord1);
        //assertEquals(expResult, result);
        //fail(Password is not correctly formatted, please ensure that the password contains at least 8 characters, 
        //a capital letter, a number and a special character.”
        
    

    /**
     * Test of registerUser method, of class LoginRegisterClass.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String firstName1 = "";
        String lastName1 = "";
        String userName1 = "";
        String passWord1 = "";
        LoginRegisterClass instance = new LoginRegisterClass();
        String expResult = "";
        String result = instance.registerUser(firstName1, lastName1, userName1, passWord1);
        assertEquals(expResult, result);
       
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnLoginStatus method, of class LoginRegisterClass.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        LoginRegisterClass instance = new LoginRegisterClass();
        String expResult = "";
        String result = instance.returnLoginStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
