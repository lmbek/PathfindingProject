package files.models;

import files.models.shapes.Rectangle2D;
import java.util.ArrayList;

public class Environment {
    ArrayList<Shape> shapes = new ArrayList<Shape>();

    public Environment() {
        addShapes();
    }

    public void generateEnvironment(){
        //TODO: Make random map generator
    }

    public void addShapes() {
        shapes.add(new Rectangle2D(50, 50, 20, 50));
        shapes.add(new Rectangle2D(350, 50, 15, 150));
    }

    public ArrayList<Shape> getShapes(){
        return shapes;
    }
}

