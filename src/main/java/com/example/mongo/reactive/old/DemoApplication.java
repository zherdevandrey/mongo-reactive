package com.example.mongo.reactive.old;


import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.concurrent.atomic.AtomicLong;

//@RestController
public class DemoApplication {
//
//    final Sinks.Many sink;
//    final AtomicLong counter;
//
//
//    public DemoApplication() {
//        this.sink = Sinks.many().multicast().onBackpressureBuffer();
//        this.counter = new AtomicLong();
//    }
//
//    @GetMapping("/send")
//    public void test() {
//        Sinks.EmitResult result = sink.tryEmitNext("Hello World #" + counter.getAndIncrement());
//
//        if (result.isFailure()) {
//            // do something here, since emission failed
//        }
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/api/javainuse")
//    public String sayHello() {
//        return "Swagger Hello World";
//    }
//
//
//    @RequestMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<ServerSentEvent> sse() {
//        return sink.asFlux().map(e -> ServerSentEvent.builder(e).build());
//    }
}