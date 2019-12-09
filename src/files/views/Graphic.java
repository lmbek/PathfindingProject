package files.views;

import files.interfaces.Overlay;
import files.models.Graph;
import files.models.Shape;
import files.models.geometry.Circle;
import files.models.geometry.Line2D;
import files.models.geometry.Point;
import files.models.geometry.Text;
import files.models.graph.Vertex;
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
    private ArrayList<Vertex> resultPath;

    public Graphic(GraphicsContext graphicsContext){
        this.graphicsContext = graphicsContext;
    }

    public void setEnvironment(ArrayList<Shape> shapes){
        this.environment = shapes;
    }
    public void setGraph(Graph graph) {
        this.graph = graph;
    }
    public void setResultPath(ArrayList<Vertex> resultPath) {
        this.resultPath = resultPath;
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

        if(resultPath!=null){
            for(int i=0; i<resultPath.size()-1; i++){
                Point from = new Point(resultPath.get(i).getX(),resultPath.get(i).getY());
                Point to = new Point(resultPath.get(i+1).getX(),resultPath.get(i+1).getY());
                Line2D line = new Line2D(from,to);
                line.draw(graphicsContext);
            }
        }

    }
}
