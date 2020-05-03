package com.example.test.model;

public class User {
    private String name;
    private String LName;

    public User(String name, String LName) {
        this.name = name;
        this.LName = LName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String lName) {
        this.LName = lName;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lName='" + LName + '\'' +
                '}';
    }

}
