package Design.LLD.BookMyShow.Driver;

import Design.LLD.BookMyShow.*;
import Design.LLD.BookMyShow.Enums.City;
import Design.LLD.BookMyShow.Enums.SeatCategory;

import java.util.ArrayList;
import java.util.List;

public class BookMyShowDriverClass {

    MovieController movieController;
    TheatreController theatreController;

    public BookMyShowDriverClass(MovieController movieController, TheatreController theatreController) {
        this.movieController = movieController;
        this.theatreController = theatreController;
    }

    public static void main(String[] args) {

        BookMyShowDriverClass bookMyShow = new BookMyShowDriverClass(new MovieController(), new TheatreController());

        bookMyShow.initialiseSystem();
    }

    private void initialiseSystem()
    {
        createMovie();

        createTheatre();
    }

    private void createMovie()
    {
        Movie spiderManMovie = new Movie();
        spiderManMovie.setMovieId(1);
        spiderManMovie.setMovieName("SPIDERMAN");
        spiderManMovie.setMovieDuration(150);

        Movie avengersMovie = new Movie();
        avengersMovie.setMovieId(2);
        avengersMovie.setMovieName("AVENGERS");
        avengersMovie.setMovieDuration(180);

        movieController.addMovie(spiderManMovie, City.HYDERABAD);
        movieController.addMovie(avengersMovie, City.HYDERABAD);
        movieController.addMovie(spiderManMovie, City.BANGALORE);
        movieController.addMovie(spiderManMovie, City.DELHI);
    }

    public void createTheatre()
    {
        List<Screen> screenList = createScreenList();
        Theatre inorbitTheatre = new Theatre();
        inorbitTheatre.setTheatreId(101);
        inorbitTheatre.setAddress(new Address(City.HYDERABAD, "Gachibowli"));
        inorbitTheatre.setScreenList(screenList);
        inorbitTheatre.setShowList(createShowList(screenList));

        Theatre ambTheatre = new Theatre();
        ambTheatre.setTheatreId(101);
        ambTheatre.setAddress(new Address(City.HYDERABAD, "Gachibowli"));
        ambTheatre.setScreenList(screenList);
        ambTheatre.setShowList(createShowList(screenList));

    }

    public List<Show> createShowList(List<Screen> screenList)
    {
        Movie avengersMovie = movieController.getMovieByMovieName("AVENGERS");
        Movie spiderManMovie = movieController.getMovieByMovieName("SPIDERMAN");
        List<Show> showList = new ArrayList<>();

        Show morningShow = new Show();
        morningShow.setShowId(1);
        morningShow.setShowStartTime(1000);
        morningShow.setMovie(avengersMovie);
        morningShow.setScreen(screenList.get(0));

        Show eveningShow = new Show();
        eveningShow.setScreen(screenList.get(1));
        eveningShow.setShowId(2);
        eveningShow.setShowStartTime(1600);
        eveningShow.setMovie(spiderManMovie);

        showList.add(morningShow);
        showList.add(eveningShow);

        return showList;
    }

    public List<Screen> createScreenList()
    {
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeatsList(createSeatsList());

        Screen screen2 = new Screen();
        screen2.setScreenId(2);
        screen2.setSeatsList(createSeatsList());

        List<Screen> screenList = new ArrayList<>();
        screenList.add(screen1);
        screenList.add(screen2);

        return screenList;
    }

    public List<Seat> createSeatsList()
    {
        List<Seat> seatsList = new ArrayList<>();

        for(int i=1; i<=10; i++) {
            Seat seat = new Seat(i, "A", SeatCategory.GOLD);
            seatsList.add(seat);
        }
        for(int i=1; i<=10; i++) {
            Seat seat = new Seat(i, "B", SeatCategory.PLATINUM);
            seatsList.add(seat);
        }
        for(int i=1; i<=10; i++) {
            Seat seat = new Seat(i, "C", SeatCategory.SILVER);
            seatsList.add(seat);
        }

        return seatsList;
    }
}
