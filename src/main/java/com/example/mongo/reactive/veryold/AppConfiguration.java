package com.example.mongo.reactive.veryold;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import javax.jms.ConnectionFactory;
import javax.jms.Message;

@Configuration
@EnableScheduling
public class AppConfiguration {

    private static final String JOKE_API_ENDPOINT = "https://official-joke-api.appspot.com/jokes/random";

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl(JOKE_API_ENDPOINT)
                .build();
    }

    @Bean
    public Sinks.Many<Item> sink(){
        return Sinks.many().replay().latest();
    }

    @Bean
    public Flux<Item> flux(Sinks.Many<Item> sink){
        return sink.asFlux();
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        final JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setDeliveryPersistent(true);
        jmsTemplate.setPubSubDomain(true);// Publish subscribe mode
        jmsTemplate.setConnectionFactory(connectionFactory);
        jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());
        return jmsTemplate;
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerFactoryWithConverter(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);// Publish subscribe mode
        bean.setConnectionFactory(connectionFactory);
        bean.setMessageConverter(jacksonJmsMessageConverter());
        return bean;
    }

}