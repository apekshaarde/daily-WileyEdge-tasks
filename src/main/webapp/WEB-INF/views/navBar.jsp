<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="<c:url value='/css/style.css' />" />
    </head>
    <body>
        <div class="wrapper">
        	<ul>
        	    <h1><center>Welcome to Wiley</center></h1>
        	    <center>
        		<li><a href="<c:url value="/register" />">Register Trainee</a></li>
        		<li><a href="view-all">View Trainees</a></li>
        		<li><a href="">Contact Us</a></li>
        		</center>
        	</ul>
        </div>
    </body>
</html>


