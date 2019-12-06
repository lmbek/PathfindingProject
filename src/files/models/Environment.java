package files.models;

import files.models.geometry.Line2D;
import files.models.geometry.Point;
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
            double width = Math.round(10 + Math.random() * 90);
            double height = Math.round(10 + Math.random() * 90);
// Set x and y after width and height, as we need to fix the location.
            double x = Math.round(Math.random() * (800-width));
            double y = Math.round(Math.random() * (600-height));
            Color backgroundColor = Color.DARKGREY;
            Color borderColor = Color.BLACK;
            int borderSize = 3;
            Rectangle2D newShape = new Rectangle2D(x, y, width, height, backgroundColor, borderColor, borderSize);

            boolean larsNotRetarded = true;

            for(Shape shape : shapes) {
                for(Point point : newShape.getPoints()){
                    if(newShape.isColliding(point)) {
                        larsNotRetarded = false;
                    }
                }
            }

            for(Shape shape : shapes) {
                for(Point point : newShape.getPoints()){
                    if(shape.isColliding(point)) {
                        larsNotRetarded = false;
                    }
                    // TODO: go into rectangle2D and make it possible to get returned lines

                }
                for(Line2D line : shape.getLines()){
                    for(Line2D newLine : newShape.getLines()){
                        if(newLine.intersects(line)) {
                            larsNotRetarded = false;
                            //System.out.println("very often");
                        } else {

                        }
                    }
                }
            }

            if(larsNotRetarded){
                shapes.add(newShape);
            } else {
                larsNotRetarded = true;
            }
        }
    }

    public ArrayList<Shape> getShapes(){
        return shapes;
    }
}

