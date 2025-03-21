package com.example.project.controler;

import java.util.LinkedList;
import java.util.List;

public class Queue {
    private final List<String> reservations = new LinkedList<>();

    public int addPerson(String firstName, String lastName, String status) {
        String person = firstName + " " + lastName + " (" + status + ")";
        reservations.add(person);
        return reservations.size();
    }


    public int getSize() {
        return reservations.size();
    }
}

