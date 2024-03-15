package Design.LLD.BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Show {

    int showId;
    int showStartTime;
    Movie movie;
    Screen screen;
    List<Integer> bookedSeatsList  = new ArrayList<>();

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(int showStartTime) {
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<Integer> getBookedSeatsList() {
        return bookedSeatsList;
    }

    public void setBookedSeatsList(List<Integer> bookedSeatsList) {
        this.bookedSeatsList = bookedSeatsList;
    }

}
