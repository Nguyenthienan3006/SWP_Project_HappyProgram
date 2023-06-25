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


        <title> List of requests</title>
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
                                        <li class="breadcrumb-item active" aria-current="page">List request by me</li>
                                    </ol>
                                </nav>
                            </div>  <!-- page banner cont -->
                        </div>
                    </div> <!-- row -->
                </div> <!-- container -->
            </section>



        <c:choose>
            <c:when test="${not empty sessionScope.listreq}">
                <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
                <div  style="    width:100%;
                      margin-right:auto;
                      margin-left:auto;
                      margin-top: 100px;
                      padding-left: 5%;
                      margin-bottom: 100px">
                    <div class="row">
                        <!-- BEGIN SEARCH RESULT -->
                        <div class="col-md-12">
                            <div class="grid search">
                                <div class="grid-body">
                                    <div class="row">
                                        <!-- BEGIN FILTERS -->
                                        <div  class="col-md-3">
                                            <h2 class="grid-title"><i class="fa fa-filter"></i> Filters</h2><br>

                                            <!-- BEGIN FILTER BY CATEGORY -->
                                            <form action="listreqadmin" method="post">

                                                <!-- BEGIN SEARCH INPUT -->
                                                <form action="listreqadmin" method="post">
                                                    <div class="input-group">
                                                        <div class="col-sm-6">
                                                            <h4 style="font-size: 20px">By name:</h4>
                                                            <input type="text" name="searchText" id="searchInput" placeholder="Search..." style="width: 200px;"><br><br>


                                                            <h4 style="font-size: 20px">By status:</h4>
                                                            <select name="status" style="width: 200%;">
                                                                <option value="" >All</option>
                                                                <option value="Open">Open</option>
                                                                <option value="Processing">Processing</option>
                                                                <option value="Reject">Reject</option>
                                                                <option value="Finish">Finish</option>
                                                                <option value="Close">Close</option>


                                                            </select> <br><br><br>

                                                            <h4 style="font-size: 20px">By date:</h4>
                                                            From <br>

                                                            <input type="date" name="startDate"  style="width: 200px;"><br>
                                                            To <br>
                                                            <input type="date" name="endDate"  style="width: 200px;"><br><br>


                                                            <div>

                                                                <span>
                                                                    <input style="padding: 10px 20px;
                                                                           background-color: #0056b3;
                                                                           color: white;
                                                                           border: none;
                                                                           border-radius: 10px;
                                                                           cursor: pointer;
                                                                           font-size: 16px;
                                                                           font-weight: bold" type="submit" value="Search">
                                                                </span>
                                                            </div>

                                                        </div>
                                                    </div>

                                                    <!-- END SEARCH INPUT -->


                                                </form>
                                                <!-- END FILTER BY PRICE -->
                                        </div>
                                        <!-- END FILTERS -->
                                        <!-- BEGIN RESULT -->
                                        <div class="col-md-9">
                                            <h2><i class="fa fa-file-o"></i> Result</h2>
                                            <div class="row">
                                            </div>

                                            <!-- BEGIN TABLE RESULT -->
                                            <div class="table-responsive">

                                                <div class="table-wrapper">
                                                    <table class="fl-table">
                                                        <thead>

                                                            <tr>
                                                                <th>Request ID</th>
                                                                <th>ID</th>
                                                                <th>Account Name</th>
                                                                <th>Title Of Request</th>
                                                                <th>Status</th>
                                                                <th>Request Detail</th>


                                                            </tr>
                                                        </thead>
                                                        <tbody> 
                                                            <c:forEach items="${sessionScope.listreq}" var="list">
                                                                <tr>
                                                                    <td>${list.getRequestID()}</td>
                                                                    <td>${list.getMenteeID()}</td>
                                                                    <td>${list.getMenteeName()}</td>
                                                                    <td>${list.getTitle_of_request()}</td>  
                                                                    <td>${list.getRequestStatus()}</td>

                                                                    <td>
                                                                        <a href="reqdetailadmin?requestid=${list.getRequestID()}">
                                                                            <input style=" font-weight: bold;" type="Submit" value="Request Detail">
                                                                        </a>
                                                                    </td>

                                                                </tr>
                                                            </c:forEach>
                                                        <tbody>

                                                    </table>   
                                                </div>
                                            </div>
                                            <!-- END TABLE RESULT -->


                                        </div>
                                        <!-- END RESULT -->
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- END SEARCH RESULT -->
                    </div>
                </div>
            </c:when>
            <c:otherwise>

                <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
                <div style="    width:100%;
                     margin-right:auto;
                     margin-left:auto;
                     margin-top: 100px;
                     padding-left: 5%;
                     margin-bottom: 100px">
                    <div class="row">
                        <!-- BEGIN SEARCH RESULT -->
                        <div class="col-md-12">
                            <div class="grid search">
                                <div class="grid-body">
                                    <div class="row">
                                        <!-- BEGIN FILTERS -->
                                        <div class="col-md-3">
                                            <h2 class="grid-title"><i class="fa fa-filter"></i> Filters</h2>

                                            <!-- BEGIN FILTER BY CATEGORY -->
                                            <form action="listreqadmin" method="post">

                                                <!-- BEGIN SEARCH INPUT -->
                                                <form action="listreqadmin" method="post">
                                                    <div class="input-group">
                                                        <div class="col-sm-6">
                                                            <h4 style="font-size: 20px">By name:</h4>
                                                            <input type="text" name="searchText" id="searchInput" placeholder="Search...">


                                                            <h4 style="font-size: 20px">By status:</h4>
                                                            <select name="status">
                                                                <option value="" >All</option>
                                                                <option value="Open">Open</option>
                                                                <option value="Processing">Processing</option>
                                                                <option value="Reject">Reject</option>
                                                                <option value="Finish">Finish</option>
                                                                <option value="Close">Close</option>


                                                            </select> <br><br>

                                                            <h4 style="font-size: 20px">By date:</h4>
                                                            From <br>

                                                            <input type="date" name="startDate" ><br>
                                                            To <br>
                                                            <input type="date" name="endDate" ><br><br>


                                                            <div>

                                                                <span>
                                                                    <input style="padding: 10px 20px;
                                                                           background-color: #4CAF50;
                                                                           color: white;
                                                                           border: none;
                                                                           border-radius: 4px;
                                                                           cursor: pointer;
                                                                           font-size: 16px;" type="submit" value="Search">
                                                                </span>
                                                            </div>


                                                        </div>
                                                    </div>

                                                    <!-- END SEARCH INPUT -->


                                                </form>
                                                <!-- END FILTER BY PRICE -->
                                        </div>

                                        <!-- END FILTERS -->
                                        <!-- BEGIN RESULT -->
                                        <div class="col-md-9">
                                            <h2><i class="fa fa-file-o"></i> Result</h2>

                                            <tr>
                                                <td colspan="9">No mentors found</td>
                                            </tr>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>

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
