package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

@DatabaseTable(tableName = "moviesEntity")
public class MovieEntity {
    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField
    private String apiId;

    @DatabaseField
    private String title;

    @DatabaseField
    private String description;

    @DatabaseField
    private String genres;

    @DatabaseField
    private int releaseYear;

    @DatabaseField
    private String imgUrl;

    @DatabaseField
    private int lengthInMinutes;

    @DatabaseField
    private double rating;


    public MovieEntity(){}

    public MovieEntity(long id, String title, String description, int releaseYear, int lengthInMinutes, double rating, String genres, String imgUrl, String apiId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.lengthInMinutes = lengthInMinutes;
        this.rating = rating;
        this.genres = genres;
        this.imgUrl = imgUrl;
        this.apiId = apiId;
    }
}

