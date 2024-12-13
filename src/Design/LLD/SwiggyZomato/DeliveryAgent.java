package Design.LLD.SwiggyZomato;

public class DeliveryAgent {
    private final String deliveryAgentId;
    private final String deliveryAgentName;
    private final String deliveryAgentPhone;
    private boolean isAvailable;


    public DeliveryAgent(String deliveryAgentId, String deliveryAgentName, String deliveryAgentPhone) {
        this.deliveryAgentId = deliveryAgentId;
        this.deliveryAgentName = deliveryAgentName;
        this.deliveryAgentPhone = deliveryAgentPhone;
        this.isAvailable = true;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getDeliveryAgentId() {
        return deliveryAgentId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
