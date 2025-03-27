package com.example.project.System;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class MyController {

    private final ReservationService reservationService = new ReservationService();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/reserve")
    public String reserve(Model model) {
        return "reserve";
    }

    @PostMapping("/submitReservation")
    public String submitReservation(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String date,
            @RequestParam String time,
            @RequestParam String status,
            @RequestParam String rodzaj,
            @RequestParam(required = false) Integer groupSize) {

        Reservation reservation = new Reservation();
        reservation.setCustomerId(idCounter.getAndIncrement());
        reservation.setCustomerName(firstName);
        reservation.setCustomerSurname(lastName);
        reservation.setCustomerEmail(email);
        reservation.changeStatus((byte) 0);

        if ("Grupowa".equals(rodzaj) && groupSize != null) {
            reservation.setCustomerCount(groupSize);
        } else {
            reservation.setCustomerCount(1); // Dla rezerwacji samotnej domyślnie 1 osoba
        }

        String dateTime = date + "T" + time + ":00";
        reservation.setReservationTime(dateTime);

        reservationService.addReservation(reservation);
        System.out.println(reservation);

        return "redirect:/reserve?success=true";
    }
}

