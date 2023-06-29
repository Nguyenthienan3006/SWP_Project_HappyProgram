<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!--====== Required meta tags ======-->
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!--====== Title ======-->
        <title>Happy Programming</title>

        <!--====== Favicon Icon ======-->
        <style>

        </style>
        <link rel="shortcut icon" href="images/favicon.png" type="image/png">

        <!--====== Slick css ======-->
        <link rel="stylesheet" href="css/slick.css">

        <!--====== Animate css ======-->
        <link rel="stylesheet" href="css/animate.css">
        <style>
            #course-part {
                padding-top: 115px;
                padding-bottom: 120px;
                background-color: #f5f5f5;
            }

            .section-title {
                padding-bottom: 45px;
            }

            .section-title h5 {
                /* Your styles for h5 tag */
            }

            .section-title h2 {
                /* Your styles for h2 tag */
            }

            .course-slied {
                margin-top: 30px;
            }

            .singel-course {
                margin-bottom: 30px;
                background-color: #ffffff;
                border: 1px solid #e6e6e6;
                border-radius: 4px;
                box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
                padding: 30px;
            }

            .thum {
                text-align: center;
                margin-bottom: 20px;
            }

            .thum .image img {
                max-width: 100%;
                height: auto;
            }

            .cont {
                padding: 20px 0;
            }

            .course-teacher {
                display: flex;
                align-items: center;
                margin-bottom: 15px;
            }

            .course-teacher .thum {
                margin-right: 10px;
            }

            .course-teacher .thum img {
                width: 50px;
                height: 50px;
                border-radius: 50%;
            }

            .course-teacher .name a {
                color: #333333;
                text-decoration: none;
            }

            .course-teacher .name h6 {
                margin-bottom: 0;
            }

            .admin ul {
                list-style: none;
                padding: 0;
                margin: 0;
            }

            .admin button a {
                display: block;
                padding: 8px 16px;
                background-color: #337ab7;
                color: #ffffff;
                text-decoration: none;
                border-radius: 4px;
                text-align: center;
            }
        </style>


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

        <!--====== Responsive css ======-->
        <link rel="stylesheet" href="css/ViewInfo/ViewInfomation.css">

        <!--====== l? d?ng ?? nh?ng th? vi?n jQuery v?o trang web. ======-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <!--====== authorize message ======-->
        <script>
            //n? s? th?c thi khi trang web ?? ho?n th?nh vi?c t?i v? s?n s?ng cho vi?c thao t?c.
            $(document).ready(function () {
                //l?y th?ng b?o t? phi?n
                var message = '<%= session.getAttribute("message") %>';

                // ki?m tra v? hi?n th?
                if (message != null) {
                    // ??t n?i dung c?a ph?n t? c? id l? "message" b?ng gi? tr? c?a bi?n message. 
                    $('#message').text(message);
                    //  thi?t l?p th?ng b?o t? bi?n m?t sau 5s.
                    setTimeout(function () {
                        //l?m m? message ch?m d?n
                        $('#message').fadeOut('slow', function () {
                        });
                    }, 5000);
                }
            });
        </script>
    </head>

    <body>
        <!--====== HEADER PART START ======-->
        <jsp:include page="header.jsp"></jsp:include>
            <!--====== HEADER PART ENDS ======-->

            <!--====== authorize message ======-->
        <c:if test="${sessionScope.message != null}">
            <div id="message" class="str1">
                <% 
                // l?y gi? tr? c?a thu?c t?nh "message" t? ??i t??ng session.
                String message = (String) session.getAttribute("message");
        
               // ki?m tra v? hi?n th? th?ng b?o
                if (message != null && !message.isEmpty()) {               
                    // X?a th?ng b?o sau khi hi?n th?
                    session.removeAttribute("message");
                }
                %>
            </div>
        </c:if>
        <!--====== SLIDER PART START ======-->
        <section id="slider-part" class="slider-active">
            <div class="single-slider bg_cover pt-150" style="background-image: url(images/slider/s-1.jpg)" data-overlay="4">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-7 col-lg-9">
                            <div class="slider-cont">
                                <h1 data-animation="bounceInLeft" data-delay="1s">We are here to help you</h1>
                                <p data-animation="fadeInUp" data-delay="1.3s">Donec vitae sapien ut libearo venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt  Sed fringilla mauri amet nibh.</p>

                            </div>
                        </div>
                    </div> <!-- row -->
                </div> <!-- container -->
            </div> <!-- single slider -->

            <div class="single-slider bg_cover pt-150" style="background-image: url(images/slider/s-2.jpg)" data-overlay="4">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-7 col-lg-9">
                            <div class="slider-cont">
                                <h1 data-animation="bounceInLeft" data-delay="1s">Welcome</h1>
                                <p data-animation="fadeInUp" data-delay="1.3s">Donec vitae sapien ut libearo venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt  Sed fringilla mauri amet nibh.</p>

                            </div>
                        </div>
                    </div> <!-- row -->
                </div> <!-- container -->
            </div> <!-- single slider -->

            <div class="single-slider bg_cover pt-150" style="background-image: url(images/slider/s-3.jpg)" data-overlay="4">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-7 col-lg-9">
                            <div class="slider-cont">
                                <h1 data-animation="bounceInLeft" data-delay="1s">Knowledge is power</h1>
                                <p data-animation="fadeInUp" data-delay="1.3s">Donec vitae sapie.</p>

                            </div>
                        </div>
                    </div> <!-- row -->
                </div> <!-- container -->
            </div> <!-- single slider -->
        </section>

        <!--====== SLIDER PART ENDS ======-->

        <!--====== CATEGORY PART START ======-->

        <section id="category-part">
            <div class="container">
                <div class="category pt-40 pb-80">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="category-text pt-40">
                                <h2>Best platform to learn everything</h2>
                            </div>
                        </div>
                        <div class="col-lg-6 offset-lg-1 col-md-8 offset-md-2 col-sm-8 offset-sm-2 col-8 offset-2">
                            <div class="row category-slied mt-40">
                                <div class="col-lg-4">
                                    <a href="#">
                                        <span class="singel-category text-center color-1">
                                            <span class="icon">
                                                <img src="images/all-icon/ctg-1.png" alt="Icon">
                                            </span>
                                            <span class="cont">
                                                <span>Language</span>
                                            </span>
                                        </span> <!-- singel category -->
                                    </a>
                                </div>
                                <div class="col-lg-4">
                                    <a href="#">
                                        <span class="singel-category text-center color-2">
                                            <span class="icon">
                                                <img src="images/all-icon/ctg-2.png" alt="Icon">
                                            </span>
                                            <span class="cont">
                                                <span>Business</span>
                                            </span>
                                        </span> <!-- singel category -->
                                    </a>
                                </div>
                                <div class="col-lg-4">
                                    <a href="#">
                                        <span class="singel-category text-center color-3">
                                            <span class="icon">
                                                <img src="images/all-icon/ctg-3.png" alt="Icon">
                                            </span>
                                            <span class="cont">
                                                <span>Literature</span>
                                            </span>
                                        </span> <!-- singel category -->
                                    </a>
                                </div>
                                <div class="col-lg-4">
                                    <a href="#">
                                        <span class="singel-category text-center color-1">
                                            <span class="icon">
                                                <img src="images/all-icon/ctg-1.png" alt="Icon">
                                            </span>
                                            <span class="cont">
                                                <span>Language</span>
                                            </span>
                                        </span> <!-- singel category -->
                                    </a>
                                </div>
                                <div class="col-lg-4">
                                    <a href="#">
                                        <span class="singel-category text-center color-2">
                                            <span class="icon">
                                                <img src="images/all-icon/ctg-2.png" alt="Icon">
                                            </span>
                                            <span class="cont">
                                                <span>Business</span>
                                            </span>
                                        </span> <!-- singel category -->
                                    </a>
                                </div>
                                <div class="col-lg-4">
                                    <a href="#">
                                        <span class="singel-category text-center color-3">
                                            <span class="icon">
                                                <img src="images/all-icon/ctg-3.png" alt="Icon">
                                            </span>
                                            <span class="cont">
                                                <span>Literature</span>
                                            </span>
                                        </span> <!-- singel category -->
                                    </a>
                                </div>
                            </div> <!-- category slied -->
                        </div>
                    </div> <!-- row -->
                </div> <!-- category -->
            </div> <!-- container -->
        </section>

        <!--====== CATEGORY PART ENDS ======-->

        <!--====== ABOUT PART START ======-->


        <!--====== ABOUT PART ENDS ======-->

        <!--====== APPLY PART START ======-->



        <!--====== APPLY PART ENDS ======-->

        <!--====== COURSE PART START ======-->


        <section id="course-part" class="pt-115 pb-120 gray-bg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="section-title pb-45">
                            <h5>Our Mentor</h5>
                            <h2>Mentor suggest </h2>
                        </div> <!-- section title -->
                    </div>
                </div> <!-- row -->                      



                <form action="suggest" method="post"> 
                    <select name="skill">
                        <option value="" selected disabled hidden>Choose Skill</option>
                        <c:forEach items="${ls}" var="s" varStatus="status">
                            <option value="${s.getSkillId()}" ${s.getSkillId() eq param.skill ? 'selected' : ''}>${s.getSkillName()}</option>
                        </c:forEach>      
                    </select>
                    <input style="margin-left: 10px" type="submit" value="Find">
                </form>
                <style>
                    form {
                        display: flex;
                        align-items: center;
                    }

                    select {
                        padding: 5px;
                        margin-right: 10px;
                        font-size: 16px;
                        border: 1px solid #ccc;
                        border-radius: 4px;
                    }

                    input[type="submit"] {
                        padding: 5px 10px;
                        font-size: 16px;
                        background-color: #0056b3;
                        color: white;
                        border: none;
                        border-radius: 4px;
                        cursor: pointer;
                    }
                </style>


                <div class="row course-slied mt-30">
                    <c:forEach items="${mentorList}" var="mentor" varStatus="status">

                        <div class="col-lg-4">
                            <div class="singel-course">
                                <div class="thum">
                                    <div class="image">
                                        <a href="CvOfMentorServlet?uid=${mentor.getID()}"><img src="${mentor.getImg()}" alt="Course"></a>
                                    </div>
                                </div>
                                <div class="cont">
                                    <div class="course-teacher">
                                        <div class="thum">
                                            <a href="CvOfMentorServlet?uid=${mentor.getID()}"><img src="${mentor.getImg()}" alt="teacher"></a>
                                        </div>
                                        <div class="name">
                                            <a href="CvOfMentorServlet?uid=${mentor.getID()}"><h6>Name: ${mentor.getFullname()}</h6></a>
                                        </div>


                                    </div>

                                    <!--                                    <span>(20 Reviws)</span>-->
                                    <span> AccountName: ${mentor.getAccountname()}</span> <br>
                                    <span>Accepted request: ${mentor.getNumberOfAcceptedRequest()}</span> <br>   
                                    <ul>
                                        <li>${mentor.getRateStar()}<i class="fa fa-star"></i></li>
                                    </ul>
                                    <div class="admin d-flex justify-content-center align-items-center">
                                        <ul>
                                            <c:if test="${sessionScope.user == null}">
                                                <button><a href="signin.jsp"><span style="color: #ffffff">Invite</span></a></button>
                                            </c:if>
                                            <c:if test="${sessionScope.user.getRole() == 1}">
                                                <button><a href="loadskill"><span style="color: #ffffff">Invite</span></a></button>
                                            </c:if>
                                        </ul>
                                    </div>

                                </div>
                            </div> <!-- singel course -->
                        </div>
                    </c:forEach>      


                </div>

            </div>

        </div> <!-- course slied -->
    </div> <!-- container -->
