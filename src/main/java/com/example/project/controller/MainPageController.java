package com.example.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class MainPageController extends WindowUtility {


    public void onKelnerButton(ActionEvent actionEvent) {
        openNewWindow("/templates/kelner.fxml", "Kelner");
    }

    public void onKucharzButton(ActionEvent actionEvent) {
        openNewWindow("/templates/kucharz.fxml", "Kucharz");
    }

}
