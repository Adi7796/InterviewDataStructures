package Design.LLD.Elevetor;

public class ElevatorSystem {
    private Building building;
    private ElevatorSystem elevatorSystem = null;

    private ElevatorSystem(){}

    public ElevatorSystem getElevatorSystemInstance(){
        if(elevatorSystem == null)
            return new ElevatorSystem();
        else return elevatorSystem;
    }
    public void monitoring(){}

    public void dispatcher(){}

}
