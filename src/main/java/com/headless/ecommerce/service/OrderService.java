package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.CommerceOrder;
import com.headless.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public CommerceOrder createOrder(CommerceOrder commerceOrder){
       return orderRepository.save(commerceOrder);
    }


}
