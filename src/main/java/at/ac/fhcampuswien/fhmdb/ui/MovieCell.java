package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.ClickEventHandler;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.util.stream.Collectors;

public class MovieCell extends ListCell<Movie> {
    private final Label title = new Label();
    private final Label detail = new Label();
    private final Label genre = new Label();
    private final JFXButton detailBtn = new JFXButton("Show Details");
    private final JFXButton watchlistBtn = new JFXButton("Watchlist");

    private final HBox buttonBox = new HBox(5, detailBtn, watchlistBtn);
    private final VBox layout = new VBox(title, detail, genre, buttonBox);
    private boolean collapsedDetails = true;
    private ClickEventHandler<Movie> addToWatchlistHandler;

    public MovieCell(ClickEventHandler<Movie> addToWatchlistHandler) {
        super();
        this.addToWatchlistHandler = addToWatchlistHandler;
        configureButtons();
        configureLayout();
    }

    private void configureButtons() {
        // Styling für die Buttons
        detailBtn.setStyle("-fx-background-color: #f5c518;");
        watchlistBtn.setStyle("-fx-background-color: #f5c518;");

        detailBtn.setOnMouseClicked(mouseEvent -> toggleDetails());
        watchlistBtn.setOnMouseClicked(mouseEvent -> {
            Movie currentMovie = getItem();
            if (currentMovie != null) {
                addToWatchlistHandler.onClick(currentMovie);
            }
        });
    }

    private void configureLayout() {
        title.getStyleClass().add("text-yellow");
        detail.getStyleClass().add("text-white");
        genre.getStyleClass().add("text-white");
        genre.setStyle("-fx-font-style: italic");

        layout.setBackground(new Background(new BackgroundFill(Color.web("#454545"), null, null)));
        layout.setPadding(new Insets(10));
        layout.setSpacing(10);
        layout.setAlignment(javafx.geometry.Pos.CENTER_LEFT);

        title.fontProperty().set(title.getFont().font(20));
        detail.setWrapText(true);
    }

    private void toggleDetails() {
        if (collapsedDetails) {
            layout.getChildren().add(getDetails());
            collapsedDetails = false;
            detailBtn.setText("Hide Details");
        } else {
            layout.getChildren().remove(4);
            collapsedDetails = true;
            detailBtn.setText("Show Details");
        }
        setGraphic(layout);
    }

    private VBox getDetails() {
        VBox details = new VBox();
        details.getChildren().addAll(
                new Label("Release Year: " + getItem().getReleaseYear()),
                new Label("Length: " + getItem().getLengthInMinutes() + " minutes"),
                new Label("Rating: " + getItem().getRating() + "/10"),
                new Label("Directors: " + String.join(", ", getItem().getDirectors())),
                new Label("Writers: " + String.join(", ", getItem().getWriters())),
                new Label("Main Cast: " + String.join(", ", getItem().getMainCast()))
        );
        details.getStyleClass().addAll("text-white");
        return details;
    }

    @Override
    protected void updateItem(Movie movie, boolean empty) {
        super.updateItem(movie, empty);
        if (empty || movie == null) {
            setGraphic(null);
            setText(null);
        } else {
            title.setText(movie.getTitle());
            detail.setText(movie.getDescription() != null ? movie.getDescription() : "No description available");
            genre.setText(movie.getGenres().stream().map(Enum::toString).collect(Collectors.joining(", ")));
            setGraphic(layout);
        }
    }
}
