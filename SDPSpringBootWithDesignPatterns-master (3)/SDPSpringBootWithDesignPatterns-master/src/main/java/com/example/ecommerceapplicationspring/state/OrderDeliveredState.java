package com.example.ecommerceapplicationspring.state;

import com.example.ecommerceapplicationspring.model.Order;

public class OrderDeliveredState implements OrderState {
    @Override
    public void process(Order order) {
        System.out.println("Cannot process an order that is already delivered.");

    }

    @Override
    public void ship(Order order) {
        System.out.println("Cannot ship an order that is already delivered.");

    }

    @Override
    public void deliver(Order order) {
        System.out.println("Order delivered");
    }
}
