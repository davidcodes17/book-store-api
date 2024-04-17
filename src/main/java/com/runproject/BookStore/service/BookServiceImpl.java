package com.runproject.BookStore.service;

import com.runproject.BookStore.model.Book;
import com.runproject.BookStore.repository.BookRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public String addBook(Book book) {
        String uuid = UUID.randomUUID().toString();
        book.setId(uuid);
        bookRepository.save(book);
        return "Book Added Successfully";
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(String id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new Error("Could not find"));
        return book;
    }

    @Override
    public String updateBook(Book book, String id) {
        Book found_book = bookRepository.findById(id).orElseThrow(() -> new Error("Could not find"));

        found_book.setTitle(book.getTitle());
        found_book.setBookContent(book.getBookContent());
        found_book.setAuthor(book.getAuthor());

        bookRepository.save(found_book);

        return "Book Updated Successfully";
    }

    @Override
    public String deleteBook(String id) {
        Book found_book = bookRepository.findById(id).orElseThrow(() -> new Error("Could not find"));
        bookRepository.delete(found_book);
        return "Book Deleted Successfully";
    }
}
