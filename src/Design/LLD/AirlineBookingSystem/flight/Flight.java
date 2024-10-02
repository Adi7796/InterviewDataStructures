package Design.LLD.AirlineBookingSystem.flight;

import Design.LLD.AirlineBookingSystem.seat.Seat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {

    private final String flightNumber;
    private final String sourceCity;
    private final String destinationCity;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;

    private final List<Seat> availableSeats;

    public Flight(String flightNumber, String sourceCity, String destinationCity,
                  LocalDateTime departureTime, LocalDateTime arrivalTime)
    {
        this.flightNumber = flightNumber;
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }
}
