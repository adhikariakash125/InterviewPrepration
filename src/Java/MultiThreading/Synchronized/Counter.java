package Java.MultiThreading.Synchronized;

public class Counter {
    private int count = 0;

    public synchronized void increment(){ // if we put synchronized block here then it will solve race condition
        count++;
    }

    public int getCount(){
        return count;
    }
}
