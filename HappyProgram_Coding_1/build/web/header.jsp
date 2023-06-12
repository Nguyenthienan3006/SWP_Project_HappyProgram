<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--====== PRELOADER PART START ======-->

<div class="preloader">
    <div class="loader rubix-cube">
        <div class="layer layer-1"></div>
        <div class="layer layer-2"></div>
        <div class="layer layer-3 color-1"></div>
        <div class="layer layer-4"></div>
        <div class="layer layer-5"></div>
        <div class="layer layer-6"></div>
        <div class="layer layer-7"></div>
        <div class="layer layer-8"></div>
    </div>
</div>

<!--====== PRELOADER PART START ======-->

<!--====== HEADER PART START ======-->

<header id="header-part">
    <div class="header-top d-none d-lg-block">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="header-contact text-lg-left text-center">
                        <ul>
                            <li><img src="images/all-icon/map.png" alt="icon"><span>127/5 Mark street, New york</span></li>
                            <li><img src="images/all-icon/email.png" alt="icon"><span>info@yourmail.com</span></li>
                        </ul>
                    </div>
                </div>
            </div> <!-- row -->
        </div> <!-- container -->
    </div> <!-- header top -->

    <div class="header-logo-support pt-30 pb-30">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <div class="logo">
                        <a href="home.jsp">
                            <img src="images/logo.png" alt="Logo">
                        </a>
                    </div>
                </div>
                <div class="col-lg-8 col-md-8">
                    <div class="support-button float-right d-none d-md-block">
                        <div class="support float-left">
                            <div class="icon">
                                <img src="images/all-icon/support.png" alt="icon">
                            </div>
                            <div class="cont">
                                <p>Need Help? call us free</p>
                                <span>0123456789</span>
                            </div>
                        </div>
                        <c:if test="${sessionScope.user == null}">
                            <div class="button float-left">
                                <a href="signin.jsp" class="main-btn">Sign in</a>
                                <a href="signup.jsp" class="main-btn">Sign up</a>

                            </div>
                        </c:if>
                        <c:if test="${sessionScope.user != null}">
                            <div class="button float-left">
                                <a href="signout" class="main-btn">Sign out</a> 
                                <a href="change" class="main-btn">Change Pass</a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div> <!-- row -->
        </div> <!-- container -->
    </div> <!-- header logo support -->

    <div class="navigation">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-md-10 col-sm-9 col-8">
                    <nav class="navbar navbar-expand-lg">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>

                        <div class="collapse navbar-collapse sub-menu-bar" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item">
                                    <a href="home.jsp">Home</a>            
                                </li>
                                <li class="nav-item">
                                    <a href="about.jsp">About us</a>
                                </li>
                                <li class="nav-item">
                                    <a>Courses</a>
                                    <ul class="sub-menu">
                                        <li><a href="SkillServlet">Courses</a></li>
                                        <li><a href="courses-singel.jsp">Course Singel</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item">
                                    <a>Our Mentors</a>
                                    <ul class="sub-menu">
                                        <li><a href="View_mentorList">Mentors List</a></li>
                                        <li><a href="teachers-singel.jsp">teacher Singel</a></li>
                                    </ul>
                                </li>
                                
                                <c:if test="${sessionScope.user.getRole() == 1}">
                                <li class="nav-item">
                                    <a>Requests</a>
                                    <ul class="sub-menu">
                                        <li><a href="listrequest">Requests List</a></li>
                                        <li><a href="statistic">Requests statistics</a></li>
                                    </ul>
                                </li>
                                </c:if>
                                
                                <c:if test="${sessionScope.user.getRole() == 2}">
                                <li class="nav-item">
                                    <a>Requests</a>
                                    <ul class="sub-menu">
                                        <li><a href="listreqmentor">Invited Request</a></li>
                                        <li><a href="staticreq">Requests statistics</a></li>
                                       
                                    </ul>
                                </li>
                                </c:if>
                                
                            </ul>
                        </div>
                    </nav> <!-- nav -->
                </div>
            </div> <!-- row -->
        </div> <!-- container -->
    </div>
</header>

<!--====== HEADER PART ENDS ======-->