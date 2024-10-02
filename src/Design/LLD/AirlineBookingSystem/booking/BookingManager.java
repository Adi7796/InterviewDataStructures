package Design.LLD.AirlineBookingSystem.booking;

import Design.LLD.AirlineBookingSystem.Passenger;
import Design.LLD.AirlineBookingSystem.flight.Flight;
import Design.LLD.AirlineBookingSystem.seat.Seat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingManager {

    private static BookingManager instance;
    private final Map<String, Booking> bookingsMap;

    private final Object lock = new Object();

    private final AtomicInteger bookingCounter = new AtomicInteger(0);

    private BookingManager()
    {
        bookingsMap = new HashMap<>();
    }

    public static synchronized BookingManager getInstance()
    {
        if(instance == null){
            instance = new BookingManager();
        }
        return instance;
    }

    public Booking createBooking(Flight flight, Passenger passenger, Seat seat, double price)
    {
        String bookingRefNumber = generateBookingRefNumber();
        Booking booking = new Booking(bookingRefNumber, passenger, seat, flight, price);
        synchronized (lock)
        {
            bookingsMap.put(bookingRefNumber, booking);
        }

        return booking;
    }

    public void cancelBooking(String bookingRefNumber)
    {
        synchronized (lock) {
            Booking booking = bookingsMap.get(bookingRefNumber);
            if (booking != null)
            {
                booking.cancelBooking();
            }
        }
    }

    public String generateBookingRefNumber()
    {
        int bookingId = bookingCounter.incrementAndGet();
        String timeStamp = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "BKG" + timeStamp + String.format("%06d", bookingId);
    }
}
