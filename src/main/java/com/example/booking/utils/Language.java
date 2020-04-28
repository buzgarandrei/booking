package com.example.booking.utils;

public enum Language {

    EN(0),
    RO(1),
    FR(2),
    DE(3),
    GR(4);


    private int id;
    Language() {
    }

    Language(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
