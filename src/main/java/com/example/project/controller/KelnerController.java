package com.example.project.controller;

import com.example.project.Jedzenie.Dish;
import com.example.project.Jedzenie.Drink;
import com.example.project.Jedzenie.Food;
import com.example.project.Pracownicy.Waiter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
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
    public void setEmployee(Waiter waiter) {
        this.waiter = waiter;
    }

    public void onAnulujButton(ActionEvent actionEvent) {
        //waiter.cancelReservation();
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