package at.ac.fhcampuswien.fhmdb.database;

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
}
