package files.views.userInterface;

import files.views.Environment;
import files.views.environment.Circle;
import files.views.environment.Line;
import files.views.environment.Text;
import files.views.environment.Wall;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

// TODO: remove this.draw() from Graphic constructor, implement Environment on Graphic class and use the draw method in View or UI
public class Graphic {
    GraphicsContext graphicsContext;
    private ArrayList<Environment> environment = new ArrayList<Environment>();


    public Graphic(GraphicsContext graphicsContext){
        this.graphicsContext = graphicsContext;
        Wall wall = new Wall(50,50,100,100,Color.VIOLET);
        Wall wall2 = new Wall(250,40,50,150,Color.RED);
        Line line = new Line(300,500,500,500);
        Circle circle = new Circle(280, 480, 40, Color.WHITE, Color.BLACK, 1);
        Circle circle2 = new Circle(480, 480, 40, Color.WHITE, Color.BLACK, 1);
        Text text = new Text("Node "+1,  300, 450, 20, Color.BLACK, FontWeight.BOLD,null);
        Text text2 = new Text("Node "+2,  500, 450, 20, Color.BLACK, FontWeight.BOLD,null);
        environment.add(wall);
        environment.add(wall2);
        environment.add(line);
        environment.add(circle);
        environment.add(circle2);
        environment.add(text);
        environment.add(text2);
    }

    public void draw(){
        for (int i = 0; i < environment.size(); i++) {
            environment.get(i).draw(this.graphicsContext); // Draw all the graphics
        }
    }

}
