package com.example.favoriteservice.core.events;

import lombok.Data;

@Data
public class FavoriteDeleteEvent {
    private String favoriteId;
    private String bookId; // Book data type
    private String userId;
}
