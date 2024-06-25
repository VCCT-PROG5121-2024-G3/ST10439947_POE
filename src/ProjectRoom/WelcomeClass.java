package ProjectRoom;

//imports used for the  JOptionPane window and the custom image icon
import java.awt.*;
import javax.swing.*;

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
        Image backgroundImage = new ImageIcon("Pics/background.jpg").getImage();

        //I use custom images for all the JOptionPane windows, this is how i fetch the images
        ImageIcon stardrop = new ImageIcon("Pics/stardrop.png");

        //custom register button
        Object[] options = {"Register"};

        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to EasyKanban!");
        welcomeLabel.setBounds(25, 25, 280, 30);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        backgroundPanel.add(welcomeLabel, BorderLayout.CENTER);

        JButton registerButton = new JButton("Register!");
        registerButton.setBounds(70, 70, 100, 30);
        registerButton.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
            register.RegisterScreen();
        });
        backgroundPanel.add(registerButton, BorderLayout.CENTER);

        JDialog welcomeDialog = new JDialog();
        welcomeDialog.setTitle("Welcome!");
        welcomeDialog.setModal(true);
        welcomeDialog.setSize(250, 180);
        welcomeDialog.setLocationRelativeTo(null);
        welcomeDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        welcomeDialog.setIconImage(stardrop.getImage());

        welcomeDialog.add(backgroundPanel);
        welcomeDialog.setVisible(true);

        //checks to see if user pressed the button, then takes them to the registration page
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------------------------------------------------
    public class BackgroundPanel extends JPanel {

        private Image backgroundImage;

        public BackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------------------------------------------------
}
//------------------------------------------------------------END OF FILE------------------------------------------------------------------
