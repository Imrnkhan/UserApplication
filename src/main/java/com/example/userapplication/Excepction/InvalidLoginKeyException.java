package com.example.userapplication.Excepction;



public class InvalidLoginKeyException extends RuntimeException {
    public InvalidLoginKeyException(String message) {
        super(message);
    }
}
