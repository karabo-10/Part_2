package com.mycompany.quickchat;

import javax.swing.JOptionPane;

/**
 * Karabo Kakudi
 * ST10479489
 */
public class Registration extends javax.swing.JFrame {
    
    //Test if txtUsername and Password is the same as one used in Login
    String storeUsername;
    String storePassword;

    // Creates new form registration
    public Registration() {
        initComponents();
        
        //Setup the Form
        setTitle("Registration");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
             
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtCellphone = new javax.swing.JTextField();
        txtFirstname = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Cellphone Number");

        jLabel3.setText("First Name");

        jLabel4.setText("Last Name");

        jLabel5.setText("Password");

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
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCellphone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstname)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(90, 90, 90)
                                    .addComponent(btnRegister))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(137, 137, 137)
                                    .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCellphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnRegister)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
       handleRegistration();
       
     User user = User.getInstance();
    user.setFirstName(txtFirstname.getText());
    user.setLastName(txtLastname.getText());
    
    String username = txtUsername.getText();
    String password = txtPassword.getText();
    String cellphone = txtCellphone.getText();
    String firstname = txtFirstname.getText();
    String lastname = txtLastname.getText();

// Call validation and registration method
String result = registerUser(username, cellphone, firstname,lastname, password);

// Show result to the user
JOptionPane.showMessageDialog(this, result);

// Only go to login if registration passed
if (result.equals("Registration successful!")) {
    this.dispose(); // close the registration form
    new Login().setVisible(true);
}

    }//GEN-LAST:event_btnRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtCellphone;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void handleRegistration() {
        String username = txtUsername.getText();
        String cellPhoneNumber = txtCellphone.getText();
        String firstname = txtFirstname.getText();
        String lastname = txtLastname.getText();
        String password = new String(txtPassword.getPassword());
        
        String registrationMessage = registerUser(username, cellPhoneNumber, firstname, lastname, password);
        JOptionPane.showMessageDialog(Registration.this,registrationMessage, "Registration Status", JOptionPane.INFORMATION_MESSAGE);
        if (registrationMessage.equals("Registration successful!")) {
            User.getInstance().setCredentials( username, password); //Use singleton
            dispose(); //Close the registration form
            System.out.println("Stored Username:" + " " + "Stored Password:" + password);
        }
                 
    }

    private String registerUser(String username, String cellPhoneNumber, String firstname, String lastname, String password) {
       //Check username validity
        if (!checkUsername(username)) {
            return ("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
       }
        //Check cellphone validity
        if (!isCellPhoneValid(cellPhoneNumber)){
            return ("Cell phone number incorrectly formatted or does not contain an international code.");
        }   
         //Check password complexity
        if (!checkPasswordComplexity(password)) {
            return ("Password is not correctly formatted please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }
        //Implement actual registration logic
        //For demonstration, assume registration is successful
        return "Registration successful!";
    }

    //Check if username is valid
    public static boolean checkUsername(String username) {
        if (username == null) {
            System.out.println("Username is null");
            return false;
        }
        return username.contains ("_") && username.length() <=5;           
}
    //Check if password is valid
    public static boolean checkPasswordComplexity(String password) {
        if (password == null){
            System.out.println("Password is null");
            return false;                   
        }
       return password.length() >= 8
               && password.matches(".*[A-Z].*")
               && password.matches(".*[a-z].*")
               && password.matches(".*\\d.*")
               && password.matches(".*[!@#$%^&*()-_=+\\|[{]};:'\",<.>/?`~].*");                  
    }

    public static boolean isCellPhoneValid(String cellPhoneNumber) {
        //Regex to match a phone number with international code (e.g. +27 for South Africa
        String regex = "^\\+27\\d{9}$";
         return cellPhoneNumber.matches(regex);    //Return true if the phone number matches the pattern, otherwise false
    }
    //Store login credentials
    public void storeLoginCredentials(String username, String password) {
        
        this.storeUsername = username;
        this.storePassword = password;
                
    }
    //Check login credentials
    public boolean checkLoginCredentials(String username, String password){
        return username.equals(storeUsername) && password.equals(storePassword);
     }
} 
    

  
