package Files;

import Files.Views.View;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

// Application setup and main file (start of program)
// Module View Controller Design Pattern
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override public void start(Stage stage){
        // Initialize Application Scene
        View view = new View(stage);
        view.show();
    }
}
