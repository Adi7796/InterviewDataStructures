package Design.LLD.BookMyShow;

import Design.LLD.BookMyShow.Enums.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityVsMoviesMap;
    List<Movie> allMoviesList;

    public Map<City, List<Movie>> getCityVsMoviesMap() {
        return cityVsMoviesMap;
    }

    public void setCityVsMoviesMap(Map<City, List<Movie>> cityVsMoviesMap) {
        this.cityVsMoviesMap = cityVsMoviesMap;
    }

    public List<Movie> getAllMoviesList() {
        return allMoviesList;
    }

    public void setAllMoviesList(List<Movie> allMoviesList) {
        this.allMoviesList = allMoviesList;
    }

    public void addMovie(Movie movie, City city)
    {
        allMoviesList.add(movie);
        List<Movie> moviesList = cityVsMoviesMap.get(city);
        if(moviesList == null){
            moviesList = new ArrayList<>();
        }
        moviesList.add(movie);
        cityVsMoviesMap.put(city, moviesList);
    }

    public Movie getMovieByMovieName(String movieName)
    {
        for(Movie movie : allMoviesList){
            if (movie.getMovieName().equals(movieName))
                return movie;
        }
        return null;
    }
}
