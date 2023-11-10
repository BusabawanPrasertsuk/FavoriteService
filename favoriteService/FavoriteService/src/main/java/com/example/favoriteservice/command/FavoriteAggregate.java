package com.example.favoriteservice.command;

import com.example.favoriteservice.core.events.FavoriteCreateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

@Aggregate
public class FavoriteAggregate {
    @AggregateIdentifier
    private String favoriteId;
    private String book; // Book data type
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
        this.book = favoriteCreateEvent.getBook();
        this.userId = favoriteCreateEvent.getUserId();
    }

//    @EventSourcingHandler
//    public void off(FavoriteCreateEvent favoriteCreateEvent){
//        this.favoriteId = favoriteCreateEvent.getFavoriteId();
//        this.book = favoriteCreateEvent.getBook();
//        this.userId = favoriteCreateEvent.getUserId();
//    }

}
