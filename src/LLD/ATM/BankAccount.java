package LLD.ATM;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private static final AtomicInteger ID_GEN = new AtomicInteger(1000);
    private long accountId;
    private String pin;
    private double balance;

    public BankAccount(String pin, double balance) {
        this.accountId = ID_GEN.addAndGet(1000);
        this.pin = pin;
        this.balance = balance;
    }

    public long getAccountId() {
        return accountId;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
