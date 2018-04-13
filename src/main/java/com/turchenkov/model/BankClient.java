package com.turchenkov.model;

import java.util.UUID;

public class BankClient {

    public String idNumber;
    public String username;
    public String password;
    public int accountOfBank;
    public int money;

    //public ArrayList<BankClient> bankClients = new ArrayList<BankClient>();

    public BankClient() {
    }

    public BankClient( String username, String password, int accountOfBank, int money) {
        this.idNumber = String.valueOf(UUID.randomUUID());
        this.username = username;
        this.password = password;
        this.accountOfBank = accountOfBank;
        this.money = money;
    }

//    public BankClient(String idNumber, String username, String password, int accountOfBank, int money) {
//        this.idNumber = idNumber;
//        this.username = username;
//        this.password = password;
//        this.accountOfBank = accountOfBank;
//        this.money = money;
//    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAccountOfBank() {
        return accountOfBank;
    }

    public double getMoney() {
        return money;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountOfBank(int accountOfBank) {
        this.accountOfBank = accountOfBank;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return idNumber + " " + username + " " + password + " " + accountOfBank + " " + money + "\n";
    }
}
