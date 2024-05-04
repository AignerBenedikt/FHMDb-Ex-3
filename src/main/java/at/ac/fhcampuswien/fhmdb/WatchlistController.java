package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WatchlistController implements Initializable {
    @FXML
    public JFXButton homeBtn;
    protected ObservableList<Movie> observableMovies= FXCollections.observableArrayList();

    private final Stage stage = FhmdbApplication.stage;

    public JFXListView movieListView;

    public void homeBtnClicked(ActionEvent event) {
        if (stage != null) {
            FhmdbApplication app = new FhmdbApplication();
            Scene homeScene = app.getHomeScene();
            stage.setScene(homeScene);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeState();
        initializeLayout();
    }

    public void initializeLayout() {
        movieListView.setItems(observableMovies);
        movieListView.setCellFactory(movieListView -> new MovieCell());
    }

    public void initializeState() {

    }

}
