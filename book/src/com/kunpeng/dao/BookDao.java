package com.kunpeng.dao;

import com.kunpeng.entity.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public List<Book> queryBooks();

    public Book queryBookById(Integer id);

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int i, int pageSize);

    List<Book> queryForPageItemsByPrice(int i, int pageSize, int min, int max);

    Integer queryForPageTotalCountByPrice(int min, int max);
}
