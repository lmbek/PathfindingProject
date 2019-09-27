package files.views;

import files.View;
import files.views.userInterface.GeneratorButton;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;


public class UserInterface extends Group {
    private GeneratorButton generatorButton;
    private final ArrayList<Node> eventNodes = new ArrayList<>();
    private Pane pane;
    private View view;

    public UserInterface(View view) {
        this.view = view;
        pane = new Pane();
        pane.setStyle("-fx-background-color: lightblue");
        this.getChildren().add(pane);

        addCanvas();
        addGeneratorButton();
        addText();
    }

    public ArrayList<Node> getEventNodes(){
        return eventNodes;
    }

    private void addCanvas(){
        Stage stage = this.view.getStage();

        System.out.println(stage.getWidth());
        // Create the Canvas
        System.out.println((int)Math.round(stage.getWidth()));
        Canvas canvas = new Canvas(stage.getWidth(), stage.getHeight());
        //Canvas canvas = new Canvas(300, 300);

        // Set the width of the Canvas

        // Set the height of the Canvas
        canvas.setHeight(200);

        // Get the graphics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Draw a Text
        gc.strokeText("Hello Canvas", 150, 100);

        pane.getChildren().add(canvas);
    }

    private void addGeneratorButton(){
        generatorButton = new GeneratorButton();
        generatorButton.setText("Toggle Fullscreen");
        eventNodes.add(generatorButton);
        pane.getChildren().add(generatorButton);
    }

    private void addText(){
        Text text = new Text(100,120,"Hello");
        text.setFont(Font.font("Verdana", 42));
        pane.getChildren().add(text);
    }
}
