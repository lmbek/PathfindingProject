package files.models;

import java.util.ArrayList;

public class Environment {
    ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

    public void addRectangle() {
        rectangles.add(new Rectangle(100, 100, 150, 150));
    }
}


class Rectangle {
    Point position;
    Point size;
    Triangle firstHalf;
    Triangle secondHalf;

    Rectangle(double x, double y, double width, double height) {
        firstHalf = new Triangle(new Point(x, y), new Point(x + width, y), new Point(x, y + height));
        secondHalf = new Triangle(new Point(x + width, y + height), new Point(x + width, y), new Point(x, y + height));

        this.position = new Point(x, y);
        this.size = new Point(width, height);
    }

    boolean isColliding(Point obj) {
        if (firstHalf.isColliding(obj) || secondHalf.isColliding(obj)) {
            return true;
        } else {
            return false;
        }
    }
}

class Triangle {
    private Point A, B, C;
    private Line a, b, c;
    private boolean clockwise;

    Triangle(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
        a = new Line(B, C);
        b = new Line(C, A);
        c = new Line(A, B);

        if (A.isLeftOfLine(a) && B.isLeftOfLine(b) && C.isLeftOfLine(c)) { // We use A, as we only need to use one of the 3 points
            clockwise = false;
        } else if (A.isRightOfLine(a) && B.isRightOfLine(b) && C.isRightOfLine(c)) {
            clockwise = true;
        } else {
            System.out.println("Warning: Triangle might be a line");
        }

    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle(new Point(100, 100), new Point(50, 200), new Point(150, 200));
        System.out.println("clockwise: " + triangle.clockwise);
        Point obj = new Point(100, 150);
        System.out.println("obj colliding: " + triangle.isColliding(obj));
    }

    boolean isColliding(Point obj) {
        if (clockwise) {
            if (obj.isRightOfLine(a) && obj.isRightOfLine(b) && obj.isRightOfLine(c)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (obj.isLeftOfLine(a) && obj.isLeftOfLine(b) && obj.isLeftOfLine(c)) {
                return true;
            } else {
                return false;
            }
        }
    }
}

class Line {
    private Point start;
    private Point end;

    Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }
}

class Point {
    private double x, y, z;

    Point(double x) {
        this(x, 0, 0);
    }

    Point(double x, double y) {
        this(x, y, 0);
    }

    Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    int calcRelation(Line line) {
        // Will return greater than 0 if point is left of line
        // Will return 0 if point is on the line
        // Will return left than 0 if point is right of line
        // Formula: d=(x−x1)(y2−y1)−(y−y1)(x2−x1)
        // we use d as result, we use x as point.getX(), we use y as point.getY(),
        // we use x1 as start.getX(), we use y1 as start.getY(), we use x2 as end.getX(), and we use y2 as end.getY()
        double result = (x - line.getStart().getX()) * (line.getEnd().getY() - line.getStart().getY()) - (y - line.getStart().getY()) * (line.getEnd().getX() - line.getStart().getX());
        if (0 < result) {
            return -1;
        } else if (0 > result) {
            return 1;
        } else {
            return 0;
        }
    }

    boolean isLeftOfLine(Line line) {
        if (0 < calcRelation(line))
            return true; // if the calculation is positive, the point is on the left side of the line
        else return false;
    }

    boolean isOnLine(Line line) {
        if (0 == calcRelation(line)) return true; // if the calculation is zero, the point is on the line
        else return false;
    }

    boolean isRightOfLine(Line line) {
        // Our Choice: This is the only important check, as we chose to use this continiously for collision detection in objects
        if (0 > calcRelation(line))
            return true; // if the calculation is negative, the point is on the right side of the line
        else return false;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}