package ProjectRoom;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Amelia ST10439947@vcconnect.edu.za ST10439947
 */
public class WelcomeFrame extends javax.swing.JFrame {

   

    public void welcomeVisible() {
        WelcomeFrame welcomeFrame = new WelcomeFrame();
        welcomeFrame.pack();
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setDefaultCloseOperation(WelcomeFrame.DISPOSE_ON_CLOSE);
        welcomeFrame.setVisible(true);
    }

    /**
     * Creates new form WelcomeFrame
     */
    public WelcomeFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WelcomePanel = new javax.swing.JPanel();
        QuitButton = new javax.swing.JButton();
        LoginButton = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();
        WorkflowLabel = new javax.swing.JLabel();
        WorkflowShadow = new javax.swing.JLabel();
        WonderLabel = new javax.swing.JLabel();
        WonderShadow = new javax.swing.JLabel();
        SloganLabel = new javax.swing.JLabel();
        BubblePic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("WelcomeFrame");
        setName("WelcomeFrame"); // NOI18N

        WelcomePanel.setBackground(new java.awt.Color(255, 255, 255));
        WelcomePanel.setMaximumSize(new java.awt.Dimension(600, 350));
        WelcomePanel.setMinimumSize(new java.awt.Dimension(600, 350));
        WelcomePanel.setPreferredSize(new java.awt.Dimension(600, 350));
        WelcomePanel.setLayout(null);

        QuitButton.setBackground(new java.awt.Color(255, 122, 148));
        QuitButton.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        QuitButton.setForeground(new java.awt.Color(255, 255, 255));
        QuitButton.setText("Quit");
        QuitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitButtonActionPerformed(evt);
            }
        });
        WelcomePanel.add(QuitButton);
        QuitButton.setBounds(510, 20, 70, 20);

        LoginButton.setBackground(new java.awt.Color(255, 142, 122));
        LoginButton.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("Login");
        LoginButton.setToolTipText("");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        WelcomePanel.add(LoginButton);
        LoginButton.setBounds(420, 140, 120, 40);

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
        WelcomePanel.add(RegisterButton);
        RegisterButton.setBounds(420, 210, 120, 40);

        WorkflowLabel.setBackground(new java.awt.Color(255, 255, 255));
        WorkflowLabel.setFont(new java.awt.Font("Lovelo Black", 0, 36)); // NOI18N
        WorkflowLabel.setForeground(new java.awt.Color(255, 255, 255));
        WorkflowLabel.setText("Workflow");
        WelcomePanel.add(WorkflowLabel);
        WorkflowLabel.setBounds(100, 160, 210, 36);

        WorkflowShadow.setBackground(new java.awt.Color(255, 255, 255));
        WorkflowShadow.setFont(new java.awt.Font("Lovelo Black", 0, 36)); // NOI18N
        WorkflowShadow.setForeground(new java.awt.Color(255, 142, 122));
        WorkflowShadow.setText("Workflow");
        WelcomePanel.add(WorkflowShadow);
        WorkflowShadow.setBounds(100, 150, 210, 40);

        WonderLabel.setBackground(new java.awt.Color(255, 255, 255));
        WonderLabel.setFont(new java.awt.Font("Lovelo Black", 0, 36)); // NOI18N
        WonderLabel.setForeground(new java.awt.Color(255, 255, 255));
        WonderLabel.setText("Wonder");
        WelcomePanel.add(WonderLabel);
        WonderLabel.setBounds(170, 200, 160, 40);

        WonderShadow.setBackground(new java.awt.Color(255, 255, 255));
        WonderShadow.setFont(new java.awt.Font("Lovelo Black", 0, 36)); // NOI18N
        WonderShadow.setForeground(new java.awt.Color(255, 170, 96));
        WonderShadow.setText("Wonder");
        WelcomePanel.add(WonderShadow);
        WonderShadow.setBounds(170, 190, 160, 40);

        SloganLabel.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        SloganLabel.setForeground(new java.awt.Color(255, 141, 121));
        SloganLabel.setText("Illuminate your workflow");
        WelcomePanel.add(SloganLabel);
        SloganLabel.setBounds(110, 270, 220, 50);

        BubblePic.setIcon(new javax.swing.ImageIcon("C:\\Users\\swart\\OneDrive - ADvTECH Ltd\\Prog Java\\NetBeans\\Amelia_Swart_ST10439947_PROG5121_POE_Part1\\Pics\\Untitled design.png")); // NOI18N
        BubblePic.setText(" ");
        WelcomePanel.add(BubblePic);
        BubblePic.setBounds(50, 50, 310, 250);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WelcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WelcomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //flags if user pressed Login
    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        ///WelcomeFrame welcomeFrame = new WelcomeFrame();
        //welcomeFrame.dispose();
        RegisterFrame registerFrame = new RegisterFrame();
        registerFrame.pack();
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setDefaultCloseOperation(WelcomeFrame.DISPOSE_ON_CLOSE);
        setVisible(false);
        registerFrame.setVisible(true);
    }//GEN-LAST:event_RegisterButtonActionPerformed

    //flags if user pressed Login
    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        //WelcomeFrame welcomeFrame = new WelcomeFrame();
        //welcomeFrame.dispose();
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(WelcomeFrame.DISPOSE_ON_CLOSE);
        setVisible(false);
        loginFrame.setVisible(true);

    }//GEN-LAST:event_LoginButtonActionPerformed

    //flags if user pressed Login
    private void QuitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_QuitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BubblePic;
    public javax.swing.JButton LoginButton;
    private javax.swing.JButton QuitButton;
    public javax.swing.JButton RegisterButton;
    private javax.swing.JLabel SloganLabel;
    private javax.swing.JPanel WelcomePanel;
    private javax.swing.JLabel WonderLabel;
    private javax.swing.JLabel WonderShadow;
    private javax.swing.JLabel WorkflowLabel;
    private javax.swing.JLabel WorkflowShadow;
    // End of variables declaration//GEN-END:variables
}
