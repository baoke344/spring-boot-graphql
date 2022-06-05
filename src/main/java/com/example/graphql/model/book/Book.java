package com.example.graphql.model.book;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String title;
    private String isPublished;
    private Author author;
}
