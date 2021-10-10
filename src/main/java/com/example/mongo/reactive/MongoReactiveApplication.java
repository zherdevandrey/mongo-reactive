package com.example.mongo.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Message;

@SpringBootApplication
@EnableJms
public class MongoReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoReactiveApplication.class, args);
    }


//    @Bean
//    public Publisher<Message<String>> jmsReactiveSource() {
//        return IntegrationFlows
//                .from(Jms.messageDrivenChannelAdapter(this.connectionFactory)
//                        .destination("testQueue"))
//                .channel(MessageChannels.queue())
//                .log(LoggingHandler.Level.DEBUG)
//                .log()
//                .toReactivePublisher();
//    }

}
