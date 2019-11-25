package files.views.userInterface;

import files.models.Graph;
import files.views.Environment;
import files.views.environment.Circle;
import files.views.environment.Line;
import files.views.environment.Text;
import files.views.environment.Wall;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.LinkedList;

// TODO: remove this.draw() from Graphic constructor, implement Environment on Graphic class and use the draw method in View or UI
public class Graphic {
    GraphicsContext graphicsContext;
    private ArrayList<Environment> environment = new ArrayList<Environment>();
    private Graph graph;

    public Graphic(GraphicsContext graphicsContext){
        this.graphicsContext = graphicsContext;
        Wall wall = new Wall(50,50,100,100,Color.VIOLET);
        Wall wall2 = new Wall(250,40,50,150,Color.RED);


        environment.add(wall);
        environment.add(wall2);

    }

    public void draw(){
        // add graph


        int vertex = 2;
        //for (Vertex vertex : vertices) {
        for(int i=0; i<vertex; i++){
            Circle circle = new Circle(140 + (50 * i), 240, 28, Color.WHITE, Color.BLACK, 1);
            Text text = new Text(i+"", 154 + (50 * i), 259, 16, Color.BLACK, FontWeight.BOLD, null);
            environment.add(circle);
            environment.add(text);
        }
        //}


        for (int i = 0; i < environment.size(); i++) {
            environment.get(i).draw(this.graphicsContext); // Draw all the graphics
            //System.out.println(environment.get(i).getClass().getSimpleName());
        }
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
