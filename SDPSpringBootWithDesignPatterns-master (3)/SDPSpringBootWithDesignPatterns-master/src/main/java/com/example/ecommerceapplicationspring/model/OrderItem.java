package com.example.ecommerceapplicationspring.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderitem")
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderitemid")
    private Long orderitemid;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "orderid")
    private Order order;

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderitemid=" + orderitemid +
                ", quantity=" + quantity +
                '}';
    }
}
