package files.views;

import files.View;
import files.views.userInterface.GeneratorButton;
import files.views.userInterface.Graphics;
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
        //stage.show();

        System.out.println(stage.getWidth() + " Canvas");
        // Create the Canvas, either values or use SetHeight/setWidth
        Canvas canvas = new Canvas();
        //Canvas canvas = new Canvas(300, 300);

        // Set the width of the Canvas
        //canvas.setWidth(400);

        // Set the height of the Canvas
        //canvas.setHeight(400);

        // Get the graphics context of the canvas
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Graphics graphics = new Graphics();
        // Draw a Text
        graphicsContext.strokeText("Hello Canvas!!", 10, 100);

        pane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-color: red;");

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
