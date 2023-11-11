package com.example.favoriteservice.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class DeleteFavoriteCommand {
    @TargetAggregateIdentifier
    private String favoriteId;
    private String bookId; // Book data type
    private String userId;
}
