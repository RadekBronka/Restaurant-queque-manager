package com.example.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class MainPageController {
    WindowUtility windowUtility = new WindowUtility();

    public void onKelnerButton(ActionEvent actionEvent) {
        windowUtility.openNewWindow("/templates/kelner.fxml", "Kelner");
    }

    public void onKucharzButton(ActionEvent actionEvent) {
        windowUtility.openNewWindow("/templates/kucharz.fxml", "Kucharz");
    }

}
