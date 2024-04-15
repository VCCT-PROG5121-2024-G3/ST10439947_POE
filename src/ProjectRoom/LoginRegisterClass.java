package ProjectRoom;

import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Amelia ST10439947@vcconnect.edu.za ST10439947
 */
//-------------------------------------------------------------------------------------------------------------------------------------------------    
//This the log-in and register class. as it uses the same variables its easier to put them together
//This class checks the username and password when registering and checks the user's login details and 
//returns the neccessary messages for each scneario.
public class LoginRegisterClass {
//-------------------------------------------------------------------------------------------------------------------------------------------------    
//public global variables for logging in and registerring

    public String userName;
    public String passWord;
    public String[] userNames = new String[100];
    public String[] passWords = new String[100];
    public String[] fullNames = new String[100];
    public int userCount; //what links the usernames, passwords and full names together
    public int userCode = 0;
    public boolean userCheck;
    public boolean isComplex;
    public boolean loginSuccess;
    public String Output;

    //---------------------------------------------------------------------------------------------------------------------------------------------
    // this checks the boolean from loginUser and outputs the correct message for logging in
    public void loginCheck(String userName, String passWord) {

        if (loginSuccess = true) {
            JOptionPane.showMessageDialog(null, "Welcome " + fullNames[userCode] + ", it is great to see you again.");
            //if the uername matches one in the username array
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect please try again!");
            //if the username doesnt match the username array
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------
    //This method verifies that the login details entered matches the login details stored when the user registers.

    public boolean loginUser(String userName1, String passWord1, int i) {
        RegisterFrame register = new RegisterFrame();
        //calls register frame as that is where the variables are recieved

        userName1 = register.userName;
        passWord1 = register.passWord;

        //goes through username and password arrays to find matches
        for (i = 0; i < userCount; i++) {
            if (userNames[i].equals(userName1) && passWords[i].equals(passWord1)) {
                loginSuccess = true;
            } else {
                loginSuccess = false;
            }
        }
        userCode = i; //for the later use for finding the full name
        return loginSuccess;
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------
    //This method ensures that any username contains an underscore and is no more than 5 characters long
    public boolean checkUserName(String userName1) {
        RegisterFrame register = new RegisterFrame();
        //calls method and class as that is where the variables come from

        userName1 = register.userName;
        //checks that username meets criteria when registering
        if (userName1.length() >= 5 && userName1.contains("_")) {
            userCheck = true;
        } else {
            userCheck = false;
        }

        return userCheck;
    }
//------------------------------------------------------------------------------------------------------------------------------------------------
    //This method ensures that passwords meet the password complexity rules

    public boolean checkPasswordComplexity(String passWord1) {
        RegisterFrame register = new RegisterFrame();
        //calls method and class as that is where the variables come from

        passWord1 = register.passWord;

        //checks that password is more than 8 characters
        if (passWord1.length() < 8) {
            isComplex = false;
        } else {
            isComplex = true;
        }

        //checks that password contains a capital letter
        if (!passWord1.matches(".*[A-Z].*")) {
            isComplex = false;
        } else {
            isComplex = true;
        }

        //checks that password contains a number
        if (!passWord1.matches(".*\\d.*")) {
            isComplex = false;
        } else {
            isComplex = true;
        }

        //checks that password contains punctuation
        if (!passWord1.matches(".*[\\p{Punct}].*")) {
            isComplex = false;
        } else {
            isComplex = true;
        }

        return isComplex;
    }
//------------------------------------------------------------------------------------------------------------------------------------------------
    //This method returns the necessary registration messaging

    public String registerUser(String firstName1, String lastName1, String userName1, String passWord1) {
        Output = "User Registered Successfully";
        //for if login is successful

        RegisterFrame register = new RegisterFrame();
        //calls method

        //assigns all variables entered from register frame
        firstName1 = register.firstName;
        lastName1 = register.lastName;
        userName1 = register.userName;
        passWord1 = register.passWord;

        String fullName = firstName1 + " " + lastName1;
        //combines first name and last name

        //outputs if username was formatted correctly or incorrectly when registering
        if (userCheck = true) {
            JOptionPane.showMessageDialog(null, "Username successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your "
                    + "username contains an underscore and is no more than 5 characters in length.");
        }

        //outputs if username was formatted correctly or incorrectly when registering
        if (isComplex = true) {
            JOptionPane.showMessageDialog(null, "Password successfully captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted please ensure that the "
                    + "password contains at least 8 characters, a capital letter, a number and a special character");
        }

        //outputs if username already is on the system
        for (int i = 0; i < userCount; i++) {
            if (userNames[i].equals(userName)) {
                return "Username is already registered.";
            }
        }

        fullNames[userCount] = fullName; //assigns full name to array
        userNames[userCount] = userName1; //assigns username to arrays
        passWords[userCount] = passWord1; //assigns password to arrays

        userCount++; //increases usercount for nxt user registering

        return Output; //outputs that user logs in successfully

    }

//-------------------------------------------------------------------------------------------------------------------------------------------------            
    //This method returns the necessary messaging for if the login was successful or not
    public String returnLoginStatus() {
        return " ";
    }
   //-----------------------------------------------------END OF FILE-----------------------------------------------------------------------   

}
