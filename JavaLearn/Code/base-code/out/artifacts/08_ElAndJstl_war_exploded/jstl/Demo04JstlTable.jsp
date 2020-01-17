<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yangcc.domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/27
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <%
     List list=new ArrayList();
     list.add(new User("苗青青",28,new Date()));
     list.add(new User("王婷",27,new Date()));
     list.add(new User("希曼",26,new Date()));
     request.setAttribute("list",list);
 %>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>

    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${s.count%2==0}">
            <tr bgcolor="red">
                <th>${s.index}</th>
                <th>${user.name}</th>
                <th>${user.age}</th>
                <th>${user.birthday}</th>
            </tr>

        </c:if>
        <c:if test="${s.count%2==1}">
            <tr bgcolor="green">
                <th>${s.index}</th>
                <th>${user.name}</th>
                <th>${user.age}</th>
                <th>${user.birthday}</th>
            </tr>
        </c:if>


    </c:forEach>



</table>

</body>
</html>
