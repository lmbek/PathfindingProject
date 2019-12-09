package files.views;

import files.interfaces.Overlay;
import files.models.Graph;
import files.models.Shape;
import files.models.geometry.Circle;
import files.models.geometry.Text;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

// TODO: remove this.draw() from Graphic constructor, implement Environment on Graphic class and use the draw method in View or UI
public class Graphic {
    GraphicsContext graphicsContext;
    private ArrayList<Shape> environment = new ArrayList<>();
    private Graph graph;

    public Graphic(GraphicsContext graphicsContext){
        this.graphicsContext = graphicsContext;
    }

    public void setEnvironment(ArrayList<Shape> shapes){
        this.environment = shapes;
    }
    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void draw(){
        Canvas canvas = graphicsContext.getCanvas();
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Environment
        for (int i = 0; i < environment.size(); i++) {
            environment.get(i).draw(this.graphicsContext);
        }

        // Graph shapes
        ArrayList<Overlay> overlay = graph.getShapes();

        if(graph!=null&&graph.getVertices().size()>0){
            for(Overlay shape : overlay){
                shape.draw(graphicsContext);
            }
        }
    }
}
