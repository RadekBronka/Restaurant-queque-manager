package com.example.project.controller;

import com.example.project.Pracownicy.Cook;
import com.example.project.Pracownicy.Employee;
import com.example.project.Pracownicy.Waiter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowUtility {


    //zamykanie okna
    void closeWindow(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }
    //otwierania nowego okna
    void openNewWindow(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void openNewWindowWithData(String fxmlPath, String title, Employee employee) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            // Pobranie kontrolera i przekazanie danych
            Object controller = loader.getController();
            if (controller instanceof KelnerController && employee instanceof Waiter) {
                ((KelnerController) controller).setEmployee((Waiter) employee);
            } else if (controller instanceof KucharzController && employee instanceof Cook) {
                ((KucharzController) controller).setEmployee((Cook) employee);
            }

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
