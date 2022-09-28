package com.example.userapplication.Model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BankAccount {

    @Id
    private Integer accountNo;

    @NotNull
    @Pattern(regexp = "[0-9][a-z][A-Z]{5}", message="Invalid Ifsc Code Format Length: 6 and mixed of [0-9][a-z][A-Z]")
    private String ifscCode;

    @NotNull
    @Size(min=7, max =15, message="Bank Name must be min 7 and max 15")
    private String bankName;

    @NotNull
    @Min(0)
    private Double bankBalance;
    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Wallet.class)
    @JoinColumn(name="walletId")
    private Wallet wallet;


}
