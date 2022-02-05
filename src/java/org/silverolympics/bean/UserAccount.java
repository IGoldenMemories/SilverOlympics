
package org.silverolympics.bean;

/**
 *
 * @author Manon
 * represents the current user of the application.
 */
public class UserAccount {
    private Integer id;
    private String userName;
    private String password;
    private Integer score;
    /**
     *
     * @param id number identifying the user
     * @param userName the name of the current user 
     * @param password the password of the current user's account
     * @param score the current accumulated score of the account 
     */
    public UserAccount(Integer id, String userName, String password, Integer score) {
      this.id = id;
      this.userName = userName;
      this.password = password;
      this.score = score;
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
   
   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
   
   public Integer getUserScore() {
      return score;
   }

   public void setUserScore(Integer score) {
      this.score = score;
   }
}
