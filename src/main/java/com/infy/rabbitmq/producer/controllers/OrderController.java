package com.infy.rabbitmq.producer.controllers;

import com.infy.rabbitmq.producer.dto.Order;
import com.infy.rabbitmq.producer.enums.Status;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1")
public class OrderController {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @PostMapping(value = "/place-order", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        order.setStatus(Status.PENDING);

        rabbitTemplate.convertAndSend(exchangeName, routingKey, order);
        
        return new ResponseEntity<>("Order Placed Successfully!", HttpStatus.OK);
    }
}
