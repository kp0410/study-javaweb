package com.kunpeng.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext servletContext = getServletContext();
        System.out.println(servletContext.getAttribute("key"));
        System.out.println("ContextServlet1 ："+servletContext);
        servletContext.setAttribute("key","value");
        System.out.println("Context1中获取域数据key的值是："+servletContext.getAttribute("key"));
        System.out.println("Context1中获取域数据key的值是："+servletContext.getAttribute("key"));
        System.out.println("Context1中获取域数据key的值是："+servletContext.getAttribute("key"));
        System.out.println("Context1中获取域数据key的值是："+servletContext.getAttribute("key"));
    }
}
