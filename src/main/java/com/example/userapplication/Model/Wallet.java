package com.example.userapplication.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.transaction.Transaction;
import javax.validation.constraints.Min;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Wallet {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Min(value=0, message="Balance should be greate than 0")
    private Double balance;

}
