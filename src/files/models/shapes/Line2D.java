package files.models.shapes;

import files.interfaces.Geometry;
import files.models.Shape;
import javafx.scene.canvas.GraphicsContext;

public class Line2D extends Shape {
    private Point start;
    private Point end;

    Line2D(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public boolean isColliding(Point point){
        return point.isOnLine(this);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

    }
}
