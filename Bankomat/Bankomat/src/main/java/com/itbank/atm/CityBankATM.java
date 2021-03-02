package com.itbank.atm;

import com.itbank.atm.dao.Database;
import com.itbank.atm.model.BankAccount;
import com.itbank.atm.model.CityBankAccount;
import com.itbank.atm.service.BankService;
import com.itbank.atm.service.BankServiceImpl;

import java.util.List;
import java.util.Scanner;

public class CityBankATM {
    public static void main(String[] args) {

        BankService service = new BankServiceImpl();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your accountNumber");
        String accountNumber = input.nextLine();

        System.out.println("Enter pinCode");
        String pinCode = input.nextLine();

        System.out.println(accountNumber + "  " + pinCode);
        System.out.println("Success");

        BankAccount client1 = service.getClient(accountNumber, pinCode);
        //BankAccount client1 = service.getClient("kz2441", "9999");

        int theEnd = 0;
        while (theEnd != 1) {

            ShowMenu(client1);
            int choice = input.nextInt();

            if (choice == 1) {
                Integer totalBalance = service.totalBalance(client1);
                System.out.println("Client totalBalance: " + totalBalance);
                System.out.println("Enter money you want to get");
                Integer money = input.nextInt();
                service.withdrawal(client1, money);
                totalBalance = service.totalBalance(client1);
                System.out.println("Client totalBalance: " + totalBalance);

            } else if (choice == 2) {
                Integer totalBalance = service.totalBalance(client1);
                System.out.println("Client totalBalance: " + totalBalance);
            } else if (choice == 3) {
                String newPinCode = input.nextLine();
                service.setPinCode(client1, newPinCode);
            } else if (choice == 4) {
                Integer totalBalance = service.totalBalance(client1);
                System.out.println("Client totalBalance: " + totalBalance);
                System.out.println("Enter money");
                Integer money = input.nextInt();
                service.replenishment(client1, money);
                totalBalance = service.totalBalance(client1);
                System.out.println("Client totalBalance: " + totalBalance);
            } else if (choice == 5) {
                String accountData = service.accountData(client1);
                System.out.println("ACCOUNT DATA\n" + accountData);
            }
            else{
                break;
            }

            System.out.println("Do you want to EXIT? \n 1 - YES \t 0-NO");
            theEnd = input.nextInt();

        }

        System.out.println("Transaction is completed");

        // CHECKING getClient(..., ...); method
        //BankAccount client1 = service.getClient("kz2441", "9999");
        //System.out.println(client1.toString());
        //System.out.println(client1.getClass().equals(CityBankAccount.class)?true:false);

        // CHECKING getAccountNumber(BankAccount client) method
        /*List<BankAccount> bankAccountList = Database.getBankAccountList();
        System.out.println(bankAccountList);
        //String accountNumber1 = service.getAccountNumber(bankAccountList.get(0));
        //System.out.println(accountNumber1);

        for (BankAccount tmp: bankAccountList) {
            String accountNumber = service.getAccountNumber(tmp);
            System.out.println(accountNumber);
        }*/

        // CHECKING getPinCode(BankAccount client) method
        /*for (BankAccount tmp: Database.getBankAccountList()) {
            String pinCode = service.getPinCode(tmp);
            System.out.println("Client pinCode: " + pinCode);
        }*/

        // CHECKING setPinCode(BankAccount client, String pinCode) method
        /*List<BankAccount> bankAccountList = Database.getBankAccountList();
        System.out.println(bankAccountList);
        service.setPinCode(bankAccountList.get(0), "8888");
        System.out.println(bankAccountList);*/

        // CHECKING totalBalance(BankAccount client) method
        /*for (BankAccount tmp: Database.getBankAccountList()) {
            Integer totalBalance = service.totalBalance(tmp);
            System.out.println("Client totalBalance: " + totalBalance);
        }*/

        /*for (BankAccount tmp: Database.getBankAccountList()) {
            String accountData = service.accountData(tmp);
            System.out.println("Info about Client: " + accountData);
        }*/
    }
    public static void ShowMenu(BankAccount client){
        if (client.getClass().equals(CityBankAccount.class)) {
            System.out.println(" PRESS [1] TO CASH WITHDRAWAL  // снять деньги" + "\n" +
                    " PRESS [2] TO VIEW BALANCE // просмотр баланса" + "\n" +
                    " PRESS [3] TO CHANGE PIN CODE // изменить пин код" + "\n" +
                    " PRESS [4] TO REFILL ACCOUNT // добавить деньги в счет" + "\n" +
                    " PRESS [5] TO VIEW ACCOUNT DATA // просмотр данные счета" + "\n" +
                    " PRESS [6] TO EXIT // выход");

        } else {
            System.out.println(" PRESS [1] TO CASH WITHDRAWAL\n" +
                    " PRESS [2] TO VIEW BALANCE\n" +
                    " PRESS [3] TO EXIT");
        }
    }
}
