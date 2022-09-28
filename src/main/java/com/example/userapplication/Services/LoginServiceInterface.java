package com.example.userapplication.Services;


import com.example.userapplication.Model.Customer;
import com.example.userapplication.Model.Login;
import com.example.userapplication.Model.UserDTO;

public interface LoginServiceInterface {

    public Customer login(UserDTO userInfo, String UserType);

    public Login isTokenValid(String token);

    public String logout(String key);

}
