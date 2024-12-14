package Design.LLD.PubSubSystem;

import javax.xml.namespace.QName;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Topic {

    private final String name;
    private final Set<Subscriber> subscriberSet = new CopyOnWriteArraySet<>();

    public Topic(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSubscriber(Subscriber subscriber){
        subscriberSet.add(subscriber);
        System.out.println("Added subscriber : " + subscriber + " to topic :" + this.getName());
    }


    public void removeSubscriber(Subscriber subscriber){
        subscriberSet.remove(subscriber);
        System.out.println("Removed subscriber : " + subscriber + " from topic :" + this.getName());
    }

    public void publish(Message message)
    {
        for(Subscriber subscriber : subscriberSet)
        {
            subscriber.onMessage(message);
        }
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", subscriberSet=" + subscriberSet +
                '}';
    }
}
