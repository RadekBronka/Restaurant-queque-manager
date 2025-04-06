package com.example.project.Jedzenie;

public class Order {
    private Food food;
    private int table;
    private boolean vip;

    public Order() {}
    public Order(Food food, int table, boolean vip) {
        this.food = food;
        this.table = table;
        this.vip = vip;
    }
    public String getName() {
        return food.toString();
    }
    public int getTable() {
        return table;
    }
    public boolean isVip() {
        return vip;
    }

}
