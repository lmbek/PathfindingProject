package files.models;

import files.models.geometry.Line2D;
import files.models.geometry.Point;
import files.models.geometry.Rectangle2D;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Environment {
    int size = 50;
    ArrayList<Shape> shapes = new ArrayList<Shape>();

    public Environment() {
        generateEnvironment();
    }

    public void generateEnvironment(){
        // clear environment
        shapes.clear();
        // Create environment
        for(int i=0; i<size; i++){
            double width = Math.round(20 + Math.random() * 80);
            double height = Math.round(20 + Math.random() * 80);
            // Set x and y after width and height, as we need to fix the location.
            double x = Math.round(10+Math.random() * (800-120));
            double y = Math.round(10+Math.random() * (600-160));
            Color backgroundColor = Color.DARKGREY;
            Color borderColor = Color.BLACK;
            int borderSize = 2;
            Rectangle2D newShape = new Rectangle2D(x, y, width, height, backgroundColor, borderColor, borderSize);

            boolean creatable = true;

            for(Shape shape : shapes) {
                for(Point point : shape.getPoints()){
                    if(newShape.isColliding(point)) { // for every points check if new shape is colliding with shape point
                        creatable = false;
                    }
                }
            }

            for(Shape shape : shapes) {
                for(Point point : newShape.getPoints()){
                    if(shape.isColliding(point)) { // for every shape points check if shape is colliding with new shape point
                        creatable = false;
                    }
                }
                for(Line2D line : shape.getLines()){
                    for(Line2D newLine : newShape.getLines()){
                        if(newLine.isIntersecting(line)) {
                            creatable = false;
                        }
                    }
                }
            }

            if(creatable){
                shapes.add(newShape);
            }
        }
    }

    public ArrayList<Shape> getShapes(){
        return shapes;
    }
}

