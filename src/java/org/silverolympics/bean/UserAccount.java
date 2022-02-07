
package org.silverolympics.bean;

/**
 *
 * @author Manon
 * represents the current user of the application.
 */

public class UserAccount {
    
    //id number identifying the user
    //userName the name of the current user 
    // password the password of the current user's account
    // score the current accumulated score of the account 
    private Integer id;
    private String userName;
    private String password;
    private Integer score;
    
    public UserAccount(){
        super();
    }
    public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }
    
    public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }
   
   public void setPassword(String password) {
      this.password = password;
   }
   
   public String getPassword() {
       return password;
   }
   
   public Integer getUserScore() {
      return score;
   }

   public void setUserScore(Integer score) {
      this.score = score;
   }
}
