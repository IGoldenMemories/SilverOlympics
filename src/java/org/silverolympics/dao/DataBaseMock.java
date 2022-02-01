
package org.silverolympics.dao;
import java.util.HashMap;
import java.util.Map;
import org.silverolympics.bean.UserAccount;
/**
 * Mock object used while login database isn't implemented to test basic functions 
 * such as:
 * navigation within the web app,
 * solo game (establishment/options selection and answers resolution),
 * multi game (entering condition constraint verification(one or more available player),options selection, game sequence),
 * scoreboard display
 * @author Manon
 * @see org.silverolympics.bean.UserAccount
 */
public class DataBaseMock {
    
    private static final Map<String, UserAccount> mapUsers = new HashMap<String, UserAccount>();

   static {
      initUsers();
   }
   /**
    * creates two mock users accounts to test login (e.g.)
    */
    private static void initUsers() {

      // First mock user account 
      UserAccount usr_1 = new UserAccount("Tournesols", "1992", 5);

      // Second mock user account
      UserAccount usr_2 = new UserAccount("Tulipes", "1987", 2);

      mapUsers.put(usr_1.getUserName(), usr_1);
      mapUsers.put(usr_2.getUserName(), usr_2);
   }
    
   /**
    * Finds a User by userName and password.
     * @param userName the name of the user's account
     * @param password the password of the user's account
     * @return the UserAccount object corresponding to the userName and the password given as input,
     *         or null if no object in mapUsers corresponds to the inputed pair
    */
   public static UserAccount findUser(String userName, String password) {
      UserAccount u = mapUsers.get(userName);
      if (u != null && u.getPassword().equals(password)) {
         return u;
      }
      return null;
   }

}
