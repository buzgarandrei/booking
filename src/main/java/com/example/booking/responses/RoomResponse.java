package com.example.booking.responses;

public class RoomResponse {

    private Long id;
    private int nrOfAdults;
    private int nrOfKids;
    private Long idHotel;
    private Boolean available;

    public RoomResponse() {
    }

    public RoomResponse(Long id, int nrOfAdults, int nrOfKids, Long idHotel, Boolean available) {
        this.id = id;
        this.nrOfAdults = nrOfAdults;
        this.nrOfKids = nrOfKids;
        this.idHotel = idHotel;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNrOfAdults() {
        return nrOfAdults;
    }

    public void setNrOfAdults(int nrOfAdults) {
        this.nrOfAdults = nrOfAdults;
    }

    public int getNrOfKids() {
        return nrOfKids;
    }

    public void setNrOfKids(int nrOfKids) {
        this.nrOfKids = nrOfKids;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Boolean isAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
