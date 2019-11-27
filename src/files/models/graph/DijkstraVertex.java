package files.models.graph;

import java.util.ArrayList;

public class DijkstraVertex{
    public String name;
    public int distance;
    public DijkstraVertex predecessor;
    public ArrayList<Edge> edges = new ArrayList<>();
    public DijkstraVertex(String name){
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
    public DijkstraVertex getPredecessor() { return predecessor; }
    public void setPredecessor(DijkstraVertex predecessor) { this.predecessor = predecessor; }


}
