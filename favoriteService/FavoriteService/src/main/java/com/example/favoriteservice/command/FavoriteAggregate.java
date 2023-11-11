package com.example.favoriteservice.command;

import com.example.favoriteservice.core.events.FavoriteCreateEvent;
import com.example.favoriteservice.core.events.FavoriteDeleteEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@Aggregate
public class FavoriteAggregate {
    @AggregateIdentifier
    private String favoriteId;
    private String bookId;
    private String userId;

    public FavoriteAggregate(){}

    @CommandHandler
    public FavoriteAggregate (CreateFavoriteCommand createFavoriteCommand){
        FavoriteCreateEvent favoriteCreateEvent = new FavoriteCreateEvent();
        BeanUtils.copyProperties(createFavoriteCommand, favoriteCreateEvent);
        AggregateLifecycle.apply(favoriteCreateEvent);
    }

    @EventSourcingHandler
    public void on(FavoriteCreateEvent favoriteCreateEvent){
        this.favoriteId = favoriteCreateEvent.getFavoriteId();
        this.bookId = favoriteCreateEvent.getBookId();
        this.userId = favoriteCreateEvent.getUserId();
    }

    @CommandHandler
    public FavoriteAggregate (DeleteFavoriteCommand deleteFavoriteCommand){
        FavoriteDeleteEvent favoriteDeleteEvent = new FavoriteDeleteEvent();
        BeanUtils.copyProperties(deleteFavoriteCommand, favoriteDeleteEvent);
        AggregateLifecycle.apply(favoriteDeleteEvent);
    }

    @EventSourcingHandler
    public void on(FavoriteDeleteEvent favoriteDeleteEvent){
        this.favoriteId = UUID.randomUUID().toString();
        this.bookId = favoriteDeleteEvent.getBookId();
        this.userId = favoriteDeleteEvent.getUserId();
    }
}
