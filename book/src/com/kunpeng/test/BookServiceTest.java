package com.kunpeng.test;

import com.kunpeng.entity.Book;
import com.kunpeng.entity.Page;
import com.kunpeng.service.BookService;
import com.kunpeng.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"平凡的世界",new BigDecimal("54.5"),"gezi",20000,10,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"平凡的",new BigDecimal("35"),"鲲鹏",20000,5,"static/123.jpg"));
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(22);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book : books ) {
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        Page<Book> page = bookService.page(1, 4);
        System.out.println(page);
    }

    @Test
    public void pageByPrice() {

        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE, 10, 50));
    }
}