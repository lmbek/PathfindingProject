package files.models.geometry;

public class Point extends Vector {
    public Point(double x, double y) {
        super(x, y);
    }

    public Point(double x, double y, double z) {
        super(x, y, z);
    }

    int calcRelation(Line2D line) {
        // Will return greater than 0 if point is left of line
        // Will return 0 if point is on the line
        // Will return left than 0 if point is right of line
        // Formula: d=(x−x1)(y2−y1)−(y−y1)(x2−x1)
        // we use d as result, we use x as point.getX(), we use y as point.getY(),
        // we use x1 as start.getX(), we use y1 as start.getY(), we use x2 as end.getX(), and we use y2 as end.getY()
        double result = (super.getX() - line.getStart().getX()) * (line.getEnd().getY() - line.getStart().getY()) - (super.getY() - line.getStart().getY()) * (line.getEnd().getX() - line.getStart().getX());
        if (0 < result) {
            return -1;
        } else if (0 > result) {
            return 1;
        } else {
            return 0;
        }
    }

    boolean isLeftOfLine(Line2D line) {
        if (0 < calcRelation(line))
            return true; // if the calculation is positive, the point is on the left side of the line
        else return false;
    }

    boolean isOnLine(Line2D line) {
        if (0 == calcRelation(line)) return true; // if the calculation is zero, the point is on the line
        else return false;
    }

    boolean isRightOfLine(Line2D line) {
        // Our Choice: This is the only important check, as we chose to use this continiously for collision detection in objects
        if (0 > calcRelation(line))
            return true; // if the calculation is negative, the point is on the right side of the line
        else return false;
    }

    public double getX() {
        return super.getX();
    }

    public double getY() {
        return super.getY();
    }
}
