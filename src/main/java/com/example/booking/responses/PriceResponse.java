package com.example.booking.responses;

import com.example.booking.entities.Room;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class PriceResponse {

    private Long id;
    private String startDate;
    private String endDate;
    private float amount;
    private Long idRoom;

    public PriceResponse() {
    }

    public PriceResponse(String startDate, String endDate, float amount, Long idRoom) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.idRoom = idRoom;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
