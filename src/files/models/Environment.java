package files.models;

import java.util.ArrayList;

public class Environment {
    ArrayList<Rectangle2D> rectangles = new ArrayList<Rectangle2D>();

    public void addRectangle() {
        rectangles.add(new Rectangle2D(100, 100, 150, 150));
    }
}


class Rectangle2D {
    private Point A, B, C, D;
    private Line2D AB, BD, CD, AC;
    private Point position;
    private Point size;
    private Triangle2D firstHalf;
    private Triangle2D secondHalf;

    Rectangle2D(double x, double y, double width, double height) {
        A = new Point(x,y);
        B = new Point(x+width,y);
        C = new Point(x,y+height);
        D = new Point(x+width,y+height);
        AB = new Line2D(A,B);
        BD = new Line2D(B,D);
        CD = new Line2D(C,D);
        AC = new Line2D(A,C);
        firstHalf = new Triangle2D(A, B, C);
        secondHalf = new Triangle2D(D, B, C);

        this.position = A;
        this.size = new Point(width, height);
    }

    boolean isColliding(Point obj) {
        return firstHalf.isColliding(obj) || secondHalf.isColliding(obj);
    }
}

class Triangle2D {
    private Point A, B, C;
    private Line2D a, b, c;
    private boolean clockwise;

    Triangle2D(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
        a = new Line2D(B, C);
        b = new Line2D(C, A);
        c = new Line2D(A, B);

        if (A.isLeftOfLine(a) && B.isLeftOfLine(b) && C.isLeftOfLine(c)) { // We use A, as we only need to use one of the 3 points
            clockwise = false;
        } else if (A.isRightOfLine(a) && B.isRightOfLine(b) && C.isRightOfLine(c)) {
            clockwise = true;
        } else {
            System.out.println("Warning: Triangle might be a line");
        }

    }

    public static void main(String[] args) {
        Triangle2D triangle = new Triangle2D(new Point(100, 100), new Point(50, 200), new Point(150, 200));
        System.out.println("clockwise: " + triangle.clockwise);
        Point obj = new Point(100, 150);
        System.out.println("obj colliding: " + triangle.isColliding(obj));

        Rectangle2D rectangle = new Rectangle2D(50,50,100,100);
        Point obj2 = new Point(150,150);
        rectangle.isColliding(obj2);
        System.out.println("obj2 colliding: "+rectangle.isColliding(obj2));
    }

    boolean isColliding(Point obj) {
        if (clockwise) {
            return obj.isRightOfLine(a) && obj.isRightOfLine(b) && obj.isRightOfLine(c);
        } else {
            return obj.isLeftOfLine(a) && obj.isLeftOfLine(b) && obj.isLeftOfLine(c);
        }
    }
}

class Line2D {
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

    int calcRelation(Line2D line) {
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
        return x;
    }

    public double getY() {
        return y;
    }
}