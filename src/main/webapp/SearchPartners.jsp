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
        <style>
            .card {
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
}

.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2)
}

.container {
  float: right;
  padding-right: 2%;
}
        </style>
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
        <!-- <p> Name : ${Name} </p> -->
        <div class="card">
      <img src="images/meet.png" alt="Avatar" style="width: 20%; height: 30%; padding-left: 2%; padding-bottom: 2%; padding-top: 2%; ">
      <div class="container">
        <h4><b>${Name}</b></h4>
        <p><u>About me</u><br>Architect<br>Football/Swimming</p>
      </div>
    </div>
        <% }
        %>
    </body>
</html>
