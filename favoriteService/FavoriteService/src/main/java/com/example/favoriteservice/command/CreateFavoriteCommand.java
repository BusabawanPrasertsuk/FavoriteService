package com.example.favoriteservice.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


@Builder
@Data
public class CreateFavoriteCommand {
    @TargetAggregateIdentifier
    private final String favoriteId;
    private final String bookId;
    private final String userId;


}
