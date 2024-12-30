package Java.MultiThreading.ReterrantLockExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReterentExample {

    private final Lock lock = new ReentrantLock();

    private void outer(){
        lock.lock();
        try {
            System.out.println("Outer Method");
            inner();
        }finally {
            lock.unlock();
        }
    }

    private void inner() {
        lock.lock();
        try {
            System.out.println("Inner Method");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReterentExample example = new ReterentExample();
        example.outer();
    }
}
