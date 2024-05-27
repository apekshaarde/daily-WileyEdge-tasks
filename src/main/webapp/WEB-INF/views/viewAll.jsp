<%@page contentType="text/html" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="navBar.jsp" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Title</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
           <script type="text/javascript" src="<c:url value='/JS/searchTrainee.js' />"></script>
        </head>

        <body>
        <div class="wrapper">
            <div class="header">
                <h1>Trainees</h1>
                <div class="input-group">
                    <input type="text" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" onkeyup="searchData(this.value)" />
                </div>
            </div>
            <div id ="result">
            <table class="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Location</th>
                        <th>Actions</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="trainee" items="${trainees}">
                        <tr>
                            <td>${trainee.name()}</td>
                            <td>${trainee.email()}</td>
                            <td>${trainee.location()}</td>
                            <td>
                                <button onclick="deleteTrainee(${trainee.id()})" class="btn btn-danger">Delete</a>
                            </td>
                            <td>
                                <a href="editTrainee/${trainee.id()}" class="btn btn-primary">Update</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            </div>
            </div>
        </body>

<script>
  let deleteTrainee = (id)=>{
            if(confirm("Deleting trainee with id: "+id)){
                window.location.href = "delete-trainee?id=" + id;
            }
        }

        </script>

        </html>