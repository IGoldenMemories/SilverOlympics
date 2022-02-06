
package org.silverolympics.bean;

/**
 * The LoginBean class represents an user and contains all the getter and setter method for the login
 * @author informatique
 * @see org.silverolympics.LoginController
 */
public class LoginBean {
    
    private String username, password;

    public LoginBean(String username, String password) {
        this.username = username;
        this.password = password; 
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password= password;
    }
}
