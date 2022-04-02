package com.headless.ecommerce.controller;

import com.headless.ecommerce.domain.CommerceOrder;
import com.headless.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/order")
public class OrderController {


    @Autowired
    OrderService orderService;

    
    @PostMapping
    public ResponseEntity<CommerceOrder> createOrder(@RequestBody CommerceOrder commerceOrder) {
        return ResponseEntity.ok(orderService.createOrder(commerceOrder));
    }

    @GetMapping("/{orderID}")
    public ResponseEntity<CommerceOrder> getOrderByOrderId(@PathVariable  Long orderID) {
        return ResponseEntity.ok(orderService.getOrderID(orderID).get());
    }


    @DeleteMapping("/{orderID}")
    public void deleteOrder(@PathVariable  Long orderID) {
        orderService.deleteOrderID(orderID);
    }

    @PutMapping("/{orderID}")
    public void updateOrder(@PathVariable  Long orderID,@RequestBody CommerceOrder commerceOrder) {
        orderService.updateOrder(orderID,commerceOrder);
    }
   

}