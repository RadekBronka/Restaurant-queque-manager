package com.example.project.Pracownicy;

import com.example.project.System.Reservation;

public class Kelner extends Pracownik implements cancelReservation {
    private int napiwek;

    public Kelner() {
        super(0, "Jan", 1500 );
    }

    public Kelner(int napiwek) {
        super(0, "Jan", 1500 );
        this.napiwek = napiwek;
    }
    public Kelner(int id, String imie, int pensja, int napiwek){
        super(id,imie,pensja,napiwek);
    }

    public void cancelReservation(Reservation reservation, byte status) {
        reservation.changeStatus(status);
    }

}
