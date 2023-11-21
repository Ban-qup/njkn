package com.example.ecommerceapplicationspring.state;

import com.example.ecommerceapplicationspring.model.Order;
import org.springframework.stereotype.Component;


@Component
public interface OrderState {
    void process(Order order);
    void ship(Order order);
    void deliver(Order order);
}
