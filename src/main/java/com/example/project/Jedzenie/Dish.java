package com.example.project.Jedzenie;

public class Dish extends Food {
    private boolean spicy;

    public Dish(){}
    public Dish(boolean spicy) {
        this.spicy = spicy;
    }
    public Dish(boolean spicy, String name, int cost, boolean vegetarian, boolean kidsMenu){
        super(name, cost, vegetarian, kidsMenu);
        this.spicy = spicy;
    }
    public boolean isSpicy() {
        return spicy;
    }
    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }
}
