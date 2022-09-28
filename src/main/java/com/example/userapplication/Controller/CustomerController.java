package com.example.userapplication.Controller;

import com.example.userapplication.Model.Customer;
import com.example.userapplication.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

@Autowired
    private CustomerServices custmServices;



//save method post

@PostMapping("/customer")
    public Customer savaCustomerhandler(@RequestBody Customer customer){
    return custmServices.saveCustomer(customer);
}


//find by customer by userid

@GetMapping("/customer/{user}")
    public Customer CustomerfindById(@PathVariable("user") Integer user){
    return custmServices.FindByUserId((user));
}
}

