<%-- 
    Document   : ListRequest
    Created on : Jun 4, 2023, 9:34:10 PM
    Author     : An Nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <title>List of invited requests</title>
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
                                        <li class="breadcrumb-item active" aria-current="page">List request for me</li>
                                    </ol>
                                </nav>
                            </div>  <!-- page banner cont -->
                        </div>
                    </div> <!-- row -->
                </div> <!-- container -->
            </section>

            <div class="table-wrapper">
                <table class="fl-table">
                    <thead>
                        <tr>
                        <tr>
                            <th>RequestID</th>
                            <th>Mentee ID </th>
                            <th>Mentee Name</th>
                            <th>Title of request</th>                         
                            <th>Status</th>
                            <th>Request Detail</th>             
                            <th>Action1</th>
                            <th>Action2</th>
                        </tr>
                        </tr>
                    </thead>
                    <tbody> 
                    <c:forEach items="${lr}" var="list">
                        <tr>
                            <td>${list.getRequestID()}</td>
                            <td>${list.getMenteeID()}</td>                            
                            <td>${list.getMenteeName()}</td>                            
                            <td>${list.getTitle_of_request()}</td>                   
                            <td>${list.getRequestStatus()}</td>

                            <td>
                                <a href="listreqmentordetail?requestid=${list.getRequestID()}">
                                    <input style="padding: 10px 20px;
                                           background-color: #138496;
                                           color: white;
                                           border: none;
                                           border-radius: 10px;
                                           cursor: pointer;
                                           font-size: 12px;
                                           font-weight: bold" type="Submit" value="Request Detail">
                                </a>
                            </td>
                            <c:if test="${list.getRequestStatus().equals('Open')}">
                                <td>
                                    <a  href="acceptreq?requestid=${list.getRequestID()}">
                                        <input style="padding: 10px 20px;
                                               background-color: #218838;
                                               color: white;
                                               border: none;
                                               border-radius: 10px;
                                               cursor: pointer;
                                               font-size: 12px; margin-bottom: 5%;
                                               font-weight: bold" type="Submit" value="Accept Request">
                                    </a>
                                </td> 

                                <td>
                                    <a href="RejectRequest?requestid=${list.getRequestID()}">
                                        <input style="padding: 10px 20px;
                                               background-color: #b21f2d;
                                               color: white;
                                               border: none;
                                               border-radius: 10px;
                                               cursor: pointer;
                                               font-size: 12px; margin-bottom: 5%;
                                               font-weight: bold"" type="Submit" value="Reject Request">
                                    </a>
                                </td>


                            </c:if>
                            <c:if test="${list.getRequestStatus().equals('Processing')}">
                                <td>
                                    <a href="finishreq?requestid=${list.getRequestID()}">
                                        <input style="padding: 10px ;
                                               background-color: #c69500;
                                               color: white;
                                               border: none;
                                               border-radius: 10px;
                                               cursor: pointer;
                                               font-size: 12px; margin-bottom: 5%;
                                               font-weight: bold"" type="Submit" value="Finish Request">
                                    </a>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                <tbody>

            </table>   


        </div>
        <div style="display: flex; justify-content: center; margin-bottom: 3%">
            <a href="suggest">
                <input style="

                       padding: 10px 20px;
                       background-color: #004085;
                       color: white;
                       border: none;
                       border-radius: 10px;
                       cursor: pointer;
                       font-size: 16px;
                       font-weight: bold;" type="Submit" value="Back to homepage">
            </a>
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
    </body>
</html>
