package Design.LLD.CarRentalSystem.Service;

import Design.LLD.CarRentalSystem.Model.Vehicle;

import java.util.List;

public class VehicleInventoryManagement {
    private List<Vehicle> vehiclesList;

    public VehicleInventoryManagement(List<Vehicle> vehiclesList) {
        this.vehiclesList = vehiclesList;
    }

    public List<Vehicle> getVehiclesList() {
        return vehiclesList;
    }

    public void setVehiclesList(List<Vehicle> vehiclesList) {
        this.vehiclesList = vehiclesList;
    }
}
