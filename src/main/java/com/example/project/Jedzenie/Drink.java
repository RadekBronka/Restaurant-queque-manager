package com.example.project.Jedzenie;

public class Drink extends Food{
    private int volume;

    public Drink(){}

    public Drink(int volume){
        super("Picie", 10, false, false);
        this.volume = volume;
    }
    public Drink(int volume,String name, int cost, boolean vegetarian, boolean kidsMenu){
        super(name, cost, vegetarian, kidsMenu);
        this.volume = volume;
    }
}
