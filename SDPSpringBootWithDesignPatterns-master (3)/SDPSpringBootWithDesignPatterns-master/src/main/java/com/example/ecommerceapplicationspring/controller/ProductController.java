package com.example.ecommerceapplicationspring.controller;

import com.example.ecommerceapplicationspring.model.Product;
import com.example.ecommerceapplicationspring.model.dto.ProductDto;
import com.example.ecommerceapplicationspring.services.ProductService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class ProductController {
    private final ProductService productService;

    @FXML
    private ListView<Product> productListView;

    @FXML
    private Button addNewProductButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private TextField typeField;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @FXML
    public void initialize() {
        // Initialize the product list view
        updateProductListView();

        // Set the action for the "Add New Product" button
        addNewProductButton.setOnAction(event -> addNewProduct());
    }

    private void updateProductListView() {
        List<Product> productList = productService.findAllProducts();
        ObservableList<Product> observableList = FXCollections.observableArrayList(productList);
        productListView.setItems(observableList);

        // Set the cell factory directly within the controller
        productListView.setCellFactory(param -> new ListCell<Product>() {
            private final HBox hbox = new HBox();
            private final Button deleteButton = new Button("Delete");

            {
                deleteButton.setOnAction(event -> {
                    Product product = getItem();
                    if (product != null) {
                        productService.deleteProductById(product.getProductid());
                        updateProductListView();
                    }
                });
            }

            @Override
            protected void updateItem(Product product, boolean empty) {
                super.updateItem(product, empty);

                if (empty || product == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    // Update the cell with product details
                    setText(product.getName() + " - $" + product.getPrice());
                    hbox.getChildren().clear();
                    hbox.getChildren().addAll(new HBox(), deleteButton);
                    setGraphic(hbox);
                }
            }
        });
    }

    @FXML
    private void addNewProduct() {
        String name = nameField.getText();
        int price = Integer.parseInt(priceField.getText());
        String description = descriptionArea.getText();
        String type = typeField.getText();

        productService.createProduct(name, price, description, type);

        // Clear input fields after adding a new product
        nameField.clear();
        priceField.clear();
        descriptionArea.clear();
        typeField.clear();

        // Update the product list view
        updateProductListView();
    }
}
