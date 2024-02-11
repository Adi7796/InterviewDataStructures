package Design.LLD.ParkingLot;

import Design.LLD.ParkingLot.Model.ParkingSlotType;
import Design.LLD.ParkingLot.Model.Vehicle;

public class ParkingSlot {
    String parkingSlotName;
    boolean isAvailable;
    Vehicle vehicle;
    ParkingSlotType parkingSlotType;


    public ParkingSlot(String parkingSlotName, boolean isAvailable, ParkingSlotType parkingSlotType) {
        this.parkingSlotName = parkingSlotName;
        this.isAvailable = isAvailable;
        this.parkingSlotType = parkingSlotType;
    }

    public String getParkingSlotName() {
        return parkingSlotName;
    }

    public void setParkingSlotName(String parkingSlotName) {
        this.parkingSlotName = parkingSlotName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlotType getParkingSlotType() {
        return parkingSlotType;
    }

    public void setParkingSlotType(ParkingSlotType parkingSlotType) {
        this.parkingSlotType = parkingSlotType;
    }

    protected void addVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    protected void removeVehicle(){
        this.vehicle = null;
        this.isAvailable = true;
    }
}
