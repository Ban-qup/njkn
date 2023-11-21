package com.example.ecommerceapplicationspring.strategy;


import org.springframework.stereotype.Component;

@Component
public class CreditCardPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean pay(int amount) {
        System.out.println("Processing credit card Payment....");
        return true;
    }
}
