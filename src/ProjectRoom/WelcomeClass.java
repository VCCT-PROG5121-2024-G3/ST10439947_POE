package ProjectRoom;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Amelia ST10439947@vcconnect.edu.za ST10439947
 */
//------------------------------------------------------------------------------------------------------------------------------------------------
//This is the Welcome Class
public class WelcomeClass {

    public void WelcomeMenu() {
        RegisterClass register = new RegisterClass();

        ImageIcon stardrop = new ImageIcon("Pics/stardrop.png");

        Object[] options = {"Register"};

        int option = JOptionPane.showOptionDialog(null, "Welcome to EasyKanban!", "Welcome!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                stardrop, options, options[0]);
        if (option == 0){
            register.RegisterScreen();
        }
       
    }

}
//------------------------------------------------------------END OF FILE------------------------------------------------------------------
