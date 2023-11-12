package com.example.favoriteservice.command;

import com.example.favoriteservice.command.rest.FavoriteRestModel;
import com.example.favoriteservice.core.data.FavoriteEntity;
import com.example.favoriteservice.core.data.FavoriteRepository;
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
    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteCommandService(CommandGateway commandGateway, FavoriteRepository favoriteRepository) {

        this.commandGateway = commandGateway;
        this.favoriteRepository = favoriteRepository;
    }

    @RabbitListener(queues = "AddFavoriteQueue")
    public void createFavorite(FavoriteRestModel model){
        CreateFavoriteCommand command = CreateFavoriteCommand.builder()
                .favoriteId(UUID.randomUUID().toString())
                .bookId(model.getBookId())
                .userId(model.getUserId())
                .build();
        try {
            commandGateway.sendAndWait(command);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @RabbitListener(queues = "DeleteFavoriteQueue")
    public void deleteBook(String bookId) {
        System.out.println("DELETE FAVORITE: " + bookId);

        FavoriteEntity favoriteEntity = favoriteRepository.findFavoriteEntitiesByBookId(bookId);
        System.out.println(favoriteEntity);

        if (favoriteEntity != null) {
            DeleteFavoriteCommand deleteFavoriteCommand = DeleteFavoriteCommand.builder()
                    .favoriteId(favoriteEntity.getFavoriteId())
                    .bookId(favoriteEntity.getBookId())
                    .userId(favoriteEntity.getUserId())
                    .build();

            try {
                commandGateway.sendAndWait(deleteFavoriteCommand);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("favorite not found with ID: " + bookId);
        }

    }
}
