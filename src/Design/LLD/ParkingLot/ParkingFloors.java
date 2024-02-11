package Design.LLD.ParkingLot;

import Design.LLD.ParkingLot.Model.ParkingSlotType;
import Design.LLD.ParkingLot.Model.Vehicle;
import Design.LLD.ParkingLot.Model.VehicleCategory;

import java.util.Map;

public class ParkingFloors {
    String name;
    Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlotsMap;

    public ParkingFloors(String name, Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlotsMap) {
        this.name = name;
        this.parkingSlotsMap = parkingSlotsMap;
    }

    public ParkingSlot getAvailableParkingSlot(Vehicle vehicle){
        VehicleCategory vehicleCategory = vehicle.getVehicleCategory();
        ParkingSlotType parkingSlotType = getRelevantParkingSlotType(vehicleCategory);
        Map<String, ParkingSlot> relevantParkingSlotTypeMap = parkingSlotsMap.get(parkingSlotType);

        ParkingSlot slot = null;

        for(Map.Entry<String, ParkingSlot> entry : relevantParkingSlotTypeMap.entrySet()){
            if(entry.getValue().isAvailable){
                slot = entry.getValue();
                slot.addVehicle(vehicle);
            }
        }
        return slot;
    }

    private ParkingSlotType getRelevantParkingSlotType(VehicleCategory vehicleCategory){
        ParkingSlotType parkingSlotType = ParkingSlotType.LARGE;
        switch(vehicleCategory){
            case TWO_WHEELER :
                return ParkingSlotType.COMPACT;
            case FOUR_WHEELER:
                return ParkingSlotType.MEDIUM;
            case BUS:
                return ParkingSlotType.LARGE;
            default:
                break;
        }
        return parkingSlotType;
    }
}
