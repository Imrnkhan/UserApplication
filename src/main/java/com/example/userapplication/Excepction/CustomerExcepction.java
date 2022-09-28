package com.example.userapplication.Excepction;

public class CustomerExcepction extends RuntimeException{

    public CustomerExcepction() {
    }

    public CustomerExcepction(String message) {
        super(message);
    }
}
