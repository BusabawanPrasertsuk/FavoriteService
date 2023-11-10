package com.example.favoriteservice.core.data;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("FavoriteBooks")
public class FavoriteEntity implements Serializable {

    @Id
    private String favoriteId;
    private String book; // Book data type
    private String userId;

}
