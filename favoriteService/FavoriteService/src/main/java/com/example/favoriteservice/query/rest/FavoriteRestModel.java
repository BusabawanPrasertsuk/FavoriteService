package com.example.favoriteservice.query.rest;

import lombok.Data;

@Data
public class FavoriteRestModel {
    private String favoriteId;
    private String bookId; // Book data type
    private String userId;
}
