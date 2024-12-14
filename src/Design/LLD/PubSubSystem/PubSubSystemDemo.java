package Design.LLD.PubSubSystem;

public class PubSubSystemDemo {

    public static void main(String[] args) {

        Topic topic1 = new Topic("Topic 1");
        Topic topic2 = new Topic("Topic 2");

        Publisher publisher1 = new Publisher("Publisher 1");
        Publisher publisher2 = new Publisher("Publisher 2");

        Subscriber subscriber1 = new PrintSubscriber("Subscriber 1");
        Subscriber subscriber2 = new PrintSubscriber("Subscriber 2");
        Subscriber subscriber3 = new PrintSubscriber("Subscriber 3");

        publisher1.registerTopic(topic1);
        publisher2.registerTopic(topic2);

        topic1.addSubscriber(subscriber1);
        topic1.addSubscriber(subscriber2);
        topic2.addSubscriber(subscriber2);
        topic2.addSubscriber(subscriber3);

        publisher1.publish(topic1, new Message("Message 1 for topic 1"));
        publisher1.publish(topic1, new Message("Message 2 for topic 1"));
        publisher2.publish(topic2, new Message("Message 1 for topic 2"));

        topic1.removeSubscriber(subscriber1);

        // Publish more messages
        publisher1.publish(topic1, new Message("Message3 for Topic1"));
        publisher2.publish(topic2, new Message("Message2 for Topic2"));
    }
}
