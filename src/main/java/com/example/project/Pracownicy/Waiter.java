package com.example.project.Pracownicy;

import com.example.project.System.Reservation;

public class Waiter extends Employee implements cancelReservation, takeOrder {
    private int tip;

    public Waiter() {
        super(0, "Jan", 1500 );
    }

    public Waiter(int tip) {
        super(0, "Jan", 1500 );
        this.tip = tip;
    }
    public Waiter(int id, String imie, int pensja, int napiwek){
        super(id,imie,pensja,napiwek);
    }

    public void cancelReservation(Reservation reservation, byte status) {
        reservation.changeStatus(status);
    }

    public void cancel(){}
    public void takeOrder(){}

}
