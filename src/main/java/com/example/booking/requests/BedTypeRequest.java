package com.example.booking.requests;

public class BedTypeRequest {

    private int id;
    private String kindOfBed;
    private int noOfPersons;

    public BedTypeRequest() {
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
