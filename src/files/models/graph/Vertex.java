package files.models.graph;

import java.util.ArrayList;

public class Vertex {
    public String name;
    public ArrayList<Edge> edges = new ArrayList<>();
    public Vertex(String name){
        this.name = name;
    }
    public void addEdge(Edge edge){
        edges.add(edge);
    }
    public ArrayList<Edge> getEdges(){
        return edges;
    }
}
