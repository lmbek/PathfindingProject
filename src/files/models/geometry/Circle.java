package files.models.geometry;
import files.interfaces.Environment;
import files.models.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/*************
 **************  MADE BY LARS MORTEN BEK | Miniproject | Mastermind
 *************/


public class Circle extends Shape implements Environment {

    int x, y, radius, borderSize;
    Color bgColor, borderColor;

    public Circle(int x, int y, int radius, Color bgColor) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.bgColor = bgColor;
    }

    public Circle (int x, int y, int radius, Color bgColor, Color borderColor, int borderSize) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.bgColor = bgColor;
        this.borderColor = borderColor;
        this.bgColor = bgColor;
        this.borderSize = borderSize;
    }

    @Override
    public void draw(GraphicsContext gc) {
        // draw oval/circle
        if(this.bgColor != null){
            gc.setFill(bgColor);
            gc.fillOval(x, y, radius, radius);
        }

        if(this.borderSize != 0){
            gc.setLineWidth(borderSize);
            gc.strokeOval(x,y,radius,radius);
            gc.setStroke(borderColor);
        }
    }

    @Override
    public boolean isColliding(Point point) {
        // TODO: Implement a circle collider
        return false;
    }
}