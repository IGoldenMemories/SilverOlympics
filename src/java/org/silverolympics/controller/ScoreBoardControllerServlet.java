
package org.silverolympics.controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.silverolympics.bean.UserAccount;
import org.silverolympics.dao.AllUserData;
import org.silverolympics.dao.DataBaseDao;

/**
 *
 * @author Manon
 */
public class ScoreBoardControllerServlet extends HttpServlet {
    
    public ScoreBoardControllerServlet() {
        super();
        
    }

    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/scoreboard.jsp");
        //DataBaseDao model=new DataBaseDao();
        
        //Connection con = model.getCon();
        //if(null!= con){
        //    response.getWriter().print("Connection established......");
        //}
        //else{
        //    response.getWriter().print("Connection failed......");
        //}
        AllUserData userdata = new AllUserData();
        HashMap<String,Integer> usersmap = userdata.mapusers;
        request.setAttribute("listusers", usersmap);
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
