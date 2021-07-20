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
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        //1、获取请求的参数===封装的Book对象
        Book book = WebUtils.copyParamToBea(req.getParameterMap(), new Book());
        //2、调用BookService.addBook()保存图书数据
        bookService.addBook(book);
        //3、跳转图书列表页面
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
        try {
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + (pageNo + 1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) {

        //1、获取请求的参数id，图书id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2、调用BookService.deleteByBookId()删除图书
        bookService.deleteBookById(id);
        //3、重定向跳转图书列表页面
        try {
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) {
        Book book = WebUtils.copyParamToBea(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        try {
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 查询全部图书
        List<Book> books = bookService.queryBooks();
        //2 把全部图书保存到request域中
        req.setAttribute("books", books);
        //3 请求转发到/pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        req.setAttribute("book", book);
        try {
            req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
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
    protected void page(HttpServletRequest req, HttpServletResponse resp) {
        //1、获取请求参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、调用BookService.page(pageNo,pageSize)  返回Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        //3、把Page对象保存到requestScope中
        req.setAttribute("page", page);
        //4、请求转发到pages/manager/book_manage.jsp页面
        try {
            req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
