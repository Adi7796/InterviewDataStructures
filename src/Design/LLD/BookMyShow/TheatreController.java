package Design.LLD.BookMyShow;

import Design.LLD.BookMyShow.Enums.City;

import java.util.List;
import java.util.Map;

public class TheatreController {

    Map<City, List<Theatre>> theatreList;
    List<Theatre> allTheatresList;

    public Map<City, List<Theatre>> getTheatreList() {
        return theatreList;
    }

    public void setTheatreList(Map<City, List<Theatre>> theatreList) {
        this.theatreList = theatreList;
    }

    public List<Theatre> getAllTheatresList() {
        return allTheatresList;
    }

    public void setAllTheatresList(List<Theatre> allTheatresList) {
        this.allTheatresList = allTheatresList;
    }
}
