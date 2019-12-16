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

    }

    public ArrayList<Vertex> start(Graph graph, Vertex startNode, Vertex endNode) {

        TreeSet<Vertex> openTreeSet = new TreeSet<>(Comparator.comparingDouble(Vertex::getF));
        ArrayList<Vertex> closedList = new ArrayList<>();

        for (Vertex vertex : graph.getVertices()) {
            vertex.setDistance(infinity);
            vertex.setPredecessor(null);
        }

        startNode.setDistance(0);
        startNode.setF(startNode.distance + heuristic(startNode, endNode));
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
                    /*
                    if (successorF < successor.f) {
                    closedList.remove(successor);
                    System.out.println("reinserted on open:  " + successor.name);
                    openTreeSet.add(successor);
                    }
                    */
                } else {
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
        double deltaX =  Math.abs(start.getX() - end.getX());
        double deltaY =  Math.abs(start.getY() - end.getY());
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        //return 9-dist;
    }

    public ArrayList<Vertex> getResult() {
        return result;
    }
}
