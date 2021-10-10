package com.example.mongo.reactive.old;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.AbstractJmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.function.Consumer;


@Service
@RequiredArgsConstructor
public class TestListener {

//    private final JmsTemplate jmsTemplate;
//
//
//    @JmsListener(destination = "${queue.name}")
//    public Flux<String> listenMessages(Message message) {
//
//        return Flux.create(new Consumer<FluxSink<String>>() {
//            @SneakyThrows
//            @Override
//            public void accept(FluxSink<String> sink) {
//                sink.next(((TextMessage) message).getText());
//            }
//        });
//    }
//
//    private final AbstractJmsListenerContainerFactory jmsListenerContainerFactory;// #1
//
//
//



//    public Flux<String> subscribe() {
//        return Flux.create(sink -> {// #2
//            var endpoint = new SimpleJmsListenerEndpoint();// #3endpoint
//            endpoint.setDestination("DEV.QUEUE.1");
//            endpoint.setMessageListener(message -> {// #4
//                if (message instanceof TextMessage) {
//                    try {
//                        System.out.println(((TextMessage) message).getText());
//                        sink.next(((TextMessage) message).getText());// #5
//                    } catch (JMSException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            });
//
//            var container = this.jmsListenerContainerFactory.createListenerContainer(endpoint);// #6
//            container.setDestinationName("DEV.QUEUE.1");
//            container.setPubSubDomain(true);
//
//            sink.onCancel(container::shutdown);// #7
//            sink.onDispose(container::shutdown);
//
//            container.initialize();// #8
//            container.start();
//
//
//
//        });
//    }
}
