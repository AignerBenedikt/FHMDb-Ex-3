package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseManager {
    private static final String DATABASE_URL = "jdbc:h2:file: ./db/fhmdb";
    private static final String USERNAME = "class";
    private static final String PASSWORD = "cisco";
    private static DatabaseManager instance;
    private DatabaseManager() {
        try {
            createConnectionSource();
            movieDao = DaoManager.createDao(connectionSource, MovieEntity.class);
            watchlistDao = DaoManager.createDao(connectionSource, WatchlistMovieEntity.class);
            createTables();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static DatabaseManager getInstance() {
        if(instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }
    private static ConnectionSource connectionSource;
    private Dao<MovieEntity, Long> movieDao;
    private Dao<WatchlistMovieEntity, Long> watchlistDao;
    public void testDBM() throws SQLException {
        MovieEntity movie = new MovieEntity(012, "HS", "DU HS!", 2002, 30, 6.9, "DRAMA", "ahdsjf","tt012");
        movieDao.create(movie);
        WatchlistMovieEntity watchlistMovie = new WatchlistMovieEntity("tt013",013);
        watchlistDao.create(watchlistMovie);
    }
    public Dao<MovieEntity,Long> getMovieDao() {
        return this.movieDao;
    }
    public Dao<WatchlistMovieEntity,Long> getWatchlistDao() {
        return this.watchlistDao;
    }
    private static void createTables() throws SQLException{
        TableUtils.createTableIfNotExists(connectionSource, MovieEntity.class);
        TableUtils.createTableIfNotExists(connectionSource, WatchlistMovieEntity.class);
    }

    private static void createConnectionSource() throws SQLException {
        connectionSource = new JdbcConnectionSource(DATABASE_URL, USERNAME, PASSWORD);
    }
}
