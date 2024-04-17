package com.runproject.BookStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@AllArgsConstructor
@Data
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String bookContent;
}
