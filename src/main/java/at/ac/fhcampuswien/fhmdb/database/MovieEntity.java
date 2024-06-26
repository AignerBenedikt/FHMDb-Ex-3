package at.ac.fhcampuswien.fhmdb.database;

import java.util.ArrayList;
import java.util.List;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "movies")
public class MovieEntity {
    @DatabaseField(generatedId = true)
    private long dbId;
    @DatabaseField
    private String id;
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

    public MovieEntity(Movie m) {
        id = m.getId();
        title = m.getTitle();
        description = m.getDescription();
        genres = genresToString(m.getGenres());
        releaseYear = m.getReleaseYear();
        imgUrl = m.getImgUrl();
        lengthInMinutes = m.getLengthInMinutes();
        rating = m.getRating();
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getGenres() {
        return genres;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public int getLengthInMinutes() {
        return lengthInMinutes;
    }
    public double getRating() {
        return rating;
    }

    private String genresToString(List<Genre> genres) {
        return String.join(",",genres.toString());
    }

    public static List<MovieEntity> fromMovies(List<Movie> movies) {
        List<MovieEntity> movieEntities = new ArrayList<>();
        for (Movie m : movies) movieEntities.add(new MovieEntity(m));

        return movieEntities;
    }

    public static List<Movie> toMovies(List<MovieEntity> movieEntities) {
        List<Movie> movies = new ArrayList<>();
        for(MovieEntity m : movieEntities) movies.add(new Movie(m));
        return movies;
    }

}
