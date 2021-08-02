/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PartnerModule.RequestPartners;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
/**
 *
 * @author iamsm
 */
public class reqPartnerController extends HttpServlet {
    reqPartnerDAO dao = new reqPartnerDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter pout = response.getWriter(); 
        
        int ReqedID = Integer.parseInt(request.getParameter("requested"));
        System.out.println("request sent to " + ReqedID);
        
        HttpSession session = request.getSession();
        String ReqorEmail = (String)session.getAttribute("email");
        
        System.out.println("Request from " + ReqorEmail);
        
        dao.createRel(ReqorEmail, ReqedID);
       
        
        response.sendRedirect("searchPartners");
        pout.close();
    }

  
}
