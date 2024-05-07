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

   /* public List<MovieEntity> getAllMovies(){

    }

    public int removeAll(){

    }

    public MovieEntity getMovie(){}

    public int addAllMovies(List<Movie> movies) throws SQLException {

    }*/
}
