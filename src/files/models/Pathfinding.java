package files.models;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;

public class Pathfinding {

    public static void main(String[] args) {
        Pathfinding pathfinding = new Pathfinding();
        pathfinding.startDijkstra();
    }

    public void startDijkstra(){
        // Create graph
        Graph graph = this.makeSmallGraphB();
        // A
        //Vertex startNode = graph.getVertex("A");
        //Vertex endNode = graph.getVertex("E");

        // B
        Vertex startNode = graph.getVertex("J");
        Vertex endNode = graph.getVertex("F");

        Pair<Integer, Map<Vertex, Vertex>> results=graph.dijkstra(startNode, endNode);
        Vertex current =endNode;
        ArrayList<Vertex> Path= new ArrayList<>();
        Path.add(endNode);

        while ((current != startNode) && (results.getValue().get(current)!=null)) {
            current=results.getValue().get(current);
            Path.add(0,current);
        }

        for(Vertex v : Path)
        {
            System.out.print( v.name);
            if (v!=endNode)
                System.out.print("->");
        }

    }

    public Graph makeSmallGraphA() {
        Graph myGraph= new Graph();
        final Vertex A= myGraph.addVertex("A");
        final Vertex B= myGraph.addVertex("B");
        final Vertex C = myGraph.addVertex("C");
        final Vertex D = myGraph.addVertex("D");
        final Vertex E = myGraph.addVertex("E");

        myGraph.newEdge(A,B, 5,  3);
        myGraph.newEdge(A,C, 10,  3);
        myGraph.newEdge(B,C, 3,  3);
        myGraph.newEdge(B,D, 2,  3);
        myGraph.newEdge(B,E, 9,  3);
        myGraph.newEdge(C,B, 2,  3);
        myGraph.newEdge(C,E, 1,  3);
        myGraph.newEdge(D,E, 6,  3);
        myGraph.newEdge(E,D, 4,  3);

        return myGraph;
    }

    public Graph makeSmallGraphB() {
        Graph myGraph= new Graph();
        final Vertex A = myGraph.addVertex("A");
        final Vertex B = myGraph.addVertex("B");
        final Vertex C = myGraph.addVertex("C");
        final Vertex D = myGraph.addVertex("D");
        final Vertex E = myGraph.addVertex("E");
        final Vertex F = myGraph.addVertex("F");
        final Vertex G = myGraph.addVertex("G");
        final Vertex H = myGraph.addVertex("H");
        final Vertex I = myGraph.addVertex("I");
        final Vertex J = myGraph.addVertex("J");

        myGraph.newEdge(A,B,10,0);
        myGraph.newEdge(A,D,20,0);
        myGraph.newEdge(A,E,20,0);
        myGraph.newEdge(A,F,5,0);
        myGraph.newEdge(A,G,15,0);
        myGraph.newEdge(B,C,7,0);
        myGraph.newEdge(B,D,10,0);
        myGraph.newEdge(C,B,15,0);
        myGraph.newEdge(C,D,5,0);
        myGraph.newEdge(D,E,10,0);
        myGraph.newEdge(E,F,5,0);
        myGraph.newEdge(G,F,10,0);
        myGraph.newEdge(H,A,5,0);
        myGraph.newEdge(H,B,20,0);
        myGraph.newEdge(H,G,5,0);
        myGraph.newEdge(I,B,15,0);
        myGraph.newEdge(I,H,20,0);
        myGraph.newEdge(I,J,10,0);
        myGraph.newEdge(J,B,5,0);
        myGraph.newEdge(J,C,15,0);

        return myGraph;
    }

}
