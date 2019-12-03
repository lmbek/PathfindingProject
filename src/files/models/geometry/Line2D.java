package files.models.geometry;

import files.interfaces.Environment;
import files.models.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line2D extends Shape implements Environment {
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
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);
        gc.beginPath();
        gc.moveTo(start.getX(),start.getY());
        gc.lineTo(end.getX(),end.getY());
        gc.stroke();
    }
}
