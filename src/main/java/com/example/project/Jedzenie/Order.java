package com.example.project.Jedzenie;

public class Order {
    private String name;
    private int table;
    private boolean vip;

    public Order() {}
    public Order(String name, int table, boolean vip) {
        this.name = name;
        this.table = table;
        this.vip = vip;
    }
    public String getName() {
        return name;
    }
    public int getTable() {
        return table;
    }
    public boolean isVip() {
        return vip;
    }

}
