package com.example.mongo.reactive.veryold;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.jms.Message;

@RestController
public class SSEController {

    @Autowired
    private Flux<Item> flux;

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Item> getJoke(){
        return flux;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@RequestBody Item item){
        jmsTemplate.convertAndSend("DEV.QUEUE.1", item);
    }

}