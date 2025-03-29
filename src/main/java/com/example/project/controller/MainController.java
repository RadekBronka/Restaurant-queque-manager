package com.example.project.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;
import javafx.scene.control.DatePicker;
import com.example.project.System.Reservation;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MainController {

    @FXML
    private Label welcomeLabel;
    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<Reservation> reservationBox; // ComboBox przechowuje obiekty Reservation

    private List<Reservation> reservations = new ArrayList<>();

    @FXML
    public void initialize() {
        loadReservationsFromJson();
    }

    public void handleClick() {
        welcomeLabel.setText("Kliknięcie działa — Spring Boot + JavaFX razem 🎉");
    }

    @FXML
    public void onDatePicker(ActionEvent event) {
        loadReservationsFromJson();
        LocalDate selectedDate = datePicker.getValue();
        if (selectedDate == null) return;

        String selectedDateStr = selectedDate.toString();

        // Filtrujemy rezerwacje, ale najpierw sprawdzamy, czy reservationDate nie jest nu ll
        List<Reservation> filtered = reservations.stream()
                .filter(r -> r.getReservationDate() != null && r.getReservationDate().equals(selectedDateStr))
                .sorted((r1, r2) -> r1.getReservationTime().compareTo(r2.getReservationTime()))
                .collect(Collectors.toList());

        reservationBox.setItems(FXCollections.observableArrayList(filtered));

        System.out.println("Znaleziono rezerwacje: " + filtered.size());
    }

    private void loadReservationsFromJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("DataBase.json");

            if (inputStream != null) {
                reservations = objectMapper.readValue(inputStream, new TypeReference<List<Reservation>>() {});
                System.out.println("Załadowano rezerwacje: " + reservations.size());
            } else {
                System.out.println("Nie znaleziono pliku reservations.json!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}