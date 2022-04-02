package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.CommerceOrder;
import com.headless.ecommerce.repository.LineItemRepository;
import com.headless.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private LineItemRepository lineItemRepository;

    public CommerceOrder createOrder(CommerceOrder commerceOrder){
        CommerceOrder order = orderRepository.save(commerceOrder);
        commerceOrder.getLineItem().forEach(lineItem -> {
            lineItem.setCommerceOrder(order);
            lineItemRepository.save(lineItem);
        });
        return order;
    }

    public Optional<CommerceOrder> getOrderID(Long id){
        return orderRepository.findById(id);
    }

    public void deleteOrderID(Long id){
         orderRepository.deleteById(id);
    }

    public void updateOrder(Long orderID,CommerceOrder order) {

        if (orderRepository.existsById(orderID)){
            order.setId(orderID);
            orderRepository.save(order);
        }else{
            throw new RuntimeException("OrderID does not exist");
        }

    }
}
