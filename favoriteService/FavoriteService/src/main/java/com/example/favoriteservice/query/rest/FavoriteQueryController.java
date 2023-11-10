package com.example.favoriteservice.query.rest;

import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FavoriteQueryController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping(value = "/getFavorite")
    public ArrayList getFavorites() {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("application/json");
        Object favBook = rabbitTemplate.convertSendAndReceive("FavoriteExchange", "getFavorite", "");
        return (ArrayList) favBook;
    }
}
