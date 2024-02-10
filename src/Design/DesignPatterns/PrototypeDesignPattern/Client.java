package Design.DesignPatterns.PrototypeDesignPattern;

public class Client {
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {

        NetworkConnection networkConnection = new NetworkConnection();

        networkConnection.setIpAddress("123.432.122.3");
        System.out.println("Loading data via network call");
        networkConnection.LoadDataViaNetworkCall();

        System.out.println(networkConnection);

        NetworkConnection networkConnection1 = (NetworkConnection) networkConnection.clone();
        System.out.println(networkConnection1);
    }
}
