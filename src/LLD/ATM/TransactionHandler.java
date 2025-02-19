package LLD.ATM;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionHandler {
    Map<Integer, BankAccount> accountDetails;

    private TransactionHandler() {
        this.accountDetails = new ConcurrentHashMap<>();
    }

    private static class InnerTransactionHandler{
        private static final TransactionHandler TRANSACTION_HANDLER = new TransactionHandler();
    }

    public static TransactionHandler getTransactionHandler() {
        return InnerTransactionHandler.TRANSACTION_HANDLER;
    }

    public void openAccount(Integer id, double openingAmount, String pin){
        if (accountDetails.containsKey(id)){
            System.out.println("User already has a bank account");
            return;
        }
        accountDetails.put(id,new BankAccount(pin, openingAmount));
    }

    public void depositCash(double amount, User user, String pin){
        if (!verifyAccount(user.getId(), pin)) {
            System.out.printf("Incorrect pin for the customer " + user.getName());
            return;
        }
        BankAccount bankAccount = accountDetails.get(user.getId());
        if (amount<=0) return;
        double newBalance = bankAccount.getBalance() + amount;
        bankAccount.setBalance(newBalance);
        accountDetails.put(user.getId(),bankAccount);
        System.out.println("New Balance of account " + bankAccount.getAccountId() + " is " + newBalance);
    }

    public void checkBalance(User user, String pin) {
        if (!verifyAccount(user.getId(), pin)) {
            System.out.printf("Incorrect pin for the customer " + user.getName());
            return;
        }
        System.out.println("Current Balance is:- " + accountDetails.get(user.getId()).getBalance());
    }

    public void withdrawCash(double amount, User user, String pin) {
        if (!verifyAccount(user.getId(), pin)) {
            System.out.printf("Incorrect pin for the customer " + user.getName());
            return;
        }
        BankAccount bankAccount = accountDetails.get(user.getId());
        if (bankAccount.getBalance()<amount){
            System.out.println("Insufficient balance");
            return;
        }
        double newBalance = bankAccount.getBalance() - amount;
        System.out.println("Withdraw money " + amount);
        bankAccount.setBalance(newBalance);
        accountDetails.put(user.getId(),bankAccount);
        System.out.println("New Balance of account " + bankAccount.getAccountId() + " is " + newBalance);
    }


    private boolean verifyAccount(Integer id, String pin) {
        BankAccount bankAccount = accountDetails.get(id);
        if (bankAccount == null) return false;
        return bankAccount.getPin().equals(pin);
    }
}
