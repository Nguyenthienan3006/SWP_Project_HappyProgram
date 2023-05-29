<%-- 
    Document   : teacher
    Created on : May 24, 2023, 2:53:05 PM
    Author     : havie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--====== Required meta tags ======-->
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--====== Title ======-->
        <title>Happy Programming</title>

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
        <link rel="stylesheet" href="css/responsive.css">    </head>
    <body>
        <!--====== HEADER PART START ======-->
        <jsp:include page="header.jsp"></jsp:include>
            <!--====== HEADER PART ENDS ======-->


            <!--====== PAGE BANNER PART START ======-->

            <section id="page-banner" class="pt-105 pb-110 bg_cover" data-overlay="8" style="background-image: url(images/page-banner-3.jpg)">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="page-banner-cont">
                                <h2>Teachers</h2>
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Teachers</li>
                                    </ol>
                                </nav>
                            </div>  <!-- page banner cont -->
                        </div>
                    </div> <!-- row -->
                </div> <!-- container -->
            </section>

            <!--====== PAGE BANNER PART ENDS ======-->

            <!--====== TEACHERS PART START ======-->

            <section id="teachers-page" class="pt-90 pb-120 gray-bg">
                <div class="container">
                    <div class="row">
                    <c:forEach items="${session.mentorList}" var="LS">
                        <div class="col-lg-3 col-sm-6">
                            <div class="singel-teachers mt-30 text-center">
                                <div class="image">
                                    <img src="images/teachers/t-1.jpg" alt="Teachers">
                                </div>
                                <div class="cont">
                                    <a href="#"><h6> items="${requestScope.listSkill}" </h6></a>
                                    <span>Vice chencelor</span>
                                </div>
                            </div>  singel teachers 
                        </div>
                    </c:forEach>

                    </section>



                    <!--====== TEACHERS PART ENDS ======-->

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
                    f