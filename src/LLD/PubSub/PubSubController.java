package LLD.PubSub;

public class PubSubController {
    public static void main(String[] args) {
        // Create Topic
        Topic topic1 = new Topic("Topic-1");
        Topic topic2 = new Topic("Topic-2");

        // Create Publisher
        Publisher publisher1 = new Publisher();
        Publisher publisher2 = new Publisher();

        // Create subscribers
        Consumer consumer1 = new Consumer();
        Consumer consumer2 = new Consumer();
        Consumer consumer3 = new Consumer();

        publisher1.registerTopic(topic1);
        publisher2.registerTopic(topic2);

        // Subscribe to topics
        topic1.addNewConsumer(consumer1);
        topic1.addNewConsumer(consumer2);
        topic2.addNewConsumer(consumer2);
        topic2.addNewConsumer(consumer3);

        // Publish message
        publisher1.publishMessage(topic1, new Message<String>("Message-1 for topic-1"));
        publisher1.publishMessage(topic1, new Message<String>("Message-2 for topic-1"));
        publisher2.publishMessage(topic2, new Message<String>("Message-1 for topic-2"));

        // Unsubscribe from a topic
        topic1.removeConsumer(consumer3);

        // Publish more messages
        publisher1.publishMessage(topic1, new Message<>("Message-3 for Topic1"));
        publisher2.publishMessage(topic2, new Message<>("Message-2 for Topic2"));


    }
}
