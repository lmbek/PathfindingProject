package files.models;

import files.models.geometry.Rectangle2D;
import javafx.scene.paint.Color;

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
        for(int i=0; i<100; i++){
            //for(int j=0; j< shapes.size();j++){
            Rectangle2D rectangle = new Rectangle2D(Math.round(Math.random() * 800), Math.round(Math.random() * 600), Math.round(10+Math.random() * 90), Math.round(10+Math.random() * 90), Color.DARKGREY, Color.BLACK, 3));
                if(shapes.get(i).isColliding(rectangle.)) {
                    //shapes.add(new Rectangle2D();
                }
            //}
        }
    }

    public ArrayList<Shape> getShapes(){
        return shapes;
    }
}

