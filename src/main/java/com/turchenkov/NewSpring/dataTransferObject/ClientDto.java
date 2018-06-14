package com.turchenkov.NewSpring.dataTransferObject;

public class ClientDto {

    //<editor-fold desc="Fields">
    private Long clientID;
    private String login;
    private String password;
    //</editor-fold>

    //region Constructors
    public ClientDto() {
    }

    public ClientDto(Long clientID, String login, String password) {
        this.clientID = clientID;
        this.login = login;
        this.password = password;
    }
    //endregion

    //region Getters & Setters
    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //endregion

    @Override
    public String toString() {
        return "ClientDto{" +
                "clientID=" + clientID +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
