package com.example.ecommerceapplicationspring.strategy;


import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.stereotype.Component;

@Component
public interface PaymentStrategy {
    boolean pay(int amount);
}
