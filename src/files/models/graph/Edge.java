package files.models.graph;

import files.models.geometry.Line2D;
import files.models.graph.Vertex;

public class Edge {
    private Vertex from;
    private Vertex to;
    public double distance=0;
    public double time=0;

    public Vertex getToVertex() {
        return this.to;
    }
    public Vertex getFromVertex() {
        return this.from;
    }

    public Edge(Vertex from, Vertex to){
        this.from=from;
        this.to=to;
        this.from.addEdge(this);
        this.to.addEdge(this); //If not directional
    }
}
