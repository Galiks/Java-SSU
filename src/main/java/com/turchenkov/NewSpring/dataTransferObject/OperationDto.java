package com.turchenkov.NewSpring.dataTransferObject;

public class OperationDto {

    //region Fields
    private Long fromAccountID;
    private Long toAccountID;
    private double money;
    //endregion

    //region Constructors
    public OperationDto() {
    }

    public OperationDto(Long fromAccountID, Long toAccountID, double money) {
        this.fromAccountID = fromAccountID;
        this.toAccountID = toAccountID;
        this.money = money;
    }
    //endregion

    //region Getters & Setters
    public Long getFromAccountID() {
        return fromAccountID;
    }

    public void setFromAccountID(Long fromAccountID) {
        this.fromAccountID = fromAccountID;
    }

    public Long getToAccountID() {
        return toAccountID;
    }

    public void setToAccountID(Long toAccountID) {
        this.toAccountID = toAccountID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    //endregion

    @Override
    public String toString() {
        return "OperationDto{" +
                "fromAccountID=" + fromAccountID +
                ", toAccountID=" + toAccountID +
                ", money=" + money +
                '}';
    }
}
