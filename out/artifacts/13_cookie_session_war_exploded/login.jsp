<%--
  Created by IntelliJ IDEA.
  User: lpc0410
  Date: 2021/7/13
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:80 90/13_cookie_session/loginServlet" method="get">
    用户名：<input type="text" name="username" value="${cookie.username.value}"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>

</body>
</html>
