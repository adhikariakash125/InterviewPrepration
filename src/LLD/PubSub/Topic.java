package LLD.PubSub;

import java.util.HashSet;
import java.util.Set;

public class Topic {
    private String name;
    private Set<Consumer> consumers;

    public Topic(String name) {
        this.name = name;
        this.consumers = new HashSet<>();
    }

    public void addNewConsumer(Consumer consumer){
        consumers.add(consumer);
    }

    public void removeConsumer(Consumer consumer){
        consumers.remove(consumer);
    }

    public void publishMessage(Message<?> message){
        for (Consumer consumer:consumers){
            consumer.onCall(message);
        }
    }

}
