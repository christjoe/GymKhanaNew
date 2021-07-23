/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SignupModule;

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
public class SignupController extends HttpServlet {
    SignupDAO dao = new SignupDAO();
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
        String Name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("psw1");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
            
      
        if(dao.signupUser(Name,email, pass))
        {
            HttpSession session = request.getSession();
            session.setAttribute("email",email);
            response.sendRedirect("frames.jsp");
            System.out.println("Logged in");
        }
        else
        {
            
             out.println("not Logged in");
         response.sendRedirect("signup.html");
         
        }
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
