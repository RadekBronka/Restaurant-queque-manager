package com.example.project.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {
        welcomeLabel.setText("Witaj w systemie rezerwacji!");
    }

    public void handleClick() {
        welcomeLabel.setText("Kliknięcie działa — Spring Boot + JavaFX razem 🎉");
    }
}