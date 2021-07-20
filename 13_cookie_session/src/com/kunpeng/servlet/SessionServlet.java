package com.kunpeng.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {
    //创建和获取session
    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) {
        //创建和获取Session会话对象
        HttpSession session = req.getSession();
        //判断当前session会话，是否是新创建出来的
        boolean isNew = session.isNew();
        //获取Session会话的唯一标识 id
        String id = session.getId();
        try {
            resp.getWriter().write("得到的Session，它的id是：" + id + "<br/>");
//            (isNew = true ? "是新建的。" : "不是新建的。")
            resp.getWriter().write("这个Session是否是新创建的：" + (isNew ? "是新创建的！" : "不是新创建的！") + "<br/>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //存Session
    protected void setSession(HttpServletRequest request,HttpServletResponse response){
        request.getSession().setAttribute("key1","session1");
        try {
            response.getWriter().write("已经往Session中保存了数据！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void getSession(HttpServletRequest request,HttpServletResponse response){
        Object key1 = request.getSession().getAttribute("key1");
        try {
            response.getWriter().write("从Session中获取出key1的数据是："+key1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void defaultLife(HttpServletRequest request,HttpServletResponse response){
        //获取session的默认超时时长
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        try {
            response.getWriter().write("session的默认时长是"+maxInactiveInterval+"秒！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void life3(HttpServletRequest request,HttpServletResponse response){
        request.getSession().setMaxInactiveInterval(3);
        try {
            response.getWriter().write("当前Session已设置为3秒超时时长");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void deleteNow(HttpServletRequest request,HttpServletResponse response){
        //session马上失效
        request.getSession().invalidate();
        try {
            response.getWriter().write("session已经设置为超时（无效）");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
