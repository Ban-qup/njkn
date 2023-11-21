package com.example.ecommerceapplicationspring.strategy;


import org.springframework.stereotype.Component;

@Component
public class GooglePayPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(int amount) {
        System.out.println("Proccessing google pay payment");
        return true;
    }
}
