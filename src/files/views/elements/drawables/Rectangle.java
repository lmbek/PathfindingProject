package files.views.elements.drawables;

import files.views.Drawables;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// Note: Not sure if we should use javafx.scene.shape.Rectangle or just make our own
public class Rectangle extends javafx.scene.shape.Rectangle implements Drawables {
    public int x,y,width,height;
    public int borderSize = 0;
    public Color borderColor;
    public Color bgColor;


    public Rectangle (int x, int y, int width, int height, Color bgColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.bgColor = bgColor;
    }

    public Rectangle (int x, int y, int width, int height, Color bgColor, Color borderColor, int borderSize) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.borderColor = borderColor;
        this.bgColor = bgColor;
        this.borderSize = borderSize;
    }

    @Override
    public void draw(GraphicsContext gc) {
        if(bgColor!=null) {
            gc.setFill(bgColor);
        }

        gc.fillRect(x, y, width, height);

        if (borderSize!=0){
            gc.setLineWidth(borderSize);
            gc.strokeRect(x,y,width,height);
            gc.setStroke(borderColor);
        }
    }
}
