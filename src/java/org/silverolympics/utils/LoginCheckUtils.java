
package org.silverolympics.utils;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import org.silverolympics.config.LoginNeedConfig;

/**
 * Checks whether a user needs to be logged in to access a entered url / a certain "page" of the web app
 * @author Manon
 * @see org.silverolympics.config.LoginNeedConfig
 */
public class LoginCheckUtils {
    
    public static boolean isSecurityPage(HttpServletRequest request) {
		String urlPattern = UrlPatternUtils.getUrlPattern(request);

		List<String> urlPatterns = LoginNeedConfig.getUrlPatterns();
		if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
                    return true;
                }
                return false;
		}
		
}

