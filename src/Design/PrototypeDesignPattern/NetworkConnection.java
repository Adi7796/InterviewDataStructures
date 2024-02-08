package Design.PrototypeDesignPattern;

public class NetworkConnection implements Cloneable{

    private String ipAddress;
    private String data;

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

    public void LoadDataViaNetworkCall() throws InterruptedException {
        this.setData("Data has been loaded");
        Thread.sleep(5000); // to give an example that loading the data takes time
    }

    @Override
    public String toString() {
        return "NetworkConnection{" +
                "ipAddress='" + ipAddress + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
