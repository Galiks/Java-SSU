package com.turchenkov.NewSpring.model;

import javax.persistence.*;

@Entity
@Table(name = "Operations")
public class Operation {

    //region Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "From_client")
    @ManyToOne
    @JoinColumn(name = "From_clientID")
    private Bank sender;

    @Column(name = "To_client")
    @ManyToOne
    @JoinColumn(name = "To_clientID")
    private Bank receiver;

    @Column(name = "Money_of_transfer")
    private double money;

    @Column(name = "Reverse")
    private boolean reverse;
    //endregion

    //region Constructors
    public Operation() {
    }

    public Operation(Bank sender, Bank receiver, double money, boolean reverse) {
        this.sender = sender;
        this.receiver = receiver;
        this.money = money;
        this.reverse = reverse;
    }
    //endregion

    //region Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bank getSender() {
        return sender;
    }

    public void setSender(Bank sender) {
        this.sender = sender;
    }

    public Bank getReceiver() {
        return receiver;
    }

    public void setReceiver(Bank receiver) {
        this.receiver = receiver;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }
    //endregion

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", money=" + money +
                ", reverse=" + reverse +
                '}';
    }
}
