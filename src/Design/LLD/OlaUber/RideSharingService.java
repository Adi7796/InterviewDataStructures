package Design.LLD.OlaUber;

import Design.LLD.OlaUber.payment.PaymentProcessor;

import java.util.HashMap;
import java.util.Map;

public class RideSharingService {

    private static RideSharingService rideSharingServiceInstance;
    private final Map<String, Driver> driversMap;
    private final Map<String, Rider> ridersMap;
    private final Map<String, Trip> tripsMap;

    private RideSharingService() {
        this.driversMap = new HashMap<>();
        this.ridersMap = new HashMap<>();
        this.tripsMap = new HashMap<>();
    }

    public static RideSharingService getInstance(){
        if(rideSharingServiceInstance == null){
            rideSharingServiceInstance = new RideSharingService();
        }
        return rideSharingServiceInstance;
    }

    public Driver registerDriver(String name, String contactNumber, String licensePlate, Location location){
        Driver driver = new Driver(name, contactNumber, licensePlate, location);
        driversMap.put(driver.getId(), driver);
        return driver;
    }

    public Rider registerRider(String name, String contactNumber){
        Rider rider = new Rider(name, contactNumber);
        ridersMap.put(rider.getId(), rider);
        return rider;
    }

    public Trip requestRide(String riderId, Location from, Location to)
    {
        Rider rider = ridersMap.get(riderId);
        if(rider == null) throw new IllegalArgumentException("Rider not found");

        Trip trip = new Trip(rider, from, to);

        notifyNearbyDrivers(trip);

        tripsMap.put(trip.getId(), trip);
        return trip;
    }

    private void notifyNearbyDrivers(Trip trip)
    {
        boolean isDriverFound = false;
        for(Driver driver : driversMap.values())
        {
            if(driver.isAvailable()){
                double distance = driver.getLocation().getDistance(trip.getOriginLocation());
                if(distance <= 100.0)
                {
                    isDriverFound = true;
                    System.out.println("Notifying driver: " + driver.getName() + " about ride reqst: " + trip.getId());
                }
            }
        }

        if(!isDriverFound){
            throw new IllegalArgumentException("No nearby drivers found");
        }
    }

    public void acceptRide(String driverId, String tripId)
    {
        Trip trip = tripsMap.get(tripId);
        Driver driver = driversMap.get(driverId);

        if(trip.getTripStatus() == TripStatus.REQUESTED)
        {
            Rider rider = trip.getRider();
            trip.assignDriver(driver);
            trip.setTripStatus(TripStatus.ACCEPTED);
            driver.assignTrip(trip);
            rider.assignTrip(trip);
            driver.setDriverStatus(DriverStatus.ON_TRIP);
            System.out.println("Driver " + driver.getName() + " has accepted the ride");
            notifyDriver(trip);
        }
    }

    private void notifyDriver(Trip trip) {
        Driver driver = trip.getDriver();
        if (driver != null) {
            String message = switch (trip.getTripStatus()) {
                case COMPLETED -> "Ride completed. Fare: $" + trip.getFare();
                case CANCELLED -> "Ride cancelled by passenger";
                default -> "";
            };
            // Send notification to the driver
            System.out.println("Notifying driver: " + driver.getName() + " - " + message);
        }
    }

    private void notifyRider(Trip trip) {
        // Notify the passenger about ride status updates
        // ...
        User user = trip.getRider();
        String message = switch (trip.getTripStatus()) {
            case ACCEPTED -> "Your ride has been accepted by driver: " + trip.getDriver().getName();
            case ONGOING -> "Your ride is in progress";
            case COMPLETED -> "Your ride has been completed. Fare: $" + trip.getFare();
            case CANCELLED -> "Your ride has been cancelled";
            default -> "";
        };
        // Send notification to the passenger
        System.out.println("Notifying rider: " + user.getName() + " - " + message);
    }

    public void startRide(String tripId) {
        Trip trip = tripsMap.get(tripId);
        if (trip.getTripStatus() == TripStatus.ACCEPTED) {
            trip.setTripStatus(TripStatus.ONGOING);
            notifyRider(trip);
        }
    }

    public synchronized void completeRide(String tripId) {
        Trip trip = tripsMap.get(tripId);
        if (trip.getTripStatus() == TripStatus.ONGOING) {
            trip.completeTrip();
            trip.getDriver().completeTrip();
            trip.getRider().completeTrip();

            double fare = calculateFare(trip);
            trip.setFare(fare);

            notifyRider(trip);
            notifyDriver(trip);
            System.out.printf("Trip %s completed%n", trip.getId());
        }
    }

    public void cancelRide(String tripId) {
        Trip trip = tripsMap.get(tripId);
        if (trip.getTripStatus() == TripStatus.REQUESTED || trip.getTripStatus() == TripStatus.ACCEPTED) {
            trip.setTripStatus(TripStatus.CANCELLED);
            if (trip.getDriver() != null) {
                trip.getDriver().setDriverStatus(DriverStatus.AVAILABLE);
            }
            notifyDriver(trip);
        }
    }

    public void makePayment(String tripId, PaymentProcessor payment) {
        Trip trip = tripsMap.get(tripId);
        double fare = trip.getFare();
        payment.makePayment(fare);
        trip.markPaymentAsComplete();
    }

    private double calculateFare(Trip trip) {
        double baseFare = 2.0;
        double perKmFare = 1.5;

        double distance = trip.getOriginLocation().getDistance(trip.getDestLocation());

        double fare = baseFare + (distance * perKmFare);
        return Math.round(fare * 100.0) / 100.0; // Round to 2 decimal places
    }

}
