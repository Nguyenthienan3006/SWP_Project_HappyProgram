<%-- 
    Document   : createRequest
    Created on : Jun 12, 2023, 9:08:48 PM
    Author     : Tuan Vinh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!---Coding By CodingLab | www.codinglabweb.com--->
<html lang="en">

    <head>

        <!--====== Required meta tags ======-->
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

        <link rel="stylesheet" href="css/request.css" />
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/css/multi-select-tag.css">
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <section id="page-banner" class="pt-105 pb-110 bg_cover" data-overlay="8" style="background-image: url(images/page-banner-3.jpg)">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="page-banner-cont">
                                <h2>Requests</h2>
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Create request</li>
                                    </ol>
                                </nav>
                            </div>  <!-- page banner cont -->
                        </div>
                    </div> <!-- row -->
                </div> <!-- container -->
            </section>


            <div class="body_temp">
                <section class="container1">    
                    <div class="header_title">
                        <div class="header_tmp">
                            <header>Create Request</header>  
                        </div>
                    </div>
                    <form action="requestMentor" method="post" class="formm">
                        <div class="input-boxx">
                            <label>Title</label>
                            <input type="text" placeholder="Enter the title" name="Title"required />
                        </div>

                        <div class="columnn">
                            <div class="input-boxx">
                                <label>Create Date</label>
                                <input type="datetime-local"id="start-time" placeholder="Enter start time" name="Create Date" required />
                            </div>
                            <div class="input-boxx">
                                <label>Deadline Date</label>
                                <input type="datetime-local" id="end-time" placeholder="Enter end time"name="Deadline Date" required />
                            </div>
                        </div>
                        <script>
                            // Lấy thời gian hiện tại
                            var currentTime = new Date();

                            // Thêm 1 giờ vào thời gian hiện tại
                            currentTime.setHours(currentTime.getHours() + 1);

                            // Định dạng chuỗi YYYY-MM-DDTHH:MM
                            var minStartTime = currentTime.toISOString().slice(0, 16);

                            // Thiết lập giá trị tối thiểu cho input thời gian bắt đầu
                            document.getElementById("start-time").setAttribute("min", minStartTime);

                            // Xử lý sự kiện khi giá trị thời gian bắt đầu thay đổi
                            document.getElementById("start-time").addEventListener("input", function () {
                                var startTime = new Date(this.value);

                                // Thêm 1 giờ vào thời gian bắt đầu
                                startTime.setHours(startTime.getHours() + 1);

                                // Định dạng chuỗi YYYY-MM-DDTHH:MM
                                var minEndTime = startTime.toISOString().slice(0, 16);

                                // Thiết lập giá trị tối thiểu cho input thời gian kết thúc
                                document.getElementById("end-time").setAttribute("min", minEndTime);
                            });
                        </script>
                        <div class="gender-boxx">
                            <div class="gender-boxx">
                                <label style="font-size: 15px; font-weight: bold;">Skill</label>
                                <div class="gender-option ">
                                    <select name="skills" id="skills">
                                    <c:forEach items="${sessionScope.skillsList}" var="LS" varStatus="status">
                                        <option value="${LS.getSkillId()}">${LS.getSkillName()}</option>
                                        <c:if test="${status.index % 4 == 3}">
                                            <div style="width: 100%; height: 0;"></div>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                    </div>
                    <script>
                        function handleSkillSelection() {
                            var select = document.getElementById("skills");
                            var options = select.selectedOptions;
                            var selectedCount = options.length;
                            var minSelection = 1;
                            var maxSelection = 3;

                            if (selectedCount < minSelection) {
                                alert("Please select at least " + minSelection + " skill.");
                                event.preventDefault(); // Ngăn việc gửi dữ liệu xuống server
                            } else if (selectedCount > maxSelection) {
                                alert("Please select at most " + maxSelection + " skills.");
                                event.preventDefault(); // Ngăn việc gửi dữ liệu xuống server
                            }
                        }
                    </script>

                    <div class="input-boxx">
                        <label>Term of the request</label>
                        <div class="select-boxx" >
                            <select name="sogiohoc">
                                <option hidden >Choose time</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>

                            </select>
                        </div>
                    </div>


                    <div class="input-boxx">
                        <label>Content</label><br>
                        <textarea placeholder="Content required" name="noidung"></textarea>
                    </div>
                    <c:if test="${requestScope.errE!=null}">
                        <h6 style="color: red">${requestScope.errE}</h6>
                    </c:if>

                    <button style="border: 30px; background: #4e6ce6">Request</button>
                </form>
            </section>
        </div>
        <script src="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/js/multi-select-tag.js"></script>
        <script>
                        new MultiSelectTag('skills')
        </script>



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