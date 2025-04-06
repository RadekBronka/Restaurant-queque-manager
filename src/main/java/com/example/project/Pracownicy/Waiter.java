package com.example.project.Pracownicy;

import com.example.project.Jedzenie.Order;
import com.example.project.System.Reservation;

public class Waiter extends Employee implements cancelReservation {
    private int tip;

    public Waiter() {
        super(0, "Jan", 1500,"password" );
    }

    public Waiter(int tip) {
        super(0, "Jan", 1500,"password" );
        this.tip = tip;
    }
    public Waiter(int id, String imie, int pensja,String password){
        super(id,imie,pensja,password);
    }
    public Waiter(int id, String imie, int pensja,String password, int tip){
        super(id,imie,pensja,password);
        this.tip = tip;
    }

    public void cancelReservation(Reservation reservation,boolean status) {
        reservation.changeStatus(status);
    }

    public void cancelReservation(Reservation reservation) {
        reservation.changeStatus(false);
        System.out.println("Kelner " + getName() + " anulował rezerwację: " + reservation);
    }


}
