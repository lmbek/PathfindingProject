package files.views;

import files.View;
import files.views.userInterface.GeneratorButton;
import files.views.userInterface.Graphic;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
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
        System.out.println((int)Math.round(stage.getWidth()));
        Canvas canvas = new Canvas(800, 600);

        // Get the graphics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Graphic graphic = new Graphic(gc);
        graphic.draw();

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
