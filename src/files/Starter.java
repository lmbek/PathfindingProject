package files;

import javafx.application.Application;
import javafx.stage.Stage;

// Application setup and main file (start of program)
// Model View Controller Design Pattern
// This is the Main file (renamed to Controller)
// The controller manages the interaction between input, model, logic and view.

// Model - Data and Logic (Calculations and Path Finding) - Can be considered as a cook
// View - Graphics and UI - Root node of Application - Can be considered as a customer
// Controller - Communicates with the model and view - Can be considered as a servant
public class Starter extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // Initialize Application Scene
    public void start(Stage stage) {
        stage.setTitle("Pathfinding Project 2019");

        // Model-View-Controller Architectural Pattern
        Model model = new Model(); // Model logic seperated from the controller and view
        View view = new View(stage); // View logic seperated from the controller and model
        Controller controller = new Controller(model,view); // Controller is dependant on the model and view

        stage.show(); // Show Stage
    }
}
