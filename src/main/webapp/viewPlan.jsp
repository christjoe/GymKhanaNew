<%-- 
    Document   : viewPlan
    Created on : 31 Jul, 2021, 12:05:21 PM
    Author     : iamsm
--%>


<%@page contentType="text/html" pageEncoding="UTF-8" import = "ActivityModule.UserModel,ActivityModule.RespondPlan.ActivityModel" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='https://fonts.googleapis.com/css?family=Orbitron' rel='stylesheet' type='text/css'>
        <title>View Plans</title>
        <style>
            body{
                padding-left : 20%;
            }
            
            .card {
        box-shadow: 0 4px 8px 0 rgba(0,0,0,0.5);
        transition: 0.3s;
        overflow : auto;
        padding-bottom: 5%;
        padding-top: 2%;
      }

      .card:hover {
        box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
        background: linear-gradient(to right, #d6724e, #f5551a);
        overflow : hidden;
      }

      h3{
      /*  transform: translate(30px,50px); */
      }
      #aname {
          clear:both;
          margin-left : 50%;
          margin-top: -20%;
      }
      
       .date{
        font-family: Impact, Charcoal, sans-serif;
        font-size: 20px;
   /*     transform: translate(-370px,-90px); */
        float : left;
        background-image : url("images/calendar.jpg");
       width : 169px;
       height : 166px;
       margin-left: 30%;
       margin-top: -7%;
       }
      
      #dateval{
         margin-top : 50%;
         margin-left:  25%;
      }
      
      .time{
        font-size: 20px;
/*        transform: translate(-160px,-200px); */
        font-family: 'Orbitron', sans-serif;
        float:left;
        background-image : url("images/clock.jpg");
        background-size : cover;
        border : 1px solid black;
       width : 212px;
       height : 113px;
       margin-left: 50%;
       margin-top:-12%;
      }

      

      #timeval{
/*        transform: translate(-170px,-150px); */
         margin-top : 15%;
         margin-left : 30%;
         font-size: 30px;
         
      }
      #uname {
          margin-left : 80%;
          font-size: 25px;
      }
      
      #aname{
          font-size: 20px;
      }
      
      .buttons{
         padding-left: 80%;
      }
        </style>
        <script src ="scripts/respondPlan.js"></script>
    </head>
    <body>
        <h3>PLANS RECEIVED</h3>
        <hr>
        <form action="respondPlan" method ="POST" id="planForm">
            <input type ="hidden" name ="responseTo" value = "">
            <input type ="hidden" name ="response" value = "">
            <input type ="hidden" name ="A_ID" value = "">   
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
            pageContext.setAttribute("A_ID",  PlanRec[i].getID());
            pageContext.setAttribute("A_Name",  PlanRec[i].getName());
            pageContext.setAttribute("A_Date",  PlanRec[i].getDate());
            pageContext.setAttribute("A_Time",  PlanRec[i].getTime());
        %>
        <!-- <p> Name : ${Name} </p> -->
        <div class="card">
      <img src="images/meet.png" alt="Avatar" style="padding-left: 2%; padding-bottom: 2%; padding-top: 2%;">
      <div class="container">
        <div class ="user">
            <h4 id="aname">${A_Name}</h4>
        <h3 id = "uname"><b>${U_Name}</b></h3>
        </div>
        <div class ="activity">
            
            
            <div class="date">
            <div id = "dateval">${A_Date}</div>
            </div>
            
           <div class="time">
            <div id = "timeval">${A_Time}</div>
           </div>
        </div>
        <div class ="buttons">
            <input type ="button" onclick ="ignoreReq(${U_ID},${A_ID})"  value = "Ignore"> 
            <input type ="button" onclick ="acceptReq(${U_ID},${A_ID})"  value = "Accept">
      <!--  <p id ="testOP"> <script> document.getElementById("testOP").innerHTML += document.getElementById("test").name;</script></p> -->
        </div>
      </div>
    </div>
      <br>
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
      <img src="images/meet.png" alt="Avatar" style="padding-left: 2%; padding-bottom: 2%; padding-top: 2%;">
      <div class="container">
        <div class ="user">
            <h4 id="aname">${A_Name}</h4>
        <h3 id = "uname"><b>${U_Name}</b></h3>
        </div>
        <div class ="activity">
            <div class="date">
            <div id = "dateval">${A_Date}</div>
            </div>
            
           <div class="time">
            <div id = "timeval">${A_Time}</div>
           </div>
        </div>
      <!--  <p id ="testOP"> <script> document.getElementById("testOP").innerHTML += document.getElementById("test").name;</script></p> -->
      </div>
    </div>
           <br>
        <% }
        %>
        </body>
</html>
