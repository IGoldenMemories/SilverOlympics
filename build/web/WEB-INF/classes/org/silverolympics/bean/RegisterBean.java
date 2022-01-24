
package org.silverolympics.bean;

/**
 *
 * @author Manon Michaux
 * 
 */
public class RegisterBean {
    
    private String username, password;
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
    /**
     *
     * @return password the password of the account that's currently being created 
     */
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password= password;
    }
}


