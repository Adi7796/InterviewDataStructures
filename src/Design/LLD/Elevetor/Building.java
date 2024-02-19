package Design.LLD.Elevetor;

import java.util.List;

public class Building {
    private List<Floor> floorList;
    private List<ElevatorCar> elevatorCarList;

    private Building building = null;
    private Building(){}

    public Building getBuildingInstance(){
        if(building == null)
            return new Building();
        else return building;
    }

}
