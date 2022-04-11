<%--
  Created by IntelliJ IDEA.
  User: Gavin
  Date: 9/12/2021
  Time: 8:13 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick14" method="post">
        <!--表明是第一个user对象的name和age-->
        <input type="text" name="users[0].name"><br/>
        <input type="text" name="users[0].age"><br/>
        <input type="text" name="users[1].name"><br/>
        <input type="text" name="users[1].age"><br/>
        <input type="submit" name="提交">
    </form>
</body>
</html>
