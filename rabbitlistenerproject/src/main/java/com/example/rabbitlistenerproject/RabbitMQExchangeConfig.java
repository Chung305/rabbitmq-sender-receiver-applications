package com.example.rabbitlistenerproject;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfig {

    @Bean
    public Exchange exampleExchange(){
        return new TopicExchange("exampleExchange");
    }

    @Bean
    public Exchange exampleSecondExchange(){
        return ExchangeBuilder.directExchange("exampleSecondExchange")
                .autoDelete()
                .internal()
                .build();
    }

    @Bean
    public Exchange newExchange(){
        return ExchangeBuilder.topicExchange("TopicTestExchange")
                .internal()
                .autoDelete()
                .durable(true)
                .build();
    }

    @Bean
    public Exchange fanoutExchange(){
        return ExchangeBuilder.fanoutExchange("FanoutTestExchange")
                .autoDelete()
                .durable(false)
                .internal()
                .build();
    }

    @Bean
    public Exchange headerExchange(){
        return ExchangeBuilder.headersExchange("HeaderTestExchange")
                .internal()
                .durable(true)
                .ignoreDeclarationExceptions()
                .build();
    }
}