</section>



<!--====== COURSE PART ENDS ======-->

<!--====== VIDEO FEATURE PART START ======-->

<section id="video-feature" class="bg_cover pt-60 pb-110" style="background-image: url(images/bg-1.jpg)">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6 order-last order-lg-first">
                <div class="video text-lg-left text-center pt-50">
                    <a class="Video-popup" href="https://www.youtube.com/watch?v=bRRtdzJH1oE"><i class="fa fa-play"></i></a>
                </div> <!-- row -->
            </div>
            <div class="col-lg-5 offset-lg-1 order-first order-lg-last">
                <div class="feature pt-50">
                    <div class="feature-title">
                        <h3>Our Facilities</h3>
                    </div>
                    <ul>
                        <li>
                            <div class="singel-feature">
                                <div class="icon">
                                    <img src="images/all-icon/f-1.png" alt="icon">
                                </div>
                                <div class="cont">
                                    <h4>Global Certificate</h4>
                                    <p>Gravida nibh vel velit auctor aliquetn auci elit cons solliazcitudirem sem quibibendum sem nibhutis.</p>
                                </div>
                            </div> <!-- singel feature -->
                        </li>
                        <li>
                            <div class="singel-feature">
                                <div class="icon">
                                    <img src="images/all-icon/f-2.png" alt="icon">
                                </div>
                                <div class="cont">
                                    <h4>Alumni Support</h4>
                                    <p>Gravida nibh vel velit auctor aliquetn auci elit cons solliazcitudirem sem quibibendum sem nibhutis.</p>
                                </div>
                            </div> <!-- singel feature -->
                        </li>
                        <li>
                            <div class="singel-feature">
                                <div class="icon">
                                    <img src="images/all-icon/f-3.png" alt="icon">
                                </div>
                                <div class="cont">
                                    <h4>Books & Library</h4>
                                    <p>Gravida nibh vel velit auctor aliquetn auci elit cons solliazcitudirem sem quibibendum sem nibhutis.</p>
                                </div>
                            </div> <!-- singel feature -->
                        </li>
                    </ul>
                </div> <!-- feature -->
            </div>
        </div> <!-- row -->
    </div> <!-- container -->
    <div class="feature-bg"></div> <!-- feature bg -->
