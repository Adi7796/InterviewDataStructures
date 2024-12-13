package Design.LLD.SwiggyZomato;

public class Customer {

    private final String customerId;
    private final String customerName;
    private final String customerPhoneNo;
    private final String customerEmailId;

    public Customer(String customerId, String customerName, String customerPhoneNo, String customerEmailId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNo = customerPhoneNo;
        this.customerEmailId = customerEmailId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
