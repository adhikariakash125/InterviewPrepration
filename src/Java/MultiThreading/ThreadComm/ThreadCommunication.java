package Java.MultiThreading.ThreadComm;

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread consumer = new Thread(new Consumer(sharedResource), "Consumer Thread");
        Thread producer = new Thread(new Producer(sharedResource), "Producer Thread");

        consumer.start();
        producer.start();
    }
}
