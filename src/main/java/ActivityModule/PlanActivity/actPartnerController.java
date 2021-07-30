/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActivityModule.PlanActivity;

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
public class actPartnerController extends HttpServlet {
    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter pout = response.getWriter(); 
        
        int ReqedID = Integer.parseInt(request.getParameter("planWithID"));
        String ReqedName = request.getParameter("planWithName");
        System.out.println("PlanningWith " + ReqedID +" " + ReqedName);
        
        
        HttpSession session = request.getSession();
        session.setAttribute("planWithName",ReqedName);
        session.setAttribute("planWithID",ReqedID);
    
      
        
        response.sendRedirect("activityForm.jsp");
        pout.close();
    }

  
}
