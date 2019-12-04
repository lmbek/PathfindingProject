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

        for(Vertex v : result) {
            System.out.print( v.name + " Dist:" + v.distance + " ");
            if (v!=endNode)
                System.out.print("-> ");
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

    public ArrayList<Vertex> aStar(Vertex startNode, Vertex endNode) {

        TreeSet<Vertex> openTreeSet = new TreeSet<>(Comparator.comparingLong(Vertex::getF));
        ArrayList<Vertex> closedList = new ArrayList<>();

        for (Vertex vertex : graph.getVertices()) {
            vertex.setDistance(infinity);
            vertex.setPredecessor(null);
            //vertex.setHeuristic(endNode);
        }

        startNode.setDistance(0);
        openTreeSet.add(startNode);
        Vertex current;

        while (openTreeSet.size() != 0) {
            current = openTreeSet.first();
            System.out.println(openTreeSet.first().f);
            openTreeSet.remove(current);

            if (current == endNode){
                System.out.println("solution found " + current.name + current.predecessor.name);
                break;
            }


            for (Edge edge : current.edges){

                Vertex successor = edge.getToVertex();
                int successorG = current.distance + edge.distance;
                long successorH = heuristic(current.distance,endNode);
                long successorF = successorG + successorH;

                if (openTreeSet.contains(successor) && successorF < successor.f){
                    System.out.println(successor.name + " " + successorF);
                    successor.setPredecessor(current);
                    successor.setDistance(successorG);
                    successor.setF(successorF);
                    openTreeSet.remove(successor);
                    openTreeSet.add(successor);
                }
                else if (closedList.contains(successor) && successorF < successor.f){
                    closedList.remove(successor);
                    openTreeSet.add(successor);
                }
                else {
                    System.out.println("added:  " + successor.name);
                    successor.setPredecessor(current);
                    successor.setDistance(successorG);
                    successor.setF(successorF);
                    openTreeSet.add(successor);
                }
                System.out.println("evaluated: " + edge.getFromVertex().name
                + "  going to: " + edge.getToVertex().name
                + "  fValue: " + successorF
                + "  removed: " +current.name);
            }
            closedList.add(current);
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

    public long heuristic(int dist, Vertex endNode) {
        //return sqrt(pow(endNode.x - current.x, 2) + pow(endNode.y - current.y, 2));
        return 9-dist;
    }
}
