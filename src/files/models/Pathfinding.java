package files.models;

import files.models.graph.Vertex;

import java.util.ArrayList;

public class Pathfinding {
    private ArrayList<Vertex> result;
    private String algorithm;
    public String state = "unset";
    private Vertex start;
    private Vertex end;

    public Pathfinding(String algorithm, Graph graph){
        this.algorithm = algorithm;
        run(graph);
    }

    public void run (Graph graph){
        if(start!=null&&end!=null){
            if(algorithm.equals("Dijkstra")){
                Dijkstra dijkstra = new Dijkstra(graph);
                dijkstra.start(graph,start,end);
                //dijkstra.start(graph,graph.getVertices().get(0),graph.getVertices().get(graph.getVertices().size()-1));
                ArrayList<Vertex> result = dijkstra.getResult();
                System.out.print("path is ");
                for(Vertex vertex : result){
                    System.out.print("->"+ vertex.name);
                }
                System.out.println();
                this.result = result;

            } else if(algorithm.equals("A*")) {
                AStar aStar = new AStar(graph);
                aStar.start(graph, start,end);
                //aStar.start(graph, graph.getVertices().get(0),graph.getVertices().get(graph.getVertices().size()-1));
                ArrayList<Vertex> result = aStar.getResult();
                for(Vertex vertex : result){
                    System.out.print("->"+ vertex.name);
                }
                System.out.println();
                this.result = result;
            }
        } else {
            this.result = null;
        }
    }

    public ArrayList<Vertex> getResult() {
        return result;
    }

    public Vertex getStart() {
        return start;
    }

    public void setStart(Vertex start) {
        this.start = start;
    }

    public Vertex getEnd() {
        return end;
    }

    public void setEnd(Vertex end) {
        this.end = end;
    }
}
