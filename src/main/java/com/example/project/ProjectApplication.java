package com.example.project;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjectApplication {

    private static boolean javafxStarted = false;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ProjectApplication.class)
                .headless(false)
                .run(args);

        // Zabezpieczenie przed wielokrotnym uruchomieniem JavaFX
        if (!javafxStarted) {
            javafxStarted = true;
            try {
                JavaFxApp.startApp(context);
            } catch (IllegalStateException e) {
                System.out.println("JavaFX już działa — kontynuuję backend!");
            }
        }
    }
}