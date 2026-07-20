package DesignPatterns.Singelton.Practice;

class Counter {
    // TODO: Implement as singleton
    // Hint: Use enum or Bill Pugh pattern
    private static volatile Counter instance = null;
    private int count = 0;

    private Counter(){}

    public static Counter getInstance(){
        if(instance==null){
            synchronized(Counter.class){
                instance = new Counter();
            }
        }
        return instance;
    }
    public void increment() {
        // TODO: Make thread-safe
        count++;
    }

    public int getCount() {
        // TODO: Return current count
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
//         After implementing, usage should look like:
         Counter c1 = Counter.getInstance();
         Counter c2 = Counter.getInstance();
         System.out.println("Same instance: " + (c1 == c2));
         for (int i = 0; i < 5; i++) {
             c1.increment();
         }
         System.out.println("Count after 5 increments: " + c1.getCount());
    }
}