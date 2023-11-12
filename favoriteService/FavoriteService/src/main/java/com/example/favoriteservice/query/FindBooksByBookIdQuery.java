package com.example.favoriteservice.query;

public class FindBooksByBookIdQuery {
    private final String bookId;

    public FindBooksByBookIdQuery(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }
}