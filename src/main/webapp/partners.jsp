<%-- 
    Document   : partners
    Created on : 22 Jul, 2021, 7:25:31 PM
    Author     : iamsm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <style>
      .sidebar {
        width: 200px;
        background-color: #f1f1f1;
        position: fixed;
        height: 100%;
        overflow: auto;
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
        padding: 1px 16px;
        height: 1000px;
      }

      .topnav {
        overflow: hidden;
        background-color: white;
      }


      .topnav .search-container {
        float:left;
        padding-left: 30%;
        width: 40%;
      }

      .topnav input[type=text] {
        padding: 6px;
        margin-top: 8px;
        font-size: 15px;
        width: 510px;
      }

      .topnav .search-container button {
        float: right;
        padding: 5px 5px;
        margin-top: 5px;
        margin-right: 16px;
        background: #ddd;
        font-size: 15px;
        cursor: pointer;
      }

      .topnav .search-container button:hover {
        background: #ccc;
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
      <a class="active" href="viewPartners" target="plink">Your Partners</a>
      <a href="viewRequests" target="plink">Requests</a>
       <a href="searchPartners"  target="plink">Search Partners</a>
    </div> <br><br>

    <div class="topnav">
      <div class="search-container">
        <form>
          <input type="text" placeholder="Search.." name="search">
          <button type="submit">Search</button>
        </form>
      </div>
    </div>

    <iframe src="viewPartners" width="100%" height="640px" name="plink"></iframe>

    </div>
  </body>
</html>