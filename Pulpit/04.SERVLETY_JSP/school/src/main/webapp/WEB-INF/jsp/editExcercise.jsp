<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 09.08.18
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="/WEB-INF/fragments/header.jsp"%>

    <form action="/EditExcercise" method="post">
        Tytuł zadania: <input name="title" type="text" value="${excercise.title}"><br>
        Opis: <input name="description" type="text" value="${excercise.description}"><br>
        <c:if test="${empty excercise.id}">
            <button type="submit" name="saveExcercise" value="0">Dodaj zadanie</button>
        </c:if>
        <c:if test="${not empty excercise.id}">
            <button type="submit" name="saveExcercise" value="${excercise.id}">Zmodyfikuj zadanie</button>
        </c:if>
    </form>

    <%@include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>
