<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/27
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>choose</title>
</head>
<body>
    <%
        request.setAttribute("number",5);
    %>
    <c:choose>
        <c:when test="${number==1}">周一</c:when>
        <c:when test="${number==2}">周2</c:when>
        <c:when test="${number==3}">周3</c:when>
        <c:when test="${number==4}">周4</c:when>
        <c:when test="${number==5}">周5</c:when>
        <c:when test="${number==6}">周6</c:when>
        <c:when test="${number==7}">周7</c:when>
        <c:otherwise>超出界限</c:otherwise>
    </c:choose>

</body>
</html>
