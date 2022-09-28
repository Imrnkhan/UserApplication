package com.example.userapplication.Model;

public class BankAccounts {
    private  int SavingAccount;
    private int CurrentAccount;
    private int LoanAccount;

    @Override
    public String toString() {
        return "BankAccount{" +
                "SavingAccount=" + SavingAccount +
                ", CurrentAccount=" + CurrentAccount +
                ", LoanAccount=" + LoanAccount +
                '}';
    }

    public int getSavingAccount() {
        return SavingAccount;
    }

    public void setSavingAccount(int savingAccount) {
        SavingAccount = savingAccount;
    }

    public int getCurrentAccount() {
        return CurrentAccount;
    }

    public void setCurrentAccount(int currentAccount) {
        CurrentAccount = currentAccount;
    }

    public int getLoanAccount() {
        return LoanAccount;
    }

    public void setLoanAccount(int loanAccount) {
        LoanAccount = loanAccount;
    }

    public BankAccounts(int savingAccount, int currentAccount, int loanAccount) {
        SavingAccount = savingAccount;
        CurrentAccount = currentAccount;
        LoanAccount = loanAccount;
    }
}
