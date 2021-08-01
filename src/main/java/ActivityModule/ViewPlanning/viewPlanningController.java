/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActivityModule.ViewPlanning;

import ActivityModule.RespondPlan.ActivityModel;
import ActivityModule.UserModel;
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
public class viewPlanningController extends HttpServlet {
    viewPlanningDAO dao = new viewPlanningDAO();
    
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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
            
      
        HttpSession session = request.getSession();
        String UserEmail = (String)session.getAttribute("email");
        System.out.println(UserEmail);
        UserModel[] UPlanRec = dao.getUPlanRec(UserEmail).clone();
        UserModel[] UPlanSent = dao.getUPlanSent(UserEmail).clone();
        ActivityModel[] APlanRec = dao.getAPlanRec(UserEmail).clone(); 
        ActivityModel[] APlanSent = dao.getAPlanSent(UserEmail).clone();
        
        request.setAttribute("UPlanRec",UPlanRec);
        request.setAttribute("UPlanSent",UPlanSent);
        request.setAttribute("APlanRec",APlanRec);        
        request.setAttribute("APlanSent",APlanSent);
        
        RequestDispatcher rd = request.getRequestDispatcher("viewPlan.jsp");
        if(rd != null)
        {
            System.out.println("FORWARDED");
            rd.forward(request,response);
        }
        else
            System.out.println("RD is NULL");       
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
