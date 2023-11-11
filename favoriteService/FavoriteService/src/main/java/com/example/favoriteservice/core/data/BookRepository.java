package com.example.favoriteservice.core.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<BookEntity, String> {
    @Query(value = "{'bookId' :  ?0}")
    public BookEntity findBookEntityByBookId(String bookId);
}
