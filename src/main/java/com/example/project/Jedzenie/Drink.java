package com.example.project.Jedzenie;

public class Drink extends Food{
    private int volume;

    public Drink(){}

    public Drink(int volume){
        super(10, false, false);
        this.volume = volume;
    }
    public Drink(int volume, int cost, boolean vegetarian, boolean kidsMenu){
        super(cost, vegetarian, kidsMenu);
        this.volume = volume;
    }
}
