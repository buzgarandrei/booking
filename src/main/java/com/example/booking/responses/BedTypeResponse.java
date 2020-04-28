package com.example.booking.responses;

public class BedTypeResponse {

    private int id;
    private String kindOfBed;
    private int noOfPersons;

    public BedTypeResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKindOfBed() {
        return kindOfBed;
    }

    public void setKindOfBed(String kindOfBed) {
        this.kindOfBed = kindOfBed;
    }

    public int getNoOfPersons() {
        return noOfPersons;
    }

    public void setNoOfPersons(int noOfPersons) {
        this.noOfPersons = noOfPersons;
    }
}
