package Design.LLD.CarRentalSystem.Service;

import Design.LLD.CarRentalSystem.Model.ReservationStatus;
import Design.LLD.CarRentalSystem.Model.ReservationType;
import Design.LLD.CarRentalSystem.Model.Vehicle;

import java.util.Date;

public class Reservation {

    int reservationId;
    private User user;
    private Vehicle vehicle;
    private Date bookingDate;
    private Date dateBookedFor;
    private Date dateBookedTo;
    private Location vehiclePickupLocation;
    private Location vehicleDropLocation;
    private ReservationType reservationType;
    private ReservationStatus reservationStatus;


    // Logic to create a reservation
    // hardcoding for simplicity
    public int createReservationId(User user, Vehicle vehicle) {
        reservationId = 1234;
        this.user = user;
        this.vehicle = vehicle;
        reservationType = ReservationType.DAILY;
        reservationStatus = ReservationStatus.SCHEDULED;

        return reservationId;
    }

    // CRUD Operations to create, delete, remove or update reservations
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getDateBookedFor() {
        return dateBookedFor;
    }

    public void setDateBookedFor(Date dateBookedFor) {
        this.dateBookedFor = dateBookedFor;
    }

    public Date getDateBookedTo() {
        return dateBookedTo;
    }

    public void setDateBookedTo(Date dateBookedTo) {
        this.dateBookedTo = dateBookedTo;
    }

    public Location getVehiclePickupLocation() {
        return vehiclePickupLocation;
    }

    public void setVehiclePickupLocation(Location vehiclePickupLocation) {
        this.vehiclePickupLocation = vehiclePickupLocation;
    }

    public Location getVehicleDropLocation() {
        return vehicleDropLocation;
    }

    public void setVehicleDropLocation(Location vehicleDropLocation) {
        this.vehicleDropLocation = vehicleDropLocation;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
