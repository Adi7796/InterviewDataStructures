package Design.LLD.BookMyShow;

import java.util.List;

public class Theatre {
    private int theatreId;
    private Address address;
    private List<Show> showList;
    private List<Screen> screenList;

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }
}
