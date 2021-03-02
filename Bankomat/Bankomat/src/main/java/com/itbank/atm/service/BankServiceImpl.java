package com.itbank.atm.service;

import com.itbank.atm.dao.Database;
import com.itbank.atm.model.BankAccount;

import java.util.List;

public class BankServiceImpl implements BankService {

    @Override
    public BankAccount getClient(String accountNumber, String pincode) {
        BankAccount client = null;
        for (BankAccount account : Database.getBankAccountList()) {
            if (account.getAccountNumber().equals(accountNumber) && account.getPinCode().equals(pincode)) {
                client = account;
                break;
            }
        }
        return client;
    }

    @Override
    public String getAccountNumber(BankAccount client) {
        return client.getAccountNumber();
    }

    @Override
    public String getPinCode(BankAccount client) {
        return client.getPinCode();
    }

    @Override
    public void setPinCode(BankAccount client, String pinCode) {
        if (pinCode.length() == 4) {
            client.setPinCode(pinCode);
            System.out.println("Your pinCode changed successfully");
        } else {
            System.out.println("PinCode Length must be 4");
        }
    }

    @Override
    public Integer totalBalance(BankAccount client) {
        return client.getBalance();
    }

    @Override
    public void withdrawal(BankAccount client, Integer money) {
        if (client.getBalance() >= money) {
            client.setBalance(client.getBalance() - money);
        } else {
            System.out.println("Clients total balance is less than money");
        }
    }

    @Override
    public void replenishment(BankAccount client, Integer money) {
        client.setBalance(client.getBalance() + money);
    }

    @Override
    public String accountData(BankAccount client) {
        return client.toString();
    }
}
