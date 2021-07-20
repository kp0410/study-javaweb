package com.kunpeng.web;

import com.kunpeng.entity.User;
import com.kunpeng.service.UserService;
import com.kunpeng.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

//    private final UserService userService;
//
//    public RegistServlet(UserService userService) {
//        this.userService = userService;
//    }
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");//验证码
        //2、检查 验证码是否正确
        if ("abcde".equalsIgnoreCase(code)) {
            //3、检查 用户是否可用
            if (userService.existsUsername(username)) {
                System.out.println("用户名["+username+"]已存在");
                req.setAttribute("msg","用户名已存在!");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else {
                userService.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        } else {
            //返回注册页面
            System.out.println("验证码错误！：" + code);
            req.setAttribute("msg","验证码错误!");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
