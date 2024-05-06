package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class MovieRepository {
    Dao<MovieEntity,Long> movieDao;

    public MovieRepository(){
        this.movieDao = DatabaseManager.getInstance().getMovieDao();
    }

    public void addToWatchlist(Movie movie) {
        MovieEntity watchlistMovie = new MovieEntity(Long.parseLong(movie.getId()),movie.getTitle(),movie.getDescription(),movie.getReleaseYear(),movie.getLengthInMinutes(),movie.getRating(),movie.getGenres().toString(),movie.getImgUrl(),movie.getApiId());
    }
}
