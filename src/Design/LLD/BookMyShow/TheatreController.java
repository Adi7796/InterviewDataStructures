package Design.LLD.BookMyShow;

import Design.LLD.BookMyShow.Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

    Map<City, List<Theatre>> cityVsTheatreList;
    List<Theatre> allTheatresList;

    public TheatreController()
    {
        cityVsTheatreList = new HashMap<>();
        allTheatresList = new ArrayList<>();
    }

    public Map<City, List<Theatre>> getCityVsTheatreList() {
        return cityVsTheatreList;
    }

    public void setCityVsTheatreList(Map<City, List<Theatre>> cityVsTheatreList) {
        this.cityVsTheatreList = cityVsTheatreList;
    }

    public List<Theatre> getAllTheatresList() {
        return allTheatresList;
    }

    public void setAllTheatresList(List<Theatre> allTheatresList) {
        this.allTheatresList = allTheatresList;
    }

    public void addTheatre(Theatre theatre, City city)
    {
        allTheatresList.add(theatre);
        List<Theatre> theatreList = cityVsTheatreList.get(city);
        if(theatreList == null){
            theatreList = new ArrayList<>();
        }
        theatreList.add(theatre);
        cityVsTheatreList.put(city, theatreList);
    }

    public Map<Theatre, List<Show>> getAllShows(Movie movie, City city)
    {
        Map<Theatre, List<Show>> theatreVsShow = new HashMap<>();

        // get all theatres for this city
        List<Theatre> theatreList = cityVsTheatreList.get(city);

        for(Theatre theatre : theatreList)
        {
            // get all the shows in this theatre
            List<Show> giveMovieShows = new ArrayList<>();
            List<Show> showList = theatre.getShowList();
            for(Show show : showList)
            {
                // if the movie in the show matches the user movie
                // add it to the list of shows for this theatre
                if(show.getMovie().getMovieId() == movie.getMovieId())
                {
                    giveMovieShows.add(show);
                }
            }
            // add the showlist for this theatre
            if(!giveMovieShows.isEmpty()){
                theatreVsShow.put(theatre, giveMovieShows);
            }
        }

        return theatreVsShow;
    }
}
