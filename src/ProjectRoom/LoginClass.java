package ProjectRoom;

//imports needed for the custom panels
import java.awt.*;
import javax.swing.*;
//----------------------------------------------------------------------------------------------------------------------------------------------

/**
 *
 * @author Amelia ST10439947@vcconnect.edu.za ST10439947
 */

//----------------------------------------------------------------------------------------------------------------------------------------------  
//This the log-in class and it helps the user login, as well as check the details they enetered
//This class also returns the neccessary messages for each scneario
public class LoginClass {
//----------------------------------------------------------------------------------------------------------------------------------------------
//these Global variables are used from the custom form that the user fills in, as well as the login message

    public JTextField userNameField;
    public JTextField passWordField;

    private final String registerFirstName;
    private final String registerLastName;
    private final String registerUserName;
    private final String registerPassWord;

    private String loginSuccess;
    private String loginFail;

//----------------------------------------------------------------------------------------------------------------------------------------------
    //this gets the info entered by the user and saves it to be used throughout the class
    public LoginClass(String firstName, String lastName, String userName, String passWord) {
        this.registerFirstName = firstName;
        this.registerLastName = lastName;
        this.registerUserName = userName;
        this.registerPassWord = passWord;
    }

//----------------------------------------------------------------------------------------------------------------------------------------------
//this method creates the panel used for the login details
//it specifies the size of the main panel and creates custom labels and textboxes for logging in
    public JPanel createLoginPanel() {
        //this creates the layout to be used on the panel
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));

        //sets the panels preferred dimensions
        loginPanel.setPreferredSize(new Dimension(250, 100));

        //sets the layout to be used for the lbels and textfields
        BoxLayout layout = new BoxLayout(loginPanel, BoxLayout.Y_AXIS);
        loginPanel.setLayout(layout);

        //creates the variables for the label and textfield that the username will use
        //also adds them to the panel
        JLabel userNameLabel = new JLabel("Username: ");
        userNameField = new JTextField();
        loginPanel.add(userNameLabel);
        loginPanel.add(userNameField);

        //creates the variables for the label and textfield that the password will use
        //also adds them to the panel
        JLabel passWordLabel = new JLabel("Password: ");
        passWordField = new JTextField();
        loginPanel.add(passWordLabel);
        loginPanel.add(passWordField);

        return loginPanel;
    }

//----------------------------------------------------------------------------------------------------------------------------------------------
//this method shows the custom login panel to the user, prompting them to enter their login details
//it then saves the typed in information and calls the next methods
//it displays the loginUser string that tells the user if their username and password matches what 
//they typed in the registration form
//afterwards, it calls the task class
    public void LoginScreen() {

        //custom images
        ImageIcon pinkflower = new ImageIcon("Pics/pinkflower.png");
        ImageIcon error = new ImageIcon("Pics/error.png");
        ImageIcon stars = new ImageIcon("Pics/stars.png");

        //calls the custom login page
        JPanel loginPanel = createLoginPanel();

        //shows the JOptionPane for the login and asks the user to log in
        int result = JOptionPane.showConfirmDialog(null, loginPanel, "Please enter your Login Details",
                JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, pinkflower);

        //checks that the user pressed the "ok" button, then saves the information they entered
        if (result == JOptionPane.OK_OPTION) {
            String userNameLogin = userNameField.getText();
            String passWordLogin = passWordField.getText();

            //calls the login success method and displays the correct message 
            //based on if the login was successful or not
            String loginStatus = returnLoginStatus(userNameLogin, passWordLogin);
            if (loginStatus.equals(loginSuccess)) {
                JOptionPane.showMessageDialog(null, loginStatus, "Login Success!",
                        JOptionPane.DEFAULT_OPTION, stars);
            } else {
                JOptionPane.showMessageDialog(null, loginStatus, "Login Fail, Try again",
                        JOptionPane.DEFAULT_OPTION, error);
            }

            //if the username and password matches what they entered in the registration form, 
            //calls the task class, else makes them log in again
            if (LoginUser(userNameLogin, passWordLogin)) {
                TaskClass task = new TaskClass();
                task.TaskMenuScreen();
            } else {
                LoginScreen();
            }
        }
    }

//----------------------------------------------------------------------------------------------------------------------------------------------
//this method checks that the entered username and password match the saved registration information 
//and returns the relevant boolean
    public boolean LoginUser(String username, String password) {
        return (username.equals(registerUserName) && (password.equals(registerPassWord)));
    }

//----------------------------------------------------------------------------------------------------------------------------------------------
//this method shows the relevant message if the user was able to login successfully 
//or if either of the information did not match what was saved
//it returns it as a string
    public String returnLoginStatus(String username, String password) {

        //create the loginSuccess string
        loginSuccess = "Welcome " + registerFirstName + " " + registerLastName + ", "
                + "\nIt is great to see you again.";

        //create the loginFail string
        loginFail = "Username or password incorrect, please try again";

        //returns the corresponding string
        if (LoginUser(username, password)) {
            return loginSuccess;
        }
        return loginFail;
    }
}
    //-----------------------------------------------------END OF FILE---------------------------------------------------------------------  
