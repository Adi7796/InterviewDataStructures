package Design.LLD.OlaUber;

public class Driver extends User{

    private final String licensePlate;
    private Location location;
    private Trip currentTrip;
    private DriverStatus driverStatus;
    public Driver(String name, String contactNumber, String licensePlate, Location location){
        super(name, contactNumber);
        this.licensePlate = licensePlate;
        this.location = location;
        driverStatus = DriverStatus.AVAILABLE;
    }

    public void assignTrip(Trip trip){
        this.currentTrip = trip;
    }

    public boolean isAvailable() {
        return this.driverStatus == DriverStatus.AVAILABLE;
    }

    public void completeTrip(){
        this.currentTrip = null;
        this.driverStatus = DriverStatus.AVAILABLE;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Location getLocation() {
        return location;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }
}
