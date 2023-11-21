package com.example.ecommerceapplicationspring.services;

import com.example.ecommerceapplicationspring.factory.ProductTypeFactory;
import com.example.ecommerceapplicationspring.model.Product;
import com.example.ecommerceapplicationspring.model.dto.ProductDto;
import com.example.ecommerceapplicationspring.model.enums.ProductType;
import com.example.ecommerceapplicationspring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // singleton
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductTypeFactory productTypeFactory;

    public List<Product> findByProductType(String productType){
        return productRepository.findByProductType(productTypeFactory.defineProduct(productType));
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product createProduct(ProductDto productDto){
        Product product = Product.builder()
                        .name(productDto.getName())
                        .price(productDto.getPrice())
                                .productType(productTypeFactory.defineProduct(productDto.getProductType()))
                                        .build();
        productRepository.save(product);
        return product;
    }

    public Product createProduct(String name, int price, String type, String description){
        Product product = Product.builder()
                .name(name)
                .price(price)
                .description(description)
                .productType(productTypeFactory.defineProduct(type))
                .build();
        productRepository.save(product);
        return product;
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
}
// Service is a Singleton design pattern, because always spring will initialise only one instance of this class and after work with this class