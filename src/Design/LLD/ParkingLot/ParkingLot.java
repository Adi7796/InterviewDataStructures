package Design.LLD.ParkingLot;

import Design.LLD.ParkingLot.Model.Address;
import Design.LLD.ParkingLot.Model.Ticket;
import Design.LLD.ParkingLot.Model.Vehicle;

import java.util.List;

public class ParkingLot implements PaymentService{
    String nameOfParkingLot;
    private Address address;
    private List<ParkingFloors> parkingFloorsList;
    private static ParkingLot parkingLot = null;

    private ParkingLot(String nameOfParkingLot, Address address, List<ParkingFloors> parkingFloorsList){
        this.address = address;
        this.nameOfParkingLot = nameOfParkingLot;
        this.parkingFloorsList = parkingFloorsList;
    }

    public static ParkingLot getInstance(String nameOfParkingLot, Address address, List<ParkingFloors> parkingFloorsList){
        if(parkingLot == null)
            return new ParkingLot(nameOfParkingLot, address, parkingFloorsList);
        return parkingLot;
    }

    public String getNameOfParkingLot() {
        return nameOfParkingLot;
    }

    public void setNameOfParkingLot(String nameOfParkingLot) {
        this.nameOfParkingLot = nameOfParkingLot;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<ParkingFloors> getParkingFloorsList() {
        return parkingFloorsList;
    }

    public void setParkingFloorsList(List<ParkingFloors> parkingFloorsList) {
        this.parkingFloorsList = parkingFloorsList;
    }

    public static ParkingLot getParkingLot() {
        return parkingLot;
    }

    public static void setParkingLot(ParkingLot parkingLot) {
        ParkingLot.parkingLot = parkingLot;
    }
    
    public void addFloors(ParkingFloors parkingFloors){
        parkingFloorsList.add(parkingFloors);
    }

    public void removeFloor(ParkingFloors parkingFloors){
        parkingFloorsList.remove(parkingFloors);
    }

    public Ticket assignTicket(Vehicle vehicle){
        Ticket parkingTicket = null;
        try{
            ParkingSlot parkingSlot = getParkingSlotForVehicle(vehicle);
            if(parkingSlot==null)
                throw new RuntimeException("No Free parking spot found for :: " + vehicle.getVehicleCategory()
                        + " :: " + vehicle.getVehicleNumber());
            parkingTicket = createTicketForParkingSlot(vehicle, parkingSlot);
            return parkingTicket;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
       return parkingTicket;
    }

    private Ticket createTicketForParkingSlot(Vehicle vehicle, ParkingSlot parkingSlot){
        return Ticket.createTicket(vehicle, parkingSlot);
    }

    private ParkingSlot getParkingSlotForVehicle(Vehicle vehicle){
        ParkingSlot parkingSlot = null;
        for(ParkingFloors parkingFloors : parkingFloorsList){
            parkingSlot = parkingFloors.getAvailableParkingSlot(vehicle);
            if(parkingSlot!=null)
                break;
        }
        return parkingSlot;
    }

    @Override
    public double scanAndPay(Ticket ticket) {
        long endTime = System.currentTimeMillis();
        ticket.getParkingSlot().removeVehicle();
        int duration = (int)(endTime - ticket.getStartTime())/1000;
        double amountToPay = calculatePrice(ticket.getVehicle(), duration);
        return amountToPay;
    }

    private double calculatePrice(Vehicle vehicle, int duration){
        return vehicle.getVehicleCategory().price * duration;
    }
}
