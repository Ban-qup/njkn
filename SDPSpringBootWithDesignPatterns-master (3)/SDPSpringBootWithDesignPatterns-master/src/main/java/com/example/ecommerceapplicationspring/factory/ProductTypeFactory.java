package com.example.ecommerceapplicationspring.factory;


import com.example.ecommerceapplicationspring.model.enums.ProductType;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFactory {

    public ProductType defineProduct(String type){
        switch (type) {
            case "electronics":
                return ProductType.ELECTRONICS;
            case "toy":
                return ProductType.TOY;

            case "clothing":
                return ProductType.CLOTHING;
            default:
                return ProductType.OTHER;
        }
    }

}

// Factory pattern used to define Product Type for definition of Product when it will be searched, created
