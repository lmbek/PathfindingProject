package files.views;

import files.models.Graph;
import files.models.Shape;
import files.models.geometry.Circle;
import files.models.geometry.Text;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

// TODO: remove this.draw() from Graphic constructor, implement Environment on Graphic class and use the draw method in View or UI
public class Graphic {
    GraphicsContext graphicsContext;
    private ArrayList<Shape> environment = new ArrayList<>();
    private Graph graph;

    public Graphic(GraphicsContext graphicsContext){
        this.graphicsContext = graphicsContext;
    }

    public void setEnvironment(ArrayList<Shape> shapes){
        this.environment = shapes;
    }


    public void convertToGraphics(){

    }

    public void draw(){
        // add graph


        int vertex = 2;
        //for (Vertex vertex : vertices) {
        for(int i=0; i<vertex; i++){
            Circle circle = new Circle(140 + (50 * i), 240, 28, Color.WHITE, Color.BLACK, 1);
            Text text = new Text(i+"", 154 + (50 * i), 259, 16, Color.BLACK, FontWeight.BOLD, null);
            //environment.add(circle);
            //environment.add(text);
        }
        //}

        System.out.println("test");
        for (int i = 0; i < environment.size(); i++) {
            System.out.println("lars: "+i);
            environment.get(i).draw(this.graphicsContext); // Draw all the graphics
            //System.out.println(environment.get(i).getClass().getSimpleName());
        }
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
