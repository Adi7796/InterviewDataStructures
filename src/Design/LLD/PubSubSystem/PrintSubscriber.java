package Design.LLD.PubSubSystem;

public class PrintSubscriber implements Subscriber{

    private final String name;

    public PrintSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Subscriber : " + name + " received message : " + message.getContent());
    }

    @Override
    public String toString() {
        return "PrintSubscriber{" +
                "name='" + name + '\'' +
                '}';
    }
}
