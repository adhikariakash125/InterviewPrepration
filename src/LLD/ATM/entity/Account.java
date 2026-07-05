package LLD.ATM.entity;

import LLD.ATM.exceptions.InsufficientBalanceException;

public class Account {
    private int accountNumber;
    private int balance;

    public Account(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public synchronized void withdrawBalance(int amount){
        if (this.balance>=amount){
            this.balance-=amount;
        }else{
            throw new InsufficientBalanceException("Insufficient balance...try again");
        }
    }

    public synchronized void depositBalance(int amount){
        this.balance+=amount;
    }
}
