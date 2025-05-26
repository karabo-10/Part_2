package com.mycompany.quickchat;


import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.Timer;


/**
 * Karabo Kakudi
 * ST10479489
 */

public class Login extends javax.swing.JFrame {
      
    private String username;
    private String password;
    private Registration registration;
   
    public Login() {
        initComponents();
        setTitle("Login");     //Set title of widow
        setSize(500, 400);     //Set size of window
        setLocationRelativeTo(null);       //Centre the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);   //Closes application when the window is closed 
    }
    //Constructor that accepts a Registration object
    public Login(Registration registration){
        this.registration = registration;
        initComponents();
        setTitle("Login");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JToggleButton();
        btnRegister = new javax.swing.JToggleButton();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsername)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addComponent(btnLogin)
                .addGap(41, 41, 41)
                .addComponent(btnRegister)
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnRegister))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        Registration registration = new Registration();
        registration.setVisible(true);
        //Validate login credentials
        boolean isValid = checkLoginCredentials(username, password);
        String loginStatus = returnLoginStatus(isValid);
        
        //Display that message on the top left of the window while user login
        JOptionPane.showMessageDialog(Login.this, loginStatus, "Login Status", JOptionPane.INFORMATION_MESSAGE);

        if (isValid) {
            dispose();
            User user = User.getInstance();
          //  new Welcome(user.getFirstName(), user.getLastName()).setVisible(true);
            
            // Requirement 1: Only proceed if logged in
        WelcomeToQuickChat.startMessaging();
    }   else {
        JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed",  JOptionPane.ERROR_MESSAGE);
            
    }//GEN-LAST:event_btnRegisterActionPerformed
    
    }
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String username = txtUsername.getText();
        String password = new String(((JPasswordField) txtPassword).getPassword());
        //Validate login credentials
        boolean isValid = checkLoginCredentials(username, password);
        //Dsiplay login status
        String loginStatus = returnLoginStatus(isValid);
        
        JOptionPane.showMessageDialog(Login.this, loginStatus, "Login Status", JOptionPane.INFORMATION_MESSAGE);
        
        if (isValid) {
        User user = User.getInstance(); // get the singleton user
       // new Welcome(user.getFirstName(), user.getLastName()).setVisible(true);
        this.dispose();  
        
          // Requirement 1: Only proceed if logged in
        WelcomeToQuickChat.startMessaging();
    } else {
        JOptionPane.showMessageDialog(this,
            "Invalid username or password",
            "Login Failed",
            JOptionPane.ERROR_MESSAGE);

    JOptionPane.showMessageDialog(this, "Invalid credentials");
     //close Login screen
    }//GEN-LAST:event_btnLoginActionPerformed
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnLogin;
    private javax.swing.JToggleButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
    
    //Check if input username and password match the stored credentials
    private boolean checkLoginCredentials(String username, String password) {
    String storedUsername = User.getInstance().getUsername();
    String storedPassword = User.getInstance().getPassword();
    return storedUsername.equals(username) && storedPassword.equals(password);
}
    //Returns stored username
    public String getUsername() {
    return username;
}
    //Returns stored password
    public String getPassword() {
    return password;
}
    //Returns a message based on the login if it was successfull or not
    private String returnLoginStatus(boolean valid) {
        return valid ? "Login successful!" : "Invalid username or password";
    }
}