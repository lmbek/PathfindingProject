package files;

import files.models.Environment;
import files.models.Graph;
import files.models.Pathfinding;

/**
 * The model takes data (from database and files etc)
 * It also handles logic and algorithms such as path finding
 */
public class Model {
    private static boolean created = false;
    private Graph graph;
    private Environment environment;
    private Pathfinding pathfinding;

    public Model(){
        this.onlyOneInstance(); // Limit to only 1 instance of the Model class
    }

    private void onlyOneInstance (){
        if (created) {
            System.err.println("You can only create one instance of the Model class");
            System.exit(0);
        } else {
            created = true;
            System.out.println("Model Created");
        }
    }

    public Graph getGraph() {
        return graph;
    }
    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public Pathfinding getPathfinding() {
        return pathfinding;
    }
    public void setPathfinding(String algorithm) {
        pathfinding = new Pathfinding(graph);
    }

    public void setGraphEnvironment(String algorithm){
        if(algorithm.equals("NavMesh")){
            environment = new Environment();
            environment.setMaxSize(150);
            graph = new Graph("navmesh",environment);
        } else if(algorithm.equals("WayPoint")){
            environment = new Environment();
            environment.setMaxSize(150);
            graph = new Graph("waypoint",environment);
        }



    }
}
