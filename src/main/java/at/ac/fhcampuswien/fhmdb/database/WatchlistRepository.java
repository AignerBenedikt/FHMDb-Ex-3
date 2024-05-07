package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.models.Movie;
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

    //public int addToWatchlist(WatchlistMovieEntity movie) throws SQLException {
    //  return watchlistDao.create(movieToWatchlist(movie));
    //}
    //public int removeFromWatchlist(String apiId) throws SQLException {
    //}
    //private WatchlistMovieEntity movieToWatchlist(WatchlistMovieEntity movie){
    //}

    private WatchlistMovieEntity movieFromWatchlist(Long id, String apiId){
        return new WatchlistMovieEntity(id, apiId);
    }
}
