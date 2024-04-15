package ProjectRoom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Amelia ST10439947@vcconnect.edu.za ST10439947
 */
public class RegisterFrame extends javax.swing.JFrame implements ActionListener {

    public String passWord;
    public String userName;
    public String firstName;
    public String lastName;

    /**
     * Creates new form RegisterFrame
     */
    public RegisterFrame() {
        initComponents();
        RegisterButton.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        QuitButton = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();
        UsernameLabel = new javax.swing.JLabel();
        UsernameField = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        FirstNameLabel = new javax.swing.JLabel();
        FirstNameField = new javax.swing.JTextField();
        LastNameLabel = new javax.swing.JLabel();
        LastNameField = new javax.swing.JTextField();
        RegisterLabel1 = new javax.swing.JLabel();
        RegisterLabel2 = new javax.swing.JLabel();
        RegisterLabel3 = new javax.swing.JLabel();
        MenuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 450));
        jPanel1.setLayout(null);

        QuitButton.setBackground(new java.awt.Color(255, 122, 148));
        QuitButton.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        QuitButton.setForeground(new java.awt.Color(255, 255, 255));
        QuitButton.setText("Quit");
        QuitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(QuitButton);
        QuitButton.setBounds(360, 20, 70, 20);

        RegisterButton.setBackground(new java.awt.Color(255, 170, 96));
        RegisterButton.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        RegisterButton.setForeground(new java.awt.Color(255, 255, 255));
        RegisterButton.setText("Register");
        RegisterButton.setToolTipText("");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });
        jPanel1.add(RegisterButton);
        RegisterButton.setBounds(160, 360, 110, 30);

        UsernameLabel.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        UsernameLabel.setForeground(new java.awt.Color(255, 141, 121));
        UsernameLabel.setText("Username:");
        jPanel1.add(UsernameLabel);
        UsernameLabel.setBounds(120, 100, 100, 20);

        UsernameField.setBackground(new java.awt.Color(255, 255, 255));
        UsernameField.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        UsernameField.setForeground(new java.awt.Color(0, 0, 0));
        UsernameField.setText(" ");
        jPanel1.add(UsernameField);
        UsernameField.setBounds(120, 120, 210, 26);

        PasswordLabel.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(255, 141, 121));
        PasswordLabel.setText("Password:");
        jPanel1.add(PasswordLabel);
        PasswordLabel.setBounds(120, 160, 100, 20);

        PasswordField.setBackground(new java.awt.Color(255, 255, 255));
        PasswordField.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(0, 0, 0));
        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });
        jPanel1.add(PasswordField);
        PasswordField.setBounds(120, 180, 210, 26);

        FirstNameLabel.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        FirstNameLabel.setForeground(new java.awt.Color(255, 141, 121));
        FirstNameLabel.setText("First Name:");
        jPanel1.add(FirstNameLabel);
        FirstNameLabel.setBounds(120, 220, 100, 20);

        FirstNameField.setBackground(new java.awt.Color(255, 255, 255));
        FirstNameField.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        FirstNameField.setForeground(new java.awt.Color(0, 0, 0));
        FirstNameField.setText(" ");
        jPanel1.add(FirstNameField);
        FirstNameField.setBounds(120, 240, 210, 26);

        LastNameLabel.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        LastNameLabel.setForeground(new java.awt.Color(255, 141, 121));
        LastNameLabel.setText("Last Name:");
        jPanel1.add(LastNameLabel);
        LastNameLabel.setBounds(120, 280, 100, 20);

        LastNameField.setBackground(new java.awt.Color(255, 255, 255));
        LastNameField.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        LastNameField.setForeground(new java.awt.Color(0, 0, 0));
        LastNameField.setText(" ");
        jPanel1.add(LastNameField);
        LastNameField.setBounds(120, 300, 210, 26);

        RegisterLabel1.setFont(new java.awt.Font("Lovelo Black", 0, 30)); // NOI18N
        RegisterLabel1.setForeground(new java.awt.Color(255, 122, 148));
        RegisterLabel1.setText("register");
        jPanel1.add(RegisterLabel1);
        RegisterLabel1.setBounds(150, 40, 130, 30);

        RegisterLabel2.setFont(new java.awt.Font("Lovelo Black", 0, 30)); // NOI18N
        RegisterLabel2.setForeground(new java.awt.Color(255, 170, 96));
        RegisterLabel2.setText("register");
        jPanel1.add(RegisterLabel2);
        RegisterLabel2.setBounds(150, 50, 130, 30);

        RegisterLabel3.setFont(new java.awt.Font("Lovelo Black", 0, 30)); // NOI18N
        RegisterLabel3.setForeground(new java.awt.Color(255, 219, 112));
        RegisterLabel3.setText("register");
        jPanel1.add(RegisterLabel3);
        RegisterLabel3.setBounds(150, 60, 130, 30);

        MenuButton.setBackground(new java.awt.Color(255, 122, 148));
        MenuButton.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        MenuButton.setForeground(new java.awt.Color(255, 255, 255));
        MenuButton.setText("Menu");
        MenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });
        jPanel1.add(MenuButton);
        MenuButton.setBounds(363, 410, 72, 24);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Register")) {

            LoginRegisterClass register = new LoginRegisterClass();
            String result;

            String firstName = FirstNameField.getText();
            String lastName = LastNameField.getText();
            String userName = UsernameField.getText();
            String passWord = new String(PasswordField.getText());
          
            result = register.registerUser(firstName, lastName, userName, passWord);
            JOptionPane.showMessageDialog(null, result);
        }
    }


    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed


    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void QuitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_QuitButtonActionPerformed

    private void MenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuButtonActionPerformed
        WelcomeFrame welcomeFrame = new WelcomeFrame();
        welcomeFrame.pack();
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);
        setVisible(false);
        welcomeFrame.setVisible(true);
    }//GEN-LAST:event_MenuButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FirstNameField;
    private javax.swing.JLabel FirstNameLabel;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JButton MenuButton;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JButton QuitButton;
    public javax.swing.JButton RegisterButton;
    private javax.swing.JLabel RegisterLabel1;
    private javax.swing.JLabel RegisterLabel2;
    private javax.swing.JLabel RegisterLabel3;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
