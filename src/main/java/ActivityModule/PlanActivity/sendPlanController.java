/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActivityModule.PlanActivity;

import SignupModule.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 *
 * @author iamsm
 */
public class sendPlanController extends HttpServlet {
    
    
    /**
     
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String planWithName = request.getParameter("planWithName");
        int planWithID = Integer.parseInt(request.getParameter("planWithID"));
        UserModel planWith = new UserModel(planWithID,planWithName);
        
        ActivityModel Activity = new ActivityModel(request.getParameter("a_name"),request.getParameter("a_date"),request.getParameter("a_time"));
        
        System.out.println(planWith.getID() + " " + planWith.getName());
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
            
      
     
        out.close();
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    }
}
