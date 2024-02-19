package Design.LLD.Elevetor;

import java.util.List;

public class Floor {
    private List<Display> displayList;
    private List<HallPanel> hallPanelList;

    public boolean isTopMost(){return true;}

    public boolean isBottomMost(){ return false;}
}
