package model;

import java.time.LocalDate;

public abstract class Account {

    int id;
    int custNo;
    double balance;
    LocalDate dateCreated;

    public Account(int id, int custNo){
        this.id = id;
        this.custNo = custNo;
        this.balance = 0.0;
        this.dateCreated = LocalDate.now();


    }


    public void deposit(double amount){
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be +");
        }
    }

    public double showBalance(){
        return balance;
    }



    public abstract boolean withdraw(double amount);



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustNo() {
        return custNo;
    }

    public void setCustNo(int custNo) {
        this.custNo = custNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
