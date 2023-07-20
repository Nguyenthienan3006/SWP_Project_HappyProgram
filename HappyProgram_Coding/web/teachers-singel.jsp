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
        <link rel="stylesheet" href="css/responsive.css">
    </head>
    <body>
        <!--====== HEADER PART START ======-->
        <jsp:include page="header.jsp"></jsp:include>

            <!--====== HEADER PART ENDS ======-->

            <!--====== PAGE BANNER PART START ======-->

            <section id="page-banner" class="pt-105 pb-130 bg_cover" data-overlay="8" style="background-image: url(images/page-banner-3.jpg)">
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
                            </div> <!-- page banner cont -->
                        </div>
                    </div> <!-- row -->
                </div> <!-- container -->
            </section>

            <!--====== PAGE BANNER PART ENDS ======-->

            <!--====== TEACHERS PART START ======-->

            <section id="teachers-singel" class="pt-70 pb-120 gray-bg">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-4 col-md-8">
                            <div class="teachers-left mt-50">
                                <div class="hero">
                                    <img src="${cv.getImg()}" alt="Teachers">
                            </div>
                            <div class="name">
                                <h6>${cv.getFullname()}</h6>   
                                <span>Username: ${cv.getAccountname()}</span>
                            </div>
                            <div class="social">
                                <ul>
                                    <li><a href="#"><i class="fa fa-facebook-square"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter-square"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus-square"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin-square"></i></a></li>
                                </ul>
                            </div>
                            <div class="description">
                                <p>Rate Star</p>
                                <p>${sessionScope.rs}/5.0</p>

                            </div>
                        </div> <!-- teachers left -->
                    </div>
                    <div class="col-lg-8">
                        <div class="teachers-right mt-50">
                            <ul class="nav nav-justified" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="active" id="dashboard-tab" data-toggle="tab" href="#dashboard" role="tab" aria-controls="dashboard" aria-selected="true">Dashboard</a>
                                </li>
                                <li class="nav-item">
                                    <a id="courses-tab" data-toggle="tab" href="#courses" role="tab" aria-controls="courses" aria-selected="false">Courses</a>
                                </li>
                                <li class="nav-item">
                                    <a id="reviews-tab" data-toggle="tab" href="#reviews" role="tab" aria-controls="reviews" aria-selected="false">Reviews</a>
                                </li>
                            </ul> <!-- nav -->
                            <div class="tab-content" id="myTabContent">
                                <div class="tab-pane fade show active" id="dashboard" role="tabpanel" aria-labelledby="dashboard-tab">
                                    <div class="dashboard-cont">
                                        <div class="singel-dashboard pt-40">
                                            <h5>About</h5>
                                            <p>Welcome to our programming language learning website! Our exceptional team of Mentors is eager to guide you through the world of coding. Whether you're a beginner or an experienced programmer, they are dedicated to supporting your learning goals. With engaging lessons and practical projects, you'll master programming skills and tackle real-world challenges. Join us and explore the joy of coding with our trustworthy Mentors!</p>
                                        </div> <!-- singel dashboard -->
                                        <div class="singel-dashboard pt-40">
                                            <h5>Acchivments</h5>
                                            <p>-${cv.getAchievements()}</p>
                                        </div> <!-- singel dashboard -->

                                        <div class="singel-dashboard pt-40">
                                            <h5>My Professinal</h5>
                                            <p>-${cv.getProfession()}</p>
                                        </div> <!-- singel dashboard -->

                                        <div class="singel-dashboard pt-40">
                                            <h5>Skills</h5>
                                            <c:forEach items="${skillMentor}" var="skill">
                                                <td>-${skill}<br></td>
                                                </c:forEach>
                                        </div> <!-- singel dashboard -->

                                        <div class="singel-dashboard pt-40">
                                            <h5>My Education</h5>
                                            <p>-${cv.getEducation()}</p>
                                        </div> <!-- singel dashboard -->

                                        <div class="singel-dashboard pt-40">
                                            <h5>My Work Experience</h5>
                                            <p>-${cv.getWorkExperience()}</p>
                                        </div> <!-- singel dashboard -->
                                    </div> <!-- dashboard cont -->
                                </div>
                                <style>
                                    /* Định dạng cho các phần tử <p> */
                                    p {
                                        font-size: 16px;

                                    }

                                    /* Định dạng cho Mentor ID */
                                    .mentor-id {
                                        font-weight: bold;
                                    }

                                    /* Định dạng cho số lượng request */
                                    .request-count {
                                        color: #007bff; /* Màu xanh dương */
                                    }

                                    /* Định dạng cho phần trăm hoàn thành */
                                    .percentage {
                                        color: #28a745; /* Màu xanh lá cây */
                                        font-weight: bold;
                                    }
                                </style>
                                <br>
                                <div class="tab-pane fade" id="courses" role="tabpanel" aria-labelledby="courses-tab" >
                                    <!-- HTML -->
                                    <p class="mentor-id">Mentor ID: ${sessionScope.mentorCV.getMentorID()}</p>
                                    <p class="request-count">Number of all requests: ${sessionScope.mentorCV.getTotalReq()}</p>
                                    <p class="request-count">Number of currently accepted requests: ${sessionScope.mentorCV.getAcceptReq()}</p>
                                    <p class="request-count">Number of Complete requests: ${sessionScope.mentorCV.getCompleteReq()}</p>
                                    <p class="percentage">Percentage completed: ${sessionScope.mentorCV.getCompletePer()}%</p>
                                </div>

                                <div class="tab-pane fade" id="reviews" role="tabpanel" aria-labelledby="reviews-tab">
                                    <div class="reviews-cont">
                                        <div class="title">
                                            <h6>Student Reviews</h6>
                                        </div>
                                        <ul>                             
                                            <li>
                                                <c:forEach items="${sessionScope.commentList}" var="cmt">
                                                    <div class="singel-reviews">                                                        
                                                        <div class="reviews-description pt-20">   
                                                            <a class="pull-left" href="#fakelink">
                                                                <img style="width: 50px;" src="https://bootdey.com/img/Content/User_for_snippets.png" alt="Avatar">                                                   
                                                                <a style="font-weight: bold" href="#">Anonymous</a>    
                                                            </a>
                                                            <div class="rating">
                                                                <span>${cmt.getRateStar()}</span>
                                                                <ul>
                                                                    <li><i class="fa fa-star"></i></li>                                            
                                                                </ul>                                                              
                                                            </div>                                                            
                                                            <br>
                                                            <p>${cmt.getCommentContent()}</p>
                                                        </div>
                                                    </div> <!-- singel reviews -->
                                                </c:forEach>
                                            </li>
                                        </ul>

                                    </div> <!-- reviews cont -->
                                </div>
                            </div> <!-- tab content -->
                        </div> <!-- teachers right -->
                    </div>
                </div> <!-- row -->
            </div> <!-- container -->

            <div style="display: flex; justify-content: center; margin-top: 3%">
                <a href="View_mentorList">
                    <input style="

                           padding: 10px 20px;
                           background-color: #004085;
                           color: white;
                           border: none;
                           border-radius: 10px;
                           cursor: pointer;
                           font-size: 16px;
                           font-weight: bold;" type="Submit" value="Back">
                </a>
            </div>
        </section>

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
