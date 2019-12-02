package files.models;

import files.models.graph.Edge;
import files.models.graph.Vertex;

import java.util.*;

public class Dijkstra {

    private Graph graph;

    int infinity = (int) Double.POSITIVE_INFINITY;


    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.startDijkstra();
    }

    public void startDijkstra() {
        // Create graph
        //graph = this.makeDijkstraGraph();
        graph = this.makeSmallGraphB();
        // A
        //Vertex startNode = graph.getVertex("A");
        //Vertex endNode = graph.getVertex("E");

        // B
        Vertex startNode = graph.getVertex("J");
        Vertex endNode = graph.getVertex("F");

        ArrayList<Vertex> result = dijkstra(startNode, endNode);

        for(Vertex v : result) {
            System.out.print( v.name + " Dist:" + v.distance + " ");
            if (v!=endNode)
                System.out.print("-> ");
        }

    }


    public Graph makeSmallGraphB() {
        Graph myGraph = new Graph();
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

        myGraph.newEdge(A, B, 10, 0);
        myGraph.newEdge(A, D, 20, 0);
        myGraph.newEdge(A, E, 20, 0);
        myGraph.newEdge(A, F, 5, 0);
        myGraph.newEdge(A, G, 15, 0);
        myGraph.newEdge(B, C, 7, 0);
        myGraph.newEdge(B, D, 10, 0);
        myGraph.newEdge(C, B, 15, 0);
        myGraph.newEdge(C, D, 5, 0);
        myGraph.newEdge(D, E, 10, 0);
        myGraph.newEdge(E, F, 5, 0);
        myGraph.newEdge(G, F, 10, 0);
        myGraph.newEdge(H, A, 5, 0);
        myGraph.newEdge(H, B, 20, 0);
        myGraph.newEdge(H, G, 5, 0);
        myGraph.newEdge(I, B, 15, 0);
        myGraph.newEdge(I, H, 20, 0);
        myGraph.newEdge(I, J, 10, 0);
        myGraph.newEdge(J, B, 5, 0);
        myGraph.newEdge(J, C, 15, 0);

        return myGraph;
    }

////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////// TODO: Implement new dijkstra 25-11-2019 //////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<Vertex> dijkstra(Vertex startNode, Vertex endNode) {

        TreeSet<Vertex> graphTreeSet = new TreeSet<>(Comparator.comparingInt(Vertex::getDistance));

        for (Vertex vertex : graph.getVertices()) {
            vertex.setDistance(infinity);
            vertex.setPredecessor(null);
        }
        startNode.setDistance(0);
        graphTreeSet.addAll(graph.getVertices());
        Vertex current;

        while (graphTreeSet.size() != 0) {
            current = graphTreeSet.first();
            System.out.println("  CURRENT:  " + current.name);

            for (Edge edge : current.edges) {

                if (current.distance != infinity && edge.distance + current.distance < edge.getToVertex().distance) {
                    edge.getToVertex().setDistance(edge.distance + current.distance);
                    edge.getToVertex().setPredecessor(current);
                    graphTreeSet.remove(edge.getToVertex());
                    graphTreeSet.add(edge.getToVertex());
                }

                System.out.println("Evaluating:  " + edge.getFromVertex().name + "  ->  " + edge.getToVertex().name
                        + "  dist:  " + edge.getToVertex().distance);
            }

            graphTreeSet.remove(current);
            System.out.println("removed:  " +current.name);
        }

        Vertex resultCurrent = endNode;
        ArrayList<Vertex> Path= new ArrayList<>();
        Path.add(endNode);

        while ((resultCurrent != startNode) && (resultCurrent.predecessor != null)) {
            resultCurrent = resultCurrent.predecessor;
            Path.add(0,resultCurrent);
        }
        return Path;
    }
}
