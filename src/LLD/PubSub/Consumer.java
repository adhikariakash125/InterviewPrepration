package LLD.PubSub;

public class Consumer {
    public void onCall(Message<?> message){
        System.out.println(message.getData());
    }
}
