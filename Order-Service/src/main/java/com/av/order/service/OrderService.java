package com.av.order.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @KafkaListener(topics = "cart-items" , groupId = "cart-group")
    public void placeOrder(String item){
        System.out.println(item);
    }
}
