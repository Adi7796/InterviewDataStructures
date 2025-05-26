package Design.LLD.OlaUber;

import Design.LLD.OlaUber.payment.PaymentStatus;

import java.util.UUID;

public class Trip {

    private final String id;
    private Driver driver;
    private final Rider rider;
    private final Location originLocation;
    private final Location destLocation;
    private TripStatus tripStatus;
    private PaymentStatus paymentStatus;
    private double fare;

    public Trip(Rider rider, Location origin, Location destination)
    {
        this.id = UUID.randomUUID().toString();
        this.rider = rider;
        this.originLocation = origin;
        this.destLocation = destination;
        this.tripStatus = TripStatus.REQUESTED;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public void assignDriver(Driver driver){
        this.driver = driver;
    }

    public void completeTrip(){
        this.tripStatus = TripStatus.COMPLETED;
    }

    public void markPaymentAsComplete(){
        this.paymentStatus = PaymentStatus.SUCCESSFUL;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getId() {
        return id;
    }

    public Driver getDriver() {
        return driver;
    }

    public Rider getRider() {
        return rider;
    }

    public Location getOriginLocation() {
        return originLocation;
    }

    public Location getDestLocation() {
        return destLocation;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public double getFare() {
        return fare;
    }
}
