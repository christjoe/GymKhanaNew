<%-- 
    Document   : SearchPartners
    Created on : 25 Jul, 2021, 4:19:56 PM
    Author     : iamsm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import = "PartnerModule.SearchPartners.UserModel" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Partners</title>
    </head>
    <body>
        <% 
           //To prevent caching secure webpages
            response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); //HTTP 1.1
            response.setHeader("pragma", "no-cache");  // for HTTP 1.0
            response.setHeader("Expires","0");    //for proxy servers
          //To make it a secure webpage
            if(session.getAttribute("email") == null)
            {
                response.sendRedirect("login.html");
            }
            int ListLength = ((UserModel[])request.getAttribute("UserList")).length;
            UserModel[] SuggUsers = new UserModel[ListLength];
            System.arraycopy((UserModel[])request.getAttribute("UserList"),0,SuggUsers,0,ListLength);
            
            for(int i =0;i<ListLength;i++)
            {
                
            pageContext.setAttribute("Name",  SuggUsers[i].getName());
        %>
        <p> Name : ${Name} </p>  
        <% }
        %>
    </body>
</html>
