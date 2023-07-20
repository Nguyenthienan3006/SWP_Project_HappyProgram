<%-- 
    Document   : createRequest
    Created on : Jun 12, 2023, 9:08:48 PM
    Author     : Tuan Vinh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


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
        <style>
            .checkbox-row {
                margin-bottom: 10px; /* Khoảng cách giữa các hàng checkbox */
            }
            .checkbox-row p {
                display: inline-block; /* Hiển thị các checkbox cùng một hàng */
                margin-right: 10px; /* Khoảng cách giữa các checkbox trong cùng một hàng */
            }
        </style>
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
                            <header style="color: white">Create Request</header>  
                        </div>
                    </div>
                <%--  code anh Danh--%>
                <form action="loadmentor" onsubmit="return validateForm();"> 
                    <div class="gender-boxx">
                        <label style="font-size: 15px; font-weight: bold;">Skill</label>

                        <div class="gender-option">
                            <c:set var="skillIds" value="" />
                            <c:set var="rowCounter" value="0" />

                            <%--  check các skill đã chọn --%>
                            <c:forEach items="${lss}" var="skill">
                                <c:set var="skillIds" value="${skillIds},${skill.skillId}" />
                            </c:forEach>

                            <div class="skill-grid">
                                <c:forEach items="${ls}" var="ls" varStatus="status">
                                    <p>
                                        <input type="checkbox" name="skills" value="${ls.skillId}" ${fn:contains(skillIds, ls.skillId) ? 'checked' : ''}>
                                        ${ls.skillName}
                                    </p>
                                </c:forEach>
                            </div>

                            <br>


                            <input style="padding: 12px 10px;
                                   background-color: #4e6ce6;
                                   color: white;
                                   border: none;
                                   border-radius: 10px;
                                   cursor: pointer;
                                   font-size: 12px;
                                   font-weight: bold;
                                   margin-bottom: 3%;
                                   margin-left: 2%;" type="submit" value="Find mentor">
                        </div>
                    </div>
                </form>
                <style>
                    .skill-grid {
                        display: grid;
                        grid-template-columns: repeat(3, 1fr); /* Quy định số cột mỗi hàng */
                        grid-gap: 10px; /* Khoảng cách giữa các skill */
                    }
                </style>


                <%--  load danh sách mentor  --%>          
                <form action="loadmentor" method="post" class="formm">
                    <input name="skillid" value="${ssl}" type="hidden">

                    <select name="mentor">
                        <option value="" selected disabled hidden>Mentor for you</option>
                        <c:forEach items="${lu}" var="lu" varStatus="status">
                            <option value="${lu.getUid()}">${lu.getFullname()}</option>
                        </c:forEach>
                    </select><br><br>


                    <%-- ket thúc code anh Danh  --%>  
                    <div class="input-boxx">
                        <label style="font-weight: bold; color: black">Title</label>
                        <input type="text" placeholder="Enter the title" name="Title_of_request"required />
                    </div>

                    <div class="columnn">
                        <div class="input-boxx">
                            <label style="font-weight: bold; color: black">Create Date</label>
                            <input type="datetime-local"id="start-time" placeholder="Enter start time" name="createdDate" required />
                        </div>
                        <div class="input-boxx">
                            <label style="font-weight: bold; color: black">Deadline Date</label>
                            <input type="datetime-local" id="end-time" placeholder="Enter end time"name="finishDate" required />
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
                        <label style="font-weight: bold; color: black">Request hour</label>
                        <div>
                            <select name="Request_hour">
                                <option hidden >Choose time</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>

                            </select>
                        </div>
                    </div>
                    <br><br>

                    <div class="input-boxx">
                        <label style="font-weight: bold; color: black">Content</label><br>
                        <textarea placeholder="Content required" name="Desciption_of_request"></textarea>
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
        <script>
                        function validateForm() {
                            var checkboxes = document.getElementsByName('skills');
                            var checkedCount = 0;

                            // Đếm số lượng checkbox được chọn
                            for (var i = 0; i < checkboxes.length; i++) {
                                if (checkboxes[i].checked) {
                                    checkedCount++;
                                }
                            }

                            // Kiểm tra điều kiện số lượng checkbox
                            if (checkedCount === 0) {
                                alert("Vui lòng chọn ít nhất một kỹ năng.");
                                return false;
                            } else if (checkedCount > 3) {
                                alert("Vui lòng chọn tối đa ba kỹ năng.");
                                return false;
                            }

                            return true;
                        }
        </script>
    </body>

</html>