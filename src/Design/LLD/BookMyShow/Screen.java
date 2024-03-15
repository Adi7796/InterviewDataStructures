package Design.LLD.BookMyShow;

import java.util.List;

public class Screen {
    private int screenId;
    private List<Seat> seatsList;

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public List<Seat> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(List<Seat> seatsList) {
        this.seatsList = seatsList;
    }
}
