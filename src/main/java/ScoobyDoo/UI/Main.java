package ScoobyDoo.UI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for ScoobyDoo using FXML.
 */
public class Main extends Application {

    private final ScoobyDoo scoobyDoo = new ScoobyDoo("data/tasks.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setTitle("ScoobyDoo");
            stage.setMinHeight(220);
            stage.setMinWidth(417);
            fxmlLoader.<MainWindow>getController().setScoobyDoo(scoobyDoo);  // inject the ScoobyDoo instance
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}