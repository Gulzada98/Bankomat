package com.itbank.atm.dao;

import com.itbank.atm.model.BankAccount;
import com.itbank.atm.model.CityBankAccount;
import com.itbank.atm.model.NationalBankAccount;

import java.util.ArrayList;
import java.util.List;

public class Database {
    static List<BankAccount> bankAccountList = new ArrayList<>();
    static{
        bankAccountList.add(new CityBankAccount("Alex", "Robertson", 20000, "kz2441", "9999"));
        bankAccountList.add(new CityBankAccount("Mike", "Tacker", 40000, "kz2241", "2431"));
        bankAccountList.add(new CityBankAccount("Billy", "Elroy", 80000, "kz1441", "4432"));
        bankAccountList.add(new NationalBankAccount("Alihan Ibrashev", 4000000, "kz4521", "7777"));

        // Добавьте еще разных клиентов CityBankAccount и NationalBankAccount, чтобы их общая численность была не меньше 10
    }

    public static List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }
}
