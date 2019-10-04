package files.views.userInterface;

import files.views.Environment;
import files.views.environment.Wall;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

// TODO: remove this.draw() from Graphic constructor, implement Environment on Graphic class and use the draw method in View or UI
public class Graphic {
    GraphicsContext graphicsContext;
    private ArrayList<Environment> environment = new ArrayList<Environment>();


    public Graphic(GraphicsContext graphicsContext){
        this.graphicsContext = graphicsContext;
        Wall wall = new Wall(50,50,100,100,Color.BLACK);
        environment.add(wall);

        this.draw();
    }

    public void draw(){
        for (int i = 0; i < environment.size(); i++) {
            environment.get(i).draw(this.graphicsContext); // Draw all the graphics
        }
    }

}
