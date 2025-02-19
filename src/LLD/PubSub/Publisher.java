package LLD.PubSub;

import java.util.HashSet;
import java.util.Set;

public class Publisher {
    private Set<Topic> topics;

    public Publisher() {
        this.topics = new HashSet<>();
    }

    public void registerTopic(Topic topic){
        topics.add(topic);
    }

    public void publishMessage(Topic topic, Message<?> message){
        if (!topics.contains(topic)){
            System.out.println("Topic was not found");
            return;
        }
        topic.publishMessage(message);
    }
}
