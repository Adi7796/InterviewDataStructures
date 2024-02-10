package Design.OOPS.DeepCopyAndShallowCopy;

public class Client {
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {

        NetworkConnection networkConnection = new NetworkConnection();

        networkConnection.setIpAddress("123.432.122.3");

        DbConnection dbConnection = new DbConnection();
        dbConnection.setDbName("MySQL");
        dbConnection.setDbSchema("DbSchema");

        networkConnection.setDbConnection(dbConnection);

        System.out.println("Loading data via network call");
        networkConnection.LoadDataViaNetworkCall();

        System.out.println("Network Connection 1:");
        System.out.println(networkConnection);

        NetworkConnection networkConnection1 = (NetworkConnection) networkConnection.clone();
        DbConnection dbConnection1 = networkConnection1.getDbConnection();
        dbConnection1.setDbSchema("New Cloned SQL Schema");
        dbConnection1.setDbName("No SQL");
        networkConnection1.setDbConnection(dbConnection1);

        System.out.println("Printing after cloning the original object also changes the original DbConnection object");
        System.out.println(networkConnection);
        System.out.println(networkConnection1);

        // Uncomment the cloning logic implementation inside NetworkConnection class to implement deep copy and prevent shallow copy
    }
}
