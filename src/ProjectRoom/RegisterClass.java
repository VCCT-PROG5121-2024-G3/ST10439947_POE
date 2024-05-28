package ProjectRoom;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/**
 *
 * @author Amelia ST10439947@vcconnect.edu.za ST10439947
 */
public class RegisterClass {
//-------------------------------------------------------------------------------------------------------------------------------------------------

    public String firstName;
    public String lastName;
    public String userName;
    public String passWord;

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField userNameField;
    private JTextField passWordField;
    //----------------------------------------------------------------------------------------------------------------------------------------------

    private JPanel createRegisterPanel() {
        JPanel registerPanel = new JPanel(new GridLayout(5, 2));

        registerPanel.setPreferredSize(new Dimension(600, 150));

        BoxLayout layout = new BoxLayout(registerPanel, BoxLayout.Y_AXIS);
        registerPanel.setLayout(layout);

        JLabel firstNameLabel = new JLabel("First Name: ");
        firstNameField = new JTextField();
        registerPanel.add(firstNameLabel);

        registerPanel.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name: ");
        lastNameField = new JTextField();
        registerPanel.add(lastNameLabel);
        registerPanel.add(lastNameField);

        JLabel userNameLabel = new JLabel("Username: \n(Must be less than 5 characters "
                + "\n& contain an underscore)");
        userNameField = new JTextField();
        registerPanel.add(userNameLabel);
        registerPanel.add(userNameField);

        JLabel passWordLabel = new JLabel("Password: \n(Must be at least 8 characters in length, "
                + "\ninclude a number, & include a special character)");
        passWordField = new JTextField();
        registerPanel.add(passWordLabel);
        registerPanel.add(passWordField);

        return registerPanel;
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------

    public void RegisterScreen() {

        ImageIcon butterfly = new ImageIcon("Pics/butterfly.png");
        //   ImageIcon plant = new ImageIcon("Pics/plant.png");

        while (true) {
            JPanel registerPanel = createRegisterPanel();

            int result = JOptionPane.showConfirmDialog(null, registerPanel, "Please enter your details: ",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, butterfly);

            if (result == JOptionPane.OK_OPTION) {
                firstName = firstNameField.getText();
                lastName = lastNameField.getText();
                userName = userNameField.getText();
                passWord = passWordField.getText();

                String registerResult = RegisterUser();
                ImageIcon purple = new ImageIcon("Pics/purple.png");

                JOptionPane.showMessageDialog(null, registerResult, "Register", JOptionPane.DEFAULT_OPTION, purple);

                if (registerResult.equals("Registration Completed!")) {
                    LoginClass login = new LoginClass();

                    login.LoginScreen();

                    break;

                }

            } else {
                break;

            }

        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------

    public boolean checkUserName(String username) {
        ImageIcon stars = new ImageIcon("Pics/stars.png");
        ImageIcon error = new ImageIcon("Pics/error.png");

        if (username.length() <= 5 && username.contains("_")) {
            JOptionPane.showMessageDialog(null, "Username successfully captured!", "Username",
                    JOptionPane.DEFAULT_OPTION, stars);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, \nplease ensure that "
                    + "your username contains an underscore and is no more than 5 characters in length.",
                    "Username", JOptionPane.DEFAULT_OPTION, error);
            return false;
        }

    }
//-------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean checkPasswordComplexity(String password) {

        boolean hasUppercase = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasLowercase = Pattern.compile("[a-z]").matcher(password).find();
        boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasSpecialChar = Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();

        ImageIcon stars = new ImageIcon("Pics/stars.png");
        ImageIcon error = new ImageIcon("Pics/error.png");

        if (password.length() >= 8 && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            JOptionPane.showMessageDialog(null, "Password successfully captured!", "Password",
                    JOptionPane.DEFAULT_OPTION, stars);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "“Password is not correctly formatted please ensure that "
                    + "\nthe password contains at least 8 characters, a capital letter, "
                    + "\na number and a special character.”.",
                    "Username", JOptionPane.DEFAULT_OPTION, error);
            return false;
        }

    }
//-------------------------------------------------------------------------------------------------------------------------------------------------

    public String RegisterUser() {

        boolean userCheck = checkUserName(userName);
        boolean passwordCheck = checkPasswordComplexity(passWord);

        if (userCheck && passwordCheck) {
            return "Registration Completed!";
        }
        return "Registration Failed!";
    }
//----------------------------------------------------END---OF---FILE----------------------------------------------------------------------    
    //form for user to fill in

    //public boolean checkUserName() 
    //while checkUserName() == false
    //make user reneter details
    //public boolean checkPasswordComplexity()
    //while checkpassword() == false
    //make user reneter details
    //public String registerUser() 
    // if user name AND password ==  TRUE then loginclass()
}
