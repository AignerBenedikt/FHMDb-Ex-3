package at.ac.fhcampuswien.fhmdb;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WatchlistController {
    @FXML
    public JFXButton homeBtn;

    private final Stage stage = FhmdbApplication.stage;

    public JFXListView movieListView;

    public void homeBtnClicked(ActionEvent event) {
        if (stage != null) {
            FhmdbApplication app = new FhmdbApplication();
            Scene homeScene = app.getHomeScene();
            stage.setScene(homeScene);
        }
    }
}
