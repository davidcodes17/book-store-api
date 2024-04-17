package com.runproject.BookStore.service;

import com.runproject.BookStore.model.Book;
import org.bson.types.ObjectId;

import java.util.List;

public interface BookService {

    public String addBook(Book book);

    public List<Book> getBooks();

    public Book findBookById(String id);

    public String updateBook(Book book,String id);

    public String deleteBook(String id);
}
