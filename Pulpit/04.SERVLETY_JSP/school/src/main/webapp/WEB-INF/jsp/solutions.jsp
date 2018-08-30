<%@ page import="pl.coderslab.model.Solution" %><%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 08.08.18
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="/WEB-INF/fragments/header.jsp"%>

    Szczegóły rozwiązania zadania:<br>
    ${solution}

    <%@include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>
