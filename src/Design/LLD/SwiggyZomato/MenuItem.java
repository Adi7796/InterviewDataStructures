package Design.LLD.SwiggyZomato;

public class MenuItem {

    private final String itemId;
    private final String itemName;
    private final double price;
    private boolean isAvailable;

    public MenuItem(String itemId, String itemName, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.isAvailable = true;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
