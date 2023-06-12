<%-- 
    Document   : changepass
    Created on : May 26, 2023, 8:27:29 PM
    Author     : asus
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<!--    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>-->
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Change password</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            .login-form {
                width: 340px;
                margin: 50px auto;
                font-size: 15px;
            }
            .login-form form {
                margin-bottom: 15px;
                background: #f7f7f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .login-form h2 {
                margin: 0 0 15px;
            }
            .form-control, .btn {
                min-height: 38px;
                border-radius: 2px;
            }
            .btn {
                font-size: 15px;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <div class="login-form">
            
    <form action="change" method="post">
        <h2 class="text-center">Change Password</h2>
        <p class = "text-danger">${mess}</p>
         <label for="currentPassword">User name:</label><br>
        <input type="text" id="userName" name="userName" required><br><br>
        <label for="currentPassword">Current Password:</label>
        <input type="password" id="currentPassword" name="currentPassword" required><br><br>
        <label for="newPassword">New Password:</label>
        <input type="password" id="newPassword" name="newPassword" required><br><br>
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required><br><br>
        <input type="submit" value="Change Password">
        <a href="home.jsp"> Back to homePage</a>
    </form>
         
         
        </div>
        
    <%
     String mess = (String) request.getAttribute("mess");
     if(mess.length() > 0)
    %>
    <h2><%=mess%></h2>
    </body>
</html>
