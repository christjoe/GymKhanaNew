<%-- 
    Document   : viewPlan
    Created on : 31 Jul, 2021, 12:05:21 PM
    Author     : iamsm
--%>


<%@page contentType="text/html" pageEncoding="UTF-8" import = "ActivityModule.UserModel,ActivityModule.ActivityModel" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Plans</title>
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
div .user {
    float:left;
}
div .activity {
    float:left;
}
div .buttons {
    float:left;
}
        </style>
        <script src ="scripts/respondReq.js"></script>
    </head>
    <body>
        <h3>PLANS RECEIVED</h3>
        <hr>
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
            int ListLength = ((UserModel[])request.getAttribute("UPlanRec")).length;
            System.out.println(ListLength);
            UserModel[] ReqUsers = new UserModel[ListLength];
            ActivityModel[] PlanRec = new ActivityModel[ListLength];
            System.arraycopy((UserModel[])request.getAttribute("UPlanRec"),0,ReqUsers,0,ListLength);
            System.arraycopy((ActivityModel[])request.getAttribute("APlanRec"),0,PlanRec,0,ListLength);
            
            for(int i =0;i<ListLength;i++)
            {
                
            pageContext.setAttribute("U_Name",  ReqUsers[i].getName());
            pageContext.setAttribute("U_ID",  ReqUsers[i].getID());
            pageContext.setAttribute("A_Name",  PlanRec[i].getName());
            pageContext.setAttribute("A_Date",  PlanRec[i].getDate());
            pageContext.setAttribute("A_Time",  PlanRec[i].getTime());
        %>
        <!-- <p> Name : ${Name} </p> -->
        <div class="card">
      <img src="images/meet.png" alt="Avatar" style="width: 20%; height: 30%; padding-left: 2%; padding-bottom: 2%; padding-top: 2%; ">
      <div class="container">
        <div class ="user">
        <h4><b>${U_Name}</b></h4>
        <p><u>About me</u><br>Architect<br>Football/Swimming</p>
        </div>
        <div class ="activity">
            <h4>${A_Name}</h4>
            <p>Date : ${A_Date}</p>
           <p>Time : ${A_Time}</p>
        </div>
        <div class ="buttons">
        <input type ="button" onclick ="ignoreReq(${ID})"  value = "Ignore">
        <input type ="button" onclick ="acceptReq(${ID})"  value = "Accept">
      <!--  <p id ="testOP"> <script> document.getElementById("testOP").innerHTML += document.getElementById("test").name;</script></p> -->
        </div>
      </div>
    </div>
        <% }
        %>
        </form>
        <hr>
        <h3>PLANS SENT</h3>
        <hr>
         <%  ListLength = ((UserModel[])request.getAttribute("UPlanSent")).length;
            System.out.println(ListLength);
            UserModel[] SentUsers = new UserModel[ListLength];
            ActivityModel[] PlanSent = new ActivityModel[ListLength];
            System.arraycopy((UserModel[])request.getAttribute("UPlanSent"),0,SentUsers,0,ListLength);
            System.arraycopy((ActivityModel[])request.getAttribute("APlanSent"),0,PlanSent,0,ListLength);
            
            for(int i =0;i<ListLength;i++)
            {
                
            pageContext.setAttribute("U_Name",  SentUsers[i].getName());
            pageContext.setAttribute("U_ID",  SentUsers[i].getID());
            pageContext.setAttribute("A_Name",  PlanSent[i].getName());
            pageContext.setAttribute("A_Date",  PlanSent[i].getDate());
            pageContext.setAttribute("A_Time",  PlanSent[i].getTime());
        %>
         <!-- <p> Name : ${Name} </p> -->
        <div class="card">
      <img src="images/meet.png" alt="Avatar" style="width: 20%; height: 30%; padding-left: 2%; padding-bottom: 2%; padding-top: 2%; ">
      <div class="container">
        <div class ="user">
        <h4><b>${U_Name}</b></h4>
        <p><u>About me</u><br>Architect<br>Football/Swimming</p>
        </div>
        <div class ="activity">
            <h4>${A_Name}</h4>
            <p>Date : ${A_Date}</p>
           <p>Time : ${A_Time}</p>
        </div>
      <!--  <p id ="testOP"> <script> document.getElementById("testOP").innerHTML += document.getElementById("test").name;</script></p> -->
      </div>
    </div>
        <% }
        %>
        </body>
</html>
