
package org.silverolympics.bean;

/**
 *
 * @author Manon
 * represents the current user of the application.
 */
public class UserAccount {
    
    private String userName;
    private String password;
    private Integer score;
    /**
     *
     * @param userName the name of the current user 
     * @param password the password of the current user's account
     * @param score the current accumulated score of the account 
     */
    public UserAccount(String userName, String password, Integer score) {
      this.userName = userName;
      this.password = password;
      this.score = score;
    }
    
    public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }
   
   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
   
   public Integer getUserScore() {
      return score;
   }

   public void setUserName(Integer score) {
      this.score = score;
   }
}
