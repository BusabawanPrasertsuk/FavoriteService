package com.example.favoriteservice.command.rest;

import lombok.Data;

@Data
public class AddFavoriteRestModel {
    private String favoriteId;
    private String book; // Book data type
    private String userId;
}
