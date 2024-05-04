package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "moviesEntity")
public class MovieEntity {
    @DatabaseField(id=true, generatedId = true)
    private long id;

    @DatabaseField
    private String title;

    @DatabaseField
    private String description;

    @DatabaseField
    private int releaseYear;

    @DatabaseField
    private int lengthInMinutes;

    @DatabaseField
    private double rating;

    @DatabaseField
    private String genres;

    @DatabaseField
    private String ingUrl;

    @DatabaseField
    private String apiId;

}

