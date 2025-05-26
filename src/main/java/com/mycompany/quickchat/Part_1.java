package com.mycompany.quickchat;

/**
 *Karabo Kakudi
 * ST10479489
 */
         
public class Part_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {    //Create and show the GUI
        public void run() {
            new Login().setVisible(true);   //Create a new instance of login form and make it visible
        }
    });
}
    }
   
