package Design.LLD.CarRentalSystem.Service;

import Design.LLD.CarRentalSystem.Model.*;

import java.util.ArrayList;
import java.util.List;

public class MainDriverClass {
    public static void main(String[] args) {

        List<User> usersList = addUsers();
        List<Vehicle> vehicleList = addVehicles();
        List<Store> storeList = addStores(vehicleList);

        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(storeList, usersList);

        // 1) User comes in
        User user = usersList.get(0);

        // 2) user finds a store based on the location
        Location location = new Location("Financial District", "Hyderabad", "Telangana", 500032);
        Store store = vehicleRentalSystem.getStore(location);

        // 3) get all the vehicles user is interested in
        List<Vehicle> interestedVehicles = store.getVehicles(VehicleType.CAR);

        //4) Reserve the particular vehicle
        Reservation reservation = store.createReservation(interestedVehicles.get(0), user);

        // 5) generate the bill
        Bill bill = new Bill(reservation);

        // 6) Make the payment
        Payment payment = new Payment();
        payment.payBill(bill, PaymentMode.ONLINE);

        // 7) Trip completed, submit the vehicle and change vehicle status
        store.completeReservation(reservation);
    }

    public static List<User> addUsers()
    {
        List<User> userList = new ArrayList<>();
        User user = new User(10001, "Aditya Sharma", "462XWETS");
        userList.add(user);

        return userList;
    }

    public static List<Vehicle> addVehicles()
    {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleId(78234);
        vehicle1.setVehicleName("Taigun");
        vehicle1.setVehicleCompanyName("VW");
        vehicle1.setVehicleType(VehicleType.CAR);
        vehicle1.setVehicleStatus(VehicleStatus.ACTIVE);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleId(34324);
        vehicle2.setVehicleName("Kushaq");
        vehicle2.setVehicleCompanyName("Skoda");
        vehicle2.setVehicleType(VehicleType.CAR);
        vehicle2.setVehicleStatus(VehicleStatus.INACTIVE);

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(vehicle1);
        vehicleList.add(vehicle2);

        return vehicleList;
    }

    public static List<Store> addStores(List<Vehicle> vehicleList)
    {
        List<Store> storeList = new ArrayList<>();
        Store store = new Store();
        store.setStoreId(1);
        store.setLocation(new Location("Financial District", "Hyderabad", "Telangana", 500032));
        store.setVehicles(vehicleList);

        storeList.add(store);
        return storeList;
    }

}
