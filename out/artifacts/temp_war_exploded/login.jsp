<%--
  Created by IntelliJ IDEA.
  User: lpc0410
  Date: 2021/7/16
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="registServlet" method="get">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    验证码：<input type="text" style="width: 60px" name="code">
    <img src="kaptcha.jpg" style="width: 80px;height: 20px;margin-bottom: -6px" alt=""><br>
    <input type="submit" value="登录">
  </form>

  </body>
</html>
