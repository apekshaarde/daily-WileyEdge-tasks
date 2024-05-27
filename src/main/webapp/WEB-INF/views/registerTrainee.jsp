<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="<c:url value='/css/style.css' />" />
    </head>
    <body>
        <%@ include file="navBar.jsp" %>
        <div class="wrapper">
            <form name="frm" action="save" method="POST">
                <h1>Register</h1>
                <label for="name">Enter Your Name: </label>
                <input type="text" name="name" id="name" placeholder="Enter your name please" />

                <label for="email">Enter Your Email: </label>
                <input type="email" name="email" id="email" placeholder="Enter your email please" />

                <label for="location">Enter Your Location: </label>
                <input type="text" name="location" id="location" placeholder="Enter your location please" />

                <input type="submit" name="s" value="Register" />
            </form>
            ${msg}
        </div>
    </body>
</html>
