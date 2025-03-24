package com.example.project.System;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private static final String FILE_PATH = "DataBase.json";
    private List<Reservation> reservations;

    public ReservationService() {
        this.reservations = loadReservations();
    }

    private List<Reservation> loadReservations() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try {
            return objectMapper.readValue(file, new TypeReference<List<Reservation>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void saveReservations() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), reservations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        saveReservations();
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
