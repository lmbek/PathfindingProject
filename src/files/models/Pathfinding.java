package files.models;

import files.models.graph.Edge;
import files.models.graph.Vertex;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pathfinding {


/*
    int infinity = (int)Double.POSITIVE_INFINITY;

    public Pair<Integer, Map<Vertex,Vertex>> oldDijkstra(Vertex startNode, Vertex endNode)
    {
        Map<Vertex,Vertex> predecessorMap= new HashMap<>(); // The key is a vertex, the value is the previous vertex
        Map<Vertex,Integer> distanceMap=new HashMap<>(); // The key is a vertex, the value is the shortest distance to it
        // initialize arrays
        for(Vertex vertex: graph.getVertices()) {
            distanceMap.put(vertex,infinity); // This is the nodes and their weight
            predecessorMap.put(vertex, null); // we set the vertex to be null, which is meant to be "not visited"
        }

        /////////////////////////////implement Dijkstra /////////////////////////////
        // Initialize values


        //Vertex previous = new Vertex("Start"); // Set start to previous

        Vertex previous = startNode; // Set previous to be start node
        Vertex current = null;
        Vertex next = null;

        distanceMap.put(previous,0); // Setting previous distance map to 0
        predecessorMap.put(startNode,new Vertex("Start")); // Initialize the start as "coming from previous" (which at start is start)

        ArrayList<Vertex> queue = new ArrayList<Vertex>();

        int minimum = infinity;
        int weight = infinity;

        while(predecessorMap.containsValue(null)){
            //TODO: what would happen if we start at a point, where we cant evaluate everything?
            // TODO: FIX QUEUE, Make a foreach node check after evaluating every network from the startNode
            // TODO: print a message if the system couldnt find endNode, fix the remove script
            System.out.println(previous.name+" is having the weight of: "+distanceMap.get(previous));
            System.out.println("For: " + previous.name + " {");

            for (Edge edge : previous.getEdges()) {
                if (!previous.equals(edge.getToVertex())) {
                    current = edge.getToVertex(); // Current is set to the end of the edge, if the relation arrow is pointing outwards
                    if (predecessorMap.get(current) == null) { // check if the end of the edge is null (available)
                        System.out.print("\t From: " + previous.name + " "); System.out.print("\t To: " + current.name + " ");
                        System.out.print("\t Distance: " + edge.distance); System.out.println();

                        if (weight <= distanceMap.get(current)) {
                            weight = edge.distance+distanceMap.get(previous);
                            distanceMap.put(current, weight); // Set the weight to distMap
                            System.out.println("\t " + current.name + " is now: " + weight);
                        } else {
                            predecessorMap.remove(previous); // Removing vertex
                            System.out.println("\t removed " + previous.name);
                            // we are not setting a new previous here, the reason is that we instead had a loop that runs from the other vertices.
                        }

                        if (minimum >= edge.distance) {
                            minimum = edge.distance; // Setting the minimum to be the lowest of the edge distances in this for loop
                            next = current;
                        } else if(predecessorMap.get(current)==null&&!current.equals(endNode)) {
                            queue.add(current); // This is the Queue of the other nodes, that is higher than the minimum
                        }
                    } else {
                        System.out.println("not evaluating: " + current.name);
                    }
                }
            }

            System.out.println("Queue size: "+queue.size());
            for(Vertex q : queue){
                System.out.println("In Queue-> "+q.name);
            }


            if(previous==next&&!next.equals(endNode)){

                System.out.println("We jump (queue)");

                next = queue.get(0);

                System.out.println("Jumper: i put key: "+next.name+" the value: "+predecessorMap.get(previous).name);
                predecessorMap.put(next,predecessorMap.get(previous));
                current = queue.get(0);
                previous = queue.get(0);
                queue.remove(0);

            } else {
                System.out.println("i put key: "+next.name+" the value: "+previous.name);
                predecessorMap.put(next,previous);
                previous = next;
                System.out.println("\t Minimum is: " + minimum + " So we select: " + next.name);
                System.out.println("}");
                System.out.println();

            }
        }

        return (new Pair<Integer,Map<Vertex,Vertex>> (distanceMap.get(startNode), predecessorMap));
    }
*/

}
