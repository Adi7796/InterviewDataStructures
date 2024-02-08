package Design.DeepCopyAndShallowCopy;

public class NetworkConnection implements Cloneable{

    private String ipAddress;
    private String data;
    private DbConnection dbConnection;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DbConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void LoadDataViaNetworkCall() throws InterruptedException {
        this.setData("Data has been loaded");
        //Thread.sleep(5000); // to give an example that loading the data takes time
    }

    @Override
    public String toString() {
        return "NetworkConnection{" +
                "ipAddress='" + ipAddress + '\'' +
                ", data='" + data + '\'' +
                ", dbConnection=" + dbConnection +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();

        // logic for cloning so that internal object's reference doesn't get copied
        // uncomment the below logic to prevent shallow copying and implement deep copying
//        NetworkConnection networkConnection = new NetworkConnection();
//        networkConnection.setIpAddress(this.getIpAddress());
//        networkConnection.setData(this.getData());
//        DbConnection dbConnection = new DbConnection();
//        dbConnection.setDbName(this.getDbConnection().getDbName());
//        dbConnection.setDbSchema(this.getDbConnection().getDbSchema());
//        networkConnection.setDbConnection(dbConnection);
//
//        return networkConnection;
    }
}
