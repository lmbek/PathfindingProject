package files;

import files.models.Environment;
import files.models.Graph;
import files.models.Pathfinding;

/**
 * The model takes data (from database and files etc)
 * It also handles logic and algorithms such as path finding
 */
public class Model {
    private int tempVertices;
    private Graph graph;

    public Model(){
        Environment environment = new Environment();
        Pathfinding pathfinding = new Pathfinding();

        graph = new Graph(6);
        graph.graphTest(6);
    }


    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
