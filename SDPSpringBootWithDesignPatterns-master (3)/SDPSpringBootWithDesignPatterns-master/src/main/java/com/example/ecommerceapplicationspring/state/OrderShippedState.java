package com.example.ecommerceapplicationspring.state;

import com.example.ecommerceapplicationspring.model.Order;
import org.springframework.stereotype.Component;


@Component
public class OrderShippedState implements OrderState {
    @Override
    public void process(Order order) {
        System.out.println("Cannot process an order that is already shipped.");
    }

    @Override
    public void ship(Order order) {
        System.out.println("Order is being shipped...");
        order.setState(new OrderDeliveredState());
    }

    @Override
    public void deliver(Order order) {
        System.out.println("Cannot deliver an order that is not yet shipped.");
    }
}
