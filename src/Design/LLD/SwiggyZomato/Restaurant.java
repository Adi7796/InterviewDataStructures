package Design.LLD.SwiggyZomato;

import java.util.List;

public class Restaurant {

    private final String restaurantId;
    private final String restaurantName;
    private final String address;
    private final List<MenuItem> menuItemList;

    public Restaurant(String restaurantId, String restaurantName, String address, List<MenuItem> menuItemList) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.address = address;
        this.menuItemList = menuItemList;
    }

    public void addMenuItem(MenuItem item)
    {
        menuItemList.add(item);
    }

    public void removeMenuItem(MenuItem item){
        menuItemList.remove(item);
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }
}
