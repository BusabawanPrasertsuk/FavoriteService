package com.example.favoriteservice.core.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends MongoRepository<FavoriteEntity, String>{
    @Query(value = "{ 'favoriteId' : ?0 }")
    public FavoriteEntity findFavoriteEntitiesByFavoriteId(String favoriteId);

    @Query(value = "{ 'bookId' : ?0 }", delete = true)
    public FavoriteEntity findFavoriteEntitiesByBookId(String bookId);

}

