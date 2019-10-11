package files;

import files.models.Environment;
import files.models.Graph;
import files.models.Pathfinding;

/**
 * The model takes data (from database and files etc)
 * It also handles logic and algorithms such as path finding
 */
public class Model {
    int tempVertices;

    public Model(){
        Environment environment = new Environment();
        Pathfinding pathfinding = new Pathfinding();
        Graph graph = new Graph(tempVertices);

        graph.graphTest(6);
    }

}
