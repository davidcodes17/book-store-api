package com.runproject.BookStore.controller;

import com.runproject.BookStore.model.Book;
import com.runproject.BookStore.response.Success;
import com.runproject.BookStore.service.BookServiceImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("/books")
    public ResponseEntity<?> findAllBooks(){
        Success success = new Success();
        success.setMessage("Books found");
        success.setResponse(bookService.getBooks());
        return new ResponseEntity<>(success, HttpStatus.OK);
    }

    @PostMapping("/add-book")
    public ResponseEntity<?> addBook(@RequestBody Book book){
        Success success = new Success();
        success.setMessage("Book added");
        success.setResponse(bookService.addBook(book));
        return new ResponseEntity<>(success, HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> findBookById(@PathVariable String id){
        Success success = new Success();
        success.setMessage("Book found");
        success.setResponse(bookService.findBookById(id));
        return new ResponseEntity<>(success, HttpStatus.OK);
    }

    @PutMapping("/update-book/{id}")
    public ResponseEntity<?> updateBook(@RequestBody Book book, @PathVariable String id){
        Success success = new Success();
        success.setMessage("Book updated");
        success.setResponse(bookService.updateBook(book, id));
        return new ResponseEntity<>(success, HttpStatus.OK);
    }

    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id){
        Success success = new Success();
        success.setMessage("Book deleted");
        success.setResponse(bookService.deleteBook(id));
        return new ResponseEntity<>(success, HttpStatus.OK);
    }


}
