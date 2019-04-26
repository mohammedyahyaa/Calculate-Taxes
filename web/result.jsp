<%-- 
    Document   : newjsp
    Created on : May 1, 2018, 3:25:15 PM
    Author     : Dell
--%>


<%@page import="model.calculateData"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSp Page</title>

    </head>
    <body>
        <%
        calculateData cd= (calculateData) request.getAttribute("object");


        %>
        
        <p>Total Paid To Date:</p>
        <p style="border: 2px solid gray; background-color: skyblue; width: 500px; height: 100px">
          
        </p>
        <br>
        <p>YOur tax:</p>
        <p style="border: 2px solid gray; background-color: skyblue; width: 500px; height: 100px">
            
            
        </p>
        
        
        
    </body>
</html>
