package com.example.userapplication.Excepction;


public class LoginFailedException extends RuntimeException {
    public LoginFailedException (String message) {
        super(message);
    }
}
