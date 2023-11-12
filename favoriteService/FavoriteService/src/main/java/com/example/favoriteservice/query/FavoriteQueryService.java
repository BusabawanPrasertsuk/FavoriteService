package com.example.favoriteservice.query;

import com.example.favoriteservice.query.rest.BookRestModel;
import com.example.favoriteservice.query.rest.FavoriteRestModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteQueryService {

    @Autowired
    private QueryGateway queryGateway;

    public FavoriteQueryService(QueryGateway queryGateway) {

        this.queryGateway = queryGateway;
    }

    @RabbitListener(queues = "GetBookQueue")
    public List<BookRestModel> getBook() {
        System.out.println("GET ALL BOOKS");
        FindBooksQuery findBooksQuery = new FindBooksQuery();
        return queryGateway.query(
                findBooksQuery,
                ResponseTypes.multipleInstancesOf(BookRestModel.class)
        ).join();
    }

    @RabbitListener(queues = "GetFavoriteQueue")
    public List<FavoriteRestModel> getFavorite() {
        System.out.println("GET ALL FAV");
        FindFavoritesQuery findFavoritesQuery = new FindFavoritesQuery();
        return queryGateway.query(
                findFavoritesQuery,
                ResponseTypes.multipleInstancesOf(FavoriteRestModel.class)
        ).join();
    }

}