package Design.LLD.BookMyShow.Driver;

import Design.LLD.BookMyShow.*;
import Design.LLD.BookMyShow.Enums.City;
import Design.LLD.BookMyShow.Enums.PaymentMode;
import Design.LLD.BookMyShow.Enums.SeatCategory;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        bookMyShow.createBooking(City.HYDERABAD, "AVENGERS");

        bookMyShow.createBooking(City.HYDERABAD, "SPIDERMAN");

        bookMyShow.createBooking(City.HYDERABAD, "SPIDERMAN");
    }

    private void initialiseSystem()
    {
        createMovies();

        createTheatres();

    }

    private void createBooking(City userCity, String movieName)
    {
        // 1) Search all movies and theatres by location
        List<Movie> movieList = movieController.getCityVsMoviesMap().get(userCity);
        List<Theatre> theatreList = theatreController.getCityVsTheatreList().get(userCity);

        // 2) Pick the selected movie by the user for that location
        Movie userSelectedMovie = null;
        for(Movie movie : movieList){
            if(movie.getMovieName().equals(movieName)){
                userSelectedMovie = movie;
            }
        }
        if(userSelectedMovie == null){
            System.out.println("Movie selected by user not found, select a different movie");
            return;
        }

        // 3) fetch all shows for this movie in the theatre
        Map<Theatre, List<Show>> theatreVsShow = theatreController.getAllShows(userSelectedMovie, userCity);

        // 4) Select the interested show
        Map.Entry<Theatre, List<Show>> entry = theatreVsShow.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show intersetedShow = runningShows.get(0);

        // 5) select the seat
        int seatNumber = 25;
        List<Integer> bookedSeats = intersetedShow.getBookedSeatsList();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);

            // Start booking and Payment
            Booking booking = new Booking();
            booking.setShow(intersetedShow);

            List<Seat> selectedSeatsList = new ArrayList<>();
            int amount = 0;
            for(Seat screenSeat : intersetedShow.getScreen().getSeatsList())
            {
                if(screenSeat.getSeatNumber() == seatNumber)
                {
                    selectedSeatsList.add(screenSeat);
                    amount += screenSeat.getPrice();
                }
            }
            booking.setSelectedSeatsList(selectedSeatsList);

            Payment payment = new Payment();
            payment.setPaymentId(123123);
            payment.setPaymentMode(PaymentMode.PHONEPE);
            payment.setAmount(amount);

            booking.setPayment(payment);
            System.out.println("BOOKING SUCCESSFULL");
            System.out.println("BOOKING DETAILS : ");
            System.out.println("MovieName : " + movieName + "  Amount Paid : " + payment.getAmount());
        }
        else{
            System.out.println("Seat already booked, please select a different seat and try again!!");
            return;
        }

    }

    private void createMovies()
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

    public void createTheatres()
    {
        Theatre inorbitTheatre = createSingleTheatre(101, City.HYDERABAD, "Gachibowli");
        Theatre ambTheatre = createSingleTheatre(102, City.HYDERABAD, "Kondapur");
        Theatre phoenixCityMallTheatre = createSingleTheatre(201, City.BANGALORE, "Whitefield");
        Theatre delhiTheatre = createSingleTheatre(301, City.DELHI, "Gurgaon");


        theatreController.addTheatre(inorbitTheatre, City.HYDERABAD);
        theatreController.addTheatre(ambTheatre, City.HYDERABAD);
        theatreController.addTheatre(phoenixCityMallTheatre, City.BANGALORE);
        theatreController.addTheatre(delhiTheatre, City.DELHI);
    }

    public Theatre createSingleTheatre(int theatreId, City city, String streetName){
        Theatre theatre = new Theatre();
        List<Screen> screenList = createScreenList();
        theatre.setTheatreId(theatreId);
        theatre.setAddress(new Address(city, streetName));
        theatre.setScreenList(screenList);
        theatre.setShowList(createShowList(screenList));

        return theatre;
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
            Seat seat = new Seat(i, "A", SeatCategory.GOLD, 275);
            seatsList.add(seat);
        }
        for(int i=10; i<=20; i++) {
            Seat seat = new Seat(i, "B", SeatCategory.PLATINUM, 300);
            seatsList.add(seat);
        }
        for(int i=21; i<=30; i++) {
            Seat seat = new Seat(i, "C", SeatCategory.SILVER, 250);
            seatsList.add(seat);
        }

        return seatsList;
    }
}
