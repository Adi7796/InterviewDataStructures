package Design.LLD.ParkingLot.Model;

import Design.LLD.ParkingLot.ParkingSlot;

public class Ticket {
    private String ticketNumber;
    private long startTime;
    private long endTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;

    public Ticket(TicketBuilder ticketBuilder){
        this.ticketNumber = ticketBuilder.ticketNumber;
        this.endTime = ticketBuilder.endTime;
        this.startTime = ticketBuilder.startTime;
        this.vehicle = ticketBuilder.vehicle;
        this.parkingSlot = ticketBuilder.parkingSlot;
    }

    static class TicketBuilder{
        private String ticketNumber;
        private long startTime;
        private long endTime;
        private Vehicle vehicle;
        private ParkingSlot parkingSlot;

        public TicketBuilder setTicketNumber(String ticketNumber){
            this.ticketNumber = ticketNumber;
            return this;
        }

        public TicketBuilder setStartTime(long startTime){
            this.startTime = startTime;
            return this;
        }

        public TicketBuilder setEndTime(long endTime){
            this.endTime = endTime;
            return this;
        }

        public TicketBuilder setVehicle(Vehicle vehicle){
            this.vehicle = vehicle;
            return this;
        }

        public TicketBuilder setParkingSlot(ParkingSlot parkingSlot){
            this.parkingSlot = parkingSlot;
            return this;
        }

        public Ticket build(){
            Ticket ticket = new Ticket(this);
            return ticket;
        }
    }

    public static Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot){
        return new TicketBuilder().setVehicle(vehicle)
                .setStartTime(System.currentTimeMillis())
                .setParkingSlot(parkingSlot)
                .setTicketNumber(vehicle.getVehicleNumber() + System.currentTimeMillis())
                .build();
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }
}
