package files.models;

import files.models.graph.Edge;
import files.models.graph.Vertex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class AStar {

    private Graph graph;
    int infinity = (int) Double.POSITIVE_INFINITY;

    public static void main(String[] args) {
        AStar aStar = new AStar();
        aStar.startAStar();
    }

    public void startAStar() {
        // Create graph
        //graph = this.makeDijkstraGraph();
        graph = this.makeSmallGraphA();
        // A
        Vertex startNode = graph.getVertex("A");
        Vertex endNode = graph.getVertex("E");

        // B
        //Vertex startNode = graph.getVertex("J");
        //Vertex endNode = graph.getVertex("F");

        ArrayList<Vertex> result = aStar(startNode, endNode);

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

    public ArrayList<Vertex> aStar(Vertex startNode, Vertex endNode) {

        TreeSet<Vertex> openTreeSet = new TreeSet<>(Comparator.comparingLong(Vertex::getF));
        ArrayList<Vertex> closedList = new ArrayList<>();

        for (Vertex vertex : graph.getVertices()) {
            vertex.setDistance(200);
            vertex.setPredecessor(null);
            //vertex.setHeuristic(endNode);
        }

        startNode.setDistance(0);
        openTreeSet.add(startNode);
        Vertex current;

        loop:
        while (openTreeSet.size() != 0) {
            current = openTreeSet.first();
            System.out.println(current.name + " " + current.distance);
            openTreeSet.remove(current);

            for (Edge edge : current.edges){

                Vertex successor = edge.getToVertex();
                int successorG = current.distance + successor.distance;
                long successorH = heuristic(current,endNode);
                long successorF = successorG + successorH;

                if (successor == endNode){
                    System.out.println("solution found" + current.name + endNode.name);
                    break loop;
                }

                if (openTreeSet.contains(successor) && successorF < successor.f){
                    System.out.println(successor.name + " " + successorF);
                    successor.setPredecessor(current);
                    successor.setDistance(successorG);
                    successor.setF(successorF);
                }
                else if (closedList.contains(successor) && successorF < successor.f){
                    closedList.remove(successor);
                    openTreeSet.add(successor);
                }
                else {
                    openTreeSet.add(successor);
                    successor.setPredecessor(current);
                    successor.setDistance(successorG);
                    successor.setF(successorF);
                }
            }
            closedList.add(current);
        }

        return null;
    }

    public long heuristic(Vertex current, Vertex endNode) {
        //return sqrt((endNode.x - this.x)*(endNode.x - this.x) + (endNode.y - this.y)*(endNode.y - this.y));
        return 0;
    }
}
