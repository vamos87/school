<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 09.08.18
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/fragments/header.jsp"%>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>ID zadania</th>
            <th>Tytuł</th>
            <th>Opis</th>
        </tr>
        <c:forEach var="excercise" items="${excercises}">
            <tr>
                <td>${excercise.id}</td>
                <td>${excercise.title}</td>
                <td>${excercise.description}</td>
                <td><a href="/EditExcercise?id=${excercise.id}">Edytuj</a></td>
            </tr>
        </c:forEach>
        <a href="/EditExcercise?id=0">Nowe zadanie</a>
    </table>
    <br>
    <a href="/panel">Powrót</a>
    <%@include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>
