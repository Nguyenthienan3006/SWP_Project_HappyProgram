<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <style>
            /* Đặt font chữ và màu nền cho phần tiêu đề */
            h2 {
                font-family: Arial, sans-serif;
                padding: 10px;
            }

            /* Điều chỉnh kích thước và màu sắc của breadcrumb */
            .breadcrumb-item a {
                font-size: 14px;
                color: #999999;
            }



            /* Điều chỉnh kiểu nền và khoảng cách của phần khóa học */
            #courses-part {
                background-color: #f9f9f9;
                padding-top: 120px;
                padding-bottom: 120px;
            }

            /* Điều chỉnh kích thước và màu sắc của tiêu đề khóa học */
            .singel-course h4 {
                font-size: 18px;
                color: #333333;
                margin-top: 10px;
                margin-bottom: 10px;
            }

            /* Điều chỉnh kích thước và màu sắc của trạng thái khóa học */
            .singel-course h5 {
                font-size: 16px;
                color: #666666;
                margin-top: 5px;
                margin-bottom: 0;
            }

            /* Tùy chỉnh kiểu nền và màu sắc của nút "Join with us" */
            .course-teacher .name a {
                background-color: #ff6600;
                color: #ffffff;
                padding: 10px 20px;
                border-radius: 5px;
                text-decoration: none;
                display: inline-block;
            }

            /* Điều chỉnh kích thước và màu sắc của nút "Change Status" */
            .status-button a {
                font-size: 14px;
                color: #ffffff;
                padding: 8px 16px;
                background-color: #333333;
                border-radius: 5px;
                text-decoration: none;
                display: inline-block;
            }



            /* Điều chỉnh kích thước ảnh khóa học */
            .singel-course .image img {
                width: 100%;
                height: auto;
            }

        </style>


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

            <section id="page-banner" class="pt-105 pb-110 bg_cover" data-overlay="8" style="background-image: url(images/page-banner-2.jpg)">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="page-banner-cont">
                                <h2>Our Skills</h2>
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Skills</li>
                                    </ol>
                                </nav>
                            </div>  <!-- page banner cont -->
                        </div>
                    </div> <!-- row -->
                </div> <!-- container -->
            </section>

            <!--====== PAGE BANNER PART ENDS ======-->

            <!--====== COURSES PART START ======-->

            <section id="courses-part" class="pt-120 pb-120 gray-bg">
                <div class="container">
                    <div class="row">

                    </div> <!-- row -->
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="courses-grid" role="tabpanel" aria-labelledby="courses-grid-tab">
                            <div class="row">
                            <c:forEach items="${sessionScope.skillsList}" var="LS">
                                <div class="col-lg-4 col-md-6">
                                    <div class="singel-course mt-30">
                                        <div class="thum">
                                            <div class="image">
                                                <img src="${LS.getImg()}" alt="Course">
                                            </div>
                                            <div class="price">
                                                <span>Free</span>
                                            </div>
                                        </div>
                                        <div class="cont">
                                            <a>
                                                <h4>Skill Name: ${LS.getSkillName()}</h4>
                                                <c:if test="${sessionScope.user.getRole() == 3}">
                                                    <h5>
                                                        Status:
                                                        <c:if test="${LS.getSkill_Status() == 1}">
                                                            <span style="font-size: 16px;
                                                                  font-weight: bold;
                                                                  margin-top: 0;
                                                                  color: #008000;">Active</span>
                                                        </c:if>
                                                        <c:if test="${LS.getSkill_Status() == 0}">
                                                            <span style="  font-size: 16px;
                                                                  font-weight: bold;
                                                                  margin-top: 0;
                                                                  color: #ff0000; /* Màu đỏ */">Inactive</span>
                                                        </c:if>
                                                    </h5>
                                                </c:if>

                                            </a>



                                            <div class="course-teacher">
                                                <c:if test="${sessionScope.user == null}">
                                                    <div >
                                                        <a href="signin.jsp"><h4 style="font-size: 16px; font-weight: bold">Join with us!</h4></a>
                                                    </div>
                                                </c:if>

                                                <c:if test="${sessionScope.user.getRole() == 1}">
                                                    <div >
                                                        <a href="loadmentor"><h6>Join with us!</h6></a>
                                                    </div>
                                                </c:if>
                                                <c:if test="${sessionScope.user.getRole() == 3}">
                                                    <div class="name">
                                                        <a href="updateskillstatus?id=${LS.getSkillId()}">Change Status</a>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div> <!-- singel course -->
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>


        </section>

        <!--====== COURSES PART ENDS ======-->

        <!--====== FOOTER PART START ======-->
        <jsp:include page="footer.jsp"></jsp:include>
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
        <script src="js/map-script.js"></script>    </body>
</html>
