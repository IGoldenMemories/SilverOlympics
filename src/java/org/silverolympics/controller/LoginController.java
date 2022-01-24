package org.silverolympics.controller;

import org.silverolympics.bean.LoginBean;
import org.silverolympics.dao.LoginDao;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
/**
 *
 * @author informatique
 */



public class LoginController extends HttpServlet {
    
    @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message's MIME type
      response.setContentType("text/html;charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
 
      // Write the response message, in an HTML page
      try {
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>Hello, World</title></head>");
         out.println("<body>");
         out.println("<h1>Hello, world!</h1>");  // says Hello
         // Echo client's request information
         out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
         out.println("<p>Protocol: " + request.getProtocol() + "</p>");
         out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
         out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
         // Generate a random number upon each request
         out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
         out.println("</body>");
         out.println("</html>");
      } finally {
         out.close();  // Always close the output writer
      }
   }

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        //checks whether the button has been "pushed" on the login.jsp pop-up
         if(request.getParameter("button_login")!= null){
            //retrieves the content of the username text field
            String username=request.getParameter("username");
            //retrieves the content of the username text field
            String password=request.getParameter("password");
            //Creates a new Bean to check within the database whether the user's credentials are valid/present
            LoginBean loginBean=new LoginBean(); 
            loginBean.setUsername(username); 
            loginBean.setPassword(password);
            //LoginDao takes care of all the logic concerning database accesses 
            LoginDao loginDao= new LoginDao();
            //Checks whether the username and password given as input are valid/match each other
            String authorize=loginDao.authorizeLogin(loginBean);
            
            if(authorize.equals("SUCCESS LOGIN")){
                //Creates a session for the user 
                HttpSession session=request.getSession();
                //set the session name as login
                session.setAttribute("login",loginBean.getUsername());
                //redirection to the version of the homepage where the user is connected
                RequestDispatcher rd=request.getRequestDispatcher("Acceuil_connecté.jsp");
                rd.forward(request, response);
            }
            
            else{
                //setting the error message's name as WrongLoginMsg
                request.setAttribute("WrongLoginMsg", authorize);
                //redirects to login.jsp to retry and displays an error message
                RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
                rd.include(request, response);
                
            }
        }
    }
    
    
    
    
}