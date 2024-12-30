package Java.MultiThreading.ThreadComm;

public class SharedResource {
    private int data;
    private boolean hasData;

    public synchronized void consume() {
        while (!hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify();
    }

    public synchronized void produce(int i) {
        while (hasData){
            try {
                wait();
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        hasData = true;
        data = i;
        System.out.println("Produced: " + data);
        notify();
    }
}
