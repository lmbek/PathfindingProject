package files.models;

import files.models.graph.Vertex;

import java.util.ArrayList;

public class Pathfinding {
    private ArrayList<Vertex> result;
    String fastOrPrecise = "fast";

    public Pathfinding(Graph graph){
        run(graph);
    }

    public void run (Graph graph){
        if(fastOrPrecise.equals("precise")){
            Dijkstra dijkstra = new Dijkstra(graph);
            //dijkstra.start(graph,new Vertex("start",0,0),new Vertex("end",800,600)); // PLEZ EMIL xD give me the option to do dis
            dijkstra.start(graph,graph.getVertices().get(0),graph.getVertices().get(graph.getVertices().size()-1)); // PLEZ EMIL xD give me the option to do dis
            ArrayList<Vertex> result = dijkstra.getResult();
            System.out.print("path is ");
            for(Vertex vertex : result){
                System.out.print("->"+ vertex.name);
            }
            System.out.println();
            this.result = result;

        } else if(fastOrPrecise.equals("fast")) {
            AStar aStar = new AStar(graph);
            aStar.start(graph, graph.getVertices().get(0),graph.getVertices().get(graph.getVertices().size()-1));
            ArrayList<Vertex> result = aStar.getResult();
            this.result = result;
            // TODO: add result so we can print the line
        }
    }

    public ArrayList<Vertex> getResult() {
        return result;
    }
}
