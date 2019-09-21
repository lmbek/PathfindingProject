package Files.Views.Elements.Drawables;

import Files.Views.Drawables;
import javafx.scene.canvas.GraphicsContext;

// Note: Not sure if we should use javafx.scene.shape.Rectangle or just make our own
public class Rectangle extends javafx.scene.shape.Rectangle implements Drawables {
    public Rectangle (int x, int y, int sizeX, int sizeY){
        super(x,y,sizeX,sizeY);
    }

    public void draw(GraphicsContext graphicsContext){

    }
}
