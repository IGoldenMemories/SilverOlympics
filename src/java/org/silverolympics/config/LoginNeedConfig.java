
package org.silverolympics.config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Manon
 */
public class LoginNeedConfig {
    
    private static final List <String> urlneedlogin =  new ArrayList<String>();  
    static {
        init();
	}
    private static void init() {

		urlneedlogin.add("/classement");
		urlneedlogin.add("/aide");
                urlneedlogin.add("/acceuil");
                // ADD OTHERS HERE
	}
    
    public static List<String> getUrlPatterns() {
		return urlneedlogin;
	}
}
