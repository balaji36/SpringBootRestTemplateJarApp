<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="time" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Task Manager - ${title}</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Favicons
    ================================================== -->
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"  href="static/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="fonts/font-awesome/css/font-awesome.css">

<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css"  href="static/css/style.css">
<link rel="stylesheet" type="text/css" href="static/css/prettyPhoto.css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300" rel="stylesheet" type="text/css">
<script type="text/javascript" src="static/js/modernizr.custom.js"></script>


</head>
<body>
<!-- Navigation -->


<nav id="menu" class="navbar navbar-default navbar-fixed-top">
  <div class="container"> 
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <a class="navbar-brand page-scroll" href="#page-top"><i class="fa fa-moon-o fa-rotate-90"></i> Studio7</a> </div>
    
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="home" class="page-scroll">Home</a></li>
             <li><a href="insert" class="page-scroll">InsertTask</a></li>
        <li><a href="alltasks" class="page-scroll">AllTasks</a></li>
        <li><a href="singletask" class="page-scroll">SingleTask</a></li>
        <li><a href="login" class="page-scroll">LoginTask</a></li>
     <li><a href="inserttask" class="page-scroll">InsertTask</a></li>
   
      </ul>
    </div>
    <!-- /.navbar-collapse --> 
  </div>
  <!-- /.container-fluid --> 
</nav>
<!-- Header -->
<header id="header">
  <div class="intro text-center">
    <div class="overlay">
      <div class="container">
        <div class="row">
          <div class="intro-text">
            <h1>Welcome to <span class="brand">Studio7</span></h1>
            <p>We are a digital agency that loves what we do</p>
            <a href="#services" class="btn btn-default btn-lg page-scroll">Learn More</a> </div>
        </div>
      </div>
    </div>
  </div>
</header>
<!-- Services Section -->
<c:if test="${alltask==true}">
	<%@include file="alltask.jsp"%>
</c:if>
<!-- About Section -->
<c:if test="${singletask==true}">
	<%@include file="singletask.jsp"%>
</c:if>
<c:if test="${deletetask==true}">
	<%@include file="deletetask.jsp"%>
</c:if>
<c:if test="${inserttask==true}">
	<%@include file="inserttask.jsp"%>
</c:if>
<c:if test="${updatetask==true}">
	<%@include file="updatetask.jsp"%>
</c:if>
<c:if test="${single==true}">
	<%@include file="single.jsp"%>
</c:if>
<c:if test="${insert==true}">
	<%@include file="insert.jsp"%>
</c:if>
<c:if test="${inserts==true}">
	<%@include file="insert1.jsp"%>
</c:if>
<c:if test="${login==true}">
	<%@include file="login.jsp"%>
</c:if>
<c:if test="${logintask==true}">
	<%@include file="login1.jsp"%>
</c:if>
<c:if test="${failuretask==true}">
	<%@include file="failure.jsp"%>
</c:if>
<div id="footer">
  <div class="container text-center">
    <div class="fnav">
      <p>Copyright &copy; 2016 Studio7. Designed by <a href="http://www.templatewire.com" rel="nofollow">TemplateWire</a></p>
    </div>
  </div>
</div>
<!-- <script type="text/javascript" src="static/js/jquery.1.11.1.js"></script> 
<script type="text/javascript" src="static/js/bootstrap.js"></script> 
<script type="text/javascript" src="static/js/SmoothScroll.js"></script> 
<script type="text/javascript" src="static/js/jquery.prettyPhoto.js"></script> 
<script type="text/javascript" src="static/js/jquery.isotope.js"></script> 
<script type="text/javascript" src="static/js/jqBootstrapValidation.js"></script> 
<script type="text/javascript" src="static/js/contact_me.js"></script> 
<script type="text/javascript" src="static/js/main.js"></script> -->
</body>
</html>