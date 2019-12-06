package files.models.geometry;

import files.interfaces.Environment;
import files.models.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static java.lang.Double.NaN;

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

    public boolean intersects(Line2D otherLine){
        // TODO: rework, we dont need the hældningskvoficient, we need to look at what point they intersect
        double startX = this.getStart().getX();
        double startY = this.getStart().getY();
        double endX = this.getEnd().getX();
        double endY = this.getEnd().getY();
        double otherStartX = otherLine.getStart().getX();
        double otherEndX = otherLine.getEnd().getX();
        double otherStartY = otherLine.getStart().getY();
        double otherEndY = otherLine.getEnd().getY();

        double a = (endY - startY) / (endX - startX)+0.01;
        double c = (otherEndY - otherStartY) / (otherEndX - otherStartX)+0.01;

        double b = startY - a * startX;
        double d = otherStartY - c * otherStartX;
        if(a==c){
            return false;
        }

        double x = (d-b)/(a-c)+0.01;
        double y = a*x+b+0.01;
        System.out.println((d-b));

        if (Double.isNaN(x)||Double.isNaN(y)){
            return false;
        } else {
            System.out.println("x: "+x);
            System.out.println("y: "+y);
            return true;
        }
    }

    public boolean isColliding(Point point){
        return point.isOnLine(this);
    }

    @Override
    public Line2D[] getLines() {
        return new Line2D[0];
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
