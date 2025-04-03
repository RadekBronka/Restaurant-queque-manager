package com.example.project.System;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Reservation {
    @JsonIgnore
    private boolean active;

    @JsonProperty("customerId")
    private int customerId;
    @JsonProperty("customerNumber")
    private int customerNumber;

    @JsonProperty("reservationType")
    private String reservationType;

    @JsonProperty("customerCount")
    private int customerCount;

    @JsonProperty("customerName")
    private String customerName;

    @JsonProperty("customerSurname")
    private String customerSurname;

    @JsonProperty("customerEmail")
    private String customerEmail;

    @JsonProperty("reservationRank")
    private String reservationRank;

    @JsonProperty("reservationTime")
    private String reservationTime;

    @JsonProperty("reservationDate")
    private String reservationDate;

    @JsonProperty("reservationStatus")
    private boolean reservationStatus;


    public Reservation() {}

    public Reservation(int customerId, int customerNumber, String reservationType, int customerCount,
                       String customerName, String customerSurname, String customerEmail, String reservationRank,
                       String reservationTime, String reservationDate, boolean reservationStatus) {
        this.customerId = customerId;
        this.customerNumber = customerNumber;
        this.reservationType = reservationType;
        this.customerCount = customerCount;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerEmail = customerEmail;
        this.reservationRank = reservationRank;
        this.reservationTime = reservationTime;
        this.reservationDate = reservationDate;
        this.reservationStatus = reservationStatus;
    }

    // Nadpisanie toString(), aby ComboBox wyświetlał czytelne informacje
    @Override
    public String toString() {
        return reservationTime + " - " + customerName + " " + customerSurname;
    }

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

    public boolean getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(boolean reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    // Zmiana statusu rezerwacji
    public void changeStatus(boolean nowyStatus) {
        this.reservationStatus = nowyStatus;
    }

    // Sprawdzenie, czy rezerwacja ma status "zatwierdzona"
    public boolean isActive() {
        return this.reservationStatus == true;
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

    public void setReservationType(String reservationType) {
        this.reservationType = reservationType;
    }
    public String getReservationType() {
        return this.reservationType;
    }
}
