package ru.donkan.springCrud.models;

import org.hibernate.validator.constraints.UniqueElements;
import javax.validation.constraints.*;


public class Person {

//    @UniqueElements
//    @Size(min = 4, max = 4, message = "UUID should be 4 characters")
//    @Positive
    private int uuid;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 30 characters")
    private String name;

    @Min(value = 0, message = "Balance should be positive or null")
    @PositiveOrZero
    private double balance;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    public Person() {
    }

    public Person(int uuid, String name, double balance, String email) {
        this.uuid = uuid;
        this.name = name;
        this.balance = balance;
        this.email = email;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
