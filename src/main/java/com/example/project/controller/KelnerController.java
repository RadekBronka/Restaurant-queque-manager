package com.example.project.controller;

import com.example.project.Jedzenie.Dish;
import com.example.project.Jedzenie.Drink;
import com.example.project.Jedzenie.Food;
import com.example.project.Pracownicy.Waiter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import com.example.project.System.Reservation;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class KelnerController extends WindowUtility {
    private Waiter waiter;
    @FXML
    private Label welcomeLabel;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button exitButton;
    @FXML
    private ComboBox<Reservation> reservationBox; // ComboBox przechowuje obiekty Reservation
    @FXML
    private CheckBox klientVip;
    @FXML
    private Label imieLabel;
    @FXML
    private ComboBox<Food> daniaBox;
    private List<Reservation> reservations = new ArrayList<>();
    private List<Food> food = new ArrayList<>();



    @FXML
    public void initialize() {
        //Utworzenie kilku obiektów klas dziedziczących po Food i umieszczenie ich w liście
        food.add(new Drink(330,"CocaCola",7,true,false));
        food.add(new Drink(500,"SokPomaranczowy",6,true,true));
        food.add(new Dish(false,"Pierogi",20,false,false));
        //wyswietlanie w comboBox
        daniaBox.setItems(FXCollections.observableArrayList(food));
    }

    @FXML
    public void onDatePicker(ActionEvent event) {
        loadReservationsFromJson();
        LocalDate selectedDate = datePicker.getValue();
        if (selectedDate == null) return;

        String selectedDateStr = selectedDate.toString();

        // Filtrujemy rezerwacje, ale najpierw sprawdzamy, czy reservationDate nie jest nu ll
        List<Reservation> filtered = reservations.stream()
                .filter(r -> r.getReservationDate() != null && r.getReservationDate().equals(selectedDateStr) && r.getReservationStatus())
                .sorted((r1, r2) -> r1.getReservationTime().compareTo(r2.getReservationTime()))
                .collect(Collectors.toList());

        reservationBox.setItems(FXCollections.observableArrayList(filtered));

        System.out.println("Znaleziono rezerwacje: " + filtered.size());
    }

    private void loadReservationsFromJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String filePath = "src/main/resources/DataBase.json"; // ten sam jak przy zapisie
            java.io.File file = new java.io.File(filePath);

            if (file.exists()) {
                reservations = objectMapper.readValue(file, new TypeReference<List<Reservation>>() {});
                System.out.println("Załadowano rezerwacje: " + reservations.size());
            } else {
                System.out.println("Nie znaleziono pliku DataBase.json!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void saveReservationsToJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Ścieżka do pliku - zakładamy, że masz uprawnienia do zapisu w tym miejscu
            String filePath = "src/main/resources/DataBase.json";
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new java.io.File(filePath), reservations);
            System.out.println("Zapisano zaktualizowane rezerwacje do pliku.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Błąd podczas zapisu do pliku JSON.");
        }
    }

    public void setEmployee(Waiter waiter) {
        this.waiter = waiter;
        imieLabel.setText(waiter.getName());
    }

    public void onAnulujButton(ActionEvent actionEvent) {
        Reservation selectedReservation = reservationBox.getSelectionModel().getSelectedItem();
        if (selectedReservation != null) {
            waiter.cancelReservation(selectedReservation);

            saveReservationsToJson();
        } else {
            System.out.println("Nie wybrano rezerwacji do anulowania.");
        }
    }

    public void onDaniaBox(ActionEvent actionEvent) {
    }

    public void onKlientVip(ActionEvent actionEvent) {
    }

    public void onZatwierdzButton(ActionEvent actionEvent) {
    }

    public void onExitButton(ActionEvent actionEvent) {
        closeWindow(actionEvent);
    }
}