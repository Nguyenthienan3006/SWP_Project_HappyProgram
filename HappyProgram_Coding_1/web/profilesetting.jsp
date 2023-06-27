<%-- 
    Document   : teacher-singel
    Created on : May 24, 2023, 3:06:05 PM
    Author     : havie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <style>
            .breadcrumb-item a{
                text-decoration: none;
            }
        </style>
        
        <script>
            //nó s? th?c thi khi trang web ?ã hoàn thành vi?c t?i và s?n sàng cho vi?c thao tác.
            $(document).ready(function () {
                //l?y thông báo t? phiên
                var message = '<%= session.getAttribute("message") %>';

                // ki?m tra và hi?n th?
                if (message != null) {
                    // ??t n?i dung c?a ph?n t? có id là "message" b?ng giá tr? c?a bi?n message. 
                    $('#message').text(message);
                    //  thi?t l?p thông báo t? bi?n m?t sau 5s.
                    setTimeout(function () {
                        //làm m? message ch?m d?n
                        $('#message').fadeOut('slow', function () {
                        });
                    }, 5000);
                }
            });
        </script>

        <!--====== Required meta tags ======-->
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--====== Title ======-->
        <title>Profile Setting</title>

        <!--====== Favicon Icon ======-->
        <link rel="shortcut icon" href="images/favicon.png" type="image/png">

        <!--====== Slick css ======-->
        <link rel="stylesheet" href="css/slick.css">

        <!--====== Animate css ======-->
        <link rel="stylesheet" href="css/animate.css">

        <!--====== Nice Select css ======-->
        <link rel="stylesheet" href="css/nice-select.css">

        <!--====== Nice Number css ======-->
        <link rel="stylesheet" href="css/jquery.nice-number.min.css">

        <!--====== Magnific Popup css ======-->
        <link rel="stylesheet" href="css/magnific-popup.css">

        <!--====== Bootstrap css ======-->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!--====== Fontawesome css ======-->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!--====== Default css ======-->
        <link rel="stylesheet" href="css/default.css">

        <!--====== Style css ======-->
        <link rel="stylesheet" href="css/style.css">

        <!--====== Responsive css ======-->
        <link rel="stylesheet" href="css/responsive.css">
        <style>
            .card-header{
                text-align: center;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <!--====== HEADER PART START ======-->
        <jsp:include page="header.jsp"></jsp:include>
        
        <c:if test="${sessionScope.message != null}">
            <div id="message" class="str1">
                <% 
                // l?y giá tr? c?a thu?c tính "message" t? ??i t??ng session.
                String message = (String) session.getAttribute("message");
        
               // ki?m tra và hi?n th? thông báo
                if (message != null && !message.isEmpty()) {               
                    // Xóa thông báo sau khi hi?n th?
                    session.removeAttribute("message");
                }
                %>
            </div>
        </c:if>

            <!--====== HEADER PART ENDS ======-->

            <!--====== PAGE BANNER PART START ======-->

            <section id="page-banner" class="pt-105 pb-130 bg_cover" data-overlay="8" style="background-image: url(images/page-banner-3.jpg)">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="page-banner-cont">
                                <h2>Profile Setting</h2>
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Profile Setting</li>
                                    </ol>
                                </nav>
                            </div> <!-- page banner cont -->
                        </div>
                    </div> <!-- row -->
                </div> <!-- container -->
            </section>

            <!--====== PAGE BANNER PART ENDS ======-->

            <!--====== TEACHERS PART START ======-->




            <div class="container-xl px-4 mt-4">

                <hr class="mt-0 mb-4">
                <form action="updateprofile" method="post">
                    <div class="row">
                        <div class="col-xl-4">
                            <!-- Profile picture card-->
                            <div class="card mb-4 mb-xl-0">
                                <div class="card-header">Profile Picture</div>
                                <div class="card-body text-center">
                                    <!-- Profile picture image-->
                                    <img class="img-account-profile rounded-circle mb-2" src="${sessionScope.user.img}" alt="">
                                <!-- Profile picture help block-->
                                <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                                <!-- Profile picture upload button-->
                                <input type="hidden" name="current_img" id ="current_img" value="${sessionScope.user.img}">
                                <input style="justify-items: center;" type="file" name="img" id="img" >
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-8">
                        <!-- Account details card-->
                        <div class="card mb-4">
                            <div class="card-header">Account Details</div>
                            <div class="card-body">

                                <!-- Form Group (username)-->
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputUsername">Full Name (how your name will appear to other users on the site)</label>
                                    <input class="form-control" id="inputUsername" type="text" placeholder="Enter your username" value="${sessionScope.user.fullname}" name="inputUsername">
                                </div>
                                <!-- Form Row        -->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (location)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputLocation">Location</label>
                                        <input class="form-control" id="inputLocation" type="text" placeholder="Enter your location" value="${sessionScope.user.address}" name="inputLocation">
                                    </div>
                                </div>
                                <!-- Form Group (email address)-->
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputEmailAddress">Email address</label>
                                    <input class="form-control" name="inputEmailAddress" readonly value="${sessionScope.user.email}">
                                </div>
                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (phone number)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputPhone">Phone number</label>
                                        <input class="form-control" id="inputPhone" type="tel" placeholder="Enter your phone number" value="${sessionScope.user.phoneNumber}" name="inputPhone">
                                    </div>

                                    <!-- Form Group (birthday)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputBirthday">Birthday</label>
                                        <input class="form-control" id="inputBirthday" type="date" name="inputBirthday" placeholder="Enter your birthday"  value="${sessionScope.user.dob}" name="inputBirthday">
                                    </div>
                                    <!-- Form Group (gender)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="gender">Gender</label>
                                        <select class="form-control" name="gender" id="gender" style="  padding: 10px; border: 1px solid #ccc; border-radius: 4px; font-size: 12px;" required>
                                            <option value="1" <c:if test="${sessionScope.user.gender == true}">selected="true"</c:if>>Male</option>
                                            <option value="2" <c:if test="${sessionScope.user.gender == false}">selected="true"</c:if>>Female</option>
                                        </select>
                                    </div>
                                </div>
                                <!-- Save changes button-->
                                <button class="main-btn" value="submit" >Update</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>                    

        </div>

        <!--====== EVENTS PART ENDS ======-->

        <!--====== FOOTER PART START ======-->

        <jsp:include page="footer.jsp"></jsp:include>

        <!--====== FOOTER PART ENDS ======-->

        <!--====== BACK TO TP PART START ======-->

        <a href="#" class="back-to-top"><i class="fa fa-angle-up"></i></a>

        <!--====== BACK TO TP PART ENDS ======-->


        <!--====== jquery js ======-->
        <script src="js/vendor/modernizr-3.6.0.min.js"></script>
        <script src="js/vendor/jquery-1.12.4.min.js"></script>

        <!--====== Bootstrap js ======-->
        <script src="js/bootstrap.min.js"></script>

        <!--====== Slick js ======-->
        <script src="js/slick.min.js"></script>

        <!--====== Magnific Popup js ======-->
        <script src="js/jquery.magnific-popup.min.js"></script>

        <!--====== Counter Up js ======-->
        <script src="js/waypoints.min.js"></script>
        <script src="js/jquery.counterup.min.js"></script>

        <!--====== Nice Select js ======-->
        <script src="js/jquery.nice-select.min.js"></script>

        <!--====== Nice Number js ======-->
        <script src="js/jquery.nice-number.min.js"></script>

        <!--====== Count Down js ======-->
        <script src="js/jquery.countdown.min.js"></script>

        <!--====== Validator js ======-->
        <script src="js/validator.min.js"></script>

        <!--====== Ajax Contact js ======-->
        <script src="js/ajax-contact.js"></script>

        <!--====== Main js ======-->
        <script src="js/main.js"></script>

        <!--====== Map js ======-->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDC3Ip9iVC0nIxC6V14CKLQ1HZNF_65qEQ"></script>
        <script src="js/map-script.js"></script>
    </body>
</html>
