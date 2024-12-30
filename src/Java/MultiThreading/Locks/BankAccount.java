package Java.MultiThreading.Locks;

import Java.MultiThreading.Threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withDrawAmount(int amount) throws InterruptedException {
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                System.out.println("Attempting to withdraw:- " + Thread.currentThread().getName());
                if (balance>=amount){
                    try {
                        System.out.println("Starting the withdrawal process:- " + Thread.currentThread().getName());
                        Thread.sleep(3000);
                        balance-=amount;
                        System.out.println("Completed the withdrawal process:- " + Thread.currentThread().getName() + "--> Remaining amount: " +balance);
                    }catch (Exception e){
                        Thread.currentThread().interrupt();
                    }
                    finally {
                        lock.unlock();
                    }
                }else {
                    System.out.println("Insufficient balance:- "+ Thread.currentThread().getName());
                }
            }else {
                System.out.println("Resource is busy will try again later:- " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
