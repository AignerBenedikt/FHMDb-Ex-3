package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class MovieRepository {
    private final Dao<MovieEntity, Long > movieDao;

    public MovieRepository() throws SQLException {
        ConnectionSource connectionSource = DatabaseManager.getConnectionSource();
        this.movieDao = DaoManager.createDao(connectionSource, MovieEntity.class);
    }

    public List<MovieEntity> getAllMovies() throws SQLException {
        return movieDao.queryForAll();
    }

    public void deleteAllMovies() throws SQLException {
        movieDao.deleteBuilder().delete();
    }

}
