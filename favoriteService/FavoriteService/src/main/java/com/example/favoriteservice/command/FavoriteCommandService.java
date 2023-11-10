package com.example.favoriteservice.command;

import com.example.favoriteservice.command.rest.AddFavoriteRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FavoriteCommandService {
    @Autowired
    private final CommandGateway commandGateway;

    @Autowired
    public FavoriteCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @RabbitListener(queues = "AddFavoriteQueue")
    public void createFavorite(AddFavoriteRestModel model){
        CreateFavoriteCommand command = CreateFavoriteCommand.builder()
                .favoriteId(UUID.randomUUID().toString())
                .book(model.getBook())
                .userId(model.getUserId())
                .build();
        try {
            commandGateway.sendAndWait(command);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "DeleteFavoriteQueue")
    public void deleteFavorite(String favoriteId){
        System.out.println("Delete eiei " + favoriteId);
    }
}
