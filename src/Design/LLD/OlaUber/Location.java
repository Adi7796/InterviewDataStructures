package Design.LLD.OlaUber;

public class Location {

    private final double latitude;
    private final double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getDistance(Location otherLocation)
    {
        double dx = this.latitude - otherLocation.latitude;
        double dy = this.longitude - otherLocation.longitude;

        return Math.sqrt(dx*dx + dy*dy); // Euclidean formula
    }
}
