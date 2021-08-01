/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActivityModule.RespondPlan;

import ActivityModule.RespondPlan.ActivityModel;
import ActivityModule.UserModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author iamsm
 */
public class respondPlanController extends HttpServlet {
    respondPlanDAO dao = new respondPlanDAO();    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter pout = response.getWriter(); 
        
        int ReqorID = Integer.parseInt(request.getParameter("responseTo"));
        String res = request.getParameter("response");
        System.out.println("responded to " + ReqorID);
        
        HttpSession session = request.getSession();
        String ReqedEmail = (String)session.getAttribute("email");
        
        System.out.println("Responded by " + ReqedEmail);
        System.out.println(res);
        
        int A_ID = Integer.parseInt(request.getParameter("A_ID"));
        dao.updateAct(ReqedEmail, ReqorID, res, A_ID);
        
        response.sendRedirect("viewPlan");
        pout.close();
    }

    
}
