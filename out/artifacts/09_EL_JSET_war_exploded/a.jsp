<%--
  Created by IntelliJ IDEA.
  User: lpc0410
  Date: 2021/5/23
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("key", "kunpeng");
%>
表达式脚本输出key的值是：<%=request.getAttribute("key1")==null?"":request.getAttribute("key1")%><br/>
EL表达式数据key的值是：${key1}
</body>
</html>
