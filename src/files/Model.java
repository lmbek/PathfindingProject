package files;

import files.models.Environment;
import files.models.Pathfinding;

import java.util.stream.Stream;

/**
 * The model takes data (from database and files etc)
 * It also handles logic and algorithms such as path finding
 */
public class Model {
    public Model(){
        Environment environment = new Environment();
        Pathfinding pathfinding = new Pathfinding();
    }
}
