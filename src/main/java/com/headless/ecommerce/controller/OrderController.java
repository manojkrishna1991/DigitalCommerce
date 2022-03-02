package com.headless.ecommerce.controller;

import com.headless.ecommerce.domain.CommerceOrder;
import com.headless.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {


    @Autowired
    OrderService orderService;

    
    @PostMapping("/createOrder")
    public ResponseEntity<CommerceOrder> createOrder(@RequestBody CommerceOrder commerceOrder) {
        return ResponseEntity.ok(orderService.createOrder(commerceOrder));
    }

//    @PostMapping("/getorder")
//    public ResponseEntity<Order> getOrderByOrderId(@RequestBody Order order) {
//        return ResponseEntity.ok();
//    }

   

}