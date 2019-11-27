package files.models;

import files.models.graph.DijkstraVertex;
import files.models.graph.Edge;
import files.models.graph.Vertex;
import javafx.util.Pair;

import java.util.*;

public class Dijkstra {


    private Graph graph;

    int counter = 0;

    Map<Vertex,Vertex> predecessorMap= new HashMap<>(); // The key is a vertex, the value is the previous vertex
    Map<Vertex,Integer> distanceMap=new HashMap<>(); // The key is a vertex, the value is the shortest distance to it
    int infinity = (int)Double.POSITIVE_INFINITY;
    int minimum = infinity;
    int weight = infinity;



    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.startDijkstra();
    }

    public void startDijkstra(){
        // Create graph
        graph = this.makeDijkstraGraph();
        // A
        Vertex startNode = graph.getVertex("A");
        Vertex endNode = graph.getVertex("E");

        // B
        //Vertex startNode = graph.getVertex("J");
        //Vertex endNode = graph.getVertex("F");

        Pair<Integer, Map<Vertex, Vertex>> results = dijkstra(startNode, endNode);
        Vertex current = endNode;
        ArrayList<Vertex> Path= new ArrayList<>();
        Path.add(endNode);

        /*
        while ((current != startNode) && (results.getValue().get(current)!=null)) {
            current=results.getValue().get(current);
            Path.add(0,current);
        }

        for(Vertex v : Path)
        {
            System.out.print( v.name);
            if (v!=endNode)
                System.out.print("->");
        }*/

    }

    public Graph makeDijkstraGraph() {
        Graph dijkstraGraph = new Graph();
        final Vertex A = dijkstraGraph.addVertex("A");
        final Vertex B = dijkstraGraph.addVertex("B");
        final Vertex C = dijkstraGraph.addVertex("C");
        final Vertex D = dijkstraGraph.addVertex("D");
        final Vertex E = dijkstraGraph.addVertex("E");

        dijkstraGraph.newEdge(A,B, 5,  3);
        dijkstraGraph.newEdge(A,C, 10,  3);
        dijkstraGraph.newEdge(B,C, 3,  3);
        dijkstraGraph.newEdge(B,D, 2,  3);
        dijkstraGraph.newEdge(B,E, 9,  3);
        dijkstraGraph.newEdge(C,B, 2,  3);
        dijkstraGraph.newEdge(C,E, 1,  3);
        dijkstraGraph.newEdge(D,E, 6,  3);
        dijkstraGraph.newEdge(E,D, 4,  3);

        return dijkstraGraph;
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

////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////// TODO: Implement new dijkstra 25-11-2019 //////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    public Pair<Integer, Map<Vertex,Vertex>> dijkstra(Vertex startNode, Vertex endNode) {

        TreeSet<Vertex> graphTreeSet = new TreeSet<>(Comparator.comparingInt(Vertex::getDistance));

        for(Vertex vertex: graph.getVertices()) {
            vertex.setDistance(infinity);
            vertex.setPredecessor(null);
        }
        startNode.setDistance(0);
        for(Vertex vertex: graph.getVertices()) {
            graphTreeSet.add(vertex);
            System.out.println("added ");
        }
        graphTreeSet.addAll(graph.getVertices());


        //graphTreeSet.forEach((vertex -> System.out.print(vertex.name + ": " + vertex.distance + "   |")));

        //startNode.setDistance(0);
        //graphTreeSet.add(startNode);

        graphTreeSet.forEach((vertex -> System.out.println(vertex.name + vertex.distance)));

        return null;
    }

        //////////////////////////////////////////////////////////////////////////////////////////
/*
        for(Vertex vertex: graph.getVertices()) {
            distanceMap.put(vertex,infinity); // This is the nodes and their weight
            predecessorMap.put(vertex, null); // we set the vertex to be null, which is meant to be "not visited"
        }

        Vertex from = startNode; // Set previous to be start node
        Vertex next;

        distanceMap.put(startNode,0); // Setting previous distance map to 0
        predecessorMap.put(startNode,new Vertex("Start")); // Initialize the start as "coming from previous" (which at start is start)

        while(graph.getVertices().size()!=0) {
            System.out.println(from.name + " is having the weight of: " + distanceMap.get(from));
            System.out.println("For: " + from.name + " {");
            for(Edge edge : from.getEdges()) {
                if(!edge.getToVertex().equals(from)){
                    Vertex to = edge.getToVertex();
                    System.out.print("\t From: " + from.name + " ");
                    System.out.print("\t To: " + to.name + " ");
                    System.out.print("\t Distance: " + edge.distance);
                    System.out.println();
                    weight = edge.distance+distanceMap.get(from);
                    if (weight <= distanceMap.get(to)) {
                        weight = edge.distance+distanceMap.get(from);
                        distanceMap.put(to, weight); // Set the weight to distMap
                        System.out.println("\t " + to.name + " is now: " + weight);
                    } else {
                        predecessorMap.remove(from); // Removing vertex
                        System.out.println("\t removed " + from.name);
                        // we are not setting a new previous here, the reason is that we instead had a loop that runs from the other vertices.
                    }
                }
            }

            next = findMin(from);
            System.out.println("set "+next.name+" to "+from.name);
            predecessorMap.put(next,from);
            from = next;

            if(next.equals(endNode)){
                System.out.println("this is the end node!");
                from = predecessorMap.get(null);
            }

        }

        return (new Pair<Integer,Map<Vertex,Vertex>> (distanceMap.get(startNode), predecessorMap));
    }

    private Vertex findMin(Vertex vertex) {
        Vertex closestVertex = null;
        int lowestDistance = infinity;
        for (Edge edge : vertex.getEdges()) {

            if(!edge.getToVertex().equals(vertex)){
                int distance = edge.distance;
                if (edge.distance <= lowestDistance) {
                    lowestDistance = distance;
                    closestVertex = edge.getToVertex();
                }
            }
        }
        return closestVertex;
    }
    */


}
