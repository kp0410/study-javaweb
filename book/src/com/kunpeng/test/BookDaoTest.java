package com.kunpeng.test;

import com.kunpeng.dao.BookDao;
import com.kunpeng.dao.impl.BookDaoImpl;
import com.kunpeng.entity.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "最伟大的推销员", new BigDecimal("20.3"), "kunpeng", 3200, 50, null));
    }

    @Test
    public void deleteBookById() {
        int i = bookDao.deleteBookById(21);
        System.out.println(i);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "推销员", new BigDecimal("32"), "kunpeng", 320000, 0, null));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(21);
        System.out.println(book);
    }

    @Test
    public void queryForPageTotalCount() {
        Integer integer = bookDao.queryForPageTotalCount();
        System.out.println(integer);
    }

    @Test
    public void queryForPageItems() {
        List<Book> books = bookDao.queryForPageItems(4, 4);
        books.forEach(System.out::println);
    }

    @Test
    public void queryForPageItemsByPrice() {
        List<Book> books = bookDao.queryForPageItemsByPrice(0, 4, 10, 50);
        books.stream().forEach(System.out::println);
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));
    }
}