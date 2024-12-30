package Java.MultiThreading.Locks;

import Java.MultiThreading.Threads;

public class LockMain {
    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    sbi.withDrawAmount(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t1 = new Thread(runnable, "First Thread");
        Thread t2 = new Thread(runnable, "Second Thread");
        t1.start();
        t2.start();
    }
}
