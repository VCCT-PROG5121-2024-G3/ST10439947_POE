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
//This class checks the username and password when registering and checks the user's login details and 
//returns the neccessary messages for each scneario.
public class LoginRegisterClass {
//-------------------------------------------------------------------------------------------------------------------------------------------------    

    public String userName;
    public String passWord;
    public String[] userNames = new String[100];
    public String[] passWords = new String[100];
    public String[] fullNames = new String[100];
    public int userCount = 0;
    public int userCode = 0;
    public boolean userCheck;
    public boolean isComplex;
    public boolean loginSuccess;
    public String Output;

    //---------------------------------------------------------------------------------------------------------------------------------------------
    public void loginCheck(String userName, String passWord) {

        if (loginSuccess = true) {
            JOptionPane.showMessageDialog(null, "Welcome " + fullNames[userCode] + ", it is great to see you again.");
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect please try again!");
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------
    //This method verifies that the login details entered matches the login details stored when the user registers.

    public boolean loginUser(String userName1, String passWord1, int i) {
        RegisterFrame register = new RegisterFrame();

        userName1 = register.userName;
        passWord1 = register.passWord;

        for (i = 0; i < userCount; i++) {
            if (userNames[i].equals(userName1) && passWords[i].equals(passWord1)) {
                loginSuccess = true;
            } else {
                loginSuccess = false;
            }
        }
        userCode = i;
        return loginSuccess;
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------
    //This method ensures that any username contains an underscore and is no more than 5 characters long
    public boolean checkUserName(String userName1) {
        RegisterFrame register = new RegisterFrame();

        userName1 = register.userName;

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

        passWord1 = register.passWord;

        if (passWord1.length() < 8) {
            isComplex = false;
        } else {
            isComplex = true;
        }

        if (!passWord1.matches(".*[A-Z].*")) {
            isComplex = false;
        } else {
            isComplex = true;
        }

        if (!passWord1.matches(".*\\d.*")) {
            isComplex = false;
        } else {
            isComplex = true;
        }

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

        RegisterFrame register = new RegisterFrame();

        firstName1 = register.firstName;
        lastName1 = register.lastName;
        userName1 = register.userName;
        passWord1 = register.passWord;

        String fullName = firstName1 + " " + lastName1;

        if (userCheck = true) {
            JOptionPane.showMessageDialog(null, "Username successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your "
                    + "username contains an underscore and is no more than 5 characters in length.");
        }

        if (isComplex = true) {
            JOptionPane.showMessageDialog(null, "Password successfully captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted please ensure that the "
                    + "password contains at least 8 characters, a capital letter, a number and a special character");
        }

        for (int i = 0; i < userCount; i++) {
            if (userNames[i].equals(userName)) {
                return "Username is already registered.";
            }
        }

        fullNames[userCount] = fullName;
        userNames[userCount] = userName1;
        passWords[userCount] = passWord1;

        userCount++;

        return Output;

    }

//-------------------------------------------------------------------------------------------------------------------------------------------------            
    //This method returns the necessary messaging for if the login was successful or not
    public String returnLoginStatus() {
        return " ";
    }

}
