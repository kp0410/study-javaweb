package com.kunpeng.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ServletTest implements Servlet {

    public ServletTest() {
        System.out.println("1、构造器方法");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("2、Servlet Test init() 方法！！");
        //1、获取Servlet程序的别名servlet-name的值
        System.out.println("ServletTest程序的别名是："+config.getServletName());
        //2、获取初始化参数init-parm
        System.out.println(config.getInitParameter("username"));
        //3、获取ServletContext对象
        System.out.println(config.getInitParameterNames().toString());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("3、Servlet Test service() 方法被访问了");
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String method = httpServletRequest.getMethod();
        System.out.println(method);

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4、销毁方法");
    }
}
