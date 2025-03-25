package com.example.project.System;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reservation {

    @JsonProperty("customerId")
    private int customerId;

    @JsonProperty("customerCount")
    private int customerCount;

    @JsonProperty("customerNumber")
    private int customerNumber;

    @JsonProperty("customerName")
    private String customerName;

    @JsonProperty("customerSurname")
    private String customerSurname;

    @JsonProperty("customerEmail")
    private String customerEmail;

    @JsonProperty("reservationStatus")
    private byte reservationStatus;
    // 0 - oczekująca
    // 1 - zatwierdzona
    // 2 - anulowana

    // Domyślny konstruktor wymagany przez Jacksona
    public Reservation() {}

    // Gettery i settery muszą być PUBLICZNE!
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(int customerCount) {
        this.customerCount = customerCount;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public byte getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(byte reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    // Zmiana statusu rezerwacji
    public void changeStatus(byte nowyStatus) {
        this.reservationStatus = nowyStatus;
    }

    // Sprawdzenie, czy rezerwacja ma status "zatwierdzona"
    public boolean isActive() {
        return this.reservationStatus == 1;
    }
}
