package Design.LLD.BookMyShow;

import Design.LLD.BookMyShow.Enums.SeatCategory;

public class Seat {
    int seatNumber;
    String rowId;
    SeatCategory seatCategory;

    public Seat(int seatNumber, String rowId, SeatCategory seatCategory) {
        this.seatNumber = seatNumber;
        this.rowId = rowId;
        this.seatCategory = seatCategory;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }
}
