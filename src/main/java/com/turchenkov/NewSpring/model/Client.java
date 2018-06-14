package com.turchenkov.NewSpring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Client")
public class Client {

    //region Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Second_Name")
    private String secondName;

    @Column(name = "Age", length = 3)
    private int age;

    @Column(name = "Phone", length = 6)
    private String phone;

    @Column(name = "Login", unique = true)
    private String login;

    @Column(name = "Password")
    private String password;

    @Column(name = "Admin_or_Client")
    private boolean admin;

    @OneToMany(mappedBy = "client")
    private List<Bank> account = new ArrayList<>();
    //endregion

    //region Constructors
    public Client() {
    }

    public Client(String firstName, String secondName, int age, String phone, String login, String password, boolean admin, List<Bank> account) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.admin = admin;
        this.account = account;
    }
    //endregion

    //region Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Bank> getAccount() {
        return account;
    }

    public void setAccount(List<Bank> account) {
        this.account = account;
    }
    //endregion


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", account=" + account +
                '}';
    }
}
