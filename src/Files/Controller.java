package Files;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

// Application setup and main file (start of program)
// Model View Controller Design Pattern
// This is the Main file (renamed to Controller)
// The controller manages the interaction between input, model, logic and view.
public class Controller extends Application {

    private boolean fullScreen;
    private Model model;
    private View view;

    public static void main(String[] args) {
        launch(args);
    }

    // Initialize Application Scene
    @Override public void start(Stage stage) {
        // Model - Data and Logic (Calculations and pathfinding)
        this.model = new Model();
        // View - Graphics and UI - Root node of Application
        this.view = new View(stage);
        this.view.show();
        stage.show();
        addEventListener(view.UI.generatorButton);
        addKeyListener(view.UI.generatorButton);
    }

    public void addEventListener(Node node){
        node.setOnMouseClicked( event-> {
            System.out.println("fullscreen "+fullScreen);
            fullScreen = !fullScreen;
            this.view.setMaximized(fullScreen);
        });
    }

    public void addKeyListener(Node node){
        node.setOnKeyPressed(event -> {
            System.out.println(event.getCode());
            if(event.getCode().equals(KeyCode.ENTER)) {
                // do something
                System.out.println("You Pressed Enter");
            }
        });
    }
}
