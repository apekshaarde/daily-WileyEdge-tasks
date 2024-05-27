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
            <form name="frm" action="<c:url value='/update' />" method="post">
                <input type="hidden" name="id" value='${trainee.id()}' id="id" />
                <label for="name">Enter Your Name: </label>
                <input type="text" name="name" value='${trainee.name()}' id="name" placeholder="Enter your updated name please" />

                <label for="email">Enter Your Email: </label>
                <input type="email" name="email" value='${trainee.email()}' id="email" placeholder="Enter your updated email please" />

                <label for="location">Enter Your Location: </label>
                <input type="text" name="location" value='${trainee.location()}' id="location" placeholder="Enter your updated location please" />

                <input type="submit" name="s" value="Update" />
            </form>
        </div>
    </body>
</html>
