package com.example.ecommerceapplicationspring.controller;


import com.example.ecommerceapplicationspring.model.Product;
import com.example.ecommerceapplicationspring.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
@RequiredArgsConstructor
public class CatalogController {
    private final ProductService productService;

    @GetMapping("/fuhehe")
    public ResponseEntity<List<Product>> findAll(){
        System.out.println(productService.findAllProducts());
        return ResponseEntity.ok( productService.findAllProducts());
    }
}

