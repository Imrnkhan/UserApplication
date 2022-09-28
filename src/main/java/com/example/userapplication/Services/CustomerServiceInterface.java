package com.example.userapplication.Services;

import com.example.userapplication.Model.Customer;
import com.example.userapplication.Model.Login;

public interface CustomerServiceInterface {
    public Customer addCustomer(Customer customer);
    public Customer persistCustomer(Integer customerID, Login login);
    public Customer getCustomerById(Integer customerId);

    public Customer findByUsernameAndPassword(String username, String password);

}
