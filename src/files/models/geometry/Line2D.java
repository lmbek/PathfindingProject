package files.models.geometry;

import files.interfaces.Environment;
import files.models.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static java.lang.Double.NaN;

public class Line2D extends Shape implements Environment {
    private Point start;
    private Point end;
    private Point[] points;

    public Line2D(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.points = new Point[]{start,end};
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public boolean isIntersecting(Line2D otherLine){
        double startX = this.getStart().getX();
        double startY = this.getStart().getY();
        double endX = this.getEnd().getX();
        double endY = this.getEnd().getY();
        double otherStartX = otherLine.getStart().getX();
        double otherEndX = otherLine.getEnd().getX();
        double otherStartY = otherLine.getStart().getY();
        double otherEndY = otherLine.getEnd().getY();

            double denominator = ((endX - startX) * (otherEndY - otherStartY)) - ((endY - startY) * (otherEndX - otherStartX));
            double numerator1 = ((startY - otherStartY) * (otherEndX - otherStartX)) - ((startX - otherStartX) * (otherEndY - otherStartY));
            double numerator2 = ((startY - otherStartY) * (endX - startX)) - ((startX - otherStartX) * (endY - startY));

            // Detect coincident lines (has a problem, read below)
            if (denominator == 0) return numerator1 == 0 && numerator2 == 0;

            double r = numerator1 / denominator;
            double s = numerator2 / denominator;

            return (r >= 0 && r <= 1) && (s >= 0 && s <= 1);
    }

    public boolean isColliding(Point point){
        return point.isOnLine(this);
    }

    @Override
    public Line2D[] getLines() {
        return new Line2D[0];
    }

    @Override
    public Point[] getPoints() {
        return points;
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
