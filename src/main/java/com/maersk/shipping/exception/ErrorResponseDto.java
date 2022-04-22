package com.maersk.shipping.exception;

public class ErrorResponseDto {
    private final String message;

    public String getMessage() {
        return message;
    }

    public ErrorResponseDto(String message) {
        this.message = message;
    }
}
