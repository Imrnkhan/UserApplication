package com.example.userapplication.Services;

import com.example.userapplication.Excepction.CustomerExcepction;
import com.example.userapplication.Model.Customer;
import com.example.userapplication.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerServicesImpl implements CustomerServices{

    @Autowired
    private CustomerRepo custRepo;



    @Override
    public Customer saveCustomer(Customer customer) {
        Customer save = custRepo.save(customer);
        return save;
    }

//    --------------------------------------------

    @Override
    public Customer FindByUserId(Integer userId) throws CustomerExcepction {
        Optional<Customer> op = custRepo.findById(userId);
        if(op.isPresent()){
            Customer customer = op.get();
            return customer;
        }else {
            throw new CustomerExcepction("Customer not found"+userId);
        }
    }
}
