package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class MovieRepository {
    private Dao<MovieEntity, Long> movieDao;

    public MovieRepository(Dao<MovieEntity, Long> movieDao) {
        this.movieDao = movieDao;
    }

    public List<MovieEntity> getAllMovies() throws SQLException {
        return movieDao.queryForAll();
    }

    public int removeMovie(Long movieId) throws SQLException {
        return movieDao.deleteById(movieId);
    }

    public int removeAll() throws SQLException {
        List<MovieEntity> allMovies = movieDao.queryForAll();
        return movieDao.delete(allMovies);
    }

    public MovieEntity getMovie(Long movieId) throws SQLException {
        return movieDao.queryForId(movieId);
    }

    public int addAllMovies(List<MovieEntity> movies) throws SQLException {
        return movieDao.create(movies);
    }
}
