package com.example.userapplication.Services;

import com.example.userapplication.Excepction.CustomerNotFoundException;
import com.example.userapplication.Model.BankAccount;

public interface BankAccountService {
    public String createBankAccount(BankAccount bankAccount);

    public BankAccount getAccountByAccountNumber(Integer accountNumber) throws CustomerNotFoundException;
}
