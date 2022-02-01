
package org.silverolympics.controller;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Manon
 */


public class PageNotFoundServlet extends HttpServlet {

       private static final long serialVersionUID = 1L;

    /**
     * initialization method for this servlet
     */
    public PageNotFoundServlet() {
   }

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

       ServletOutputStream out = response.getOutputStream();

       out.println("<html>");
       out.println("<head><title>Page not found</title></head>");

       out.println("<body>");
       out.println("<h3>Sorry! Page not found</h3>");
       out.println("<h1>404</h1>");
       out.println("Message from servlet: " + this.getClass().getName());
       out.println("</body>");
       out.println("<html>");
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       this.doGet(request, response);
   }

}