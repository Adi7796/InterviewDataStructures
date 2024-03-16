package Design.LLD.BookMyShow;

import Design.LLD.BookMyShow.Enums.SeatCategory;

public class Seat {
    int seatNumber;
    String rowId;
    SeatCategory seatCategory;
    int price;

    public Seat(int seatNumber, String rowId, SeatCategory seatCategory, int price) {
        this.seatNumber = seatNumber;
        this.rowId = rowId;
        this.seatCategory = seatCategory;
        this.price = price;
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

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
