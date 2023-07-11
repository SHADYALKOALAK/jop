package com.example.alesraaprojectxml;

public class UserSignUpModel {
    private String userName;
    private String number;
    private String password;
    private int id;

    public UserSignUpModel(String userName, String number, String password) {
        this.userName = userName;
        this.number = number;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
