package Files;

import Files.Controllers.Controller;
import Files.Models.Model;
import Files.Views.View;
import javafx.application.Application;
import javafx.stage.Stage;

// Application setup and main file (start of program)
// Module View Controller Design Pattern
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override public void start(Stage stage){
        // Initialize Application Scene
        Controller controller = new Controller(stage);
    }
}
