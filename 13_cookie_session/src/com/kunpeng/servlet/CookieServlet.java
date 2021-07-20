package com.kunpeng.servlet;

import com.kunpeng.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    protected void testPath(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("path1","path1");
//        getContextPath()===>>> 得到工程路径
        cookie.setPath(request.getContextPath()+"/abc");
        response.addCookie(cookie);
        try {
            response.getWriter().write("创建了一个path路径的Cookie");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void life3600(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        try {
            response.getWriter().write("创建了一个存活1小时的Cookie");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if (cookie != null) {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            try {
                resp.getWriter().write("key1的Cookie已经被删除");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) {
        //方法一
//        Cookie cookie = new Cookie("key1", "value");
//        resp.addCookie(cookie);
        //方法二
        Cookie cookieKey2 = CookieUtils.findCookie("key2", req.getCookies());
        if (cookieKey2 != null) {
            cookieKey2.setValue("newValue2");
            resp.addCookie(cookieKey2);
        }
    }


    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            try {
                resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Cookie iWantCookie = CookieUtils.findCookie("key2", cookies);
        try {
            if (iWantCookie != null) resp.getWriter().write("找到了需要的Cookie");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie);
        //1.创建Cookie对象
        Cookie cookie1 = new Cookie("key2", "value2");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie1);
        //3.
        resp.getWriter().write("Cookie创建成功");
    }
}


