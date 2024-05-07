package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class WatchlistRepository {
    private static Dao<WatchlistMovieEntity, Long> watchlistDao;

    public WatchlistRepository() {
        watchlistDao = DatabaseManager.getInstance().getWatchlistDao();
    }

    public List<WatchlistMovieEntity> getWatchlist() throws SQLException {
        return watchlistDao.queryForAll();
    }

    public int addToWatchlist(Movie movie) throws SQLException {
      return watchlistDao.create(movieToWatchlist(movie));
    }
    public int removeFromWatchlist(String apiId) throws SQLException {
        long id = Long.parseLong(apiId);
        return watchlistDao.delete(movieFromWatchlist(id, apiId));
    }
    private WatchlistMovieEntity movieToWatchlist(Movie movie) {
        long id = Long.parseLong((movie.getId()));
        String apiId = movie.getApiId();
        return new WatchlistMovieEntity(id, apiId);
    }
    private WatchlistMovieEntity movieFromWatchlist(Long id,String apiId) {
        return new WatchlistMovieEntity(id, apiId);
    }
}
