package com.example.reservas.util.exceptions;

public class BadIdException extends RuntimeException {
    public BadIdException(String name) {
        super(name);
    }
}
