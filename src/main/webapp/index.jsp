<%@page import="java.util.Iterator"%>
<%@page import="model.Alumno"%>
<%@page import="java.util.List"%>
<%@page import="modeldao.AlumnoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CRUD - MYSQL</title   >
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body style="background-color: #F8F9FA;">
    <div class="container">
        <h2 class="text-center mt-3 mb-3 fw-bold">Estudiantes de la Facultad de Sistemas</h2>
        <% if (request.getParameter("editBtn") != null) { %>
            <jsp:include page="view/edit.jsp" />
        <% } else { %>
            <jsp:include page="view/add.jsp" />
        <% } %>
        <jsp:include page="view/list.jsp" />
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>