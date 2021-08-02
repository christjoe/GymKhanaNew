<%-- 
    Document   : viewConfirmed
    Created on : 1 Aug, 2021, 5:30:40 PM
    Author     : iamsm
--%>


<%@page contentType="text/html" pageEncoding="UTF-8" import = "ActivityModule.UserModel,ActivityModule.RespondPlan.ActivityModel" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href='https://fonts.googleapis.com/css?family=Orbitron' rel='stylesheet' type='text/css'>
        <title>View Confirmed Plans</title>
        <style>
            body{
                padding-left : 20%;
            }
            
            .card {
        box-shadow: 0 4px 8px 0 rgba(0,0,0,0.5);
        transition: 0.3s;
        width: 120%;
        height: 40%;
        padding-bottom: 4%;
      }

      .card:hover {
        box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
        background: linear-gradient(to right, #d6724e, #f5551a);
      }

      h3{
        transform: translate(30px,50px);
      }

      .container {
        float: right;
        padding-right: 2%;
      }
       
      .calendar{
        transform: translate(-350px,-30px);
      }

      .time{
        font-size: 20px;
        transform: translate(-160px,-200px);
        font-family: 'Orbitron', sans-serif;
      }

      .date{
        font-family: Impact, Charcoal, sans-serif;
        font-size: 20px;
        transform: translate(-370px,-90px);
      }

      .clock{
        transform: translate(-170px,-150px);
      }
        </style>
    </head>
    <body>
        <h3>Confirmed Activities</h3>
        <hr> 
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
            int ListLength = ((UserModel[])request.getAttribute("UActCon")).length;
            System.out.println(ListLength);
            UserModel[] ReqUsers = new UserModel[ListLength];
            ActivityModel[] ActCon = new ActivityModel[ListLength];
            System.arraycopy((UserModel[])request.getAttribute("UActCon"),0,ReqUsers,0,ListLength);
            System.arraycopy((ActivityModel[])request.getAttribute("AActCon"),0,ActCon,0,ListLength);
            
            for(int i =0;i<ListLength;i++)
            {
                
            pageContext.setAttribute("U_Name",  ReqUsers[i].getName());
            pageContext.setAttribute("U_ID",  ReqUsers[i].getID());
            pageContext.setAttribute("A_ID",  ActCon[i].getID());
            pageContext.setAttribute("A_Name",  ActCon[i].getName());
            pageContext.setAttribute("A_Date",  ActCon[i].getDate());
            pageContext.setAttribute("A_Time",  ActCon[i].getTime());
        %>
        <!-- <p> Name : ${Name} </p> -->
        <div class="card">
      <img src="images/meet.png" style="width: 20%; height: 85%; padding-left: 2%; padding-bottom: 2%; padding-top: 2%; ">
      <div class="container">
        <h3><b>${U_Name}}</b></h3>
        <img class="calendar" src="images/calendar.jpg" style="width: 70%; height: 70%; padding-bottom: 2%; padding-top: 2%;">
        <div align="center" class="date">${A_Date}</div>
        <img class="clock" src="images/clock.jpg" style="width: 100%; height: 50%; padding-bottom: 2%; padding-top: 2%;">
        <div class="time">${A_Time}</div>
      </div>
    </div>
        <% }
        %>
      
        
        </body>
</html>
