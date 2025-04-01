package com.example.project.Pracownicy;

public class Pracownik {
    private int id;
    private String imie;
    private int pensja;
    public Pracownik() {}

    public Pracownik(int id, String imie, int pensja, int napiwek) {}

    public Pracownik(int id, String imie, int pensja) {
        this.id = id;
        this.imie = imie;
        this.pensja = pensja;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public int getPensja() {
        return pensja;
    }
    public void setPensja(int pensja) {
        this.pensja = pensja;
    }


}
