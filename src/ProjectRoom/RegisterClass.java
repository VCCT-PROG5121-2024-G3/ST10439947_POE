package ProjectRoom;

//imports needed for the custom panel creation and the pattern recognition for "checkPasswordComplexity"
import java.awt.*;
import javax.swing.*;
import java.util.regex.Pattern;
//----------------------------------------------------------------------------------------------------------------------------------------------

/**
 *
 * @author Amelia ST10439947@vcconnect.edu.za ST10439947
 */
//----------------------------------------------------------------------------------------------------------------------------------------------
//this class shows the user the registration form and checks all the relevent info
public class RegisterClass {
//----------------------------------------------------------------------------------------------------------------------------------------------
//Global variables for the information enetered by the user when registering

    public String firstName;
    public String lastName;
    public String userName;
    public String passWord;

    public JTextField firstNameField;
    public JTextField lastNameField;
    private JTextField userNameField;
    private JTextField passWordField;

//----------------------------------------------------------------------------------------------------------------------------------------------
//this method creates the Register Form that the user uses to save all their information
//it custom sets the labels, textfields, and size of the panel. 
    private JPanel createRegisterPanel() {

        //sets the layout of the panel
        JPanel registerPanel = new JPanel(new GridLayout(5, 2));

        //sets preferred dimensions of the panel
        registerPanel.setPreferredSize(new Dimension(600, 150));

        //sets the layout of tte text and textfields within the panel
        BoxLayout layout = new BoxLayout(registerPanel, BoxLayout.Y_AXIS);
        registerPanel.setLayout(layout);

        //creates the variables used for the label and textbox for the first name field
        //adds the components to the panel
        JLabel firstNameLabel = new JLabel("First Name: ");
        firstNameField = new JTextField();
        registerPanel.add(firstNameLabel);
        registerPanel.add(firstNameField);

        //creates the variables used for the label and textbox for the last name field
        //adds the components to the panel
        JLabel lastNameLabel = new JLabel("Last Name: ");
        lastNameField = new JTextField();
        registerPanel.add(lastNameLabel);
        registerPanel.add(lastNameField);

        //creates the variables used for the label and textbox for the username field
        //adds the components to the panel
        JLabel userNameLabel = new JLabel("Username: \n(Must be less than 5 characters "
                + "\n& contain an underscore)");
        userNameField = new JTextField();
        registerPanel.add(userNameLabel);
        registerPanel.add(userNameField);

        //creates the variables used for the label and textbox for the password field
        //adds the components to the panel
        JLabel passWordLabel = new JLabel("Password: \n(Must be at least 8 characters in length, "
                + "\ninclude a number, & include a special character)");
        passWordField = new JTextField();
        registerPanel.add(passWordLabel);
        registerPanel.add(passWordField);

        return registerPanel;
    }
//----------------------------------------------------------------------------------------------------------------------------------------------

//This calls the register form and saves all the data entered by the user, 
//it then shows the user that they registered successfully if their details were all formatted correctly 
//then calls the login class
    public void RegisterScreen() {

        //custom image for the JOptionPane
        ImageIcon butterfly = new ImageIcon("Pics/butterfly.png");

        //while loop that makes sure it pops up again if the user incorrectly formatted their information
        while (true) {
            //calls the custom panel
            JPanel registerPanel = createRegisterPanel();

            //asks the user to input their information
            int result = JOptionPane.showConfirmDialog(null, registerPanel, "Please enter your details: ",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, butterfly);

            //checks that user pressed "ok" button, then saves their information
            if (result == JOptionPane.OK_OPTION) {
                firstName = firstNameField.getText();
                lastName = lastNameField.getText();
                userName = userNameField.getText();
                passWord = passWordField.getText();

                //calls and saves the RegisterUser() method to display the corresponding message 
                //to tell the user if they successfully registered
                String registerResult = RegisterUser();
                ImageIcon purple = new ImageIcon("Pics/purple.png");

                JOptionPane.showMessageDialog(null, registerResult, "Register",
                        JOptionPane.DEFAULT_OPTION, purple);

                //if the user successfully registered, it calls the login class and returns the variables needed
                if (registerResult.equals("Registration Completed!")) {
                    LoginClass login = new LoginClass(firstName, lastName, userName, passWord);

                    login.LoginScreen();

                    break;
                }
            } else {
                break;
            }
        }
    }

//---------------------------------------------------------------------------------------------------------------------------------------------
//this method checks that the username is 5 characters or less and includes an underscore
//It shows a message if the user formats it correctly or incorrectly
//it also returns a boolean accordingly
    public boolean checkUserName(String username) {

        //custom images
        ImageIcon stars = new ImageIcon("Pics/stars.png");
        ImageIcon error = new ImageIcon("Pics/error.png");

        //specific messages based on if the user formatted correctly or not
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

//----------------------------------------------------------------------------------------------------------------------------------------------
//this method checks that the password is at least 8 characters long, includes an uppercase letter, 
//includes a number, and includes a special character
//It shows a message if the user formats it correctly or incorrectly
//it also returns a boolean accordingly
    public boolean checkPasswordComplexity(String password) {
        //checks if the password contains the needed specifics by using a pattern matcher, and returns as a boolean
        boolean hasUppercase = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasLowercase = Pattern.compile("[a-z]").matcher(password).find();
        boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasSpecialChar = Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();

        //custom images
        ImageIcon stars = new ImageIcon("Pics/stars.png");
        ImageIcon error = new ImageIcon("Pics/error.png");

        //checks if that all the booleans are correct that it shows the right success message, 
        //else it will show a fail message
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

//----------------------------------------------------------------------------------------------------------------------------------------------
//this method returns a string based on if the user correctly formatted all of their information
//this method tells the user that they have been registered successfully or not
    public String RegisterUser() {

        //retrieves the booleans from the checkUsername method and the checkPasswordComplexity Method
        boolean userCheck = checkUserName(userName);
        boolean passwordCheck = checkPasswordComplexity(passWord);

        //returns the according string if both boolean are true
        if (userCheck && passwordCheck) {
            return "Registration Completed!";
        }
        return "Registration Failed!";
    }
}
    //-----------------------------------------------------END OF FILE---------------------------------------------------------------------
