package com.mycompany.quickchat;
/**
 * 
 */
public class User {
    
    private static User instance;
    
    private String username;
    private String password; 
    private String firstName;
    private String lastName;
      
   private User(){}
   
    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }
    //Set username and passowrd for authentication 
    public void setCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
    //Checks if provided credentials are valid
    public boolean checkCredentials(String username, String password){
        return this.username != null && this.username.equals(username) && this.password != null && this.password.equals(password);
    }
    //Returns username
    public String getUsername() {
        return username;
    }
    //Returns password
    public String getPassword() {
        return password;
    }
    //Returns firstname
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fname) {
        this.firstName = fname;
    }
    //Returns lastname
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lname) {
        this.lastName = lname;
}
}

