package Files;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

// Module View Controller
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override public void start(Stage stage){
        // Initialize Application Scene
        stage.setTitle("Pathfinding Project");
        Group group = new Group();
        stage.setScene(new Scene(group,400,300));
        stage.setMaximized(true);
        stage.show();
    }
}
