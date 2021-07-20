package com.kunpeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        System.out.println("在Servlet2中查看参数："+username);
        //查看
        Object key = req.getAttribute("key");
        System.out.println("在Servlet1中赋的key为："+key);
        //处理自己的业务
        System.out.println("Servlet2处理自己的业务 ");
    }
}
