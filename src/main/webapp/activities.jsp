<%-- 
    Document   : activities
    Created on : 22 Jul, 2021, 7:27:20 PM
    Author     : iamsm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head><title>Hyperframes</title>
  
    <style>
      .sidebar {
        width: 200px;
        background-color: #f1f1f1;  
        position: fixed;
        height: 100%;
        padding-top: 5%;
      }

      .sidebar a {
        display: block;
        color: black;
        padding: 16px;
        text-decoration: none;
      }
 
      .sidebar a:hover {
        background-color: #f78359c7;
        color: black;
      }

      .sidebar a:hover:not(.active) {
        background-color: #f78359c7;
        color: black;
      }  

      div.content {
        margin-left: 200px;
        padding-top: 5%;
        padding-left: 2%;
        height: 1000px;
      }

      iframe{
        padding-top: 5%;
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
        %>
    <div class="sidebar">
      <a class="active" href="viewConfirmed" target="alink">Confirmed</a>
      <a href="viewPlan" target="alink">Planning</a>
    </div> 

    <iframe src="viewConfirmed" width="100%" height="640px" name="alink"></iframe>
  </body>
</html>