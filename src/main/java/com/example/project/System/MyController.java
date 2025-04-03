package com.example.project.System;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
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
    @GetMapping("/reservationdetails")
    public String reservationdetails(Model model) {
        return "reservationdetails";
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
            @RequestParam(required = false) Integer groupSize,
            Model model) {


        // Tworzenie nowej rezerwacji
        Reservation reservation = new Reservation();
        reservation.setCustomerId(idCounter.getAndIncrement());
        reservation.setCustomerName(firstName);
        reservation.setCustomerSurname(lastName);
        reservation.setCustomerEmail(email);
        reservation.changeStatus((byte) 0);
        reservation.setReservationRank(status);
        reservation.setReservationType(rodzaj);
        int randomNumber = ThreadLocalRandom.current().nextInt(100000, 1000000);
        reservation.setCustomerNumber(randomNumber);

        if ("Grupowa".equals(rodzaj) && groupSize != null) {
            reservation.setCustomerCount(groupSize);
        } else {
            reservation.setCustomerCount(1);
        }

        reservation.setReservationTime(time);
        reservation.setReservationDate(date);
        // Pobranie godziny z czasu "HH:mm"
        int hour = Integer.parseInt(time.split(":")[0]);

        // Sprawdzenie dostępności stolika
        if (!reservationService.emptyTable(date, hour,reservation.getCustomerCount())) {
            return "redirect:/?full=true";
        }
        model.addAttribute("reservation", reservation);
        reservationService.addReservation(reservation);

        return "/reservationdetails";
    }

    @PostMapping("/find")
    public String find(@RequestParam int ReservationNumber,Model model) {
        Reservation foundReservation = reservationService.findReservationByNumber(ReservationNumber);
        if (foundReservation != null) {
            model.addAttribute("reservation",foundReservation);
            return "/reservationdetails";
        }
        else {
            return "redirect:/reserve?notfound=true";
        }

    }
}

