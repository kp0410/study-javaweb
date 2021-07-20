package com.kunpeng.service.impl;

import com.kunpeng.dao.BookDao;
import com.kunpeng.dao.impl.BookDaoImpl;
import com.kunpeng.entity.Book;
import com.kunpeng.entity.Page;
import com.kunpeng.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();
        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0)
            pageTotal += 1;
        // 设置总页码
        page.setPageTotal(pageTotal);
        // 设置当前页码
        page.setPageNo(pageNo);
        // 求当前页数据
        List<Book> item = bookDao.queryForPageItems((page.getPageNo() - 1) * pageSize, pageSize);
        // 设置当前页数据
        page.setItems(item);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0)
            pageTotal += 1;
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        List<Book> items = bookDao.queryForPageItemsByPrice((page.getPageNo()-1)*pageSize,pageSize,min,max);
        page.setItems(items);
        return page;
    }
}
