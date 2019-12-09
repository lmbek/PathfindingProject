package files.views;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

import java.util.ArrayList;

public class UserInterface extends Group {
    private GeneratorButton generatorButton;
    private final ArrayList<Node> eventNodes = new ArrayList<>();
    private Node fxml;
    private Graphic graphic;

    private Canvas canvas;
    private Button button;

    public UserInterface(Node fxml) {
        this.fxml = fxml;
        convertFXMLToNodes();
        initCanvas();
    }

    private void convertFXMLToNodes(){
        try {
            ScrollPane scrollPane = (ScrollPane) this.fxml.lookup("#scrollPane");
            this.canvas = (Canvas)scrollPane.getContent();
            canvas.setWidth(scrollPane.getMaxWidth()-15);
            canvas.setHeight(scrollPane.getMaxHeight()-15);
            button = (Button) this.fxml.lookup("#button");
            eventNodes.add(canvas);
            eventNodes.add(button);
        } catch(Exception exception){
            System.err.println("Couldnt convert FXML to Nodes. Check if Type is correct.");
            System.exit(0);
        }
    }

    public ArrayList<Node> getEventNodes(){
        return eventNodes;
    }

    public void initCanvas(){
        GraphicsContext gc = canvas.getGraphicsContext2D(); // Get the graphics context of the canvas
        graphic = new Graphic(gc); // Send the graphics context to the graphics
    }

    public Graphic getGraphic() {
        return graphic;
    }
}
