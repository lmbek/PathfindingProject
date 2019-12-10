package files.models;

import files.models.graph.Edge;
import files.models.graph.Vertex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class AStar {
    private Graph graph;
    private final int infinity = (int) Double.POSITIVE_INFINITY;
    private ArrayList<Vertex> result;

    public AStar(Graph graph) {

        //graph = this.makeSmallGraphA();
        /*
        // Create graph
        //graph = this.makeDijkstraGraph();
        graph = this.makeSmallGraphB();
        // A
        //Vertex startNode = graph.getVertex("A");
        //Vertex endNode = graph.getVertex("E");

        // B
        Vertex startNode = graph.getVertex("J");
        Vertex endNode = graph.getVertex("F");

        ArrayList<Vertex> result = aStar(startNode, endNode);

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
        myGraph.newEdge(B, C, 5, 0);
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
*/
        // A
        //Vertex startNode = graph.getVertex("A");
        //Vertex endNode = graph.getVertex("E");

        // B
        //Vertex startNode = graph.getVertex("J");
        //Vertex endNode = graph.getVertex("F");

        //ArrayList<Vertex> result = start(graph, startNode, endNode);

        //for(Vertex v : result) {
        //    System.out.print( v.name + " Dist:" + v.distance + " ");
        //    if (v!=endNode)
        //        System.out.print("-> ");
        //}


    }

    public Graph makeSmallGraphA() {
        // TODO: take this graph
        /*
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

         */ return null;
    }


    public ArrayList<Vertex> start(Graph graph, Vertex startNode, Vertex endNode) {

        TreeSet<Vertex> openTreeSet = new TreeSet<>(Comparator.comparingDouble(Vertex::getF));
        ArrayList<Vertex> closedList = new ArrayList<>();

        for (Vertex vertex : graph.getVertices()) {
            vertex.setDistance(infinity);
            vertex.setPredecessor(null);
        }

        startNode.setDistance(0);
        startNode.setF(startNode.distance + heuristic(startNode, endNode)); // TODO: temporary...?
        openTreeSet.add(startNode);
        Vertex current;

        int counter = 0;

        loop:
        while (openTreeSet.size() != 0) {
            current = openTreeSet.first();

/*
            if (current == endNode){
                System.out.println("solution found " + current.name + "  " + current.predecessor.name);
                break;
            }
*/

            for (Edge edge : current.edges){

                Vertex successor = edge.getToVertex();
                double successorG = current.distance + edge.distance;
                double successorH = heuristic(successor,endNode);
                double successorF = successorG + successorH;


                if (successor == endNode){
                    successor.setPredecessor(current);
                    successor.setDistance(successorG);
                    successor.setF(successorF);
                    System.out.println("solution found ");
                    break loop;
                }


                if (openTreeSet.contains(successor)){
                    if (successorF < successor.f) {
                        openTreeSet.remove(successor);
                        successor.setDistance(successorG);
                        successor.setF(successorF);
                        successor.setPredecessor(current);
                        openTreeSet.add(successor);
                    }
                } else if (closedList.contains(successor)){
                    /*if (successorF < successor.f) {
                        closedList.remove(successor);
                        System.out.println("reinserted on open:  " + successor.name);
                        openTreeSet.add(successor);
                    }*/
                } else if (openTreeSet.first() != successor){
                    successor.setPredecessor(current);
                    successor.setDistance(successorG);
                    successor.setF(successorF);
                    openTreeSet.add(successor);
                }
                System.out.println("evaluated: " + edge.getFromVertex().name
                + "  going to: " + edge.getToVertex().name
                + "  fValue: " + successorF);
            }
            openTreeSet.remove(current);
            System.out.println("removed:  " + current.name);
            closedList.add(current);
        }

        Vertex resultCurrent = endNode;
        ArrayList<Vertex> Path= new ArrayList<>();
        Path.add(endNode);

        while ((resultCurrent != startNode) && (resultCurrent.predecessor != null)) {
            resultCurrent = resultCurrent.predecessor;
            Path.add(0,resultCurrent);

        }
        this.result = Path;
        return Path;
    }

    private double heuristic(Vertex start, Vertex end) {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2)+1);
        //return 9-dist;
    }

    public ArrayList<Vertex> getResult() {
        return result;
    }
}
