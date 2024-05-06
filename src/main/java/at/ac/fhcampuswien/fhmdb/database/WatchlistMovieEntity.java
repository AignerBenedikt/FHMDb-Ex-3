package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "watchlist_movies")
public class WatchlistMovieEntity {
    @DatabaseField(id = true)
    public String apiId; // Assuming apiId is the ID of the movie in the external API

    @DatabaseField
    private long id;

    public String getApiId() {
        return apiId;
    }

    public long getId() {
        return id;
    }

    public void setApiId(String id) {
    }
    public WatchlistMovieEntity(){}
    public WatchlistMovieEntity(String apiId, long id) {
        this.apiId = apiId;
        this.id = id;
    }
}
