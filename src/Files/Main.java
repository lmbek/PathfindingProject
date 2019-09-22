package Files;

import javafx.application.Application;
import javafx.stage.Stage;

// Application setup and main file (start of program)
// Model View Controller Design Pattern
// This is the Main file (renamed to Controller)
// The controller manages the interaction between input, model, logic and view.
public class Main extends Application {
    private Model model;
    private View view;
    private Controller controller;

    public static void main(String[] args) {
        launch(args);
    }

    // Initialize Application Scene
    @Override public void start(Stage stage) {
        this.model = new Model(); // Model - Data and Logic (Calculations and pathfinding)
        this.view = new View(stage); // View - Graphics and UI - Root node of Application
        this.controller = new Controller(this.model, this.view); // Controller - Communicates with the model and view (Servant)
        stage.show();
    }
}
