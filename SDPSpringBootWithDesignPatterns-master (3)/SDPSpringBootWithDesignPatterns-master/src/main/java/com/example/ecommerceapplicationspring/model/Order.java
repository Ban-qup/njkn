package com.example.ecommerceapplicationspring.model;

import com.example.ecommerceapplicationspring.observer.OrderObserver;
import com.example.ecommerceapplicationspring.state.OrderState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Long orderId;

    private String customerName;
    private String shippingAddress;
    private Integer totalAmount;
    private boolean isPaid;
    private boolean isShipped;
    private boolean isDelivered;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Transient
    private OrderState state;

    // Constructors, getters, setters

    public void process() {
        state.process(this);
    }

    public void ship() {
        state.ship(this);
    }

    public void deliver() {
        state.deliver(this);
    }

    public void addItem(OrderItem item) {
        orderItems.add(item);
        item.setOrder(this);
        totalAmount += item.getProduct().getPrice();
    }

    public void removeItem(OrderItem item) {
        orderItems.remove(item);
        item.setOrder(null);
        totalAmount -= item.getProduct().getPrice();
    }


    @ManyToMany
    @JoinTable(
            name = "order_observer_mapping",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "observer_id")
    )
    private Set<User> observers = new HashSet<>();


    public void registerObserver(User observer) {
        observers.add(observer);
    }

    public void removeObserver(User observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", totalAmount=" + totalAmount +
                ", isPaid=" + isPaid +
                ", isShipped=" + isShipped +
                ", isDelivered=" + isDelivered +
                '}';
    }
}
