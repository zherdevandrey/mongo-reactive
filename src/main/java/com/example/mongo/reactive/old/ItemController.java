package com.example.mongo.reactive.old;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

//
//@RestController
//@Slf4j
public class ItemController {

//    @Autowired
//    private JmsTemplate jmsTemplate;
//
//    @Autowired
//    private TestListener testListener;
//
//    @Autowired
//    ItemReactiveRepository itemReactiveRepository;
//
//    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<Item> getAllItems() {
//      //  jmsTemplate.convertAndSend("DEV.QUEUE.1", "Hello World!");
//        return itemReactiveRepository.findAll().delaySubscription(Duration.ofSeconds(2));
//       // return null;
//    }
//
////    @GetMapping(path = "/test", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
////    public Flux<String> getAllItems2() {
////
////    //    String s = jmsTemplate.receiveAndConvert("DEV.QUEUE.1").toString();
////
////   //     System.out.println(s.toString());
////
////        //   return itemReactiveRepository.findAll();
////        return testListener.subscribe();
////    }
//
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Mono<Item> createItem(@RequestBody Item item){
//            return itemReactiveRepository.save(item);
//    }

}