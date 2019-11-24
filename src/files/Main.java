package files;

import javafx.application.Application;
import javafx.stage.Stage;

// Application setup and main file (start of program)
// Model View Controller Design Pattern
// This is the Main file (renamed to Controller)
// The controller manages the interaction between input, model, logic and view.

// Model - Data and Logic (Calculations and Path Finding)
// View - Graphics and UI - Root node of Application
// Controller - Communicates with the model and view (Servant)
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // Initialize Application Scene
    @Override public void start(Stage stage) {
        new Controller(new Model(), new View(stage));
        stage.show();
        // comment test
    }
}
