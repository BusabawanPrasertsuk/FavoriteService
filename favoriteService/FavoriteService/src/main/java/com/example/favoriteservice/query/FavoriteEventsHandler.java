package com.example.favoriteservice.query;

import com.example.favoriteservice.core.data.FavoriteRepository;
import com.example.favoriteservice.core.events.FavoriteCreateEvent;
import com.example.favoriteservice.core.events.FavoriteDeleteEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.favoriteservice.core.data.FavoriteEntity;
import com.example.favoriteservice.core.data.FavoriteRepository;

@Component
public class FavoriteEventsHandler {
    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteEventsHandler(FavoriteRepository favoriteRepository){
        this.favoriteRepository = favoriteRepository;
    }

    @EventHandler
    public void on(FavoriteCreateEvent event) {
        System.out.println("Adding favorite in mongoDB");
        FavoriteEntity favoriteEntity = new FavoriteEntity();
        BeanUtils.copyProperties(event, favoriteEntity);
        favoriteRepository.insert(favoriteEntity);
    }

    @EventHandler
    public void on(FavoriteDeleteEvent event) {
        System.out.println("DELETE favorite in mongoDB");
        FavoriteEntity favoriteEntity = new FavoriteEntity();
        BeanUtils.copyProperties(event, favoriteEntity);
        favoriteRepository.deleteById(favoriteEntity.getFavoriteId());
    }

}
