<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 08.08.18
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="/WEB-INF/fragments/header.jsp"%>

    <table border="1">
        <tr>
            <th>Nazwa</th>
            <th></th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.username}</td>
                <td><a href="/Details?id=${user.id}">Więcej</a></td>
            </tr>
        </c:forEach>
    </table>

    <%@include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>
