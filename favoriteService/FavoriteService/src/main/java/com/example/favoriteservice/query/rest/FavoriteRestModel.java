package com.example.favoriteservice.query.rest;

import lombok.Data;

@Data
public class FavoriteRestModel {
    private String favoriteId;
    private String book; // Book data type
    private String userId;
}
