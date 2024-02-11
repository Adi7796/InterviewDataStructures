package Design.LLD.ParkingLot.Model;

public enum VehicleCategory {
    TWO_WHEELER(20),
    FOUR_WHEELER(50),
    BUS(100);

    public int price;
    VehicleCategory(int price) {
        this.price = price;
    }
}
