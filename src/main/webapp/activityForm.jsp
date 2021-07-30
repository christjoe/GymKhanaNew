<%-- 
    Document   : activityForm
    Created on : 30 Jul, 2021, 9:50:17 AM
    Author     : iamsm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <style>
      body{
        padding-left: 20%;
        
      }

      label{
        font-family: Arial, Helvetica, sans-serif;
      }

      input[type = text], input[type = date], input[type = time]{
        width: 50%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
      }

    </style>
    <script src ="scripts/actPartner.js"></script>
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
       //     String PartName = (String)request.getAttribute("planWithName");
      //      int PartID = (int)request.getAttribute("planWithID");
     //       pageContext.setAttribute("planWithName",PartName);
       //     pageContext.setAttribute("planWithID",PartID);          %>
    <div class="plan" onmouseclick = "teltime()">
      <h3>Plan an activity with ${planWithName} !</h3><br>


      <form action="sendPlan" method = "POST" id = "plan">
          <input type ="hidden" name ="planWithID" value = "">
            <input type ="hidden" name ="planWithName" value = "">
        <label>What would you like to do?</label> <input type="text" placeholder="Enter activity" name = "a_name"> <br><br>
        <label>Choose a date: </label> <input type="date" name = "a_date"> <br><br>
        <label>Choose time: </label> <input type="time" id="testtime" name = "a_time"> <br><br>
        <input type="button" value="Plan" onclick ="addPlanWith(${planWithID},'${planWithName}')">
      <br>
      <br>
      <p id = "time"></p>
      </form>
      <script>
      function teltime(){
      document.getElementById("time").innerHTML += document.getElementById("testtime").value;
  }
      </script>
    </div>
  </body>
</html>