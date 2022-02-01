
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

    /**
     * Stores the url that was requested and that couldn't be reached because the user wasn't logged in 
     * @param session the current user's session instance
     * @param requestUri the requested uri by the user 
     * @return id the numeric id of the user's session (which is unique amongs all currently connected users' account)
     */
    public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
		Integer id = uri_id_map.get(requestUri);

		if (id == null) {
			id = REDIRECT_ID++;

			uri_id_map.put(requestUri, id);
			id_uri_map.put(id, requestUri);
			return id;
		}

		return id;
	}

    /**
     *
     * @param session the current user's session instance
     * @param redirectId 
     * @return url the url towards which the user will be redirected once logged in 
     */
    public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
		String url = id_uri_map.get(redirectId);
		if (url != null) {
			return url;
		}
		return null;
	}

}