package com.example.userapplication.Services;

import com.example.userapplication.Excepction.CustomerExcepction;
import com.example.userapplication.Model.Customer;

public interface CustomerServices {
    public Customer saveCustomer(Customer customer);
public Customer FindByUserId(Integer userId)throws CustomerExcepction;

}
