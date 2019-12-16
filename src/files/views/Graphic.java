package files.views;

import files.interfaces.Overlay;
import files.models.Graph;
import files.models.Shape;
import files.models.geometry.Line2D;
import files.models.geometry.Point;
import files.models.geometry.Rectangle2D;
import files.models.graph.Vertex;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

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
        Canvas canvas = this.graphicsContext.getCanvas();
        this.graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Environment
        for (int i = 0; i < environment.size(); i++) {
            environment.get(i).draw(this.graphicsContext);
        }

        // Graph shapes
        ArrayList<Overlay> overlay = graph.getShapes();

        if(graph!=null&&graph.getVertices().size()>0){ //TODO: is these checks neccesary?
            for(Overlay shape : overlay){
                shape.drawEdges(this.graphicsContext);
            }

            for(Overlay shape : overlay){
                shape.draw(this.graphicsContext);
            }
        }

        // Print the path
        if(resultPath!=null){
            for(int i=0; i<resultPath.size()-1; i++){
                Point from = new Point(resultPath.get(i).getX(),resultPath.get(i).getY());
                Point to = new Point(resultPath.get(i+1).getX(),resultPath.get(i+1).getY());
                Line2D line = new Line2D(from,to,Color.GREEN,5);

                line.draw(this.graphicsContext);
            }
        }

    }
}
