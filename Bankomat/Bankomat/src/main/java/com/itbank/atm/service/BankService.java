package com.itbank.atm.service;

import com.itbank.atm.model.BankAccount;
// alt+Enter -> implementation
public interface BankService {

    BankAccount getClient(String accountNumber, String pincode);
    //Данный метод ищет и возвращает клиента из базы данных Database.java
    String getAccountNumber(BankAccount client);
    //Данный метод возвращает номер счета
    String getPinCode(BankAccount client); //Данный метод возвращает пин код карточки
    void setPinCode(BankAccount client, String pinCode); //Данный метод меняет пин код карточки
    Integer totalBalance(BankAccount client); //Данный метод возвращает текущий баланс
    void withdrawal(BankAccount client, Integer money); //Данный метод мы используем при снятии денег со счета
    void replenishment(BankAccount client, Integer money); // Данный метод мы используем при добавлении денег к счету
    String accountData(BankAccount client); //Данный метод возвращает данные о клиенте
}
