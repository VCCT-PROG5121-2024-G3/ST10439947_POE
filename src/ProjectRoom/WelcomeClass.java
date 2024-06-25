package ProjectRoom;

//imports used for the JOptionPane window and the custom image icon
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
        //calls the register class
        RegisterClass register = new RegisterClass();

        //retrieves the background image
        Image backgroundImage = new ImageIcon("Pics/background.jpg").getImage();

        //I use custom images for all the JOptionPane windows, this is how i fetch the images
        ImageIcon stardrop = new ImageIcon("Pics/stardrop.png");

        //custom register button
        Object[] options = {"Register"};

        //custom background image
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(null);

        //creates and customises the font and size of the welcome message title
        JLabel welcomeLabel = new JLabel("Welcome to EasyKanban!");
        welcomeLabel.setBounds(25, 25, 280, 30);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        backgroundPanel.add(welcomeLabel, BorderLayout.CENTER);

        //sets the size and gets the action listener for the custom "register" button
        JButton registerButton = new JButton("Register!");
        registerButton.setBounds(70, 70, 100, 30);
        registerButton.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
            register.RegisterScreen();
        });

        //adds the custom background image
        backgroundPanel.add(registerButton, BorderLayout.CENTER);

        //creates the custom Jdialog instead of a normal JOptionPane as it allows for more customisation
        JDialog welcomeDialog = new JDialog();
        welcomeDialog.setTitle("Welcome!");
        welcomeDialog.setModal(true);
        welcomeDialog.setSize(250, 180);
        welcomeDialog.setLocationRelativeTo(null);
        welcomeDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        welcomeDialog.setIconImage(stardrop.getImage());

        //adds the main panel and makes it visible
        welcomeDialog.add(backgroundPanel);
        welcomeDialog.setVisible(true);

    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------------------------------------------------
    //this class helps call the background panel as it needs to customise the paint Component
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
