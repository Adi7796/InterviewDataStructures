package Design.LLD.AirlineBookingSystem.seat;

public class Seat {

    private final String seatNumber;
    private final SeatType seatType;
    private SeatStatus seatStatus;

    public Seat(String seatNumber, SeatType seatType) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = SeatStatus.AVAILABLE;
    }

    public void bookSeat()
    {
        seatStatus = SeatStatus.BOOKED;
    }

    public void releaseSeat()
    {
        seatStatus = SeatStatus.AVAILABLE;
    }
}
