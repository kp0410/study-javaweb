package com.kunpeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class RegistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String code = req.getParameter("code");
        //获取用户名
        String username = req.getParameter("username");
//        equalsIgnoreCase()忽略大小写
        if (token != null && token.equalsIgnoreCase(code)){
            System.out.println("保存到数据库："+username);
            resp.sendRedirect(req.getContextPath()+"/loginsuccess.jsp");
        }else {
            System.out.println("请不要重复提交表单！");
        }

//        System.out.println("保存到数据库："+username);
//        //解决表单重复提交问题的方法  1.重定向
//        resp.sendRedirect(req.getContextPath()+"/loginsuccess.jsp");



    }
}
