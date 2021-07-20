package com.kunpeng.web;

import com.kunpeng.entity.Book;
import com.kunpeng.entity.Page;
import com.kunpeng.service.BookService;
import com.kunpeng.service.impl.BookServiceImpl;
import com.kunpeng.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClinetBookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 处理分页功能
     *
     * @param req
     * @param resp
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) {
        //1、获取请求参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、调用BookService.page(pageNo,pageSize)  返回Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        //3、把Page对象保存到requestScope中
        req.setAttribute("page", page);
        //4、请求转发到pages/manager/book_manage.jsp页面
        try {
            req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理分页功能
     *
     * @param req
     * @param resp
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) {
        //1、获取请求参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        //2、调用BookService.page(pageNo,pageSize)  返回Page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if (req.getParameter("min") != null) sb.append("&min=").append(req.getParameter("min"));
        if (req.getParameter("max") != null) sb.append("&max=").append(req.getParameter("max"));
        page.setUrl(sb.toString());
        //3、把Page对象保存到requestScope中
        req.setAttribute("page", page);
        //4、请求转发到pages/manager/book_manage.jsp页面
        try {
            req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
