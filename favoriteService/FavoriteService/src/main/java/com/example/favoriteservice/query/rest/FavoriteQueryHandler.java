package com.example.favoriteservice.query.rest;

import com.example.favoriteservice.core.data.BookEntity;
import com.example.favoriteservice.core.data.BookRepository;
//import com.example.favoriteservice.query.FindBooksByBookIdQuery;
import com.example.favoriteservice.core.data.FavoriteEntity;
import com.example.favoriteservice.core.data.FavoriteRepository;
import com.example.favoriteservice.query.FindBooksByBookIdQuery;
import com.example.favoriteservice.query.FindBooksQuery;
import com.example.favoriteservice.query.FindFavoritesQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FavoriteQueryHandler {
    private final BookRepository bookRepository;
    private final FavoriteRepository favoriteRepository;

    public FavoriteQueryHandler(BookRepository bookRepository, FavoriteRepository favoriteRepository) {

        this.bookRepository = bookRepository;
        this.favoriteRepository = favoriteRepository;
    }

    @QueryHandler
    public List<BookRestModel> findBooks(FindBooksQuery query) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        List<BookRestModel> bookRest = new ArrayList<>();
        List<BookEntity> storedBooks = bookRepository.findAll();
        for (BookEntity bookEntity : storedBooks) {
            BookRestModel bookRestModel = new BookRestModel();
            BeanUtils.copyProperties(bookEntity, bookRestModel);
            bookRest.add(bookRestModel);
        }
        return bookRest;
    }

    @QueryHandler
    public List<FavoriteRestModel> findFavorites(FindFavoritesQuery query) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        List<FavoriteRestModel> favRestModel = new ArrayList<>();
        List<FavoriteEntity> storedBooks = favoriteRepository.findAll();
        for (FavoriteEntity favoriteEntity : storedBooks) {
            FavoriteRestModel favoriteRestModel = new FavoriteRestModel();
            BeanUtils.copyProperties(favoriteEntity, favoriteRestModel);
            favRestModel.add(favoriteRestModel);
        }
        return favRestModel;
    }

    @QueryHandler
    public BookRestModel findBooksByBookId(FindBooksByBookIdQuery query) {
        BookEntity bookEntity = bookRepository.findBookEntityByBookId(query.getBookId());
        if (bookEntity != null) {
            BookRestModel bookRestModel = new BookRestModel();
            BeanUtils.copyProperties(bookEntity, bookRestModel);
            return bookRestModel;
        } else {
            return null;
        }

    }

}