<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/27
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach</title>
</head>
<body>
    <%
        List list=new ArrayList();
        list.add("Animal");
        list.add("You");
        list.add("Are");
        list.add("My");
        list.add("World");
        request.setAttribute("list",list);
    %>

    <c:forEach items="${list}" var="str" varStatus="s">
        ${s.index}   ${s.count}  ${str} <br>
    </c:forEach>


<%--    <c:forEach begin="1" end="10" var="i" step="1">--%>
<%--        ${i}<br>--%>
<%--    </c:forEach>--%>


</body>
</html>
