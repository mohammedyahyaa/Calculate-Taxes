<%-- 
    Document   : error
    Created on : May 9, 2018, 5:49:15 PM
    Author     : mohamed
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>


<!DOCTYPE html>
<html class="animated fadeIn">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='animationPage.css' rel='stylesheet' type='text/css'>
        <link href='fonts.css' rel='stylesheet' type='text/css'>
        <title>Error Page </title>
        <style>
             body{
              background-image: url(images/signup_new.jpg);
              background-repeat: no-repeat;
              background-size: cover;
             }
             *{
              font-family: "open sans";
             }
            h1{
                color: red;
                padding:15px; 
                text-align: center;
            }
            h2{
                color: #fff;
                padding:15px; 
                text-align: center;
            }
            img{
                margin-left: 40%;
            }
        </style>
    </head>
    <body>
        
        <h1>your page Generated error!</h1>
        <h1><%= exception %></h1>
        
             
        <div id="logo">
            <img alt="error" src="images/Sign-Error-icon.png">
           
           </div>
        
 
    </body>
</html>
