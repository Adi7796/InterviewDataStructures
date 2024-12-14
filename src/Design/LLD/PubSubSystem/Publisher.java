package Design.LLD.PubSubSystem;

import java.util.HashSet;
import java.util.Set;

public class Publisher {

    private final String name;
    private final Set<Topic> topicSet;

    public Publisher(String name) {
        this.name = name;
        this.topicSet = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void registerTopic(Topic topic){
        topicSet.add(topic);
        System.out.println("Added topic : " + topic);
    }

    public void removeTopic(Topic topic){
        topicSet.remove(topic);
        System.out.println("Removed topic : " + topic);
    }

    public void publish(Topic topic, Message message){
        if(!topicSet.contains(topic))
        {
            System.out.println("This publisher can't publish to topic: " + topic.getName());
            return;
        }
        topic.publish(message);
    }
}
