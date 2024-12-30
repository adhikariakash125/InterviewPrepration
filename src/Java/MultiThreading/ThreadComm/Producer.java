package Java.MultiThreading.ThreadComm;

public class Producer implements Runnable{
    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            sharedResource.produce(i);
        }
    }
}
