<%-- 
    Document   : requests
    Created on : 27 Jul, 2021, 9:57:13 AM
    Author     : iamsm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import = "PartnerModule.RequestPartners.UserModel" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Partners</title>
        <style>
            body{
                padding-left : 20%;
            }
            .card {
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  padding-bottom: 5%;
  width : 80%;
  height : 40%;
}

.card:hover {
  box-shadow: 0 64px 64px 0 rgba(0,0,0,0.2);
      background: linear-gradient(to right, #d6724e, #f5551a);
      width : 90%;
}


.container {
  float: right;
  padding-right: 2%;
}
        </style>
        <script src ="scripts/respondReq.js"></script>
    </head>
    <body>
        <form action="respondReq" method ="POST" id="resForm">
            <input type ="hidden" name ="responseTo" value = "">
            <input type ="hidden" name ="response" value = "">
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
            int ListLength = ((UserModel[])request.getAttribute("ReqList")).length;
            System.out.println(ListLength);
            UserModel[] ReqUsers = new UserModel[ListLength];
            System.arraycopy((UserModel[])request.getAttribute("ReqList"),0,ReqUsers,0,ListLength);
            
            for(int i =0;i<ListLength;i++)
            {
                
            pageContext.setAttribute("Name",  ReqUsers[i].getName());
            pageContext.setAttribute("ID",  ReqUsers[i].getID());
        %>
        <!-- <p> Name : ${Name} </p> -->
        <div class="card">
      <img src="images/meet.png" alt="Avatar" style="width: 20%; height: 30%; padding-left: 2%; padding-bottom: 2%; padding-top: 2%; ">
      <div class="container">
        <h4><b>${Name}</b></h4>
        <p><u>About me</u><br>Architect<br>Football/Swimming</p>
        <input type ="button" onclick ="ignoreReq(${ID})"  value = "Ignore">
        <input type ="button" onclick ="acceptReq(${ID})"  value = "Accept">
      <!--  <p id ="testOP"> <script> document.getElementById("testOP").innerHTML += document.getElementById("test").name;</script></p> -->
      </div>
    </div>
        <% }
        %>
        </form>
        </body>
</html>
