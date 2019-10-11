package files.models;

import java.util.LinkedList;

public class Graph {

    int vertices;
    LinkedList<Integer> adjListArray[];

    public Graph(int vertices) {
        this.vertices = vertices;
        adjListArray = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjListArray[i] = new LinkedList<>();

        }
    }


    public void addEdge(Graph graph, int source, int destination) {
        graph.adjListArray[source].add(destination);
        graph.adjListArray[destination].add(source);
    }

    public void printGraph(Graph graph) {
        for (int v = 0; v < graph.vertices; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (Integer pCrawl : graph.adjListArray[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println();
        }
    }
    public void graphTest(int v){
        Graph graph = new Graph(v);
        // Creates and prints an adjacency list of graph
        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 0, 5);
        graph.addEdge(graph, 1, 2);
        graph.addEdge(graph, 2, 3);
        graph.addEdge(graph, 2, 4);
        graph.addEdge(graph, 3, 4);
        graph.addEdge(graph, 4, 5);

        graph.printGraph(graph);
    }

}
