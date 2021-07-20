package com.kunpeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(resp.getCharacterEncoding());//字符集默认ISO-8859-1
        //设置服务器字符集
//        resp.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("GBK");
//        System.out.println(resp.getCharacterEncoding());
        //通过响应头，设置浏览器使用UTF-8字符集
//        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        //此方法一定要在获取流对象前调用才有效   否则乱码
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println(resp.getCharacterEncoding());
        PrintWriter writer = resp.getWriter();
        //要求：往客户端传字符串数据
//        resp.getOutputStream();
//        writer.write("response's content!!!");
        writer.write("鲲鹏爱鸽子");

    }
}
