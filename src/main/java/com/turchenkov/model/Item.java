package com.turchenkov.model;

public class Item {

    public String id;
    public String name;
    public int money;

    public Item(String id, String name, int money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public Item(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + money;
    }
}
