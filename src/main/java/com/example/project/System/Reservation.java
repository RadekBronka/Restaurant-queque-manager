package com.example.project.System;

public class Reservation {

    private int customerId;
    private int customerCount;
    private int customerNumber;
    private String customerName;
    private String customerSurname;
    private String customerEmail;
    private byte reservationStatus;
    //0- oczekujaca
    //1- zatwierdzona
    //2- anulowana

    public Reservation() {
    }

    //zmiana statusu rezerwacji
    //metoda do przepisania aby uwzględnić priorytet klienta
    void changeStatus(byte nowyStatus){
        reservationStatus = nowyStatus;
    }
    //sprawdzenie, czy rezerwacja ma status "zatwierdzona"
    boolean isActive(){
        if(reservationStatus == 1){
            return true;
        }
        return false;
    }

    void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    void setCustomerCount(int customerCount){
        this.customerCount = customerCount;
    }
    void setCustomerNumber(int customerNumber){
        this.customerNumber = customerNumber;
    }
    void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    void setCustomerSurname(String customerSurname){
        this.customerSurname = customerSurname;
    }
    void setCustomerEmail(String customerEmail){
        this.customerEmail = customerEmail;
    }
    int getCustomerId(){
        return customerId;
    }
    int getCustomerCount(){
        return customerCount;
    }
    int getCustomerNumber(){
        return customerNumber;
    }
    String getCustomerName(){
        return customerName;
    }
    String getCustomerSurname(){
        return customerSurname;
    }
    String getCustomerEmail(){
        return customerEmail;
    }
    byte getReservationStatus(){
        return reservationStatus;
    }




}
