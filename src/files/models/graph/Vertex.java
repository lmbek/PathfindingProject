package files.models.graph;

import java.util.ArrayList;

public class Vertex {
    public String name;
    public int distance;
    public Vertex predecessor;
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
    public int getDistance() { return distance; }
    public void setDistance(int distance) { this.distance = distance; }
    public Vertex getPredecessor() { return predecessor; }
    public void setPredecessor(Vertex predecessor) { this.predecessor = predecessor; }
}
