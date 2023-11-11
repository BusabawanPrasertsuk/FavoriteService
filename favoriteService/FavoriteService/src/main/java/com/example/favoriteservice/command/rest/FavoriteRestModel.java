package com.example.favoriteservice.command.rest;

import lombok.Data;

@Data
public class FavoriteRestModel {
    private String favoriteId;
    private String bookId; // Book data type
    private String userId;
}
