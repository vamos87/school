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
            <th>ID grupy</th>
            <th>Nazwa grupy</th>
        </tr>
        <c:forEach var="group" items="${groups}">
            <tr>
                <td>${group.id}</td>
                <td>${group.name}</td>
                <td><a href="/EditGroup?id=${group.id}">Edytuj</a></td>
            </tr>
        </c:forEach>
        <a href="/EditGroup?id=0">Nowa grupa</a>
    </table>
    <br>
    <a href="/panel">Powrót</a>
    <%@include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>
