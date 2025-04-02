package com.example.project.controller;

import com.example.project.Pracownicy.Cook;
import com.example.project.Pracownicy.Employee;
import com.example.project.Pracownicy.Waiter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainPageController extends WindowUtility {
    @FXML
    private TextField hasloTextField;
    @FXML
    private TextField idTextField;

    //symulowana baza danych z pracownikami
    private static final List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Waiter(1, "Jan", 3000, "jan123"));
        employees.add(new Cook(2, "Krzysztof", 4000, "krzysztof123"));
    }

    private Employee findEmployeeById(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null; // Zwracamy null, jeśli nie znaleziono pracownika
    }

    public void onKelnerButton(ActionEvent actionEvent) {
        openNewWindow("/templates/kelner.fxml", "Kelner");
    }

    public void onKucharzButton(ActionEvent actionEvent) {
        openNewWindow("/templates/kucharz.fxml", "Kucharz");
    }


    public void onZalogujButton(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(idTextField.getText());
            String password = hasloTextField.getText();
            Employee employee = findEmployeeById(id);  // Znajdź pracownika na podstawie ID

            // Jeśli pracownik istnieje i hasło się zgadza
            if (employee != null && employee.getPassword().equals(password)) {
                if (employee instanceof Waiter) {
                    openNewWindowWithData("/templates/kelner.fxml", "Kelner", employee);
                } else if (employee instanceof Cook) {
                    openNewWindowWithData("/templates/kucharz.fxml", "Kucharz", employee);
                }
            } else {
                System.out.println("Błąd logowania, Nieprawidłowe ID lub hasło.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Błąd, ID musi być liczbą.");
        }
    }

    public void onHasloTextField(ActionEvent actionEvent) {
    }

    public void onIDTextField(ActionEvent actionEvent) {
    }
}
