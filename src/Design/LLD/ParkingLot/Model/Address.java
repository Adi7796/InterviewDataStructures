package Design.LLD.ParkingLot.Model;

public class Address {
    private final String street;
    private final String block;
    private final String city;
    private final String state;
    private final String country;

    public Address(String street, String block, String city, String state, String country) {
        this.street = street;
        this.block = block;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
