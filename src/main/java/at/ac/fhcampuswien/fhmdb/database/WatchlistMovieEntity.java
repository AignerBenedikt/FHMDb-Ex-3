package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "watchlist_movies")
public class WatchlistMovieEntity {
    @DatabaseField(id = true)
    private int apiId; // Assuming apiId is the ID of the movie in the external API


}
