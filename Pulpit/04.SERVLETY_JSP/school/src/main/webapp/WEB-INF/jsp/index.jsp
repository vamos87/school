<%@ page import="java.util.List" %>
<%@ page import="pl.coderslab.model.Solution" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 06.08.18
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="../fragments/header.jsp"%>

    <table border="1">
            <tr>
                <th>ID zadania</th>
                <th>Data dodania</th>
                <th></th>
            </tr>
        <c:forEach items="${loadAllSolutions}" var="solution">
            <tr>
                <td>${solution.id}</td>
                <td>${solution.updated}</td>
                <td><a href="/Solutions?id=${solution.id}">Szczegóły</a> </td>
            </tr>
        </c:forEach>
    </table>

    <%@include file="../fragments/footer.jsp"%>
</body>
</html>