</section>

<!--====== VIDEO FEATURE PART ENDS ======-->

<!--====== TEACHERS PART START ======-->



<!--====== TEACHERS PART ENDS ======-->


<!--====== TEASTIMONIAL PART START ======-->

<section id="testimonial" class="bg_cover pt-115 pb-115" data-overlay="8" style="background-image: url(images/bg-2.jpg); margin-top: 5%">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="section-title pb-40">
                    <h5>Testimonial</h5>
                    <h2>What they say</h2>
                </div> <!-- section title -->
            </div>
        </div> <!-- row -->
        <div class="row testimonial-slied mt-40">
            <div class="col-lg-6">
                <div class="singel-testimonial">
                    <div class="testimonial-thum">
                        <img src="images/testimonial/t-1.jpg" alt="Testimonial">
                        <div class="quote">
                            <i class="fa fa-quote-right"></i>
                        </div>
                    </div>
                    <div class="testimonial-cont">
                        <p>Aliquetn sollicitudirem quibibendum auci elit cons equat ipsutis sem nibh id elit. Duis sed odio sit amet sem nibh id elit sollicitudirem </p>
                        <h6>Rubina Helen</h6>
                        <span>Bsc, Engineering</span>
                    </div>
                </div> <!-- singel testimonial -->
            </div>
            <div class="col-lg-6">
                <div class="singel-testimonial">
                    <div class="testimonial-thum">
                        <img src="images/testimonial/t-2.jpg" alt="Testimonial">
                        <div class="quote">
                            <i class="fa fa-quote-right"></i>
                        </div>
                    </div>
                    <div class="testimonial-cont">
                        <p>Aliquetn sollicitudirem quibibendum auci elit cons equat ipsutis sem nibh id elit. Duis sed odio sit amet sem nibh id elit sollicitudirem </p>
                        <h6>Rubina Helen</h6>
                        <span>Bsc, Engineering</span>
                    </div>
                </div> <!-- singel testimonial -->
            </div>
            <div class="col-lg-6">
                <div class="singel-testimonial">
                    <div class="testimonial-thum">
                        <img src="images/testimonial/t-3.jpg" alt="Testimonial">
                        <div class="quote">
                            <i class="fa fa-quote-right"></i>
                        </div>
                    </div>
                    <div class="testimonial-cont">
                        <p>Aliquetn sollicitudirem quibibendum auci elit cons equat ipsutis sem nibh id elit. Duis sed odio sit amet sem nibh id elit sollicitudirem </p>
                        <h6>Rubina Helen</h6>
                        <span>Bsc, Engineering</span>
                    </div>
                </div> <!-- singel testimonial -->
            </div>
        </div> <!-- testimonial slied -->
    </div> <!-- container -->
