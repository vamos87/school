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
            <th>ID</th>
            <th>Nazwa użytkownika</th>
            <th>E-mail</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td><a href="/EditUser?id=${user.id}">Edytuj</a></td>
            </tr>
        </c:forEach>
        <a href="/EditUser?id=0">Nowy użytkownik</a>
    </table>
    <br>
    <a href="/panel">Powrót</a>
    <%@include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>
