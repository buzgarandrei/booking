package com.example.booking.requests.special_requests;

public class RequestWithId {
    private Long id;

    public RequestWithId() {
    }

    public RequestWithId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
