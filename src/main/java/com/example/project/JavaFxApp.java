package com.example.project;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApp extends Application {

    private static ConfigurableApplicationContext springContext;

    public static void startApp(ConfigurableApplicationContext context) {
        springContext = context;
        Application.launch();  // Uruchamiamy JavaFX tylko raz
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/templates/main-page.fxml"));
        Scene scene = new Scene(loader.load(), 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Restaurant Queue Manager");
        primaryStage.show();
    }

    @Override
    public void stop() {
        springContext.close();
        Platform.exit();
    }
}