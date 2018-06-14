package com.turchenkov.NewSpring.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "Bank")
public class Bank {

    //region Fields
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Number_of_account")
    private String accountNumber;

    @Column(name = "Money")
    private double money;

    @Column(name = "ClientID")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientID")
    private Client client;
    //endregion

    //region Constructors
    public Bank() {
    }

    public Bank(String accountNumber, double money, Client client) {
        this.accountNumber = accountNumber;
        this.money = money;
        this.client = client;
    }
    //endregion

    //region Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    //endregion


    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", money=" + money +
                ", client=" + client +
                '}';
    }
}
