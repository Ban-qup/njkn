package com.example.ecommerceapplicationspring;

import java.io.InputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Main extends Application {

    protected ConfigurableApplicationContext springContext;

    public static void main(final String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = springBootApplicationContext();
    }

    @Override
    public void start(Stage stage) throws Exception {
        byte[] array = new byte[10000];
        InputStream fxmlStream = getClass().getResourceAsStream("/fxml/Product.fxml");
        System.out.println("Line 32");
        fxmlStream.read(array);
        if (fxmlStream == null) {
            throw new IOException("FXML file not found");
        }
        System.out.println("Line 36");
        Parent parent = FXMLLoader.load(getClass().getResource("target/classes/fxml/Product.fxml"));
        System.out.println("Line 38");
        Scene scene = new Scene(parent, 1280, 720);
        System.out.println("Line 40");
        stage.setScene(scene);
        System.out.println("Line 42");
        stage.setTitle("Your Application Title");
        System.out.println("Line 44");
        stage.show();
        System.out.println("Line 46");

    }

    @Override
    public void stop() throws Exception {
        springContext.close();
    }

    private ConfigurableApplicationContext springBootApplicationContext() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
        String[] args = getParameters().getRaw().stream().toArray(String[]::new);
        return builder.run(args);
    }

}