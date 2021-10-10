package com.example.mongo.reactive.veryold;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Sinks;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.function.Consumer;

@Service
public class JokePublisher {

    @Autowired
    private WebClient webClient;

    @Autowired
    private Sinks.Many<Item> sink;

    @Autowired
    private JmsTemplate jmsTemplate;


    @JmsListener(destination = "${queue.name}", containerFactory = "jmsListenerContainerFactoryWithConverter")
    public void listenMessages(Item item) {
        sink.tryEmitNext(item);
    }

}