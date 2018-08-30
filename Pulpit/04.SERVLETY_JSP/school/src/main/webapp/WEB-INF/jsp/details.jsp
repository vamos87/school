<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 08.08.18
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="/WEB-INF/fragments/header.jsp"%>

    Szczegóły użytkownika: <br>
    Nazwa: ${username}<br>
    Email: ${email}<br>
    <br>
    Dodane rozwiązania zadań:
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Utworzone</th>
            <th>Zaktualizowane</th>
            <th>Opis</th>
        </tr>
        <c:forEach var="solution" items="${solutions}">
            <tr>
                <td>${solution.id}</td>
                <td>${solution.created}</td>
                <td>${solution.updated}</td>
                <td>${solution.description}</td>
            </tr>
        </c:forEach>
    </table>

    <%@include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>