</section>

<!--====== TEASTIMONIAL PART ENDS ======-->



<!--====== PATNAR LOGO PART START ======-->

<div id="patnar-logo" class="pt-40 pb-80 gray-bg">
    <div class="container">
        <div class="row patnar-slied">
            <div class="col-lg-12">
                <div class="singel-patnar text-center mt-40">
                    <img src="images/patnar-logo/p-1.png" alt="Logo">
                </div>
            </div>
            <div class="col-lg-12">
                <div class="singel-patnar text-center mt-40">
                    <img src="images/patnar-logo/p-2.png" alt="Logo">
                </div>
            </div>
            <div class="col-lg-12">
                <div class="singel-patnar text-center mt-40">
                    <img src="images/patnar-logo/p-3.png" alt="Logo">
                </div>
            </div>
            <div class="col-lg-12">
                <div class="singel-patnar text-center mt-40">
                    <img src="images/patnar-logo/p-4.png" alt="Logo">
                </div>
            </div>
            <div class="col-lg-12">
                <div class="singel-patnar text-center mt-40">
                    <img src="images/patnar-logo/p-2.png" alt="Logo">
                </div>
            </div>
            <div class="col-lg-12">
                <div class="singel-patnar text-center mt-40">
                    <img src="images/patnar-logo/p-3.png" alt="Logo">
                </div>
            </div>
        </div> <!-- row -->
    </div> <!-- container -->
</div> 

<!--====== PATNAR LOGO PART ENDS ======-->

<!--====== FOOTER PART STARTS ======-->
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
