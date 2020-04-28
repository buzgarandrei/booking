package com.example.booking.entities;

import com.example.booking.utils.KindOfBed;

import javax.persistence.*;

@Entity
@Table(name = "bed_type")
public class BedType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "kind_of_bed")
    @Enumerated(EnumType.STRING)
    private KindOfBed kindOfBed;

    // no. of persons that fits in this kind of bed
    @Column(name = "no_of_persons")
    private int noOfPersons;


    public BedType() {
    }

    public BedType(KindOfBed kindOfBed, int noOfPersons) {
        this.kindOfBed = kindOfBed;
        this.noOfPersons = noOfPersons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KindOfBed getKindOfBed() {
        return kindOfBed;
    }

    public void setKindOfBed(KindOfBed kindOfBed) {
        this.kindOfBed = kindOfBed;
    }

    public int getNoOfPersons() {
        return noOfPersons;
    }

    public void setNoOfPersons(int noOfPersons) {
        this.noOfPersons = noOfPersons;
    }
}
