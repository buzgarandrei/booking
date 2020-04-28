package com.example.booking.utils;

public class StateResponse {
    private boolean success;

    public StateResponse() {
    }

    public StateResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
