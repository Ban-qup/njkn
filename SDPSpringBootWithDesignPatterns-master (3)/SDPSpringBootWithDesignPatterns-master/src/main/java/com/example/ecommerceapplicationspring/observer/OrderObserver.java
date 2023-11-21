package com.example.ecommerceapplicationspring.observer;

import com.example.ecommerceapplicationspring.model.Order;
import org.springframework.stereotype.Component;

@Component
public interface OrderObserver {
    void update(Order order);
}
