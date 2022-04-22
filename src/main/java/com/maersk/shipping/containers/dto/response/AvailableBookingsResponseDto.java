package com.maersk.shipping.containers.dto.response;

public class AvailableBookingsResponseDto {
    private boolean available;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
