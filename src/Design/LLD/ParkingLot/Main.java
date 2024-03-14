package Design.LLD.ParkingLot;

import Design.LLD.ParkingLot.Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        String nameOfParkingLot = "Parking Lot";
        Address address = new Address("xyz", "Blocl", "Hyderabad", "Telangana", "India");
        List<ParkingFloors> parkingFloorsList = new ArrayList<>();
        Map<ParkingSlotType, Map<String, ParkingSlot>> allSlots = new HashMap<>();

        Map<String, ParkingSlot> compactSlots = new HashMap<>();
        compactSlots.put("P1", new ParkingSlot("P1", true, ParkingSlotType.COMPACT));
        compactSlots.put("P2", new ParkingSlot("P2", true, ParkingSlotType.COMPACT));
        compactSlots.put("P3", new ParkingSlot("P3", true, ParkingSlotType.COMPACT));

        Map<String, ParkingSlot> mediumSlots = new HashMap<>();
        mediumSlots.put("P1", new ParkingSlot("P1", true, ParkingSlotType.MEDIUM));
        mediumSlots.put("P2", new ParkingSlot("P2", true, ParkingSlotType.MEDIUM));
        mediumSlots.put("P3", new ParkingSlot("P3", true, ParkingSlotType.MEDIUM));

        Map<String, ParkingSlot> largeSlots = new HashMap<>();
        mediumSlots.put("P1", new ParkingSlot("P1", true, ParkingSlotType.LARGE));
        mediumSlots.put("P2", new ParkingSlot("P2", true, ParkingSlotType.LARGE));
        mediumSlots.put("P3", new ParkingSlot("P3", true, ParkingSlotType.LARGE));

        allSlots.put(ParkingSlotType.COMPACT, compactSlots);
        allSlots.put(ParkingSlotType.MEDIUM, mediumSlots);
        allSlots.put(ParkingSlotType.LARGE, largeSlots);

        ParkingFloors parkingFloor1 = new ParkingFloors("Level1", allSlots);
        ParkingFloors parkingFloor2 = new ParkingFloors("Level2", allSlots);

        parkingFloorsList.add(parkingFloor1);
        parkingFloorsList.add(parkingFloor2);

        ParkingLot parkingLot = ParkingLot.getInstance(nameOfParkingLot, address, parkingFloorsList);

        Vehicle hatchBack = new Vehicle();
        hatchBack.setVehicleCategory(VehicleCategory.FOUR_WHEELER);
        hatchBack.setVehicleNumber("TS-10-ET-3132");

        Vehicle bike = new Vehicle();
        bike.setVehicleCategory(VehicleCategory.TWO_WHEELER);
        bike.setVehicleNumber("TS-10-ET-2345");

        Ticket ticketHatchBack = parkingLot.assignTicket(hatchBack);
        Ticket ticketBike = parkingLot.assignTicket(bike);
        if(ticketHatchBack != null)
            System.out.println(hatchBack.getVehicleCategory().name() + " has checked in at " + ticketHatchBack.getStartTime());

        if(ticketBike != null)
            System.out.println(bike.getVehicleCategory().name() + " has checked in at " + ticketBike.getStartTime());
        Thread.sleep(10000);
        double hatchBackAmount = ticketHatchBack != null ?  parkingLot.scanAndPay(ticketHatchBack) : 0.0;
        double bikeAmount = ticketBike != null ? parkingLot.scanAndPay(ticketBike) : 0.0;
        System.out.println("Price to be paid for " + hatchBack.getVehicleCategory().name() + " :: " + hatchBackAmount);
        System.out.println("Price to be paid for " + bike.getVehicleCategory().name() + " :: " + bikeAmount);


    }
}
