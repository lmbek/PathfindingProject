package files.models;
import files.interfaces.Overlay;
import files.models.geometry.Circle;
import files.models.geometry.Line2D;
import files.models.geometry.Point;
import files.models.geometry.Text;
import files.models.graph.Edge;
import files.models.graph.Vertex;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices = new ArrayList<>();
    private ArrayList<Overlay> shapes = new ArrayList<>();
    private String type;
    private int waypointSize = 40;

    public Graph(String type, Environment environment){
        this.type = type;
        switch(type){
            case "waypoint":
                waypointGraph(environment);
                break;
            case "navmesh":
                navMeshGraph(environment);
                break;
            default:
                System.err.println("Graph type doesn't exist");
                System.exit(0);
            break;
        }
    }

    public void waypointGraph(Environment environment){
        // TODO: lets start with this first
        int id = 0;

        while (vertices.size()<waypointSize){
            boolean creatable = true;
            double x = Math.round(10+Math.random() * (760));
            double y = Math.round(10+Math.random() * (560));

            for(Vertex vertex : vertices){ // check environment
                if(50>Math.sqrt(Math.pow(vertex.getX() - x, 2) + Math.pow(vertex.getY() - y, 2))){
                    creatable = false;
                }
            }

            for(Shape object : environment.getShapes()){ // check environment
                if(object.isColliding(new Point(x,y))){
                    creatable = false;
                }
            }
            if(creatable){
                // if the nodes is not inside unallowed terrain
                Vertex vertex = addVertex(""+id,x,y);
                shapes.add(vertex);
                id += 1;
            }
        }

        for(int i = 0; i<vertices.size(); i++){
            for(int j = 0; j<vertices.size(); j++){
                boolean creatableRelation = true;
                if(i!=j){
                    Vertex start = vertices.get(i);
                    Vertex end = vertices.get(j);
                    Line2D line = new Line2D(new Point(start.getX(),start.getY()),new Point(end.getX(),end.getY()));
                    for(Shape object : environment.getShapes()){
                        for(Line2D obstacleLine : object.getLines()){
                            if(line.isIntersecting(obstacleLine)){
                                creatableRelation = false;
                            }
                        }
                    }
                    // if we have creatable Relation, lets add it
                    if(creatableRelation){
                        double distance = 5;
                        newEdge(start,end, distance,  3); // from, to, distance, time
                    }
                }
            }
        }

    }

    public void navMeshGraph(Environment environment){
        // TODO: Lets take this second
        //for(){

        //}
    }

    public void recalculate(Environment environment){
        vertices.clear();
        shapes.clear();

        switch (type){
            case "waypoint":
                waypointGraph(environment);
                break;
            case "navmesh":
                navMeshGraph(environment);
                break;
        }
    }

    public Vertex addVertex(String name, double x, double y) {
        Vertex newVertex = new Vertex(name,x,y);
        vertices.add(newVertex);
        return newVertex;
    }

    public Vertex getVertex(String name) {
        for(Vertex vertex : vertices) {
            if (vertex.name == name){
                return vertex;
            }
        }
        return null;
    }

    public Edge newEdge(Vertex from, Vertex to, double distance, double time) {
        Edge edge = new Edge(from,to);
        edge.distance = distance;
        edge.time = time;
        return edge;
    }

    public ArrayList<Vertex> getVertices(){
        return vertices;
    }

    public ArrayList<Overlay> getShapes() {
        return shapes;
    }
}

