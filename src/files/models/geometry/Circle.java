package files.models.geometry;
import files.interfaces.Environment;
import files.models.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape implements Environment {
    private Point position;
    private double radius, borderSize;
    private Color bgColor, borderColor;

    public Circle(Point position, int radius, Color bgColor) {
        this(position,radius,bgColor,null,0);
    }

    public Circle (Point position, int radius, Color bgColor, Color borderColor, int borderSize) {
        this.position = position;
        this.radius = radius;
        this.bgColor = bgColor;
        this.borderColor = borderColor;
        this.borderSize = borderSize;
    }

    @Override
    public void draw(GraphicsContext gc) {
        // draw oval/circle
        if(this.bgColor != null){
            gc.setFill(bgColor);
            gc.fillOval(position.getX()-(radius/2), position.getY()-(radius/2), radius, radius);
        }

        if(this.borderSize != 0){
            gc.setLineWidth(borderSize);
            gc.strokeOval(position.getX()-(radius/2),position.getY()-(radius/2),radius,radius);
            gc.setStroke(borderColor);
        }
    }

    @Override
    public boolean isColliding(Point point) {
        // TODO: Implement a circle collider
        return false;
    }

    @Override
    public Line2D[] getLines() {
        return null; // only return lines if we rework from 360 builtin lines to our own lines.
    }

    @Override
    public Point[] getPoints() {
        return new Point[0]; // TODO: implement circle with 1 points, the centrum, rework from x and y to center point
    }

    @Override
    public Point[] getGraphPoints() {
        return null;
    }
}