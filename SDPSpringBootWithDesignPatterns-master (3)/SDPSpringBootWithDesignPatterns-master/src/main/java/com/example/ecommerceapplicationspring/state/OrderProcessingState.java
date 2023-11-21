package com.example.ecommerceapplicationspring.state;

import com.example.ecommerceapplicationspring.model.Order;

public class OrderProcessingState implements OrderState {
    @Override
    public void process(Order order) {
        System.out.println("Order is being processed...");
        order.setState(new OrderShippedState());
    }

    @Override
    public void ship(Order order) {
        System.out.println("Cannot ship an order that is still processing.");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("Cannot deliver an order that is still processing.");
    }
}
