package files.models.graph;

import files.interfaces.Overlay;
import files.models.geometry.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class Vertex extends Vector implements Overlay {
    public String name;
    public double distance;
    public Vertex predecessor;
    public ArrayList<Edge> edges = new ArrayList<>();
    public double f;

    public Vertex(String name, double x, double y){
        super(x,y);
        this.name = name;
    }
    public void addEdge(Edge edge){
        edges.add(edge);
    }
    public ArrayList<Edge> getEdges(){
        return edges;
    }
    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }
    public Vertex getPredecessor() { return predecessor; }
    public void setPredecessor(Vertex predecessor) { this.predecessor = predecessor; }
    public void setF(double f) { this.f = f; }
    public double getF() { return f; }

    @Override // This was a nasty quick fix, in order to hide the edges behind the nodes
    public void drawEdges(GraphicsContext graphicsContext) {
        for(Edge edge : edges){
            Point from = new Point(edge.getFromVertex().getX(),edge.getFromVertex().getY());
            Point to =  new Point(edge.getToVertex().getX(),edge.getToVertex().getY());

            Line2D line = new Line2D(from,to,Color.BLACK,1);
            line.draw(graphicsContext);
        }
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        Circle circle = new Circle(new Point(super.getX(),super.getY()), 20, Color.WHITE, Color.BLACK, 1);
        Text text = new Text(name, super.getX(), super.getY()+3, 8, Color.BLACK, FontWeight.NORMAL, null);
        circle.draw(graphicsContext);
        text.draw(graphicsContext);
    }
}
