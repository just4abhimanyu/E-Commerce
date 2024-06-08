package com.av.cart.conf;

import com.av.cart.constant.AppConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@Configurable
public class CartConfig {

    @Bean
    public NewTopic topics(){
        return TopicBuilder.name(AppConstant.CART_ITEMS)
                .build();
    }
}
