
package org.silverolympics.filter;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.silverolympics.bean.UserAccount;
import org.silverolympics.utils.AppUtils;
import org.silverolympics.utils.LoginCheckUtils;

/**
 * Filter the url and redirects towards login on web app access (e.g.)
 * @author Manon
 * @see org.silverolympics.bean.UserAccount
 * @see org.silverolympics.utils.AppUtils
 * @see rg.silverolympics.utils.LoginCheckUtils
 */

@WebFilter("/*")
public class UrlFilter implements Filter {

    /**
     * Constructor for the filter 
     */
    public UrlFilter() {
	}
    
    /**
     * Tear-down for the filter
     */
    @Override
    public void destroy() {
	}
    
    /**
     * Filters the request following the url (does it need to be logged in and if so is the current user ?)
     * @param req the current request
     * @param resp the following response
     * @param chain 
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
	HttpServletRequest request = (HttpServletRequest) req;
	HttpServletResponse response = (HttpServletResponse) resp;

	String servletPath = request.getServletPath();

	// User information stored in the Session.
	// (After successful login).
	UserAccount loggedinUser = AppUtils.getLoggedinUser(request.getSession());
        
        //Nothing to do if the login is requested
	if (servletPath.equals("/login")) {
            chain.doFilter(request, response);
            return;
		}
	
        HttpServletRequest wrapRequest = request;

	if (loggedinUser != null) {
            // User Name
            String userName = loggedinUser.getUserName();

            }

	// Checks whether the chosen page requests to be logged in to access it
	if (LoginCheckUtils.isSecurityPage(request)) {
            // If the user is not logged in,
			// Redirect to the login page.
			if (loggedinUser == null) {

				String requestUri = request.getRequestURI();

				// Store the current page to redirect to after successful login.
				int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);

				response.sendRedirect(wrapRequest.getContextPath() + "/login?redirectId=" + redirectId);
				return;
			}

			
		}

		chain.doFilter(wrapRequest, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
