package com.example.userapplication.Excepction;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
