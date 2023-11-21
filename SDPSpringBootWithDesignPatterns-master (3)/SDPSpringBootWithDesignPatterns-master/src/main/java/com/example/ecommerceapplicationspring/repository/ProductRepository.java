package com.example.ecommerceapplicationspring.repository;

import com.example.ecommerceapplicationspring.model.Product;
import com.example.ecommerceapplicationspring.model.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findByProductType(ProductType productType);
}

// The repository pattern is a design pattern that isolates the data layer from the rest of the app