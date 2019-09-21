package Files;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

// Application setup and main file (start of program)
// Module View Controller Design Pattern
// This is the Main file (renamed to Controller)
// The controller manages the interaction between input, model, logic and view.
public class Controller extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // Initialize Application Scene
    @Override public void start(Stage stage) throws Exception{
        // Model - Data and Logic (Calculations and pathfinding)
        Model model = new Model();

        // View - Graphics and UI - Root node of Application
        View view = new View(stage);


        view.show();
        view.setMaximized(false);
        addEventListener(view.UI.generatorButton);
        stage.show();
    }

    public void addEventListener(Node node){
        node.setOnMouseClicked((event)->{
            System.out.println("test");
        });
    }
}
