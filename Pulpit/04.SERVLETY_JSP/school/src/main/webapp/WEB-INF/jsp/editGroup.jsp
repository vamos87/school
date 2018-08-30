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

    <form action="/EditGroup" method="post">
        Nazwa grupy: <input name="nazwa" type="text" value="${group.name}"><br>
        <c:if test="${empty group.id}">
            <button type="submit" name="saveGroup" value="0">Dodaj grupę</button>
        </c:if>
        <c:if test="${not empty group.id}">
            <button type="submit" name="saveGroup" value="${group.id}">Zmodyfikuj grupę</button>
        </c:if>
    </form>

    <%@include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>
