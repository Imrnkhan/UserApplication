package com.example.userapplication.Services;


import com.example.userapplication.Excepction.CustomerNotFoundException;
import com.example.userapplication.Model.BankAccount;

import com.example.userapplication.Repository.BankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepo bankAccRepo;


    @Override
    public String createBankAccount(BankAccount bankAccount) {
        return null;
    }

    @Override
    public BankAccount getAccountByAccountNumber(Integer accountNumber) throws CustomerNotFoundException {
        return null;
    }
}