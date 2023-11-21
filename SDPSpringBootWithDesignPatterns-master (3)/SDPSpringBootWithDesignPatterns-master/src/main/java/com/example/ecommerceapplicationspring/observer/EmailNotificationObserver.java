package com.example.ecommerceapplicationspring.observer;

import com.example.ecommerceapplicationspring.model.Order;

public class EmailNotificationObserver implements OrderObserver{
    @Override
    public void update(Order order) {
        System.out.println("Order state was changed " + order.getState() + " " + order.getOrderId());
    }
}
