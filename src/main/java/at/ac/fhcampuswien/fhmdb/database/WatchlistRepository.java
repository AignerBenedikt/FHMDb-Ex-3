package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class WatchlistRepository {
    private static Dao<WatchlistMovieEntity, Long> watchlistDao;

    public WatchlistRepository(Dao<WatchlistMovieEntity, Long> watchlistDao) {
        this.watchlistDao = watchlistDao;
    }

    public List<WatchlistMovieEntity> getWatchlist() throws SQLException {
        return watchlistDao.queryForAll();
    }

    public static int addToWatchlist(WatchlistMovieEntity movie) throws SQLException {
        // Prüfen, ob der Film bereits in der Watchlist ist
        List<WatchlistMovieEntity> existing = watchlistDao.queryForEq("apiId", movie.getId());
        if (existing.isEmpty()) {
            return watchlistDao.create(movie);
        }
        return 0;
    }

    public static int removeFromWatchlist(String apiId) throws SQLException {
        List<WatchlistMovieEntity> movies = watchlistDao.queryForEq("apiId", apiId);
        return watchlistDao.delete(movies);
    }
}
