package Design.LLD.CarRentalSystem.Service;

import Design.LLD.CarRentalSystem.Model.ReservationStatus;
import Design.LLD.CarRentalSystem.Model.Vehicle;
import Design.LLD.CarRentalSystem.Model.VehicleType;

import java.util.List;

public class Store {

    private int storeId;
    private VehicleInventoryManagement vehicleInventoryManagement;
    private Location location;
    private List<Reservation> reservationList;


    public List<Vehicle> getVehicles(VehicleType vehicleType){
        // can pass the vehicleType filter and the inv management will return those vehicles
        return vehicleInventoryManagement.getVehiclesList();
    }
    public void setVehicles(List<Vehicle> vehicles){
        vehicleInventoryManagement.setVehiclesList(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle, User user)
    {
        Reservation reservation = new Reservation();
        reservation.createReservationId(user, vehicle);
        reservationList.add(reservation);
        return reservation;
    }

    public void completeReservation(Reservation reservation){
        reservation.setReservationStatus(ReservationStatus.COMPLETED);
    }
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public VehicleInventoryManagement getVehicleInventoryManagement() {
        return vehicleInventoryManagement;
    }

    public void setVehicleInventoryManagement(VehicleInventoryManagement vehicleInventoryManagement) {
        this.vehicleInventoryManagement = vehicleInventoryManagement;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
