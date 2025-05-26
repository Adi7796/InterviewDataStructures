package Design.LLD.OlaUber;

public class Rider extends User{

    private Trip currentTrip;

    public Rider(String name, String contactNumber){
        super(name, contactNumber);
    }

    public void completeTrip(){
        this.currentTrip = null;
    }

    public void assignTrip(Trip trip){
        this.currentTrip = trip;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }
}
