package com.example.project.controller;

import com.example.project.Jedzenie.Order;
import com.example.project.Pracownicy.Cook;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.charts.Legend;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.stereotype.Component;
import com.example.project.System.Reservation;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KucharzController extends WindowUtility{

    private Cook cook;

    @FXML
    private Button exitButton;
    @FXML
    public ListView zamowieniaList;

    private List<Order> orders = new ArrayList<>();

    @FXML
    public void initialize() {
        loadOrdersFromJson();
        wyswietlZamowienia();
    }

    public void onWydajButton(ActionEvent actionEvent) {
        int selectedIndex = zamowieniaList.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0 && selectedIndex < orders.size()) {
            Order removedOrder = orders.remove(selectedIndex);
            System.out.println("Usunięto zamówienie: " + removedOrder);
            saveOrdersToJson();
            wyswietlZamowienia();
        } else {
            System.out.println("Błędny wybór");
        }
    }
    public void onExitButton(ActionEvent actionEvent) {
        closeWindow(actionEvent);
    }
    
    public void setEmployee(Cook cook) {
        this.cook = cook;
    }

    private void wyswietlZamowienia() {
        // Tworzymy listę opisów zamówień
        List<String> orderDescriptions = orders.stream()
                .map(order -> "Stolik: " + order.getTable() +
                        ", " + order.getName() +
                        ", VIP: " + (order.isVip() ? "Tak" : "Nie"))
                .collect(Collectors.toList());

        // Ustawiamy listę w ListView
        zamowieniaList.setItems(FXCollections.observableArrayList(orderDescriptions));
    }

    private void loadOrdersFromJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String filePath = "src/main/resources/Orders.json";
            File file = new File(filePath);

            if (file.exists()) {
                orders = objectMapper.readValue(file, new TypeReference<List<Order>>() {});
                System.out.println("Załadowano zamówienia: " + orders.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveOrdersToJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String filePath = "src/main/resources/Orders.json";
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), orders);
            System.out.println("Zapisano zaktualizowaną listę zamówień.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
