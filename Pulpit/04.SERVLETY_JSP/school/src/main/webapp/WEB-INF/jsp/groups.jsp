<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pl.coderslab.model.Group" %><%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 08.08.18
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="/WEB-INF/fragments/header.jsp"%>

    <%--<%--%>
        <%--ArrayList<Group> groups = (ArrayList<Group>) request.getAttribute()--%>
    <%--%>--%>
    <table border="1">
        <tr>
            <th>id</th>
            <th>name</th>
            <th></th>
        </tr>
        <c:forEach var="group" items="${groups}">
            <tr>
                <td>${group.id}</td>
                <td>${group.name}</td>
                <td><a href="/Users?id=${group.id}">Więcej</a></td>
            </tr>
        </c:forEach>
    </table>

    <%@include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>
