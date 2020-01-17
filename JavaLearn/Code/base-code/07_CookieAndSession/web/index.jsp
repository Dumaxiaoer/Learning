<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/25
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    String contextPath=request.getContextPath();
    out.print(contextPath);
  %>

  <%!
    int i=3;
  %>
  <%= "学习" %>
  <h1>我会成为大神</h1>

  </body>
</html>
