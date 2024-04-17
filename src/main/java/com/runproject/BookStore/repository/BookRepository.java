package com.runproject.BookStore.repository;

import com.runproject.BookStore.model.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

//import java.util.UUID;

public interface BookRepository extends MongoRepository<Book, String> {
}
