<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Happy Programming</title>

        <!-- Font Icon -->
        <link rel="stylesheet"
              href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>

        <div class="main">

            <!-- Sign up form -->
            <section class="signup">
                <div class="container">
                    <div class="signup-content">
                        <div class="signup-form">
                            <h2 class="form-title">Sign up</h2>
                            <p style="color: red">${mess}</p>

                            <form action="signup" method="get" class="register-form" id="register-form">
                                <div class="form-group">
                                    <label for="name">
                                        <i class="zmdi zmdi-account material-icons-name"></i>
                                    </label> 
                                    <input type="text" name="user" id="user" placeholder="Username" />
                                </div>

                                <div class="form-group">
                                    <label for="pass">
                                        <i class="zmdi zmdi-lock"></i>
                                    </label> 
                                    <input type="password" name="pass" id="pass" placeholder="Password" />
                                </div>

                                <div class="form-group">
                                    <label for="re-pass">
                                        <i class="zmdi zmdi-lock-outline"></i>
                                    </label>
                                    <input type="password" name="cfpass" id="re_pass"  placeholder="Repeat your password" />
                                </div>
                                <div class="form-group">
                                    <label for="name">
                                        <i class="zmdi zmdi-account material-icons-name"></i>
                                    </label> 
                                    <input  type="text" name="fullname" id="name" placeholder="Fullname" />
                                </div>
                                <div>
                                      <select name="gender">
                                        <option value="male">Male</option>
                                        <option value="female">Female</option>
                                    </select>                                   
                                </div>
                                <div class="form-group">
                                    <label for="name">
                                        <i  class="zmdi zmdi-account material-icons-name"></i>
                                    </label> 
                                    <input  type="date" name="dob" id="name" placeholder="Date of birth" />
                                </div>
                                <div class="form-group">
                                    <label for="email">
                                        <i class="zmdi zmdi-email"></i>
                                    </label>
                                    <input type="email" name="email" id="email" placeholder="Your Email" />
                                </div>
                                <div class="form-group">
                                    <label for="name">
                                        <i class="zmdi zmdi-account material-icons-name"></i></label> <input
                                        type="number" name="phone" id="name" placeholder="Phone number" />
                                </div>
                                <div class="form-group">
                                    <label for="contact">
                                        <i class="zmdi zmdi-lock-outline"></i>
                                    </label>
                                    <input type="text" name="address" id="contact"  placeholder="Address " />
                                </div>

                                <div class="form-group">
                                    Join as: 
                                    <select name="role">
                                        <option value="1">Mentee</option>
                                        <option value="2">Mentor</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <input type="checkbox" name="agree-term" id="agree-term"
                                           class="agree-term" /> <label for="agree-term"
                                           class="label-agree-term"><span><span></span></span>I
                                        agree all statements in <a href="#" class="term-service">Terms
                                            of service</a></label>
                                </div>
                                <div class="form-group form-button">
                                    <input type="submit" name="signup" id="signup"
                                           class="form-submit" value="Sign up" />
                                </div>
                            </form>
                        </div>
                        <div class="signup-image">
                            <figure>
                                <img src="images/signup-image.jpg" alt="sing up image">
                            </figure>
                            <a href="signin.jsp" class="signup-image-link">I am already member</a>
                            <a href="home.jsp" class="signup-image-link">Back to homepage</a>
                        </div>
                    </div>
                </div>
            </section>


        </div>
        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>



    </body>
    <!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>