package ProjectRoom;

//imports used for the  JOptionPane window and the custom image icon
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//-------------------------------------------------------------------------------------------------------------------------------------------------

/**
 *
 * @author Amelia ST10439947@vcconnect.edu.za ST10439947
 */
//------------------------------------------------------------------------------------------------------------------------------------------------
//This is the Welcome Class, this shows the user a welcome message for the program, 
//and calls the register class to start the registration process
public class WelcomeClass {
//------------------------------------------------------------------------------------------------------------------------------------------------
//This method checks if the user pressed the custom "register" button, this calls the register class

    public void WelcomeMenu() {
        RegisterClass register = new RegisterClass();

        //I use custom images for all the JOptionPane windows, this is how i fetch the images
        ImageIcon stardrop = new ImageIcon("Pics/stardrop.png");

        //custom register button
        Object[] options = {"Register"};

        int option = JOptionPane.showOptionDialog(null, "Welcome to EasyKanban!", "Welcome!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                stardrop, options, options[0]);
        //checks to see if user pressed the button, then takes them to the registration page
        if (option == 0) {
            register.RegisterScreen();
        }
    }
}
//------------------------------------------------------------END OF FILE------------------------------------------------------------------
