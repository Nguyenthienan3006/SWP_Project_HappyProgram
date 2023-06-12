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
        
        <!--====== Responsive css ======-->
         <link rel="stylesheet" href="css/ViewInfo/ViewInfomation.css">

        <!--====== Hi?n th? th�ng b�o ======-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
            $(document).ready(function () {
                //l?y th�ng b�o t? phi�n
                var message = '<%= session.getAttribute("message") %>';

                // ki?m tra v� hi?n th?
                if (message != "null") {  
                    $('#message').text(message);

                    // T? ??ng ?n th�ng b�o sau 3 gi�y
                    setTimeout(function () {
                        //l�m m? message ch?m d?n
                        $('#message').fadeOut('slow', function () {
                            // G?i y�u c?u AJAX ?? x�a th�ng b�o
                            $.ajax({
                                url: 'removeMessage',
                                method: 'POST',
                                success: function (response) {
                                    console.log('Thanh cong: ' + response);
                                },
                                error: function (xhr, status, error) {
                                    console.log('Loi: ' + error);
                                }
                            });
                        });
                    }, 5000);
                }else{
                }
            });
        </script>

    </head>

    <body>
        <!--====== HEADER PART START ======-->
        <jsp:include page="header.jsp"></jsp:include>
            <!--====== HEADER PART ENDS ======-->


            <div id="message" class="str1">
            <% 
            // L?y th�ng b�o t? session
            String message = (String) session.getAttribute("message");
        
            // Ki?m tra v� hi?n th? th�ng b�o
            if (message != null && !message.isEmpty()) {
                out.println("<p>" + message + "</p>");
                // X�a th�ng b�o sau khi hi?n th?
                session.removeAttribute("message");
            }
            %>
        </div>
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
                            <h5>Our course</h5>
                            <h2>Featured courses </h2>
                        </div> <!-- section title -->
                    </div>
                </div> <!-- row -->
                <div class="row course-slied mt-30">
                    <div class="col-lg-4">
                        <div class="singel-course">
                            <div class="thum">
                                <div class="image">
                                    <img src="images/course/cu-1.jpg" alt="Course">
                                </div>
                                <div class="price">
                                    <span>Free</span>
                                </div>
                            </div>
                            <div class="cont">
                                <ul>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                </ul>
                                <span>(20 Reviws)</span>
                                <a href="courses-singel.html"><h4>Learn basis javascirpt from start for beginner</h4></a>
                                <div class="course-teacher">
                                    <div class="thum">
                                        <a href="#"><img src="images/course/teacher/t-1.jpg" alt="teacher"></a>
                                    </div>
                                    <div class="name">
                                        <a href="#"><h6>Mark anthem</h6></a>
                                    </div>
                                    <div class="admin">
                                        <ul>
                                            <li><a href="#"><i class="fa fa-user"></i><span>31</span></a></li>
                                            <li><a href="#"><i class="fa fa-heart"></i><span>10</span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- singel course -->
                    </div>
                    <div class="col-lg-4">
                        <div class="singel-course">
                            <div class="thum">
                                <div class="image">
                                    <img src="images/course/cu-2.jpg" alt="Course">
                                </div>
                                <div class="price">
                                    <span>Free</span>
                                </div>
                            </div>
                            <div class="cont">
                                <ul>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                </ul>
                                <span>(20 Reviws)</span>
                                <a href="courses-singel.html"><h4>Learn basis javascirpt from start for beginner</h4></a>
                                <div class="course-teacher">
                                    <div class="thum">
                                        <a href="#"><img src="images/course/teacher/t-2.jpg" alt="teacher"></a>
                                    </div>
                                    <div class="name">
                                        <a href="#"><h6>Mark anthem</h6></a>
                                    </div>
                                    <div class="admin">
                                        <ul>
                                            <li><a href="#"><i class="fa fa-user"></i><span>31</span></a></li>
                                            <li><a href="#"><i class="fa fa-heart"></i><span>10</span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- singel course -->
                    </div>
                    <div class="col-lg-4">
                        <div class="singel-course">
                            <div class="thum">
                                <div class="image">
                                    <img src="images/course/cu-3.jpg" alt="Course">
                                </div>
                                <div class="price">
                                    <span>Free</span>
                                </div>
                            </div>
                            <div class="cont">
                                <ul>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                </ul>
                                <span>(20 Reviws)</span>
                                <a href="courses-singel.html"><h4>Learn basis javascirpt from start for beginner</h4></a>
                                <div class="course-teacher">
                                    <div class="thum">
                                        <a href="#"><img src="images/course/teacher/t-3.jpg" alt="teacher"></a>
                                    </div>
                                    <div class="name">
                                        <a href="#"><h6>Mark anthem</h6></a>
                                    </div>
                                    <div class="admin">
                                        <ul>
                                            <li><a href="#"><i class="fa fa-user"></i><span>31</span></a></li>
                                            <li><a href="#"><i class="fa fa-heart"></i><span>10</span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- singel course -->
                    </div>
                    <div class="col-lg-4">
                        <div class="singel-course">
                            <div class="thum">
                                <div class="image">
                                    <img src="images/course/cu-4.jpg" alt="Course">
                                </div>
                                <div class="price">
                                    <span>Free</span>
                                </div>
                            </div>
                            <div class="cont">
                                <ul>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                </ul>
                                <span>(20 Reviws)</span>
                                <a href="courses-singel.html"><h4>Learn basis javascirpt from start for beginner</h4></a>
                                <div class="course-teacher">
                                    <div class="thum">
                                        <a href="#"><img src="images/course/teacher/t-4.jpg" alt="teacher"></a>
                                    </div>
                                    <div class="name">
                                        <a href="#"><h6>Mark anthem</h6></a>
                                    </div>
                                    <div class="admin">
                                        <ul>
                                            <li><a href="#"><i class="fa fa-user"></i><span>31</span></a></li>
                                            <li><a href="#"><i class="fa fa-heart"></i><span>10</span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- singel course -->
                    </div>
                    <div class="col-lg-4">
                        <div class="singel-course">
                            <div class="thum">
                                <div class="image">
                                    <img src="images/course/cu-5.jpg" alt="Course">
                                </div>
                                <div class="price">
                                    <span>Free</span>
                                </div>
                            </div>
                            <div class="cont">
                                <ul>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                </ul>
                                <span>(20 Reviws)</span>
                                <a href="courses-singel.html"><h4>Learn basis javascirpt from start for beginner</h4></a>
                                <div class="course-teacher">
                                    <div class="thum">
                                        <a href="#"><img src="images/course/teacher/t-5.jpg" alt="teacher"></a>
                                    </div>
                                    <div class="name">
                                        <a href="#"><h6>Mark anthem</h6></a>
                                    </div>
                                    <div class="admin">
                                        <ul>
                                            <li><a href="#"><i class="fa fa-user"></i><span>31</span></a></li>
                                            <li><a href="#"><i class="fa fa-heart"></i><span>10</span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- singel course -->
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
