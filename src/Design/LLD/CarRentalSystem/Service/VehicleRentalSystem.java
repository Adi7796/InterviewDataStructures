package Design.LLD.CarRentalSystem.Service;

import java.util.List;

public class VehicleRentalSystem {

    private List<Store> storeList;
    private List<User> usersList;

    public VehicleRentalSystem(List<Store> storeList, List<User> usersList) {
        this.storeList = storeList;
        this.usersList = usersList;
    }

    // add Users and stores
    // remove Users and stores

    public Store getStore(Location location)
    {
        // some filtering logic based on the location
        // return default store for simplicity
        return storeList.get(0);
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
}
