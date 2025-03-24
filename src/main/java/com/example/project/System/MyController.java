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
            @RequestParam String rodzaj,
            @RequestParam(required = false, defaultValue = "1") int groupSize) {

        Reservation reservation = new Reservation();
        reservation.setCustomerId(idCounter.getAndIncrement());
        reservation.setCustomerName(firstName);
        reservation.setCustomerSurname(lastName);
        reservation.setCustomerEmail(email);
        reservation.setCustomerCount(groupSize);
        reservation.changeStatus((byte) 0);

        String dateTime = date + "T" + time + ":00";
        reservation.setCustomerNumber(LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME).getHour());

        reservationService.addReservation(reservation);

        return "redirect:/reserve?success=true";
    }
}
