package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "watchlist_movies")
public class WatchlistMovieEntity {
    @DatabaseField(generatedId = true)
    public long id;

    @DatabaseField(unique = true)
    private String apiId;

    public WatchlistMovieEntity() {
    }

    public WatchlistMovieEntity(long id, String apiId) {
        this.id = id;
        this.apiId = apiId;
    }
}
