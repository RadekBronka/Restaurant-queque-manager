package com.example.project.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;
import javafx.scene.control.DatePicker;
import com.example.project.System.Reservation;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KucharzController {
    WindowUtility windowUtility = new WindowUtility();
    @FXML
    private Button exitButton;

    public void onWydajButton(ActionEvent actionEvent) {
    }
    public void onExitButton(ActionEvent actionEvent) {
        windowUtility.closeWindow(actionEvent);
    }
}
