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

    <form action="/EditUser" method="post">
        Nazwa użytkownika: <input name="username" type="text" value="${user.username}"><br>
        Hasło: <input name="password" type="password" value="${user.password}"><br>
        E-mail: <input name="email" type="email" value="${user.email}"><br>
        <c:if test="${empty user.id}">
            <button type="submit" name="saveUser" value="0">Dodaj użytkownika</button>
        </c:if>
        <c:if test="${not empty user.id}">
            <button type="submit" name="saveUser" value="${user.id}">Zmodyfikuj użytkownika</button>
        </c:if>
    </form>

    <%@include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>
