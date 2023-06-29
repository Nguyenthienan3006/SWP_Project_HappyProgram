<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Change Password</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            body {
                background-color: #f7f7f7;
            }

            .login-form {
                max-width: 340px;
                margin: 50px auto;
                padding: 30px;
                background: #f7f7f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            }

            .login-form h2 {
                margin-bottom: 15px;
            }

            .login-form h5 {
                margin-bottom: 20px;
            }

            .form-group label {
                font-weight: bold;
            }

            .form-control {
                min-height: 38px;
                border-radius: 2px;
            }

            .btn {
                font-size: 15px;
                font-weight: bold;
                margin-top: 15px;
            }

            .text-danger {
                color: red;
                margin-bottom: 15px;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="login-form">
                        <form action="change" method="post">
                            <h2 class="text-center">Change Password</h2>
                            <p class="text-danger">${mess}</p>
                            <div class="form-group">
                                <label for="userName">Username:</label>
                                <input type="text" id="userName" name="userName" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="currentPassword">Current Password:</label>
                                <input type="password" id="currentPassword" name="currentPassword" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="newPassword">New Password:</label>
                                <input type="password" id="newPassword" name="newPassword" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="confirmPassword">Confirm Password:</label>
                                <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" required>
                            </div>
                            <div class="form-group text-center">
                                <input type="submit" value="Change Password" class="btn btn-primary">
                                <a href="suggest" class="btn btn-link">Back to Homepage</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="js/main.js"></script>
        <script src="vendor/jquery/jquery.min.js"></script>
        <link rel="stylesheet" href="alert/dist/sweetalert.css">

        <script type="text/javascript">
            var mess = document.getElementById("mess").value;
            if (mess === "success") {
                swal("Hello!");
            }
        </script>
    </body>
</html>
