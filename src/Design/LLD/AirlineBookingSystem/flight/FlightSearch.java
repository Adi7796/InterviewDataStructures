package Design.LLD.AirlineBookingSystem.flight;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearch {
    private final List<Flight> flightList;

    public FlightSearch(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> searchFlights(String source, String destination, LocalDate date)
    {
        return flightList.stream()
                .filter(f -> f.getSourceCity().equalsIgnoreCase(source)
                        && f.getDestinationCity().equalsIgnoreCase(destination)
                        && f.getDepartureTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }
}
