<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/ListRequest/ListRequest.css">
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
        <title>Create Skill</title>
        <style>
            label {
                display: block;
                margin-bottom: 10px;
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
                                        <li class="breadcrumb-item active" aria-current="page">Create Cv</li>
                                    </ol>
                                </nav>
                            </div>  <!-- page banner cont -->
                        </div>
                    </div> <!-- row -->
                </div> <!-- container -->
            </section>

            <div style="margin: 5%;">
                <style>
                    .form-container {
                        padding: 20px;
                        border: 1px solid #ccc;
                        border-radius: 10px;
                        background-color: #f2f2f2;
                        max-width: 500px;
                        margin: 0 auto;
                    }

                    .form-container h2 {
                        font-size: 24px;
                        margin-bottom: 10px;
                    }

                    .form-container h4 {
                        font-size: 20px;
                        margin-bottom: 5px;
                    }

                    .form-container select,
                    .form-container input[type="text"] {
                        width: 100%;
                        padding: 10px;
                        border: 1px solid #ccc;
                        border-radius: 5px;
                        margin-bottom: 10px;
                    }

                    .form-container input[type="submit"] {
                        padding: 10px 20px;
                        background-color: #0056b3;
                        color: white;
                        border: none;
                        border-radius: 10px;
                        cursor: pointer;
                        font-size: 16px;
                        font-weight: bold;
                    }
                </style>
                <div class="form-container" >
                    <h2 class="grid-title">Update Cv</h2><br>

                    <!-- BEGIN FILTER BY CATEGORY -->
                    <form action="updatecv" method="post" onsubmit="return validateForm()">
                        <div class="gender-boxx">
                            <div class="gender-boxx">
                                <label style="font-size: 15px; font-weight: bold;">Skill</label>
                                <div class="gender-option ">

                                <c:set var="skillIds" value="" />
                                <c:set var="rowCounter" value="0" />
                                <%--  check các skill dã chon --%>
                                <c:forEach items="${lss}" var="skill">
                                    <c:set var="skillIds" value="${skillIds},${skill.skillId}" />
                                </c:forEach>

                                <div class="checkbox-row">
                                    <c:forEach items="${ls}" var="ls" varStatus="status">
                                        <c:if test="${status.index % 4 == 0 && status.index != 0}">
                                            <div style="clear: both;"></div> <!-- Xóa float của các dòng trước -->
                                        </c:if>

                                        <c:if test="${rowCounter == 3}">
                                            <div style="clear: both;"></div> <!-- Tạo dòng mới -->
                                            <c:set var="rowCounter" value="0" /> <!-- Đặt lại giá trị rowCounter -->
                                        </c:if>
                                        <%--  check các skill dã chon --%>
                                        <p>
                                            <input type="checkbox" name="skills" value="${ls.skillId}" ${fn:contains(skillIds, ls.skillId) ? 'checked' : ''}>
                                            ${ls.skillName}
                                        </p>

                                        <c:set var="rowCounter" value="${rowCounter + 1}" />
                                    </c:forEach>
                                </div>
                            </div>
                        </div>  
                    </div>
                    <div class="input-boxx">
                        <h5 style="font-size: 20px">Professional</h5>
                        <div>
                            <input type="text"  name="pro" placeholder="typing..." required>
                        </div>
                        <h5 style="font-size: 20px">Education</h5>
                        <div>
                            <input type="text"  name="edu" placeholder="typing..." required>
                        </div>
                        <h5 style="font-size: 20px">Work experience</h5>
                        <div>
                            <input type="text"  name="exp" placeholder="typing..." required>
                        </div>
                        <h5 style="font-size: 20px">Achievement</h5>
                        <div>
                            <input type="text"  name="achi" placeholder="typing..." required>
                        </div>

                    </div>
                    <input style="padding: 10px 20px;
                           background-color: #0056b3;
                           color: white;
                           border: none;
                           border-radius: 10px;
                           cursor: pointer;
                           font-size: 16px;
                           font-weight: bold;
                           margin-top: 4%" type="Submit" value="Ok"  >
                </form  >
                <!-- END FILTER BY PRICE -->

                <a href="suggest">
                    <input style="padding: 10px 20px;
                           background-color: #b21f2d;
                           color: white;
                           border: none;
                           border-radius: 10px;
                           cursor: pointer;
                           font-size: 16px;
                           font-weight: bold;

                           margin-top: 2%" type="Submit" value="Cancel">
                </a>
            </div>
            <!-- END FILTERS -->

        </div>


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
        // Lấy tất cả các checkbox kỹ năng
        const checkboxes = document.getElementsByName('skills');

        // Kiểm tra xem có ít nhất một checkbox được chọn hay không
        let atLeastOneSkillSelected = false;
        for (let i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].checked) {
                atLeastOneSkillSelected = true;
                break;
            }
        }

        // Hiển thị thông báo nếu không có kỹ năng nào được chọn
        if (!atLeastOneSkillSelected) {
            alert('Vui lòng chọn ít nhất 1 kỹ năng');
            return false; // Ngăn form được gửi lên server
        }
    }
</script>
    </body>
</html>
