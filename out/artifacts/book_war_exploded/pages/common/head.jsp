<%--
  Created by IntelliJ IDEA.
  User: lpc0410
  Date: 2021/6/2
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--动态base标签值的获取--%>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":" + request.getServerPort()
            + request.getContextPath() + "/";
    pageContext.setAttribute("basePath",basePath);
%>

<!--写base标签，永远固定相对路径跳转的结构-->
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
