package files.models;
import files.models.graph.Edge;
import files.models.graph.Vertex;
import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices = new ArrayList<>();

    public Vertex addVertex(String name) {
        Vertex newvertex = new Vertex(name);
        vertices.add(newvertex);
        return newvertex;
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public Vertex getVertex(String name) {
        for(Vertex vertex : vertices ) {
            if (vertex.name == name){
                return vertex;
            }
        }
        return null;
    }

    public void newEdge(Vertex from, Vertex to, int distance, int time) {
        Edge edge = new Edge(from,to);
        edge.distance = distance;
        edge.time = time;
    }

    public ArrayList<Vertex> getVertices(){
        return vertices;
    }
}

