package Design.LLD.AirlineBookingSystem.booking;

import Design.LLD.AirlineBookingSystem.Passenger;
import Design.LLD.AirlineBookingSystem.flight.Flight;
import Design.LLD.AirlineBookingSystem.seat.Seat;

public class Booking {

    private final String bookingReference;
    private final Passenger passenger;
    private final Seat seat;
    private final Flight flight;
    private final double price;
    private BookingStatus bookingStatus;

    public Booking(String bookingReference, Passenger passenger,
                   Seat seat, Flight flight, double price) {
        this.bookingReference = bookingReference;
        this.passenger = passenger;
        this.seat = seat;
        this.flight = flight;
        this.price = price;
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void cancelBooking()
    {
        bookingStatus = BookingStatus.CANCELLED;
    }

    public String getBookingReference() {
        return bookingReference;
    }
}
