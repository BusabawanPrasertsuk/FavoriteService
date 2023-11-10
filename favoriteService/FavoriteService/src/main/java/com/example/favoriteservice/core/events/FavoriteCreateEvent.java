package com.example.favoriteservice.core.events;

import lombok.Data;

@Data
public class FavoriteCreateEvent {
    private String favoriteId;
    private String book; // Book data type
    private String userId;
}
