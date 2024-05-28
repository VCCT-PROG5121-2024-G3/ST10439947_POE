package ProjectRoom;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Amelia ST10439947@vcconnect.edu.za ST10439947
 */
//-------------------------------------------------------------------------------------------------------------------------------------------------    
//This the log-in and register class. As it uses the same variables itsbest to have them as one class
//This class checks the username and password when registering and checks the user's login details 
//This class also returns the neccessary messages for each scneario.
public class LoginClass {
//-------------------------------------------------------------------------------------------------------------------------------------------------

    public JTextField userNameField;
    public JTextField passWordField;

    private final String registerFirstName;
    private final String registerLastName;
    private final String registerUserName;
    private final String registerPassWord;

    private String loginSucess;
    private String loginFail;

//-------------------------------------------------------------------------------------------------------------------------------------------------
    public LoginClass(String firstName, String lastName, String userName, String passWord) {
        this.registerFirstName = firstName;
        this.registerLastName = lastName;
        this.registerUserName = userName;
        this.registerPassWord = passWord;

    }
//-------------------------------------------------------------------------------------------------------------------------------------------------

    public JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));

        loginPanel.setPreferredSize(new Dimension(250, 100));

        BoxLayout layout = new BoxLayout(loginPanel, BoxLayout.Y_AXIS);
        loginPanel.setLayout(layout);

        JLabel userNameLabel = new JLabel("Username: ");
        userNameField = new JTextField();
        loginPanel.add(userNameLabel);
        loginPanel.add(userNameField);

        JLabel passWordLabel = new JLabel("Password: ");
        passWordField = new JTextField();
        loginPanel.add(passWordLabel);
        loginPanel.add(passWordField);

        return loginPanel;
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------

    public void LoginScreen() {

        ImageIcon pinkflower = new ImageIcon("Pics/pinkflower.png");
        ImageIcon error = new ImageIcon("Pics/error.png");
        ImageIcon stars = new ImageIcon("Pics/stars.png");

        JPanel loginPanel = createLoginPanel();

        int result = JOptionPane.showConfirmDialog(null, loginPanel, "Please enter your Login Details",
                JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, pinkflower);

        if (result == JOptionPane.OK_OPTION) {
            String userNameLogin = userNameField.getText();
            String passWordLogin = passWordField.getText();

            String loginStatus = returnLoginStatus(userNameLogin, passWordLogin);
            if (loginStatus.equals(loginSucess)) {
                JOptionPane.showMessageDialog(null, loginStatus, "Login Sucess!",
                        JOptionPane.DEFAULT_OPTION, stars);
            } else {
                JOptionPane.showMessageDialog(null, loginStatus, "Login Fail, Try again",
                        JOptionPane.DEFAULT_OPTION, error);
            }

            if (LoginUser(userNameLogin, passWordLogin)) {
                TaskClass task = new TaskClass();
                task.TaskScreen();
            } else {
                LoginScreen();

            }
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean LoginUser(String username, String password) {

        return (username.equals(registerUserName) && (password.equals(registerPassWord)));

    }

//-------------------------------------------------------------------------------------------------------------------------------------------------
    public String returnLoginStatus(String username, String password) {
        loginSucess = "Welcome " + registerFirstName + " " + registerLastName + ", "
                + "\nIt is great to see you again.";
        loginFail = "Username or password incorrect, please try again";

        if (LoginUser(username, password)) {
            return loginSucess;
        }
        return loginFail;
    }

    //-----------------------------------------------------END OF FILE-----------------------------------------------------------------------   
}
