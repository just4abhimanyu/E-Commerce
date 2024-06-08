package com.av.cart.service;

import com.av.cart.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private KafkaTemplate<String , Object> kafkaTemplate;

    public boolean addToCart(List<String> items){
       for(String item : items) {
           updateCart(item);
           try {
               Thread.sleep(1000);
           }catch (Exception ignored){}

       }
       return true;
    }
    public void updateCart(String item){
        kafkaTemplate.send(AppConstant.CART_ITEMS, item);
    }
}
