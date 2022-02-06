
package org.silverolympics.utils;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpSession;
import org.silverolympics.bean.UserAccount;

/**
 * Handles the creation of an object HttpSession and its attribute (userName) assignement
 * @author Manon
 * @see org.silverolympics.bean.UserAccount
 */
public class AppUtils {
  private static int REDIRECT_ID = 0;
  private static final Map<Integer, String> id_uri_map = new HashMap<Integer, String>();
  private static final Map<String, Integer> uri_id_map = new HashMap<String, Integer>();
        
        
 
    /**
     * Stores the user account's object in the current Session object to access it in homepage (e.g.)
     * @param session the current user's session instance
     * @param loggedinUser the current user who's logged in
     */

	public static void storeLoggedinUser(HttpSession session, UserAccount loggedinUser) {
		// On the JSP can access via ${loggedinUser}
		session.setAttribute("loggedinUser", loggedinUser);
	}

	

    /**
     * Gets the UserAccount instance of the current user
     * @param session the current user's session instance
     * @return loggedinUser the user account's instance representing the current user
     */
	public static UserAccount getLoggedinUser(HttpSession session) {
		UserAccount loggedinUser = (UserAccount) session.getAttribute("loggedinUser");
		return loggedinUser;
	}


}