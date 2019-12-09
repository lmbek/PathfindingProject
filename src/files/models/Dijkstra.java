package files.models;

import files.models.graph.Edge;
import files.models.graph.Vertex;

import java.util.*;

public class Dijkstra {
    private final int infinity = (int) Double.POSITIVE_INFINITY;
    private ArrayList<Vertex> result;

    public Dijkstra(Graph graph) {

    }

    public ArrayList<Vertex> start(Graph graph, Vertex startNode, Vertex endNode) {

        TreeSet<Vertex> graphTreeSet = new TreeSet<>(Comparator.comparingDouble(Vertex::getDistance));

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

        result = Path;
        return Path;
    }

    public ArrayList<Vertex> getResult() {
        return result;
    }
}
