package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.database.DatabaseManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class FhmdbApplication extends Application {

    public static Stage stage;
    public static Scene homeScene;
    public static Scene watchlistScene;

    @Override
    public void start(Stage primaryStage) throws IOException {

        stage = primaryStage;

        FXMLLoader homeLoader = new FXMLLoader(FhmdbApplication.class.getResource("home-view.fxml"));
        homeScene = new Scene(homeLoader.load(), 890, 620);
        homeScene.getStylesheets().add(Objects.requireNonNull(FhmdbApplication.class.getResource("styles.css")).toExternalForm());

        FXMLLoader watchlistLoader = new FXMLLoader(FhmdbApplication.class.getResource("watchlist-view.fxml"));
        watchlistScene = new Scene(watchlistLoader.load(), 890, 620);
        watchlistScene.getStylesheets().add(Objects.requireNonNull(FhmdbApplication.class.getResource("styles.css")).toExternalForm());

        stage.setTitle("FHMDb!");
        stage.setScene(homeScene);
        stage.show();

        /*try {
            DatabaseManager.getInstance().testDBM();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public Scene getHomeScene() {
        return homeScene;
    }
    public Scene getWatchlistScene() {
        return watchlistScene;
    }

    public static void main(String[] args) {
        launch();
    }
}
