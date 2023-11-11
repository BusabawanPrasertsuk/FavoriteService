package com.example.favoriteservice.command.rest;

import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FavoriteCommandController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping(value = "/addFavorite")
    public String addFavoriteBook(@RequestBody FavoriteRestModel model){
        System.out.println("dai sak teeeeeeeeeeeeeeeeeeeeeeee");
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("application/json");
        rabbitTemplate.convertAndSend("FavoriteExchange", "addFavorite", model);
        return "add daiiiiiiiiiii";
//        urn true;  ret
    }

    @DeleteMapping(value = "/deleteFavorite/{favoriteId}")
    public String deleteFavoriteBook(@PathVariable("favoriteId") String favoriteId){
        rabbitTemplate.convertAndSend("FavoriteExchange", "deleteFavorite", favoriteId);
        return "DELETE " + favoriteId;
    }

//    @DeleteMapping("/deleteBook/{bookId}")
//    public String deleteBook(@PathVariable("bookId") String bookId) {
//        rabbitTemplate.convertAndSend("Direct", "deleteBook", bookId);
//        return "Delete Book ID: " + bookId;
//    }

//    @RequestMapping(value = "/addFavorite", method = RequestMethod.POST)
//    public Boolean addFavorite(@RequestBody Favorite favorite) {
//        System.out.println("Add >>>>>>>>>> " + favorite);
//        rabbitTemplate.convertAndSend("FavoriteExchange", "addFavorite", favorite);
//        return true;
//    }
//
//    @RequestMapping(value = "/deleteFavorite", method = RequestMethod.DELETE)
//    public Boolean deleteFavorite(@RequestBody Favorite favorite) {
//        System.out.println("Delete >>>>>>>>>> " + favorite);
//        rabbitTemplate.convertAndSend("FavoriteExchange", "deleteFavorite", favorite);
//        return true;
//    }

}
