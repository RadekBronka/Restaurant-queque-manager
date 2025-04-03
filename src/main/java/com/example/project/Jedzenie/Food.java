package com.example.project.Jedzenie;

public class Food {
    private String name;
    private int cost;
    private boolean vegetarian;
    private boolean kidsMenu;

    public Food(){};

    public Food(String name,int cost, boolean vegetarian, boolean kidsMenu) {
        this.name = name;
        this.cost = cost;
        this.vegetarian = vegetarian;
        this.kidsMenu = kidsMenu;
    }

    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
    public boolean isKidsMenu() {
        return kidsMenu;
    }
    public void setKidsMenu(boolean kidsMenu) {
        this.kidsMenu = kidsMenu;
    }
    //uzywane przy wyswietlaniu w comboBox w kontrolerze
    public String toString() {
        return this.name;
    }
}
