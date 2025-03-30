package com.example.project.System;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationService {
    private static final String FILE_PATH = "src/main/resources/DataBase.json";
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
    public Reservation findReservationByNumber(int reservationNumber) {
        return reservations.stream()
                .filter(reservation -> reservation.getCustomerNumber() == reservationNumber)
                .findFirst()
                .orElse(null);
    }
    public List<Reservation> findReservationsByDateAndHour(String date, int hour,int customerCount) {
        return reservations.stream()
                .filter(reservation -> reservation.getReservationDate() != null && reservation.getReservationDate().equals(date))
                .filter(reservation -> {
                    if (reservation.getReservationTime() == null) return false;
                    String[] timeParts = reservation.getReservationTime().split(":");
                    int reservationHour = Integer.parseInt(timeParts[0]);
                    return reservationHour == hour;
                })
                .filter(reservation -> reservation.getCustomerCount() == customerCount)
                .collect(Collectors.toList());
    }
    public List<Reservation> findReservationsBycustomerCount(int customerCount) {
        return reservations.stream()
                .filter(reservation -> reservation.getCustomerCount() == customerCount)
                .collect(Collectors.toList());
    }


    public boolean emptyTable(String date, int hour, int customerCount) {
        return findReservationsByDateAndHour(date, hour,customerCount).size() < 1;
    }




    public List<Reservation> getReservations() {
        return reservations;
    }
}
