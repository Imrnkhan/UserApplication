package com.example.userapplication.Services;


import com.example.userapplication.Model.Customer;
import com.example.userapplication.Model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements CustomerServiceInterface {

    @Override
    public Customer addCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer persistCustomer(Integer customerID, Login login) {
        return null;
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return null;
    }

    @Override
    public Customer findByUsernameAndPassword(String username, String password) {
        return null;
    }

    public Customer persistSeller(String username, Login newLogin) {
        return null;
    }
}
