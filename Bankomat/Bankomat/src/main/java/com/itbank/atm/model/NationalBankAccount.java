package com.itbank.atm.model;

public class NationalBankAccount extends BankAccount{
    private String fullname;

    public NationalBankAccount(String fullname, Integer balance, String accountNumber, String pinCode) {
        super(balance, accountNumber, pinCode);
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "NationalBankAccount{" +
                "fullname='" + fullname + '\'' +
                '}';
    }
}
