package com.av.cart.controller;

import com.av.cart.constant.AppConstant;
import com.av.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("addToCart")
    public ResponseEntity<Map<String,String>> addToCart(@RequestParam String item){
        cartService.addToCart(AppConstant.ITEMS);
        return new ResponseEntity<>(Map.of("message",item), HttpStatus.OK);
    }
}
