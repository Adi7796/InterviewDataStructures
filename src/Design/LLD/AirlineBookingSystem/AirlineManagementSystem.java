package Design.LLD.AirlineBookingSystem;

import Design.LLD.AirlineBookingSystem.booking.Booking;
import Design.LLD.AirlineBookingSystem.booking.BookingManager;
import Design.LLD.AirlineBookingSystem.flight.Flight;
import Design.LLD.AirlineBookingSystem.flight.FlightSearch;
import Design.LLD.AirlineBookingSystem.payment.PaymentProcessor;
import Design.LLD.AirlineBookingSystem.payment.PaymentService;
import Design.LLD.AirlineBookingSystem.seat.Seat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AirlineManagementSystem {

    private final List<Aircraft> aircraftList;
    private final List<Flight> flightList;
    private final PaymentProcessor paymentProcessor;
    private final BookingManager bookingManager;
    private final FlightSearch flightSearch;

    public AirlineManagementSystem() {
        this.aircraftList = new ArrayList<>();
        this.flightList = new ArrayList<>();
        this.paymentProcessor = PaymentProcessor.getInstance();
        this.bookingManager = BookingManager.getInstance();
        this.flightSearch = new FlightSearch(flightList);
    }

    public void addFlight(Flight flight)
    {
        flightList.add(flight);
    }

    public void addAircraft(Aircraft aircraft)
    {
        aircraftList.add(aircraft);
    }

    public List<Flight> searchFlights(String source, String destination, LocalDate date) {
        return flightSearch.searchFlights(source, destination, date);
    }

    public Booking bookFlight(Flight flight, Passenger passenger, Seat seat, double price) {
        return bookingManager.createBooking(flight, passenger, seat, price);
    }

    public void cancelBooking(String bookingNumber) {
        bookingManager.cancelBooking(bookingNumber);
    }

    public void processPayment(PaymentService payment) {
        paymentProcessor.processPayment(payment);
    }
}
