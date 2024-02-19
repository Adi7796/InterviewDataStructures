package Design.LLD.Elevetor;

import Design.LLD.Elevetor.Enums.Direction;

public class HallButton extends Button{
    Direction buttonSign;
    int sourceFloorNumber;

    @Override
    public void pressDown() {
        super.pressDown();
    }

    @Override
    public boolean isPressed() {
        return true;
    }
}
