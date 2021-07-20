package com.kunpeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ParmenterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-------------------doGet----------------");
        System.out.println("用户名为：" + request.getParameter("username"));
        System.out.println("密码为：" + request.getParameter("password"));
        System.out.println("兴趣爱好为：" + Arrays.asList(request.getParameterValues("hobby")));

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-------------------doPost----------------");
        request.setCharacterEncoding("UTF-8");
        System.out.println("用户名为：" + request.getParameter("username"));
        System.out.println("密码为：" + request.getParameter("password"));
        System.out.println("兴趣爱好为：" + Arrays.asList(request.getParameterValues("hobby")));

    }
}

