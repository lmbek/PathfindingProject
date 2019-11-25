package files.models.graph;

import files.models.graph.Vertex;

public class Edge {
    private Vertex from;
    private Vertex to;
    public int distance=0;
    public int time=0;

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
