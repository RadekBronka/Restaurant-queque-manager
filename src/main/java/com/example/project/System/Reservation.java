package com.example.project.System;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Reservation {
    @JsonIgnore
    private boolean active;

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

    @JsonProperty("reservationRank")
    private String reservationRank;
    @JsonProperty("reservationStatus")
    private byte reservationStatus;

    @JsonProperty("reservationTime")
    private String reservationTime;

    @JsonProperty("reservationDate")
    private String reservationDate;

    public Reservation() {}

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
    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }
    public String getReservationTime() {
        return this.reservationTime;
    }
    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;

    }
    public String getReservationDate() {
        return this.reservationDate;
    }
    public void setReservationRank(String reservationRank) {
        this.reservationRank = reservationRank;
    }
    public String getReservationRank() {
        return this.reservationRank;
    }
}
