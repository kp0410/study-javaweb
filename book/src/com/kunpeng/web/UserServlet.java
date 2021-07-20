package com.kunpeng.web;

import com.kunpeng.entity.User;
import com.kunpeng.service.UserService;
import com.kunpeng.service.impl.UserServiceImpl;
import com.kunpeng.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
//    @Resource
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(new User(username, password));
        if (user == null) {
            System.out.println("用户名或密码错误！");
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);
            //跳转
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            System.out.println("登录成功！");
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    protected void logout(HttpServletRequest request,HttpServletResponse response){
        //1、销毁Session中用户登录的信息（或者销毁Session）
        request.getSession().invalidate();
        //2、重定向到首页（或登录页面）
        try {
            response.sendRedirect(request.getContextPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");//验证码
        User user = WebUtils.copyParamToBea(req.getParameterMap(),new User());
        //2、检查 验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)) {
            //3、检查 用户是否可用
            if (userService.existsUsername(username)) {
                System.out.println("用户名[" + username + "]已存在");
                req.setAttribute("msg", "用户名[" + username + "]已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                userService.registUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //返回注册页面
            System.out.println("验证码错误！：" + code);
            req.setAttribute("msg", "验证码错误!");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        try {
//            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
//            method.invoke(this,req,resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
