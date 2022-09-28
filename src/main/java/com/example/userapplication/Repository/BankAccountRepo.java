package com.example.userapplication.Repository;

import com.example.userapplication.Model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepo extends JpaRepository<BankAccount, Integer> {

}