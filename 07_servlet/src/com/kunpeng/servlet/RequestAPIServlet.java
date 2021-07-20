package com.kunpeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        i. getRequestURI() 获取请求的资源路径
        System.out.println("URI => " + request.getRequestURI());
//        ii. getRequestURL() 获取请求的统一资源定位符（绝对路径）
        System.out.println("URL => " + request.getRequestURL());
//        iii. getRemoteHost() 获取客户端的 ip 地址
        System.out.println("client IP => " + request.getRemoteHost());
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemoteUser());
        System.out.println(request.getRemotePort());
//        iv. getHeader() 获取请求头
        System.out.println("请求头User-Agent  ==> "+request.getHeader("User-Agent"));
        System.out.println("请求头Cookie  ==> "+request.getHeader("Cookie"));
//        v. getParameter() 获取请求的参数
//        System.out.println();
//        vi. getParameterValues() 获取请求的参数（多个值的时候使用）
//        vii. getMethod() 获取请求的方式 GET 或 POST
//        viii. setAttribute(key, value); 设置域数据
//        ix. getAttribute(key); 获取域数据
//        x. getRequestDispatcher() 获取请求转发对象

    }
}
