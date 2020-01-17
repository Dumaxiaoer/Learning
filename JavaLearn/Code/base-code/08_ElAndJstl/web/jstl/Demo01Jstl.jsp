<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/27
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%--
属性：
1.test：必须属性，接收boolea表达式
如果表达为true，则显示if标签体内容，false则不显示
2.一般test会结合el表达式一起使用
3.注意：c:if 标签，没有else情况，想要其效果则需再定义一个标签
--%>
    <c:if test="true">
        <h1> 我是真的</h1>>

    </c:if>


<%--    <c:if  test="false">我不是真的东西</c:if>--%>


</body>
</html>
