package Design.LLD.BookMyShow;

import Design.LLD.BookMyShow.Enums.City;

public class Address {
    City city;
    String streetName;

    public Address(City city, String streetName) {
        this.city = city;
        this.streetName = streetName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
